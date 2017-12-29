package org.wxmotor4j.mp.jsapi;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.utils.http.WxHttpClient;
import org.wxmotor4j.mp.api.WxConfigStorage;

import com.alibaba.fastjson.JSONObject;

public class WxMpJsServiceImpl implements WxMpJsService {
	private WxConfigStorage configStorage;

	public void setWxConfigStorage(WxConfigStorage configStorage) throws WXMotorException {
		this.configStorage = configStorage;

	}

	public String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state)
			throws WXMotorException {
		try {
			String url = "https://open.weixin.qq.com/connect/oauth2/authorize?";
			url += "appid=" + configStorage.getAppId();
			url += "&redirect_uri=" + WxHttpClient.encode(redirectURI);
			url += "&response_type=code";
			url += "&scope=" + scope;
			if (state != null) {
				url += "&state=" + state;
			}
			url += "#wechat_redirect";
			return url;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	public WxMpOAuth2AccessToken oauth2getAccessToken(String code) throws WXMotorException {
		try {
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?";
			url += "appid=" + configStorage.getAppId();
			url += "&secret=" + configStorage.getSecret();
			url += "&code=" + code;
			url += "&grant_type=authorization_code";
			String jsonData = WxHttpClient.doGet(url, null);
			WxMpOAuth2AccessToken res = JSONObject.parseObject(jsonData, WxMpOAuth2AccessToken.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

}
