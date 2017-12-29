package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdGetJsapiTicketResponse;

/**
 * 获取JS临时票据请求对象
 * 
 * @ClassName: WXThirdGetJsapiTicketRequest
 * @author Tluo
 * @date 2017年9月28日
 *
 */
public class WXThirdGetJsapiTicketRequest implements WXThirdRequest<WXThirdGetJsapiTicketResponse> {
	private String componentAccessToken;

	public WXThirdGetJsapiTicketRequest(String componentAccessToken) {
		super();
		this.componentAccessToken = componentAccessToken;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
				+ this.componentAccessToken + "&type=jsapi";
	}

	@Override
	public String getJsonParams() {
		return null;
	}

	@Override
	public Class<WXThirdGetJsapiTicketResponse> getResponseClass() {
		return WXThirdGetJsapiTicketResponse.class;
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
