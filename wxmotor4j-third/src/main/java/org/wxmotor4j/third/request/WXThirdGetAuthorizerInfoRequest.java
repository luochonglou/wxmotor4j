package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdGetAuthorizerInfoResponse;

/**
 * 获取授权用户基本信息
 * 
 * @ClassName: WXThirdGetAuthorizerInfoRequest
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdGetAuthorizerInfoRequest implements
		WXThirdRequest<WXThirdGetAuthorizerInfoResponse> {
	private String componentAccessToken;
	protected String component_appid;
	protected String authorizer_appid;

	public WXThirdGetAuthorizerInfoRequest(String componentAccessToken, String componentAppid,
			String authorizerAppid) {
		this.authorizer_appid = authorizerAppid;
		this.component_appid = componentAppid;
		this.componentAccessToken = componentAccessToken;

	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token="
				+ this.componentAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXThirdGetAuthorizerInfoResponse> getResponseClass() {
		return WXThirdGetAuthorizerInfoResponse.class;
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
