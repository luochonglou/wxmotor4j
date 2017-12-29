package org.wxmotor4j.pay.api;

/**
 * 第三方网关请求接口
 * 
 * @ClassName: WXThirdClient
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public interface WXPayClient {
	/**
	 * 执行微信支付服务请求
	 * 
	 * @Title: execute
	 * @return T 返回类型
	 */
	public <T extends WXPayResponse> T execute(WXPayRequest<T> request) throws WXPayException;

}
