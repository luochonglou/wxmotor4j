package org.wxmotor4j.third.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.WXMotorLogger;
import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.core.utils.WebUtils;
import org.wxmotor4j.core.utils.file.FileItem;
import org.wxmotor4j.third.response.WXThirdGetJsapiTicketResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: DefaultThirdClient
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class DefaultThirdClient implements WXThirdClient {
	private static final int connectTimeout = 5000;
	private static final int readTimeout = 30000;
	private static final String charset = "UTF-8";

	@Override
	public <T extends WXThirdResponse> T execute(WXThirdRequest<T> request) throws WXMotorException {
 		String requestType = request.getRequestType();
		if (WXThirdRequest.requestType_GET.equals(requestType)) {
			return executeGet(request);
		}
		if (WXThirdRequest.requestType_POST.equals(requestType)) {
			return executePost(request);
		}
		throw new WXMotorException("Request_Type_Error");
	}

	private <T extends WXThirdResponse> T executePost(WXThirdRequest<T> request)
			throws WXMotorException {
		String resData = doPost(request.getURL(), request.getJsonParams());
		T res = JSONObject.parseObject(resData, request.getResponseClass());
		res.setJsonData(resData);
		Integer errcode = res.getErrcode();
		if (null == errcode || 0 == errcode) {
			return res;
		}
		throw new WXMotorException("微信请求错误>>>errcode：" + errcode + "，errmsg：" + res.getErrmsg()
				+ "，desc：" + res.getDesc());
	}

	private <T extends WXThirdResponse> T executeGet(WXThirdRequest<T> request)
			throws WXMotorException {
		String resData = doGet(request.getURL(), null);
		T res = JSONObject.parseObject(resData, request.getResponseClass());
		res.setJsonData(resData);
		Integer errcode = res.getErrcode();
		if (null == errcode || 0 == errcode) {
			return res;
		}
		throw new WXMotorException("微信请求错误>>>errcode：" + errcode + "，errmsg：" + res.getErrmsg()
				+ "，desc：" + res.getDesc());
	}
public static void main(String[] args) {
	
	String s = "{\"errcode\":0,\"errmsg\":\"ok\",\"ticket\":\"52Tw1_qSfGvjmabRE6VHqcCILMfQW1oviSLSFSx3rZeyqc4DCh9N864dhzV2GopiidTA5RrmmgnYrYMVXF1uNw\",\"expires_in\":7200}";
	 WXThirdGetJsapiTicketResponse res = JSONObject.parseObject(s, WXThirdGetJsapiTicketResponse.class);
	 System.out.println(res.getDesc());
	 System.out.println(res.getTicket());
}
	/**
	 * 执行GET请求
	 * 
	 * @Title: doGet
	 * @return String 返回类型
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 */
	public static String doGet(String url, Map<String, String> params) throws WXMotorException {
		try {
			return WebUtils.doGet(url, params, charset);
		} catch (IOException e) {
			WXMotorLogger.printError("HTTP请求异常==>" + e.getMessage());
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	/**
	 * 执行POST请求
	 * 
	 * @Title: doPost
	 * @return String 返回类型
	 * @param url
	 *            请求地址
	 * @param jsonStr
	 *            请求参数，json字符串原样写入
	 */
	public static String doPost(String url, String jsonParams) throws WXMotorException {
		try {
			System.out.println("jsonParams==>" + jsonParams);
			String ctype = "application/x-www-form-urlencoded;charset=" + charset;
			byte[] content = {};
			if (StringUtils.isNotEmpty(jsonParams)) {
				content = jsonParams.getBytes(charset);
			}
			return WebUtils.doPost(url, ctype, content, connectTimeout, readTimeout);
		} catch (IOException e) {
			WXMotorLogger.printError("HTTP请求异常==>" + e.getMessage());
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	/**
	 * 执行GET请求，参数最终JSON格式写入
	 * 
	 * @Title: doPostMap2Json
	 * @return String 返回类型
	 */
	public static String doPostMap2Json(String url, Map<String, Object> params)
			throws WXMotorException {
		return doPost(url, JSONObject.toJSONString(params));
	}

	/**
	 * 执行带文件Post请求
	 * 
	 * @Title: doPost
	 * @return String 返回类型
	 */
	public static String doPost(String url, Map<String, FileItem> fileParams)
			throws WXMotorException {
		return doPost(url, null, fileParams);
	}

	/**
	 * 执行带参数和文件Post请求
	 * 
	 * @Title: doPost
	 * @return String 返回类型
	 */
	public static String doPost(String url, Map<String, String> params,
			Map<String, FileItem> fileParams) throws WXMotorException {
		try {
			String ctype = "multipart/form-data;";
			return WebUtils.doPost(url, params, fileParams, charset, ctype, connectTimeout,
					readTimeout);
		} catch (IOException e) {
			WXMotorLogger.printError("HTTP请求异常==>" + e.getMessage());
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public static void doPost(String url, Map<String, String> params, String charset, String path)
			throws Exception {
		// String ctype = "application/x-www-form-urlencoded;charset=" +
		// charset;

		WebUtils.downloadFilePost(url, charset, getXMLEntry(params, charset), connectTimeout,
				readTimeout, path);

	}

	private static byte[] getXMLEntry(Map<String, String> params, String charset)
			throws UnsupportedEncodingException {
		if (params == null || params.isEmpty())
			return null;
		StringBuilder entry = new StringBuilder("<xml>");
		for (Entry<String, String> para : params.entrySet()) {
			entry.append(String.format("<%s>%s</%s>", para.getKey(), para.getValue(), para.getKey()));
		}
		entry.append("</xml>");
		return entry.toString().getBytes(charset);
	}
}
