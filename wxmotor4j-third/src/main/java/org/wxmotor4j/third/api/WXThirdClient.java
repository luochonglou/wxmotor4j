package org.wxmotor4j.third.api;

import org.wxmotor4j.core.WXMotorException;

/**
 * 
 * @ClassName: WXThirdClient
 * @author Tluo
 * @date 2017年11月6日
 *
 */
public interface WXThirdClient {
	/**
	 * 执行请求
	 * 
	 * @Title: execute
	 * @return T 返回类型
	 */
	public <T extends WXThirdResponse> T execute(WXThirdRequest<T> request) throws WXMotorException;

}
