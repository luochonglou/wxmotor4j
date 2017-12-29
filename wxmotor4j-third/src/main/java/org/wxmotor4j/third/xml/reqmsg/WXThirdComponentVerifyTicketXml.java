package org.wxmotor4j.third.xml.reqmsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.wxmotor4j.core.utils.JAXBUtils;
import org.wxmotor4j.third.utils.aes.WXBizMsgCrypt;
import org.wxmotor4j.third.utils.aes.WXThirdAesException;
import org.wxmotor4j.third.xml.WXThirdXml;

/**
 * 推送component_verify_ticket协议XML
 * 
 * @ClassName: WXThirdComponentVerifyTicketXml
 * @author Tluo
 * @date 2017年9月25日
 *
 */
@XmlRootElement(name = "xml")
public class WXThirdComponentVerifyTicketXml extends WXThirdXml {

	private String appId;
	private Long createTime;
	private String infoType;
	private String componentVerifyTicket;
	private String encryptData;
	private String decryptData;

	public String getAppId() {
		return appId;
	}

	@XmlElement(name = "AppId")
	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Long getCreateTime() {
		return createTime;
	}

	@XmlElement(name = "CreateTime")
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getInfoType() {
		return infoType;
	}

	@XmlElement(name = "InfoType")
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getComponentVerifyTicket() {
		return componentVerifyTicket;
	}

	@XmlElement(name = "ComponentVerifyTicket")
	public void setComponentVerifyTicket(String componentVerifyTicket) {
		this.componentVerifyTicket = componentVerifyTicket;
	}

	public String getEncryptData() {
		return encryptData;
	}

	@XmlElement(name = "Encrypt")
	public void setEncryptData(String encryptData) {
		this.encryptData = encryptData;
	}

	public boolean isNeedDecrypt() {
		return true;
	}

	public void decryptOperate(WXBizMsgCrypt wXBizMsgCrypt) {
		try {
			String xml = wXBizMsgCrypt.decrypt(this.encryptData);
			this.decryptData = xml;
			WXThirdComponentVerifyTicketXml obj = JAXBUtils.toObject(this.getClass(), xml);
			this.appId = obj.getAppId();
			this.componentVerifyTicket = obj.getComponentVerifyTicket();
			this.createTime = obj.getCreateTime();
			this.infoType = obj.getInfoType();
		} catch (WXThirdAesException e) {
			e.printStackTrace();
		}

	}

	public String getDecryptDate() {
		return this.decryptData;
	}
}
