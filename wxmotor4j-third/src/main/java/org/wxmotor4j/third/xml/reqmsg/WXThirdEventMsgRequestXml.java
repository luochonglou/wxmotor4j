package org.wxmotor4j.third.xml.reqmsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.wxmotor4j.core.utils.JAXBUtils;
import org.wxmotor4j.third.utils.aes.WXBizMsgCrypt;
import org.wxmotor4j.third.utils.aes.WXThirdAesException;
import org.wxmotor4j.third.xml.WXThirdXml;

/**
 * 微信事件、消息接收XML
 * 
 * @ClassName: WXThirdEventMsgReceiveXml
 * @author Tluo
 * @date 2017年9月28日
 *
 */
@XmlRootElement(name = "xml")
public class WXThirdEventMsgRequestXml extends WXThirdXml {

	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private String Event;
	private String EventKey;
	private String MsgId;
	private String Content;
	private String Location_X;
	private String Location_Y;
	private String Scale;
	private String Label;
	private String Title;
	private String Description;
	private String Url;
	private String PicUrl;
	private String MediaId;
	private String Format;
	private String Status;
	private String Latitude; // 上报地理位置事件Latitude
	private String Longitude; // 上报地理位置事件Longitude
	private String Precision; // 上报地理位置事件Precision
	private String Ticket; // 扫描带参数二维码事件Ticket
	private String ThumbMediaId; // 视频消息 ThumbMediaId
									// 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	private WXThirdScanCodeInfoRequestXml ScanCodeInfo; // 扫描信息
	private WXThirdSendPicsInfoRequestXml SendPicsInfo; // 发送的图片信息
	private WXthirdSendLocationInfoRequestXml SendLocationInfo; // 发送的位置信息

	private String encryptData;
	private String decryptData;

	@XmlElement(name = "Format")
	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	@XmlElement(name = "PicUrl")
	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	@XmlElement(name = "MediaId")
	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@XmlElement(name = "Title")
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	@XmlElement(name = "Description")
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@XmlElement(name = "Url")
	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	@XmlElement(name = "Location_X")
	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	@XmlElement(name = "Location_Y")
	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	@XmlElement(name = "Scale")
	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	@XmlElement(name = "Label")
	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	@XmlElement(name = "MsgId")
	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	@XmlElement(name = "ToUserName")
	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	@XmlElement(name = "FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	@XmlElement(name = "CreateTime")
	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	@XmlElement(name = "MsgType")
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@XmlElement(name = "Event")
	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	@XmlElement(name = "EventKey")
	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	@XmlElement(name = "Content")
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@XmlElement(name = "Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@XmlElement(name = "Latitude")
	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	@XmlElement(name = "Longitude")
	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	@XmlElement(name = "Precision")
	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	@XmlElement(name = "Ticket")
	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	@XmlElement(name = "ThumbMediaId")
	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	@XmlElement(name = "ScanCodeInfo")
	public WXThirdScanCodeInfoRequestXml getScanCodeInfo() {
		return ScanCodeInfo;
	}

	public void setScanCodeInfo(WXThirdScanCodeInfoRequestXml scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}

	@XmlElement(name = "SendPicsInfo")
	public WXThirdSendPicsInfoRequestXml getSendPicsInfo() {
		return SendPicsInfo;
	}

	public void setSendPicsInfo(WXThirdSendPicsInfoRequestXml sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}

	@XmlElement(name = "SendLocationInfo")
	public WXthirdSendLocationInfoRequestXml getSendLocationInfo() {
		return SendLocationInfo;
	}

	public void setSendLocationInfo(WXthirdSendLocationInfoRequestXml sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}

	public String getEncryptData() {
		return encryptData;
	}

	@XmlElement(name = "Encrypt")
	public void setEncryptData(String encryptData) {
		this.encryptData = encryptData;
	}

	public String getDecryptDate() {
		return this.decryptData;
	}

	@Override
	public boolean isNeedDecrypt() {
		return true;
	}

	@Override
	public void decryptOperate(WXBizMsgCrypt wXBizMsgCrypt) {
		try {
			String xml = wXBizMsgCrypt.decrypt(this.encryptData);
			this.decryptData = xml;
			WXThirdEventMsgRequestXml obj = JAXBUtils.toObject(this.getClass(), xml);
			this.ToUserName = obj.getToUserName();
			this.FromUserName = obj.getFromUserName();
			this.CreateTime = obj.getCreateTime();
			this.MsgType = obj.getMsgType();
			this.Event = obj.getEvent();
			this.EventKey = obj.getEventKey();
			this.MsgId = obj.getMsgId();
			this.Content = obj.getContent();
			this.Location_X = obj.getLocation_X();
			this.Location_Y = obj.getLocation_Y();
			this.Scale = obj.getScale();
			this.Label = obj.getLabel();
			this.Title = obj.getTitle();
			this.Description = obj.getDescription();
			this.Url = obj.getUrl();
			this.PicUrl = obj.getPicUrl();
			this.MediaId = obj.getMediaId();
			this.Format = obj.getFormat();
			this.Status = obj.getStatus();
			this.Latitude = obj.getLatitude();
			this.Longitude = obj.getLongitude();
			this.Precision = obj.getPrecision();
			this.Ticket = obj.getTicket();
			this.ThumbMediaId = obj.getThumbMediaId();
			this.ScanCodeInfo = obj.getScanCodeInfo();
			this.SendPicsInfo = obj.getSendPicsInfo();
			this.SendLocationInfo = obj.getSendLocationInfo();

		} catch (WXThirdAesException e) {
			e.printStackTrace();
		}

	}
}
