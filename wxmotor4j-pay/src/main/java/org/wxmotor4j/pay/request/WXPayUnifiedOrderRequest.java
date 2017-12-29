package org.wxmotor4j.pay.request;

import java.util.Map;

import org.wxmotor4j.pay.api.WXPayConfigManage;
import org.wxmotor4j.pay.api.WXPayConstants;
import org.wxmotor4j.pay.api.WXPayConstants.ERequestType;
import org.wxmotor4j.pay.api.WXPayConstants.ETradeType;
import org.wxmotor4j.pay.api.WXPayException;
import org.wxmotor4j.pay.api.WXPayRequest;
import org.wxmotor4j.pay.api.utils.StringUtils;
import org.wxmotor4j.pay.api.utils.WXPayUtil;
import org.wxmotor4j.pay.response.WXPayUnifiedOrderResponse;

/**
 * 微信支付：统一下单请求对象
 * 
 * @ClassName: WXPayUnifiedOrderRequest
 * @author Tluo
 * @date 2017年11月6日
 *
 */
public class WXPayUnifiedOrderRequest extends WXPayRequest<WXPayUnifiedOrderResponse> {
	private final String[] required = { WXPayConstants.FIELD_NONCE_STR, WXPayConstants.FIELD_BODY,
			WXPayConstants.FIELD_OUT_TRADE_NO, WXPayConstants.FIELD_TOTAL_FEE,
			WXPayConstants.FIELD_SPBILL_CREATE_IP, WXPayConstants.FIELD_NOTIFY_URL,
			WXPayConstants.FIELD_TRADE_TYPE };

	public WXPayUnifiedOrderRequest(WXPayConfigManage wXPayConfigManage, Map<String, String> params) {
		super(wXPayConfigManage, params);
	}

	@Override
	public ERequestType getRequestType() {
		return ERequestType.POST;
	}

	@Override
	public String getRequestUrl() {
		return "https://api.mch.weixin.qq.com/pay/unifiedorder";
	}

	@Override
	public String[] getRequired() {
		return this.required;
	}

	@Override
	public Class<WXPayUnifiedOrderResponse> getResponseClass() {
		return WXPayUnifiedOrderResponse.class;
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
		String traType = params.get(WXPayConstants.FIELD_TRADE_TYPE);
		// trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
		if (ETradeType.NATIVE.toString().equals(traType)) {
			if (StringUtils.isEmpty(params.get(WXPayConstants.FIELD_PRODUCT_ID))) {
				throw new WXPayException(WXPayConstants.FIELD_PRODUCT_ID
						+ " request params is null.");
			}
		}

		// trade_type=JSAPI，此参数必传，用户在主商户appid下的唯一标识。
		// openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid
		if (ETradeType.JSAPI.toString().equals(traType)) {
			String openId = params.get(WXPayConstants.FIELD_OPENID);// 用户标识
			String subOpenId = params.get(WXPayConstants.FIELD_SUB_OPENID); // 用户子标识
			String subAppid = params.get(WXPayConstants.FIELD_SUB_APPID); // 子商户公众账号ID
			if (StringUtils.isNotEmpty(openId)) {
				return;
			}
			if (StringUtils.isNotEmpty(subOpenId) && StringUtils.isNotEmpty(subAppid)) {
				if (wXPayConfigManage.getAppid().equals(subAppid)) {
					params.remove(WXPayConstants.FIELD_SUB_APPID);
					params.remove(WXPayConstants.FIELD_SUB_OPENID);
					params.put(WXPayConstants.FIELD_OPENID, subOpenId);
				}
				return;
			}

			throw new WXPayException(WXPayConstants.FIELD_OPENID + " or "
					+ WXPayConstants.FIELD_SUB_OPENID + " - " + WXPayConstants.FIELD_SUB_APPID
					+ " request params is null.");
		}
	}
}
