/**
 * 微信请求参数映射类
 * <ul>
 * <li>用于映射微信向公众号发送的消息</li>
 * <li>所有消息均用此类映射，此类类似一个所有消息的‘组合’类</li>
 * </ul>
 */
package org.wxmotor4j.mp.reply.reqmsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信消息：接收主体消息
 * 
 * @ClassName: WxMpEntireMsgRequest
 * @author Tluo
 * @date 2016年12月29日
 *
 */
@XmlRootElement(name = "xml")
public class WxMpEntireMsgRequest {
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
	private WxMpScanCodeInfo ScanCodeInfo; // 扫描信息
	private WxMpSendPicsInfo SendPicsInfo; // 发送的图片信息
	private WxMpSendLocationInfo SendLocationInfo; // 发送的位置信息

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
	public WxMpScanCodeInfo getScanCodeInfo() {
		return ScanCodeInfo;
	}

	public void setScanCodeInfo(WxMpScanCodeInfo scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}

	@XmlElement(name = "SendPicsInfo")
	public WxMpSendPicsInfo getSendPicsInfo() {
		return SendPicsInfo;
	}

	public void setSendPicsInfo(WxMpSendPicsInfo sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}

	@XmlElement(name = "SendLocationInfo")
	public WxMpSendLocationInfo getSendLocationInfo() {
		return SendLocationInfo;
	}

	public void setSendLocationInfo(WxMpSendLocationInfo sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}

}
