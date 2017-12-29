package org.wxmotor4j.pay.request;

import java.util.Map;

import org.wxmotor4j.pay.api.WXPayConfigManage;
import org.wxmotor4j.pay.api.WXPayConstants;
import org.wxmotor4j.pay.api.WXPayConstants.ERequestType;
import org.wxmotor4j.pay.api.WXPayRequest;
import org.wxmotor4j.pay.response.WXPayDownloadBillResponse;

/**
 * 微信支付：下载对账单请求对象
 * 
 * @ClassName: WXPayDownloadBillRequest
 * @author Tluo
 * @date 2017年11月7日
 *
 */
public class WXPayDownloadBillRequest extends WXPayRequest<WXPayDownloadBillResponse> {
	private final String[] required = { WXPayConstants.FIELD_NONCE_STR,
			WXPayConstants.FIELD_BILL_DATE };

	public WXPayDownloadBillRequest(WXPayConfigManage wXPayConfigManage, Map<String, String> params) {
		super(wXPayConfigManage, params);
	}

	@Override
	public ERequestType getRequestType() {
		return ERequestType.POST;
	}

	@Override
	public String getRequestUrl() {
		return "https://api.mch.weixin.qq.com/pay/downloadbill";
	}

	@Override
	public String[] getRequired() {
		return this.required;
	}

	@Override
	public Class<WXPayDownloadBillResponse> getResponseClass() {
		return WXPayDownloadBillResponse.class;
	}

}