package org.wxmotor4j.mp.jsapi;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信页面授权返回对象
 * 
 * @ClassName: WxMpOAuth2AccessToken
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public class WxMpOAuth2AccessToken extends WxMpResponse {
	@JSONField(name = "created_at")
	private String accessToken;
	@JSONField(name = "created_at")
	private int expiresIn = -1;
	@JSONField(name = "created_at")
	private String refreshToken;
	@JSONField(name = "openid")
	private String openId;
	@JSONField(name = "scope")
	private String scope;
	@JSONField(name = "unionid")
	private String unionId;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

}
