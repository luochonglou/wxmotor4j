/**
 * 
 */
package org.wxmotor4j.third.xml.resmsg;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxmotor4j.core.utils.xml.CDATAAdapter;

/**
 * 被动回复：主体消息
 * 
 * @ClassName: WxMpEntireMsgResponse
 * @author Tluo
 * @date 2016年12月29日
 *
 */
@XmlRootElement(name = "xml")
public class WXThirdEventMsgResponseXml {

	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private String Content;
	private String ArticleCount;

	private WXThirdImageResponseXml Image;
	private WXThirdVoiceResponseXml Voice;
	private WXThirdVideoResponseXml Video;
	private WXThirdMusicResponseXml Music;
	private List<WXThirdArticleResponseXml> article;
	private WXThirdTransInfoResponseXml TransInfo;

	@XmlElement(name = "ToUserName")
	public String getToUserName() {
		return ToUserName;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	@XmlElement(name = "FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	@XmlElement(name = "CreateTime")
	public String getCreateTime() {
		return CreateTime;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	@XmlElement(name = "MsgType")
	public String getMsgType() {
		return MsgType;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@XmlElement(name = "Content")
	public String getContent() {
		return Content;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setContent(String content) {
		Content = content;
	}

	@XmlElement(name = "ArticleCount")
	public String getArticleCount() {
		return ArticleCount;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}

	@XmlElement(name = "Image")
	public WXThirdImageResponseXml getImage() {
		return Image;
	}

	public void setImage(WXThirdImageResponseXml image) {
		Image = image;
	}

	@XmlElement(name = "Voice")
	public WXThirdVoiceResponseXml getVoice() {
		return Voice;
	}

	public void setVoice(WXThirdVoiceResponseXml voice) {
		Voice = voice;
	}

	@XmlElement(name = "Video")
	public WXThirdVideoResponseXml getVideo() {
		return Video;
	}

	public void setVideo(WXThirdVideoResponseXml video) {
		Video = video;
	}

	@XmlElement(name = "Music")
	public WXThirdMusicResponseXml getMusic() {
		return Music;
	}

	public void setMusic(WXThirdMusicResponseXml music) {
		Music = music;
	}

	@XmlElementWrapper(name = "Articles")
	@XmlElement(name = "item")
	public List<WXThirdArticleResponseXml> getArticle() {
		return article;
	}
	public void setArticle(List<WXThirdArticleResponseXml> article) {
		this.article = article;
	}

	@XmlElement(name = "TransInfo")
	public WXThirdTransInfoResponseXml getTransInfo() {
		return TransInfo;
	}

	public void setTransInfo(WXThirdTransInfoResponseXml transInfo) {
		TransInfo = transInfo;
	}

}
