package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdAuthorizeRefreshAccessTokenResponse;

/**
 * 网页授权刷新TOKEN
 * 
 * @ClassName: WXThirdAuthorizeRefreshAccessTokenRequest
 * @author Tluo
 * @date 2017年9月29日
 *
 */
public class WXThirdAuthorizeRefreshAccessTokenRequest implements
		WXThirdRequest<WXThirdAuthorizeRefreshAccessTokenResponse> {

	private String authorizerAppid;
	private String refreshToken;
	private String componentAppid;
	private String componentAccessToken;

	public WXThirdAuthorizeRefreshAccessTokenRequest(String authorizerAppid, String refreshToken,
			String componentAppid, String componentAccessToken) {
		super();
		this.authorizerAppid = authorizerAppid;
		this.refreshToken = refreshToken;
		this.componentAppid = componentAppid;
		this.componentAccessToken = componentAccessToken;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/sns/oauth2/component/refresh_token?appid="
				+ this.authorizerAppid + "&grant_type=refresh_token" + "&component_appid="
				+ this.componentAppid + "&component_access_token=" + this.componentAccessToken
				+ "&refresh_token=" + this.refreshToken;
	}

	@Override
	public String getJsonParams() {
		return null;
	}

	@Override
	public Class<WXThirdAuthorizeRefreshAccessTokenResponse> getResponseClass() {
		return WXThirdAuthorizeRefreshAccessTokenResponse.class;
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
