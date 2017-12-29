package org.wxmotor4j.third.api;

import org.apache.commons.codec.digest.DigestUtils;
import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.third.api.entity.WXThirdJSConfig;
import org.wxmotor4j.third.api.entity.WXThirdTemplateMsg;
import org.wxmotor4j.third.request.WXGetUserInfoResquest;
import org.wxmotor4j.third.request.WXThirdAuthorizeGetUserInfoRequest;
import org.wxmotor4j.third.request.WXThirdAuthorizeSwapAccessTokenRequest;
import org.wxmotor4j.third.request.WXThirdCreateQRCodeRequest;
import org.wxmotor4j.third.request.WXThirdGetAuthorizerInfoRequest;
import org.wxmotor4j.third.request.WXThirdQueryComponentAuthRequest;
import org.wxmotor4j.third.request.WXThirdSendTemplateMsgRequest;
import org.wxmotor4j.third.response.WXGetUserInfoResponse;
import org.wxmotor4j.third.response.WXThirdAuthorizeGetUserInfoResponse;
import org.wxmotor4j.third.response.WXThirdAuthorizeSwapAccessTokenResponse;
import org.wxmotor4j.third.response.WXThirdCreateQRCodeResponse;
import org.wxmotor4j.third.response.WXThirdGetAuthorizerInfoResponse;
import org.wxmotor4j.third.response.WXThirdQueryComponentAuthResponse;
import org.wxmotor4j.third.response.WXThirdSendTemplateMsgResponse;
import org.wxmotor4j.third.utils.aes.SHA1;
import org.wxmotor4j.third.utils.aes.URIUtil;
import org.wxmotor4j.third.utils.aes.WXThirdAesException;
import org.wxmotor4j.third.xml.WXThirdXml;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信第三方服务接口实现
 * 
 * @ClassName: WXThirdServiceImpl
 * @author Tluo
 * @date 2017年9月26日
 *
 */
public class WXThirdServiceImpl implements WXThirdService {

	private WXThirdTokenManage wXThirdTokenManage;
	private WXThirdXmlParsers wXThirdXmlParsers;
	private WXThirdClient wXThirdClient;

	/**
	 * 
	 * 创建一个新的实例 WXThirdServiceImpl.
	 * 
	 * @param wXThirdTokenManage
	 * @throws WXThirdAesException
	 */
	public WXThirdServiceImpl(WXThirdTokenManage wXThirdTokenManage) throws WXThirdAesException {
		this.wXThirdTokenManage = wXThirdTokenManage;
		this.wXThirdXmlParsers = new DefaultXmlParsers(getConfigComponentToken(),
				getConfigEncodingAesKey(), getConfigComponentAppid());
		this.wXThirdClient = new DefaultThirdClient();
	}

	public void setwXThirdXmlParsers(WXThirdXmlParsers wXThirdXmlParsers) {
		this.wXThirdXmlParsers = wXThirdXmlParsers;
	}

	public void setwXThirdClient(WXThirdClient wXThirdClient) {
		this.wXThirdClient = wXThirdClient;
	}

	// ////////////////////////////////
	// ///////////接口实现
	// ////////////////////////////////

	@Override
	public <T extends WXThirdXml> T parsers(String xml, Class<T> clazz) throws WXThirdAesException {
		return wXThirdXmlParsers.parsers(xml, clazz);
	}

	@Override
	public <T extends WXThirdResponse> T execute(WXThirdRequest<T> request) throws WXMotorException {
		return wXThirdClient.execute(request);
	}

	@Override
	public String getConfigComponentAppid() throws WXMotorException {
		return wXThirdTokenManage.getConfigComponentAppid();
	}

	@Override
	public String getConfigComponentAppsecret() throws WXMotorException {
		return wXThirdTokenManage.getConfigComponentAppsecret();
	}

	@Override
	public String getConfigComponentToken() throws WXMotorException {
		return wXThirdTokenManage.getConfigComponentToken();
	}

	@Override
	public String getConfigEncodingAesKey() throws WXMotorException {
		return wXThirdTokenManage.getConfigEncodingAesKey();
	}

	@Override
	public String getComponentVerifyTicket() throws WXMotorException {
		return wXThirdTokenManage.getComponentVerifyTicket();
	}

	@Override
	public String getComponentPreAuthCode() throws WXMotorException {
		return wXThirdTokenManage.getComponentPreAuthCode();
	}

	@Override
	public String getComponentJsapiTicket() throws WXMotorException {
		return wXThirdTokenManage.getComponentJsapiTicket();
	}

	@Override
	public String getComponentAccessToken() throws WXMotorException {
		return wXThirdTokenManage.getComponentAccessToken();
	}

	@Override
	public String getAuthorizerAccessToken(String authorizerAppid) throws WXMotorException {
		return wXThirdTokenManage.getAuthorizerAccessToken(authorizerAppid);
	}

	@Override
	public String getAuthorizerJsapiTicket(String authorizerAppid) throws WXMotorException {
		return wXThirdTokenManage.getAuthorizerJsapiTicket(authorizerAppid);
	}

	@Override
	public String encryptMsg(String replyMsg, String timeStamp, String nonce)
			throws WXThirdAesException {
		return wXThirdXmlParsers.encryptMsg(replyMsg, timeStamp, nonce);
	}

	@Override
	public WXThirdJSConfig getJSAuthorizerConfig(String authorizerAppid, String importUrl,
			String timeStamp, String nonce) throws WXMotorException {
		try {
			WXThirdJSConfig config = new WXThirdJSConfig();
			config.setAppId(authorizerAppid);
			config.setTimestamp(timeStamp);
			config.setNonceStr(nonce);
			String jsapiTicket = getAuthorizerJsapiTicket(authorizerAppid);
			String str = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonce + "&timestamp="
					+ timeStamp + "&url=" + importUrl;
			String signature = DigestUtils.sha1Hex(str);
			config.setSignature(signature);
			return config;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	@Override
	public String getJSAuthorizeUrl(String authorizeAppid, String redirectUri, String scope,
			String state) throws WXMotorException {
		try {
			String URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
					+ authorizeAppid + "&redirect_uri=" + URIUtil.encodeURIComponent(redirectUri)
					+ "&response_type=code&scope=" + scope + "&state=STATE&component_appid="
					+ getConfigComponentAppid() + "#wechat_redirect";
			if (StringUtils.isNotEmpty(state)) {
				URL = URL.replaceAll("STATE", state);
			}
			return URL;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public WXThirdAuthorizeSwapAccessTokenResponse getJSAccessTokenRequest(String authorizerAppid,
			String code) throws WXMotorException {
		try {
			WXThirdAuthorizeSwapAccessTokenRequest request = new WXThirdAuthorizeSwapAccessTokenRequest(
					authorizerAppid, code, getConfigComponentAppid(), getComponentAccessToken());
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	@Override
	public WXThirdAuthorizeGetUserInfoResponse getJSUserInfo(String oauthAccessToken, String openId)
			throws WXMotorException {
		try {
			WXThirdAuthorizeGetUserInfoRequest request = new WXThirdAuthorizeGetUserInfoRequest(
					oauthAccessToken, openId);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public boolean checkSignature(String timestamp, String nonce, String signature)
			throws WXMotorException {
		try {
			return SHA1.gen(getConfigComponentToken(), timestamp, nonce).equals(signature);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getAuthorizeAuthorizeUrl(String redirectUri) throws WXMotorException {
		String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?"
				+ "component_appid=COMPONENTAPPID&pre_auth_code=PREAUTHCODE&redirect_uri=REDIRECTURI";
		url = url.replaceAll("COMPONENTAPPID", getConfigComponentAppid())
				.replaceAll("PREAUTHCODE", upComponentPreAuthCode())
				.replaceAll("REDIRECTURI", redirectUri);
		return url;
	}

	@Override
	public WXThirdQueryComponentAuthResponse queryComponentAuth(String authorizationCode)
			throws WXMotorException {
		try {
			WXThirdQueryComponentAuthRequest request = new WXThirdQueryComponentAuthRequest(
					getComponentAccessToken(), getConfigComponentAppid(), authorizationCode);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public WXThirdGetAuthorizerInfoResponse getAuthorizerInfo(String authorizerAppid)
			throws WXMotorException {
		try {
			WXThirdGetAuthorizerInfoRequest request = new WXThirdGetAuthorizerInfoRequest(
					getComponentAccessToken(), getConfigComponentAppid(), authorizerAppid);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public WXThirdSendTemplateMsgResponse sendTemplateMsg(String authorizeAppid,
			WXThirdTemplateMsg templateMsg) throws WXMotorException {
		try {
			String authorizerAccessToken = getAuthorizerAccessToken(authorizeAppid);
			JSONObject obj = (JSONObject) JSONObject.toJSON(templateMsg);
			WXThirdSendTemplateMsgRequest request = new WXThirdSendTemplateMsgRequest(
					authorizerAccessToken, obj);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public WXGetUserInfoResponse getUserInfo(String authorizerAppid, String openId)
			throws WXMotorException {
		try {
			WXGetUserInfoResquest request = new WXGetUserInfoResquest(
					getAuthorizerAccessToken(authorizerAppid), openId);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);

		}
	}

	@Override
	public WXThirdCreateQRCodeResponse createTmpQRCode(String authorizerAppid, Integer sceneId,
			Long expireSeconds) throws WXMotorException {
		try {
			WXThirdCreateQRCodeRequest request = new WXThirdCreateQRCodeRequest(
					getAuthorizerAccessToken(authorizerAppid), sceneId, expireSeconds);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public WXThirdCreateQRCodeResponse createTmpQRCode(String authorizerAppid, String sceneStr,
			Long expireSeconds) throws WXMotorException {
		try {
			WXThirdCreateQRCodeRequest request = new WXThirdCreateQRCodeRequest(
					getAuthorizerAccessToken(authorizerAppid), sceneStr, expireSeconds);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public WXThirdCreateQRCodeResponse createForeverQRCode(String authorizerAppid, Integer sceneId)
			throws WXMotorException {
		try {
			WXThirdCreateQRCodeRequest request = new WXThirdCreateQRCodeRequest(
					getAuthorizerAccessToken(authorizerAppid), sceneId);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public WXThirdCreateQRCodeResponse createForeverQRCode(String authorizerAppid, String sceneStr)
			throws WXMotorException {
		try {
			WXThirdCreateQRCodeRequest request = new WXThirdCreateQRCodeRequest(
					getAuthorizerAccessToken(authorizerAppid), sceneStr);
			return wXThirdClient.execute(request);
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	@Override
	public String upComponentPreAuthCode() throws WXMotorException {
		try {
			return wXThirdTokenManage.upComponentPreAuthCode();
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

}
