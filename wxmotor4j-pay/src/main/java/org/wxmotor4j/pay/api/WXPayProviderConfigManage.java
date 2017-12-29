package org.wxmotor4j.pay.api;

import org.wxmotor4j.pay.api.WXPayConstants.ESignType;

/**
 * 
 * @ClassName: DefaultWXPayConfigManage
 * @author Tluo
 * @date 2017年11月8日
 *
 */
public class WXPayProviderConfigManage implements WXPayConfigManage {

	private boolean serviceProvider = true;
	private String appid;
	private String mchId;
	private String mchKey;
	private String signType;

	public WXPayProviderConfigManage(String appid, String mchId, String mchKey, String signType) {
		super();
		this.appid = appid;
		this.mchId = mchId;
		this.mchKey = mchKey;
		this.signType = signType;
	}

	@Override
	public boolean isServiceProvider() {
		return serviceProvider;
	}

	@Override
	public String getAppid() {
		return appid;
	}

	@Override
	public String getMchId() {
		return mchId;
	}

	@Override
	public String getMchKey() {
		return mchKey;
	}

	@Override
	public ESignType getSignType() {
		if (ESignType.HMACSHA256.toString().equals(signType)) {
			return ESignType.HMACSHA256;
		}
		return ESignType.MD5;
	}

}
