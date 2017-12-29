package org.wxmotor4j.third.api;

/**
 * 微信第三方基础请求类
 * 
 * @ClassName: WXThirdRequest
 * @author Tluo
 * @date 2017年9月25日
 * 
 * @param <T>
 */
public interface WXThirdRequest<T extends WXThirdResponse> {

	/** 请求类型：POST **/
	public String requestType_POST = "POST";
	/** 请求类型：GET **/
	public String requestType_GET = "GET";

	/**
	 * 获取请求URL
	 * 
	 * @Title: getURL
	 * @return String 返回类型
	 */
	public String getURL();

	/**
	 * 获取请求参数
	 * 
	 * @Title: getJsonParams
	 * @return String 返回类型
	 */
	public String getJsonParams();

	/**
	 * 获取返回类Class
	 * 
	 * @Title: getResponseClass
	 * @return Class<T> 返回类型
	 */
	public Class<T> getResponseClass();

	/**
	 * 获取请求类型
	 * 
	 * @Title: getRequestType
	 * @return String 返回类型
	 */
	public String getRequestType();

	/**
	 * 是否加密
	 * 
	 * @Title: isNeedEncrypt
	 * @return boolean 返回类型
	 */
	public boolean isNeedEncrypt();
}
