package org.wxmotor4j.third.response;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

public class WXThirdCreateQRCodeResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 5423793085063864507L;

	@JSONField(name = "ticket")
	private String ticket;

	@JSONField(name = "expire_seconds")
	private Long expireSeconds;

	@JSONField(name = "url")
	private String url;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Long getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(Long expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
