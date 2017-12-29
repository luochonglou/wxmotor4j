package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdQueryComponentAuthResponse;

/**
 * 查询授权方授权令牌
 * 
 * @ClassName: WXThirdQueryComponentAuthRequest
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdQueryComponentAuthRequest implements
		WXThirdRequest<WXThirdQueryComponentAuthResponse> {

	private String componentAccessToken;

	protected String component_appid;
	protected String authorization_code;

	public WXThirdQueryComponentAuthRequest(String componentAccessToken, String componentAppid,
			String authorizationCode) {
		this.authorization_code = authorizationCode;
		this.component_appid = componentAppid;
		this.componentAccessToken = componentAccessToken;

	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token="
				+ this.componentAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXThirdQueryComponentAuthResponse> getResponseClass() {
		return WXThirdQueryComponentAuthResponse.class;
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
