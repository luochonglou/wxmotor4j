package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdGetAuthorizerOptionResponse;

/**
 * 获取授权方的选项设置信息
 * 
 * @ClassName: WXThirdGetAuthorizerOptionRequest
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdGetAuthorizerOptionRequest implements
		WXThirdRequest<WXThirdGetAuthorizerOptionResponse> {

	private String componentAccessToken;
	protected String component_appid;
	protected String authorizer_appid;
	protected String option_name;

	public WXThirdGetAuthorizerOptionRequest(String componentAccessToken, String componentAppid,
			String authorizerAppid, String optionName) {
		this.authorizer_appid = authorizerAppid;
		this.option_name = optionName;
		this.component_appid = componentAppid;
		this.componentAccessToken = componentAccessToken;

	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_option?component_access_token="
				+ this.componentAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXThirdGetAuthorizerOptionResponse> getResponseClass() {
		return WXThirdGetAuthorizerOptionResponse.class;
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
