package org.wxmotor4j.third.api;

import org.wxmotor4j.core.WXMotorException;

/**
 * 
 * @ClassName: DefaultTokenManage
 * @author Tluo
 * @date 2017年9月27日
 *
 */
public class DefaultTokenManage implements WXThirdTokenManage {

	private String configComponentAppid;

	private String configComponentAppsecret;

	private String configComponentToken;

	private String configEncodingAesKey;

	private String componentVerifyTicket;

	public DefaultTokenManage(String componentAppid, String componentAppsecret,
			String componentToken, String encodingAesKey) {
		this.configComponentAppid = componentAppid;
		this.configComponentAppsecret = componentAppsecret;
		this.configComponentToken = componentToken;
		this.configEncodingAesKey = encodingAesKey;

	}

	public String getConfigComponentAppid() {
		return configComponentAppid;
	}

	public void setConfigComponentAppid(String configComponentAppid) {
		this.configComponentAppid = configComponentAppid;
	}

	public String getConfigComponentAppsecret() {
		return configComponentAppsecret;
	}

	public void setConfigComponentAppsecret(String configComponentAppsecret) {
		this.configComponentAppsecret = configComponentAppsecret;
	}

	public String getConfigComponentToken() {
		return configComponentToken;
	}

	public void setConfigComponentToken(String configComponentToken) {
		this.configComponentToken = configComponentToken;
	}

	public String getConfigEncodingAesKey() {
		return configEncodingAesKey;
	}

	public void setConfigEncodingAesKey(String configEncodingAesKey) {
		this.configEncodingAesKey = configEncodingAesKey;
	}

	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}

	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
	}

	@Override
	public String getComponentPreAuthCode() throws WXMotorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComponentAccessToken() throws WXMotorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComponentJsapiTicket() throws WXMotorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthorizerAccessToken(String authorizerAppid) throws WXMotorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthorizerJsapiTicket(String authorizerAppid) throws WXMotorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String upComponentPreAuthCode() throws WXMotorException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
