package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdGetComponentTokenResponse;

/**
 * 获取第三方平台COMPONENTTOKEN令牌
 * 
 * @ClassName: WXThirdGetComponentTokenRequest
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdGetComponentTokenRequest implements
		WXThirdRequest<WXThirdGetComponentTokenResponse> {

	protected String component_appid;
	protected String component_appsecret;
	protected String component_verify_ticket;

	public WXThirdGetComponentTokenRequest(String componentAppid, String componentAppsecret,
			String componentVerifyTicket) {
		this.component_appid = componentAppid;
		this.component_appsecret = componentAppsecret;
		this.component_verify_ticket = componentVerifyTicket;

	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXThirdGetComponentTokenResponse> getResponseClass() {
		return WXThirdGetComponentTokenResponse.class;
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
