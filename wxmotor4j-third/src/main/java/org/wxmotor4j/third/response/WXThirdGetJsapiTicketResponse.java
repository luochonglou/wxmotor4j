package org.wxmotor4j.third.response;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXThirdGetJsapiTicketResponse
 * @author Tluo
 * @date 2017年9月28日
 *
 */
public class WXThirdGetJsapiTicketResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 8280383517808773360L;
	@JSONField(name = "ticket")
	private String ticket;

	@JSONField(name = "expires_in")
	private Integer expiresIn;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

}
