package org.wxmotor4j.third.api;

import org.wxmotor4j.core.WXMotorException;

/**
 * 微信第三方令牌资源接口
 * 
 * @ClassName: WXThirdTokenManage
 * @author Tluo
 * @date 2017年9月27日
 *
 */
public interface WXThirdTokenManage {

	public String getConfigComponentAppid() throws WXMotorException;

	public String getConfigComponentAppsecret() throws WXMotorException;

	public String getConfigComponentToken() throws WXMotorException;

	public String getConfigEncodingAesKey() throws WXMotorException;

	public String getComponentVerifyTicket() throws WXMotorException;

	public String getComponentPreAuthCode() throws WXMotorException;
	
	public String upComponentPreAuthCode() throws WXMotorException;

	public String getComponentAccessToken() throws WXMotorException;

	public String getComponentJsapiTicket() throws WXMotorException;

	public String getAuthorizerAccessToken(String authorizerAppid) throws WXMotorException;

	public String getAuthorizerJsapiTicket(String authorizerAppid) throws WXMotorException;

}