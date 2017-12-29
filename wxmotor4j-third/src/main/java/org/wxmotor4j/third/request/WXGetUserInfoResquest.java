package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXGetUserInfoResponse;

/**
 * 基本功能：获取关注用户信息
 * 
 * @ClassName: WXGetUserInfoResquest
 * @author Tluo
 * @date 2017年10月9日
 *
 */
public class WXGetUserInfoResquest implements WXThirdRequest<WXGetUserInfoResponse> {
	private String authorizerAccessToken;
	private String openId;

	public WXGetUserInfoResquest(String authorizerAccessToken, String openId) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.openId = openId;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/user/info?access_token="
				+ this.authorizerAccessToken + "&openid=" + this.openId + "&lang=zh_CN";
	}

	@Override
	public String getJsonParams() {
		return null;
	}

	@Override
	public Class<WXGetUserInfoResponse> getResponseClass() {
		return WXGetUserInfoResponse.class;
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
