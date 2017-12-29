package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdAuthorizeSwapAccessTokenResponse;

/**
 * 网页授权交互TOKEN
 * 
 * @ClassName: WXThirdAuthorizeSwapAccessTokenRequest
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdAuthorizeSwapAccessTokenRequest implements
		WXThirdRequest<WXThirdAuthorizeSwapAccessTokenResponse> {

	private String authorizerAppid;
	private String code;
	private String componentAppid;
	private String componentAccessToken;

	public WXThirdAuthorizeSwapAccessTokenRequest(String authorizerAppid, String code,
			String componentAppid, String componentAccessToken) {
		super();
		this.authorizerAppid = authorizerAppid;
		this.code = code;
		this.componentAppid = componentAppid;
		this.componentAccessToken = componentAccessToken;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/sns/oauth2/component/access_token?appid="
				+ this.authorizerAppid + "&code=" + this.code + "&grant_type=authorization_code"
				+ "&component_appid=" + this.componentAppid + "&component_access_token="
				+ this.componentAccessToken;
	}

	@Override
	public String getJsonParams() {
		return null;
	}

	@Override
	public Class<WXThirdAuthorizeSwapAccessTokenResponse> getResponseClass() {
		return WXThirdAuthorizeSwapAccessTokenResponse.class;
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
