package org.wxmotor4j.pay;

import java.util.HashMap;
import java.util.Map;

import org.wxmotor4j.pay.api.WXPayConfigManage;
import org.wxmotor4j.pay.api.WXPayProviderConfigManage;
import org.wxmotor4j.pay.api.WXPayService;
import org.wxmotor4j.pay.api.WXPayServiceImpl;
import org.wxmotor4j.pay.api.utils.WXPayUtil;
import org.wxmotor4j.pay.response.WXPayCloseOrderResponse;
import org.wxmotor4j.pay.response.WXPayUnifiedOrderResponse;

import com.google.gson.Gson;

public class test {
	public static void main(String[] args) {

		// WXPayQueryOrderResponse res = new WXPayQueryOrderResponse();
		// res.setSubOpenid("sdd");
		// res.setReturnCode("code");
		// res.setOpenid("21222222222");
		// res.setAppid("12312");
		// res.setDeviceInfo("ssss");
		// String xml = JAXBUtils.objectToXML(res);
		// System.out.println(xml);
		// WXPayQueryOrderResponse re = WXPayUtil.xmlToObject(xml,
		// WXPayQueryOrderResponse.class);
		// System.out.println(re.getReturnCode());
		// System.out.println(re.getOpenid());
		// System.out.println(re.getAppid());
		// System.out.println(re.getErrCodeDes());
		// System.out.println(re.getSubOpenid());

		// WXPayProviderConfigManage m = new WXPayProviderConfigManage("11",
		// "11", "22", "");
		// System.out.println(m.isServiceProvider());
		// System.out.println(m.getAppid());
		// System.out.println(m.getMchId());
		// System.out.println(m.getMchKey());
		// System.out.println(m.getSignType());
		// wx.appId=wx6fdd506a399cdc67
		// wx.secret=728ddfa76dfb2a0cb125d7dda16d9ca5
		// wx.token=snkecelyong2017
		// wx.aesKey=ggtylcPqTlvMPUNzvOskzrSlUE7O0sBaH0AGlp23VuM
		// wx.partnerId=1426124102
		// wx.partnerKey=OfJl4QJHVvKJezJebbqOQqXcobGFTSC3

		String appid = "wx6fdd506a399cdc67";
		String mchId = "1426124102";
		String mchKey = "OfJl4QJHVvKJezJebbqOQqXcobGFTSC3";
		String signType = "";
		WXPayConfigManage wXPayConfigManage = new WXPayProviderConfigManage(appid, mchId, mchKey,
				signType);
		WXPayService ser = new WXPayServiceImpl(wXPayConfigManage);

		String outTradeNo = WXPayUtil.generateUUID();
		Map<String, String> params = new HashMap<String, String>();
		params.put("nonce_str", WXPayUtil.generateUUID());
		params.put("body", "测试");
		params.put("out_trade_no", outTradeNo);
		params.put("total_fee", "0.1");
		params.put("spbill_create_ip", "127.0.0.1");
		params.put("notify_url", "http://");
		params.put("trade_type", "NATIVE");
		params.put("product_id", "4876412567");
		WXPayUnifiedOrderResponse res = ser.unifiedOrder(params);

		System.out.println(res.getCodeUrl());
		Gson g = new Gson();
		System.out.println(g.toJson(res));

		WXPayCloseOrderResponse ss = ser.closeOrder(outTradeNo, null);
		System.out.println(g.toJson(ss));
	}
}
