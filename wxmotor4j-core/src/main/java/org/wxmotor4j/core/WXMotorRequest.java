package org.wxmotor4j.core;

import org.wxmotor4j.core.consts.WXMotorConstsConfig.RequestType;

/**
 * 
 * @ClassName: WXMotorRequest
 * @author Tluo
 * @date 2017年10月12日
 * 
 * @param <T>
 */
public interface WXMotorRequest<T extends WXMotorResponse> {
	/**
	 * 请求类型
	 * 
	 * @Title: getRequestType
	 * @return RequestType 返回类型
	 */
	public RequestType getRequestType();

	/**
	 * 获取请求地址
	 * 
	 * @Title: getRequestUrl
	 * @return String 返回类型
	 */
	public String getRequestUrl();

	/**
	 * 获取提交数据
	 * 
	 * @Title: getRequestData
	 * @return String 返回类型
	 */
	public String getRequestData();

	/**
	 * 获取返回类Class
	 * 
	 * @Title: getResponseClass
	 * @return Class<T> 返回类型
	 */
	public Class<T> getResponseClass();

}
