package org.wxmotor4j.third.request.customservice;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.customservice.WXCustomserviceSendMsgResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信客服：发送客服消息请求对象
 * 
 * @ClassName: WXCustomserviceSendMsgRequest
 * @author Tluo
 * @date 2017年10月12日
 *
 */
public class WXCustomserviceSendMsgRequest implements
		WXThirdRequest<WXCustomserviceSendMsgResponse> {
	private String authorizerAccessToken;
	private JSONObject params;

	public WXCustomserviceSendMsgRequest(String authorizerAccessToken, JSONObject params) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.params = params;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="
				+ this.authorizerAccessToken;
	}

	@Override
	public String getJsonParams() {
		return params.toString();
	}

	@Override
	public Class<WXCustomserviceSendMsgResponse> getResponseClass() {
		return WXCustomserviceSendMsgResponse.class;
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
