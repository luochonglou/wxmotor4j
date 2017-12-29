package org.wxmotor4j.mp.account;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信长链接转换对象
 * 
 * @ClassName: WxMpLink
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public class WxMpLink extends WxMpResponse {
	/* 此处填long2short，代表长链接转短链接 */
	@JSONField(name = "action")
	private String action = "long2short";
	/* 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url */
	@JSONField(name = "long_url")
	private String longUrl;
	/* 转换后的短连接 */
	@JSONField(name = "short_url")
	private String shortUrl;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

}
