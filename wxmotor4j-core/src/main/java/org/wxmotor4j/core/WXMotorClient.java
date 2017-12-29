package org.wxmotor4j.core;

/**
 * 
 * @ClassName: WXMotorClient
 * @author Tluo
 * @date 2017年10月12日
 *
 */
public interface WXMotorClient {
	/**
	 * 执行请求
	 * 
	 * @Title: execute
	 * @return T 返回类型
	 */
	public <T extends WXMotorResponse> T execute(WXMotorRequest<T> request) throws WXMotorException;

}
