package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdSetAuthorizerOptionResponse;

/**
 * 设置授权方的选项信息
 * 
 * @ClassName: WXThirdSetAuthorizerOptionRequest
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdSetAuthorizerOptionRequest implements
		WXThirdRequest<WXThirdSetAuthorizerOptionResponse> {

	private String componentAccessToken;
	protected String component_appid;
	protected String authorizer_appid;
	protected String option_name;
	protected String option_value;

	public WXThirdSetAuthorizerOptionRequest(String componentAccessToken, String componentAppid,
			String authorizerAppid, String optionName, String optionValue) {
		this.authorizer_appid = authorizerAppid;
		this.option_name = optionName;
		this.option_value = optionValue;
		this.component_appid = componentAppid;
		this.componentAccessToken = componentAccessToken;

	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/component/api_set_authorizer_option?component_access_token="
				+ this.componentAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXThirdSetAuthorizerOptionResponse> getResponseClass() {
		return WXThirdSetAuthorizerOptionResponse.class;
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
