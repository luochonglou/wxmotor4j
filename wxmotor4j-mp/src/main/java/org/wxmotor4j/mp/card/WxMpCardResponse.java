package org.wxmotor4j.mp.card;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信卡卷创建返回对象
 * 
 * @ClassName: WxMpCardResponse
 * @author Tluo
 * @date 2017年8月18日
 *
 */
public class WxMpCardResponse extends WxMpResponse {
	/*
	 * 卡卷id
	 */
	@JSONField(name = "card_id")
	private String cardId;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
