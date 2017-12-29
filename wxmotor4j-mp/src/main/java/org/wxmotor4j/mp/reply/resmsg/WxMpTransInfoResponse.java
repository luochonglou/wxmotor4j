package org.wxmotor4j.mp.reply.resmsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxmotor4j.core.utils.xml.CDATAAdapter;

/**
 * 被动会话：客户消息
 * 
 * @ClassName: WxMpTransInfoResponse
 * @author Tluo
 * @date 2016年12月29日
 *
 */

public class WxMpTransInfoResponse {
	private String KfAccount;// 指定会话接入的客服账号

	public WxMpTransInfoResponse() {
		super();
	}

	public WxMpTransInfoResponse(String kfAccount) {
		super();
		KfAccount = kfAccount;
	}

	@XmlElement(name = "KfAccount")
	public String getKfAccount() {
		return KfAccount;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setKfAccount(String kfAccount) {
		KfAccount = kfAccount;
	}

}
