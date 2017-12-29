/**
 * 
 */
package org.wxmotor4j.mp.reply.resmsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxmotor4j.core.utils.xml.CDATAAdapter;

/**
 * 被动回复：视频消息
 * 
 * @ClassName: WxMpVideoResponse
 * @author Tluo
 * @date 2016年12月29日
 *
 */
public class WxMpVideoResponse {

	private String MediaId; // 通过上传多媒体文件，得到的id
	private String Title; // 视频消息的标题
	private String Description; // 视频消息的描述
	private String ThumbMediaId;

	@XmlElement(name = "MediaId")
	public String getMediaId() {
		return MediaId;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@XmlElement(name = "Title")
	public String getTitle() {
		return Title;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setTitle(String title) {
		Title = title;
	}

	@XmlElement(name = "Description")
	public String getDescription() {
		return Description;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setDescription(String description) {
		Description = description;
	}

	@XmlElement(name = "ThumbMediaId")
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
