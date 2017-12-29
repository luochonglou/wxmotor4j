package org.wxmotor4j.mp.api;

import java.io.Serializable;

/**
 * 微信配置存储接口
 * 
 * @ClassName: WxConfigStorage
 * @author Tluo
 * @date 2017年8月3日
 *
 */
public interface WxConfigStorage extends Serializable {
	public String getAppId();

	public String getSecret();

	public String getToken();

	public String getAesKey();

	public String getPartnerId();

	public String getPartnerKey();

	public long getDelayTime();

	/**
	 * 获取AccessToken
	 * 
	 * @Title: getAccessToken
	 * @return String 返回类型
	 */
	public String getAccessToken();

	/**
	 * 强制更新AccessToken
	 * 
	 * @Title: mandatoryUpdateAccessToken
	 * @return void 返回类型
	 */
	public void mandatoryUpdateAccessToken();

	/**
	 * 获取JsapiTicket
	 * 
	 * @Title: getJsapiTicket
	 * @return String 返回类型
	 */
	public String getJsapiTicket();

	/**
	 * 强制更新JsapiTicket
	 * 
	 * @Title: mandatoryUpdateJsapiTicket
	 * @return void 返回类型
	 */
	public void mandatoryUpdateJsapiTicket();

}
