/**
 * 
 */
package org.wxmotor4j.mp.reply.resmsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxmotor4j.core.utils.xml.CDATAAdapter;

/**
 * 被动回复：图文消息
 * 
 * @ClassName: WxMpArticleResponse
 * @author Tluo
 * @date 2016年12月29日
 *
 */
public class WxMpArticleResponse {

	private String Title; // 图文消息标题
	private String Description; // 图文消息描述
	private String PicUrl; // 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	private String Url; // 点击图文消息跳转链接

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

	@XmlElement(name = "PicUrl")
	public String getPicUrl() {
		return PicUrl;
	}

	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	@XmlElement(name = "Url")
	public String getUrl() {
		return Url;
	}

	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setUrl(String url) {
		Url = url;
	}

}
