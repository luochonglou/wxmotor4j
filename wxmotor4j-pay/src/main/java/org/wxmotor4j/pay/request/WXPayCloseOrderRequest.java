package org.wxmotor4j.pay.request;

import java.util.Map;

import org.wxmotor4j.pay.api.WXPayConfigManage;
import org.wxmotor4j.pay.api.WXPayConstants;
import org.wxmotor4j.pay.api.WXPayConstants.ERequestType;
import org.wxmotor4j.pay.api.WXPayRequest;
import org.wxmotor4j.pay.response.WXPayCloseOrderResponse;

/**
 * 微信支付：关闭订单请求对象
 * 
 * @ClassName: WXPayCloseOrderRequest
 * @author Tluo
 * @date 2017年11月7日
 *
 */
public class WXPayCloseOrderRequest extends WXPayRequest<WXPayCloseOrderResponse> {
	private final String[] required = { WXPayConstants.FIELD_NONCE_STR,
			WXPayConstants.FIELD_OUT_TRADE_NO };

	public WXPayCloseOrderRequest(WXPayConfigManage wXPayConfigManage, Map<String, String> params) {
		super(wXPayConfigManage, params);
	}

	@Override
	public ERequestType getRequestType() {
		return ERequestType.POST;
	}

	@Override
	public String getRequestUrl() {
		return "https://api.mch.weixin.qq.com/pay/closeorder";
	}

	@Override
	public String[] getRequired() {
		return this.required;
	}

	@Override
	public Class<WXPayCloseOrderResponse> getResponseClass() {
		return WXPayCloseOrderResponse.class;
	}

}