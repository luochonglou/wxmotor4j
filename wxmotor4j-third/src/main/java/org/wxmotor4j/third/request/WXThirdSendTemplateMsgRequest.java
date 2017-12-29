package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdSendTemplateMsgResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * 发送模版消息
 * 
 * @ClassName: WXThirdSendTemplateMsgRequest
 * @author Tluo
 * @date 2017年9月29日
 *
 */
public class WXThirdSendTemplateMsgRequest implements
		WXThirdRequest<WXThirdSendTemplateMsgResponse> {

	private String authorizerAccessToken;
	protected JSONObject params;

	public WXThirdSendTemplateMsgRequest(String authorizerAccessToken, JSONObject params) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.params = params;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
				+ this.authorizerAccessToken;
	}

	@Override
	public String getJsonParams() {
		return params.toString();
	}

	@Override
	public Class<WXThirdSendTemplateMsgResponse> getResponseClass() {
		return WXThirdSendTemplateMsgResponse.class;
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
