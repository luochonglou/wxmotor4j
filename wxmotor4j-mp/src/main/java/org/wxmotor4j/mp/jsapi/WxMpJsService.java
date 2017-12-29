package org.wxmotor4j.mp.jsapi;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.mp.api.WxMpApi;

/**
 * 微信js服务
 * 
 * @ClassName: WxMpJsService
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public interface WxMpJsService extends WxMpApi {

	public String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state)
			throws WXMotorException;

	public WxMpOAuth2AccessToken oauth2getAccessToken(String code) throws WXMotorException;

}
