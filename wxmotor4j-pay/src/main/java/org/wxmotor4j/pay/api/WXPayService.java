package org.wxmotor4j.pay.api;

import java.util.Map;

import org.wxmotor4j.pay.response.WXPayCloseOrderResponse;
import org.wxmotor4j.pay.response.WXPayQueryOrderResponse;
import org.wxmotor4j.pay.response.WXPayUnifiedOrderResponse;

/**
 * 微信支付服务
 * 
 * @ClassName: WXPayService
 * @author Tluo
 * @date 2017年11月7日
 *
 */
public interface WXPayService {
	/**
	 * 设置请求代理
	 * 
	 * @Title: setWXPayClient
	 * @return void 返回类型
	 */
	public void setWXPayClient(WXPayClient wXPayClient);

	/**
	 * 设置微信配置
	 * 
	 * @Title: setWXPayConfigManage
	 * @return void 返回类型
	 */
	public void setWXPayConfigManage(WXPayConfigManage wXPayConfigManage);

	/**
	 * 扫码支付
	 * <ul>
	 * <li>1、结果失败均以异常抛出形式报错失败原因</li>
	 * <li>2、异常有标识错误和业务错误两种情况，注意原因字段不一样</li>
	 * <li>3、业务成功查询订单状态，失败则轮询查询4次，轮询规则：5s-10s-20s</li>
	 * </ul>
	 * 
	 * 
	 * @Title: barPayOrder
	 * @return WXPayMicropayResponse 返回类型
	 * @throws WXPayException
	 */
	public WXPayQueryOrderResponse barPayOrder(Map<String, String> params) throws WXPayException;

	/**
	 * 查询支付订单
	 * 
	 * @Title: queryOrder
	 * @return WXPayQueryOrderResponse 返回类型
	 * @throws WXPayException
	 */
	public WXPayQueryOrderResponse queryOrder(String transactionId, String outTradeNo,
			String subMchId) throws WXPayException;

	/**
	 * 统一下单
	 * <ul>
	 * <li>1、支付方式，必需字段不一样，必需字段缺少错误以抛出异常</li>
	 * <li>2、结果失败均以异常抛出形式报错失败原因</li>
	 * </ul>
	 * 
	 * @Title: unifiedOrder
	 * @return WXPayUnifiedOrderResponse 返回类型
	 * @throws WXPayException
	 */
	public WXPayUnifiedOrderResponse unifiedOrder(Map<String, String> params) throws WXPayException;

	/**
	 * 关闭下单
	 * 
	 * @Title: closeOrder
	 * @return WXPayCloseOrderResponse 返回类型
	 */
	public WXPayCloseOrderResponse closeOrder(String outTradeNo, String subMchId)
			throws WXPayException;

	/**
	 * 处理支付回调
	 * <ul>
	 * <li>1、支付回调处理，业务成功返回返回数据</li>
	 * <li>2、支付回调签名无效返回空，支付状态不成功返回空</li>
	 * <ul/>
	 * 
	 * @Title: handleWxpayCallback
	 * @return Map<String,String> 返回类型
	 */
	public Map<String, String> handleWxpayCallback(String queryXml) throws WXPayException;
}
