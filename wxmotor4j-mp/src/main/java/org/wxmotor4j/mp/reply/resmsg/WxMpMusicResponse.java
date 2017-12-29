/**
 * 
 */
package org.wxmotor4j.mp.reply.resmsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxmotor4j.core.utils.xml.CDATAAdapter;

/**
 * 被动回复：音乐消息
 * 
 * @ClassName: WxMpMusicResponse
 * @author Tluo
 * @date 2016年12月29日
 *
 */
public class WxMpMusicResponse {

	private String Title; // 音乐标题
	private String Description; // 音乐描述
	private String MusicURL; // 音乐链接
	private String HQMusicUrl; // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	private String ThumbMediaId; // 缩略图的媒体id，通过上传多媒体文件，得到的id

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

	@XmlElement(name = "MusicURL")
	public String getMusicURL() {
		return MusicURL;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}

	@XmlElement(name = "HQMusicUrl")
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
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
