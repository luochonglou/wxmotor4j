package org.wxmotor4j.mp.account;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.mp.api.WxMpApi;

/**
 * 微信帐号管理服务
 * 
 * @ClassName: WxMpAccountService
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public interface WxMpAccountService extends WxMpApi {
	/**
	 * 创建临时二维码
	 * 
	 * @Title: createTemporaryQrcode
	 * @return WxMpQrcode 返回类型
	 * @param sceneId
	 *            场景id
	 * @param expireSeconds
	 *            有效期单位秒
	 */
	public WxMpQrcode createTemporaryQrcode(Integer sceneId, Long expireSeconds)
			throws WXMotorException;

	/**
	 * 
	 * @Title: createTemporaryQrcode
	 * @return WxMpQrcode 返回类型
	 * @param sceneStr
	 *            场景id
	 * @param expireSeconds
	 *            有效期单位秒
	 */
	public WxMpQrcode createTemporaryQrcode(String sceneStr, Long expireSeconds)
			throws WXMotorException;

	/**
	 * 创建永久二维码
	 * 
	 * @Title: createForeverQrcode
	 * @return WxMpQrcode 返回类型
	 */
	public WxMpQrcode createForeverQrcode(Integer sceneId) throws WXMotorException;

	/**
	 * 创建永久二维码
	 * 
	 * @Title: createForeverQrcode
	 * @return WxMpQrcode 返回类型
	 */
	public WxMpQrcode createForeverQrcode(String sceneStr) throws WXMotorException;

	/**
	 * 通过ticket换取二维码
	 * 
	 * @Title: qrcodeUrl
	 * @return String 返回类型
	 */
	public String getQrcodeUrlByTicket(String ticket) throws WXMotorException;

	/**
	 * 长链接转短链接
	 * 
	 * @Title: longlinkToShortlink
	 * @return WxMpLink 返回类型
	 */
	public WxMpLink longlinkToShortlink(String longUrl) throws WXMotorException;

}
