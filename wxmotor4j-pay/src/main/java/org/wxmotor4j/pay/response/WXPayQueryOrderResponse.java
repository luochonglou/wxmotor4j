package org.wxmotor4j.pay.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.wxmotor4j.pay.api.WXPayResponse;

/**
 * * 微信支付：查询订单返回对象
 * 
 * @ClassName: WXPayQueryOrderResponse
 * @author Tluo
 * @date 2017年11月7日
 *
 */
@XmlRootElement(name = "xml")
public class WXPayQueryOrderResponse extends WXPayResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 5768927165845601408L;

	private String openid;

	private String isSubscribe;

	private String subOpenid;

	private String subIsSubscribe;

	private String tradeType;

	private String tradeState;

	private String bankType;

	private String detail;

	private String totalFee;

	private String feeType;

	private String settlementTotalFee;

	private String cashFee;

	private String cashFeeType;

	private String couponFee;

	private String couponCount;

	private String transactionTd;

	private String outTradeNo;

	private String attach;

	private String timeEnd;

	private String tradeStateDesc;

	@XmlElement(name = "openid")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@XmlElement(name = "is_subscribe")
	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	@XmlElement(name = "sub_openid")
	public String getSubOpenid() {
		return subOpenid;
	}

	public void setSubOpenid(String subOpenid) {
		this.subOpenid = subOpenid;
	}

	@XmlElement(name = "sub_is_subscribe")
	public String getSubIsSubscribe() {
		return subIsSubscribe;
	}

	public void setSubIsSubscribe(String subIsSubscribe) {
		this.subIsSubscribe = subIsSubscribe;
	}

	@XmlElement(name = "trade_type")
	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	@XmlElement(name = "trade_state")
	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	@XmlElement(name = "bank_type")
	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	@XmlElement(name = "detail")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@XmlElement(name = "total_fee")
	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	@XmlElement(name = "fee_type")
	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	@XmlElement(name = "settlement_total_fee")
	public String getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(String settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	@XmlElement(name = "cash_fee")
	public String getCashFee() {
		return cashFee;
	}

	public void setCashFee(String cashFee) {
		this.cashFee = cashFee;
	}

	@XmlElement(name = "cash_fee_type")
	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	@XmlElement(name = "coupon_fee")
	public String getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(String couponFee) {
		this.couponFee = couponFee;
	}

	@XmlElement(name = "coupon_count")
	public String getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(String couponCount) {
		this.couponCount = couponCount;
	}

	@XmlElement(name = "transaction_id")
	public String getTransactionTd() {
		return transactionTd;
	}

	public void setTransactionTd(String transactionTd) {
		this.transactionTd = transactionTd;
	}

	@XmlElement(name = "out_trade_no")
	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	@XmlElement(name = "attach")
	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	@XmlElement(name = "time_end")
	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	@XmlElement(name = "trade_state_desc")
	public String getTradeStateDesc() {
		return tradeStateDesc;
	}

	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}

}
