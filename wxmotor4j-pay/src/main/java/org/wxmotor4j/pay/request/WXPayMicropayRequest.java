package org.wxmotor4j.pay.request;

import java.util.Map;

import org.wxmotor4j.pay.api.WXPayConfigManage;
import org.wxmotor4j.pay.api.WXPayConstants;
import org.wxmotor4j.pay.api.WXPayConstants.ERequestType;
import org.wxmotor4j.pay.api.WXPayRequest;
import org.wxmotor4j.pay.response.WXPayMicropayResponse;

/**
 * 微信支付：刷卡支付请求对象
 * 
 * @ClassName: WXPayMicropayRequest
 * @author Tluo
 * @date 2017年11月7日
 *
 */
public class WXPayMicropayRequest extends WXPayRequest<WXPayMicropayResponse> {
	private final String[] required = { WXPayConstants.FIELD_NONCE_STR, WXPayConstants.FIELD_BODY,
			WXPayConstants.FIELD_OUT_TRADE_NO, WXPayConstants.FIELD_TOTAL_FEE,
			WXPayConstants.FIELD_SPBILL_CREATE_IP, WXPayConstants.FIELD_AUTH_CODE };

	public WXPayMicropayRequest(WXPayConfigManage wXPayConfigManage, Map<String, String> params) {
		super(wXPayConfigManage, params);
	}

	@Override
	public ERequestType getRequestType() {
		return ERequestType.POST;
	}

	@Override
	public String getRequestUrl() {
		return "https://api.mch.weixin.qq.com/pay/micropay";
	}

	@Override
	public String[] getRequired() {
		return this.required;
	}

	@Override
	public Class<WXPayMicropayResponse> getResponseClass() {
		return WXPayMicropayResponse.class;
	}

}
