package org.wxmotor4j.third.request.customservice;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.request.RequestParamsUtil;
import org.wxmotor4j.third.response.customservice.WXCustomserviceAddAccountResponse;

/**
 * 微信客服：添加客服请求对象
 * 
 * @ClassName: WXCustomserviceAddAccountRequest
 * @author Tluo
 * @date 2017年10月12日
 *
 */
public class WXCustomserviceAddAccountRequest implements
		WXThirdRequest<WXCustomserviceAddAccountResponse> {
	private String authorizerAccessToken;
	protected String kf_account;
	protected String nickname;
	protected String password;

	public WXCustomserviceAddAccountRequest(String authorizerAccessToken, String kfAccount,
			String nickname, String password) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.kf_account = kfAccount;
		this.nickname = nickname;
		this.password = password;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/customservice/kfaccount/add?access_token="
				+ this.authorizerAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXCustomserviceAddAccountResponse> getResponseClass() {
		return WXCustomserviceAddAccountResponse.class;
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
