package org.wxmotor4j.pay.request;

import java.util.Map;

import org.wxmotor4j.pay.api.WXPayConfigManage;
import org.wxmotor4j.pay.api.WXPayConstants;
import org.wxmotor4j.pay.api.WXPayConstants.ERequestType;
import org.wxmotor4j.pay.api.WXPayException;
import org.wxmotor4j.pay.api.WXPayRequest;
import org.wxmotor4j.pay.api.utils.StringUtils;
import org.wxmotor4j.pay.api.utils.WXPayUtil;
import org.wxmotor4j.pay.response.WXPayQueryOrderResponse;

/**
 * 微信支付：查询订单请求对象
 * 
 * @ClassName: WXPayQueryOrderRequest
 * @author Tluo
 * @date 2017年11月7日
 *
 */
public class WXPayQueryOrderRequest extends WXPayRequest<WXPayQueryOrderResponse> {
	private final String[] required = { WXPayConstants.FIELD_NONCE_STR };

	public WXPayQueryOrderRequest(WXPayConfigManage wXPayConfigManage, Map<String, String> params) {
		super(wXPayConfigManage, params);
	}

	@Override
	public ERequestType getRequestType() {
		return ERequestType.POST;
	}

	@Override
	public String getRequestUrl() {
		return "https://api.mch.weixin.qq.com/pay/orderquery";
	}

	@Override
	public String[] getRequired() {
		return this.required;
	}

	@Override
	public Class<WXPayQueryOrderResponse> getResponseClass() {
		return WXPayQueryOrderResponse.class;
	}

	/*
	 * (非 Javadoc) 重写验证方法
	 * 
	 * @throws WXPayException
	 * 
	 * @see org.wxmotor4j.pay.api.WXPayRequest#verificationRequired()
	 */
	@Override
	public void verificationRequired() throws WXPayException {
		WXPayUtil.verificationRequired(getRequired(), params);
		if (StringUtils.isEmpty(params.get(WXPayConstants.FIELD_TRANSACTION_ID))
				&& StringUtils.isEmpty(params.get(WXPayConstants.FIELD_OUT_TRADE_NO))) {
			throw new WXPayException(WXPayConstants.FIELD_TRANSACTION_ID + " and "
					+ WXPayConstants.FIELD_OUT_TRADE_NO + "can't be empty at the same time");
		}
	}
}
