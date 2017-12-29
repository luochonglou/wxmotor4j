package org.wxmotor4j.pay.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.wxmotor4j.pay.api.WXPayResponse;

/**
 * * 微信支付：统一下单返回对象
 * 
 * @ClassName: WXPayUnifiedOrderResponse
 * @author Tluo
 * @date 2017年11月7日
 *
 */
@XmlRootElement(name = "xml")
public class WXPayUnifiedOrderResponse extends WXPayResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -8160441092705057828L;
	private String tradeType;
	private String prepayId;
	private String codeUrl;
	private String mwebUrl;

	@XmlElement(name = "trade_type")
	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	@XmlElement(name = "prepay_id")
	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	@XmlElement(name = "code_url")
	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	@XmlElement(name = "mweb_url")
	public String getMwebUrl() {
		return mwebUrl;
	}

	public void setMwebUrl(String mwebUrl) {
		this.mwebUrl = mwebUrl;
	}

}
