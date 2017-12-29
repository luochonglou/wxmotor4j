package org.wxmotor4j.pay.api;

import org.wxmotor4j.pay.api.WXPayConstants.ESignType;

/**
 * 微信支付配置管理
 * 
 * @ClassName: WXPayConfigManage
 * @author Tluo
 * @date 2017年10月26日
 *
 */
public interface WXPayConfigManage {
	/**
	 * 是服务商配置
	 * 
	 * @Title: isServiceProvider
	 * @return boolean 返回类型
	 */
	boolean isServiceProvider();

	/**
	 * 公众账号ID
	 * 
	 * @Title: getAppid
	 * @return String 返回类型
	 */
	String getAppid();

	/**
	 * 商户号
	 * 
	 * @Title: getMchId
	 * @return String 返回类型
	 */
	String getMchId();

	/**
	 * 商户钥匙
	 * 
	 * @Title: getMchKey
	 * @return String 返回类型
	 */
	String getMchKey();

	/**
	 * 签名类型
	 * 
	 * @Title: getSignType
	 * @return String 返回类型
	 */
	ESignType getSignType();

}
