package org.wxmotor4j.third.request.customservice;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.request.RequestParamsUtil;
import org.wxmotor4j.third.response.customservice.WXCustomserviceUpdateAccountResponse;

/**
 * 微信客服：修改客服请求对象
 * 
 * @ClassName: WXCustomserviceUpdateAccountRequest
 * @author Tluo
 * @date 2017年10月12日
 *
 */
public class WXCustomserviceUpdateAccountRequest implements
		WXThirdRequest<WXCustomserviceUpdateAccountResponse> {

	private String authorizerAccessToken;
	protected String kf_account;
	protected String nickname;
	protected String password;

	public WXCustomserviceUpdateAccountRequest(String authorizerAccessToken, String kfAccount,
			String nickname, String password) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.kf_account = kfAccount;
		this.nickname = nickname;
		this.password = password;
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/customservice/kfaccount/update?access_token="
				+ this.authorizerAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXCustomserviceUpdateAccountResponse> getResponseClass() {
		return WXCustomserviceUpdateAccountResponse.class;
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
