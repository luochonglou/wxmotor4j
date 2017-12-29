package org.wxmotor4j.third.request;

import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdAuthorizeGetUserInfoResponse;

/**
 * 网页授权获取用户信息
 * 
 * @ClassName: WXThirdAuthorizeGetUserInfoRequest
 * @author Tluo
 * @date 2017年9月29日
 *
 */
public class WXThirdAuthorizeGetUserInfoRequest implements
		WXThirdRequest<WXThirdAuthorizeGetUserInfoResponse> {

	private String oauthAccessToken;
	private String openId;
	private String lang;

	public WXThirdAuthorizeGetUserInfoRequest(String oauthAccessToken, String openId) {
		super();
		this.oauthAccessToken = oauthAccessToken;
		this.openId = openId;
	}

	public WXThirdAuthorizeGetUserInfoRequest(String oauthAccessToken, String openId, String lang) {
		super();
		this.oauthAccessToken = oauthAccessToken;
		this.openId = openId;
		this.lang = lang;
	}

	@Override
	public String getURL() {
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + this.oauthAccessToken
				+ "&openid=" + this.openId + "&lang=zh_CN";
		if (StringUtils.isNotEmpty(lang)) {
			url = url.replaceAll("zh_CN", lang);
		}
		return url;
	}

	@Override
	public String getJsonParams() {
		return null;
	}

	@Override
	public Class<WXThirdAuthorizeGetUserInfoResponse> getResponseClass() {
		return WXThirdAuthorizeGetUserInfoResponse.class;
	}

	@Override
	public String getRequestType() {
		return WXThirdRequest.requestType_GET;
	}

	@Override
	public boolean isNeedEncrypt() {
		return false;
	}

}
