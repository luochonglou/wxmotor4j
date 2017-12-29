package org.wxmotor4j.pay.api;

import java.util.Map;

import org.wxmotor4j.pay.api.WXPayConstants.ERequestType;
import org.wxmotor4j.pay.api.utils.WXPayUtil;

/**
 * 
 * @ClassName: WXPayRequest
 * @author Tluo
 * @date 2017年10月26日
 * 
 * @param <T>
 */
public abstract class WXPayRequest<T extends WXPayResponse> {

	protected WXPayConfigManage wXPayConfigManage;
	protected Map<String, String> params;

	public WXPayRequest(WXPayConfigManage wXPayConfigManage, Map<String, String> params) {
		super();
		this.wXPayConfigManage = wXPayConfigManage;
		this.params = params;
	}

	/**
	 * 请求类型
	 * 
	 * @Title: getRequestType
	 * @return RequestType 返回类型
	 */
	public abstract ERequestType getRequestType();

	/**
	 * 获取请求地址
	 * 
	 * @Title: getRequestUrl
	 * @return String 返回类型
	 */
	public abstract String getRequestUrl();

	/**
	 * 获取所有必需参数集合
	 * 
	 * @Title: getRequired
	 * @return String[] 返回类型
	 */
	public abstract String[] getRequired();

	/**
	 * 获取返回类CLASS
	 * 
	 * @Title: getResponseClass
	 * @return Class<T> 返回类型
	 */
	public abstract Class<T> getResponseClass();

	/**
	 * 验证请求参数
	 * 
	 * @Title: verificationRequired
	 * @return void 返回类型
	 */
	public void verificationRequired() throws WXPayException {
		WXPayUtil.verificationRequired(getRequired(), params);
	}

	/**
	 * 获取请求数据
	 * 
	 * @Title: getRequestDataXml
	 * @return String 返回类型
	 */
	public String getRequestDataXml() throws WXPayException {
		verificationRequired(); // 验证请求参数
		WXPayUtil.tirm(params); // 去除空格和空项，是否需要？
		return WXPayUtil.generateSignedXml(params, wXPayConfigManage);
	}

	/**
	 * 获取请求原始参数
	 * 
	 * @Title: getParams
	 * @return Map<String,String> 返回类型
	 */
	public Map<String, String> getParams() {
		return params;
	}

}
