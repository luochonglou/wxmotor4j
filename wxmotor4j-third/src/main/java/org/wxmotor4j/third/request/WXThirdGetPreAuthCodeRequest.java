package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdGetPreAuthCodeResponse;

/**
 * 获取第三方平台预授权码
 * 
 * @ClassName: WXThirdGetPreAuthCodeRequest
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdGetPreAuthCodeRequest implements WXThirdRequest<WXThirdGetPreAuthCodeResponse> {

	private String componentAccessToken;

	protected String component_appid;

	public WXThirdGetPreAuthCodeRequest(String componentAccessToken, String componentAppid) {
		this.component_appid = componentAppid;
		this.componentAccessToken = componentAccessToken;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token="
				+ this.componentAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXThirdGetPreAuthCodeResponse> getResponseClass() {
		return WXThirdGetPreAuthCodeResponse.class;
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
