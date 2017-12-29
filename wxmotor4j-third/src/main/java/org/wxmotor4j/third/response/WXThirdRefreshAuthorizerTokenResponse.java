package org.wxmotor4j.third.response;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXThirdRefreshAuthorizerTokenResponse
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdRefreshAuthorizerTokenResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 6712791073882804381L;

	@JSONField(name = "authorizer_access_token")
	private String authorizerAccessToken;

	@JSONField(name = "expires_in")
	private Integer expiresIn;

	@JSONField(name = "authorizer_refresh_token")
	private String authorizerRefreshToken;

	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}

	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}

	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}

}
