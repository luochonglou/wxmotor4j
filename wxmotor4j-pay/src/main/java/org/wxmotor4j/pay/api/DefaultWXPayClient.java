package org.wxmotor4j.pay.api;

import java.io.IOException;
import java.util.Map;

import org.wxmotor4j.pay.api.WXPayConstants.ERequestType;
import org.wxmotor4j.pay.api.utils.StringUtils;
import org.wxmotor4j.pay.api.utils.WXPayUtil;
import org.wxmotor4j.pay.api.utils.WebUtils;

/**
 * 
 * @ClassName: DefaultThirdClient
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class DefaultWXPayClient implements WXPayClient {
	private static final int connectTimeout = 5000;
	private static final int readTimeout = 30000;
	private static final String charset = "UTF-8";

	@Override
	public <T extends WXPayResponse> T execute(WXPayRequest<T> request) throws WXPayException {
		if (ERequestType.POST.equals(request.getRequestType())) {
			return executePost(request);
		} else if (ERequestType.GET.equals(request.getRequestType())) {
			return executeGet(request);
		}
		throw new WXPayException("Request_Type_Error");
	}

	/**
	 * 执行POST请求
	 * 
	 * @Title: executePost
	 * @return T 返回类型
	 */
	private <T extends WXPayResponse> T executePost(WXPayRequest<T> request) throws WXPayException {
		String url = request.getRequestUrl();
		String requestData = request.getRequestDataXml();
		WXPayUtil.getLogger().info("WXPayClient POST url>>> {} | params>>> {}", url, requestData);
		String xmlString = doPost(url, requestData);
		T res = WXPayUtil.xmlToObject(xmlString, request.getResponseClass());
		res.setXmlDate(xmlString);
		return res;
	}

	/**
	 * 执行GET请求
	 * 
	 * @Title: executeGet
	 * @return T 返回类型
	 */
	private <T extends WXPayResponse> T executeGet(WXPayRequest<T> request) throws WXPayException {
		String url = request.getRequestUrl();
		WXPayUtil.getLogger().info("WXPayClient GET url>>> {}", url);
		String xmlString = doGet(request.getRequestUrl(), null);
		T res = WXPayUtil.xmlToObject(xmlString, request.getResponseClass());
		res.setXmlDate(xmlString);
		return res;
	}

	/**
	 * 模拟POST请求
	 * 
	 * @Title: doPost
	 * @return String 返回类型
	 */
	private static String doPost(String url, String requestData) throws WXPayException {
		try {
			String ctype = "application/x-www-form-urlencoded;charset=" + charset;
			byte[] content = {};
			if (StringUtils.isNotEmpty(requestData)) {
				content = requestData.getBytes(charset);
			}
			return WebUtils.doPost(url, ctype, content, connectTimeout, readTimeout);
		} catch (IOException e) {
			throw new WXPayException(e.getMessage(), e);
		}
	}

	/**
	 * 模拟GET请求
	 * 
	 * @Title: doGet
	 * @return String 返回类型
	 */
	private static String doGet(String url, Map<String, String> params) throws WXPayException {
		try {
			WXPayUtil.getLogger().info("WXPayClient GET url>>> {} ", url);
			return WebUtils.doGet(url, params, charset);
		} catch (IOException e) {
			throw new WXPayException(e.getMessage(), e);
		}
	}
}
