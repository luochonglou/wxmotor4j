package org.wxmotor4j.third.response;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXThirdAuthorizeSwapAccessTokenResponse
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdAuthorizeSwapAccessTokenResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 268341496932212973L;

	@JSONField(name = "access_token")
	private String accessToken;

	@JSONField(name = "expires_in")
	private Integer expiresIn;

	@JSONField(name = "refresh_token")
	private String refreshToken;

	@JSONField(name = "openid")
	private String openid;

	@JSONField(name = "scope")
	private String scope;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
