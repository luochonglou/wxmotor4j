package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdRefreshAuthorizerTokenResponse;

/**
 * 刷新授权方令牌
 * 
 * @ClassName: WXThirdRefreshAuthorizerTokenRequest
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdRefreshAuthorizerTokenRequest implements
		WXThirdRequest<WXThirdRefreshAuthorizerTokenResponse> {

	private String componentAccessToken;
	protected String component_appid;
	protected String authorizer_appid;
	protected String authorizer_refresh_token;

	public WXThirdRefreshAuthorizerTokenRequest(String componentAccessToken, String componentAppid,
			String authorizerAppid, String authorizerRefreshToken) {
		this.authorizer_appid = authorizerAppid;
		this.authorizer_refresh_token = authorizerRefreshToken;
		this.component_appid = componentAppid;
		this.componentAccessToken = componentAccessToken;

	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token="
				+ this.componentAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXThirdRefreshAuthorizerTokenResponse> getResponseClass() {
		return WXThirdRefreshAuthorizerTokenResponse.class;
	}

	@Override
	public String getRequestType() {
		return WXThirdRequest.requestType_POST;
	}

	@Override
	public boolean isNeedEncrypt() {
		return false;
	}

}
