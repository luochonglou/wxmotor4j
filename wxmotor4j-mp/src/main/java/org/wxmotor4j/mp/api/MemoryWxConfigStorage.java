package org.wxmotor4j.mp.api;

import org.wxmotor4j.core.WXMotorLogger;
import org.wxmotor4j.core.utils.http.WxHttpClient;

import com.alibaba.fastjson.JSONObject;

/**
 * 基于内存微信配置
 * 
 * @ClassName: MemoryWxConfigStorage
 * @author Tluo
 * @date 2017年8月3日
 *
 */
public class MemoryWxConfigStorage implements WxConfigStorage {

	private volatile String appId;
	private volatile String secret;
	private volatile String token;
	private volatile String aesKey;
	private volatile String partnerId;
	private volatile String partnerKey;

	private volatile String accessToken;
	private volatile String jsapiTicket;
	private volatile long accessTokenExpiresTime;
	private volatile long jsapiTicketExpiresTime;
	private volatile long delayTime = 7000;
	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -4031008303367492698L;

	public String getAppId() {
		return this.appId;
	}

	public String getSecret() {
		return this.secret;
	}

	public String getToken() {
		return this.token;
	}

	public String getAesKey() {
		return this.aesKey;
	}

	public String getPartnerId() {
		return this.partnerId;
	}

	public String getPartnerKey() {
		return this.partnerKey;
	}

	public long getDelayTime() {
		return this.delayTime;
	}

	public String getAccessToken() {
		if (isExpire(accessTokenExpiresTime)) {
			mandatoryUpdateAccessToken();
		}
		return this.accessToken;
	}

	public String getJsapiTicket() {
		if (isExpire(jsapiTicketExpiresTime)) {
			mandatoryUpdateJsapiTicket();
		}
		return this.jsapiTicket;
	}

	public synchronized void mandatoryUpdateAccessToken() {
		if (isExpire(accessTokenExpiresTime)) {
			try {
				WXMotorLogger.printInfo(accessTokenExpiresTime + " 到期更新==>AccessToken");
				String url = WxApiGateway.accesstoken_get_gateway.replaceAll("APPID", appId)
						.replaceAll("SECRET", secret);
				String jsonStr = WxHttpClient.doGet(url, null);
				WXMotorLogger.printInfo("请求获取AccessToken==>" + jsonStr);
				JSONObject jObject = JSONObject.parseObject(jsonStr);
				String accessToken = jObject.getString("access_token");
				WXMotorLogger.printInfo("请求获取AccessToken==>" + accessToken);
				this.accessToken = accessToken;
				this.accessTokenExpiresTime = System.currentTimeMillis() + delayTime * 1000l;
			} catch (Exception e) {
				WXMotorLogger.printError("更新AccessToken失败！" + e.getMessage());
			}
		}
	}

	public synchronized void mandatoryUpdateJsapiTicket() {
		if (isExpire(jsapiTicketExpiresTime)) {
			try {
				WXMotorLogger.printInfo(jsapiTicketExpiresTime + "到期更新==>JsapiTicket");
				String url = WxApiGateway.jsapiticket_get_gateway.replaceAll("ACCESS_TOKEN",
						getAccessToken());
				String jsonStr = WxHttpClient.doGet(url, null);
				WXMotorLogger.printInfo("请求获取JsapiTicket==>" + jsonStr);
				JSONObject jObject = JSONObject.parseObject(jsonStr);
				String jsapiTicket = jObject.getString("ticket");
				WXMotorLogger.printInfo("请求获取JsapiTicket==>" + jsapiTicket);
				this.jsapiTicket = jsapiTicket;
				this.jsapiTicketExpiresTime = System.currentTimeMillis() + delayTime * 1000l;
			} catch (Exception e) {
				WXMotorLogger.printError("更新JsapiTicket失败！" + e.getMessage());
			}
		}
	}

	private boolean isExpire(long expiresTime) {
		if (System.currentTimeMillis() < expiresTime) {
			return false;
		}
		return true;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}

	public void setDelayTime(long delayTime) {
		this.delayTime = delayTime;
	}

}
