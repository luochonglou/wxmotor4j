/**
 * 
 */
package org.wxmotor4j.mp.reply.resmsg;

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
public class WxMpEntireMsgResponse {

	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private String Content;
	private String ArticleCount;

	private WxMpImageResponse Image;
	private WxMpVoiceResponse Voice;
	private WxMpVideoResponse Video;
	private WxMpMusicResponse Music;
	private List<WxMpArticleResponse> article;
	private WxMpTransInfoResponse TransInfo;

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
	public WxMpImageResponse getImage() {
		return Image;
	}

	public void setImage(WxMpImageResponse image) {
		Image = image;
	}

	@XmlElement(name = "Voice")
	public WxMpVoiceResponse getVoice() {
		return Voice;
	}

	public void setVoice(WxMpVoiceResponse voice) {
		Voice = voice;
	}

	@XmlElement(name = "Video")
	public WxMpVideoResponse getVideo() {
		return Video;
	}

	public void setVideo(WxMpVideoResponse video) {
		Video = video;
	}

	@XmlElement(name = "Music")
	public WxMpMusicResponse getMusic() {
		return Music;
	}

	public void setMusic(WxMpMusicResponse music) {
		Music = music;
	}

	@XmlElementWrapper(name = "Articles")
	@XmlElement(name = "item")
	public List<WxMpArticleResponse> getArticle() {
		return article;
	}
	public void setArticle(List<WxMpArticleResponse> article) {
		this.article = article;
	}

	@XmlElement(name = "TransInfo")
	public WxMpTransInfoResponse getTransInfo() {
		return TransInfo;
	}

	public void setTransInfo(WxMpTransInfoResponse transInfo) {
		TransInfo = transInfo;
	}

}
