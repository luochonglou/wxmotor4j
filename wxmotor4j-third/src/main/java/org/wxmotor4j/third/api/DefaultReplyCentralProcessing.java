package org.wxmotor4j.third.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.wxmotor4j.core.WXMotorLogger;
import org.wxmotor4j.core.consts.WXMotorConstsConfig;
import org.wxmotor4j.core.utils.JAXBUtils;
import org.wxmotor4j.third.utils.aes.RandomUtils;
import org.wxmotor4j.third.xml.reqmsg.WXThirdEventMsgRequestXml;
import org.wxmotor4j.third.xml.resmsg.WXThirdArticleResponseXml;
import org.wxmotor4j.third.xml.resmsg.WXThirdEventMsgResponseXml;
import org.wxmotor4j.third.xml.resmsg.WXThirdImageResponseXml;
import org.wxmotor4j.third.xml.resmsg.WXThirdMusicResponseXml;
import org.wxmotor4j.third.xml.resmsg.WXThirdTransInfoResponseXml;
import org.wxmotor4j.third.xml.resmsg.WXThirdVideoResponseXml;
import org.wxmotor4j.third.xml.resmsg.WXThirdVoiceResponseXml;

/**
 * 微信被动回复默认中央处理器
 * 
 * @ClassName: DefaultReplyCentralProcessing
 * @author Tluo
 * @date 2017年7月18日
 *
 */
public class DefaultReplyCentralProcessing implements WXThirdReplyCentralProcessing {
	private String subAppid;

	/**
	 * 微信服务
	 */
	private WXThirdService wxThirdService;

	/**
	 * 具体处理对象，以ConcurrentHashMap方式储存
	 */
	private ConcurrentHashMap<String, WXThirdReplyProcessor> processorMap;

	/**
	 * 微信请求数据
	 */
	private WXThirdEventMsgRequestXml msgRequest;
	/**
	 * 微信响应数据
	 */
	private WXThirdEventMsgResponseXml msgResponse;

	public DefaultReplyCentralProcessing(WXThirdService wxThirdService) {
		super();
		this.wxThirdService = wxThirdService;
		processorMap = new ConcurrentHashMap<String, WXThirdReplyProcessor>();
	}

	public void registerHandle(WXThirdReplyProcessor processor) {
		String key = getKey(processor);
		if (processorMap.containsKey(key))
			return;
		processorMap.put(key, processor); // 添加处理器
	}

	public void removeHandle(WXThirdReplyProcessor processor) {
		String key = getKey(processor);
		if (processorMap.containsKey(key))
			processorMap.remove(key); // 删除处理器
	}

	public String notifyHandle(String requestXml, String subAppid) {
		try {
			this.subAppid = subAppid;
			// 解析并解密消息
			msgRequest = wxThirdService.parsers(requestXml, WXThirdEventMsgRequestXml.class);

			// 发送方帐号open_id
			String fromUserName = msgRequest.getFromUserName();
			// 公众帐号
			String toUserName = msgRequest.getToUserName();
			// 消息类型
			String msgType = msgRequest.getMsgType();
			// 事件类型
			String event = msgRequest.getEvent();
			// 事件KEY值，由开发者在创建菜单时设定
			String eventKey = msgRequest.getEventKey();
			/*
			 * 构造基础响应
			 */
			msgResponse = new WXThirdEventMsgResponseXml();
			msgResponse.setToUserName(fromUserName);
			msgResponse.setFromUserName(toUserName);
			msgResponse.setCreateTime(System.currentTimeMillis() + "");
			WXThirdReplyProcessor processor = getWXThirdReplyProcessor(msgType, event, eventKey);
			if (null != processor) {
				processor.handleMsg();
			} else {
				return "success";
			}
			String xml = JAXBUtils.objectToXML(msgResponse);
			String encrypeXml = wxThirdService.encryptMsg(xml, System.currentTimeMillis() + "",
					RandomUtils.getRandomStr32());// 加密消息
			return encrypeXml;
		} catch (Exception e) {
			WXMotorLogger.printError(e.getMessage());
			return null;
		}

	}

	/**
	 * 获取消息、事件的key
	 * 
	 * @Title: getKey
	 * @return String 返回类型
	 */
	private String getKey(WXThirdReplyProcessor processor) {
		return getKey(processor.getMsgType(), processor.getEvent(), processor.getEventKey());
	}

	/**
	 * 获取消息、事件的key
	 * 
	 * @Title: getKey
	 * @return String 返回类型
	 */
	private String getKey(String msgType, String event, String eventKey) {
		StringBuffer strb = new StringBuffer();
		strb.append("msgType:" + msgType == null ? "" : msgType);
		strb.append("event:" + event == null ? "" : event);
		strb.append("eventKey:" + eventKey == null ? "" : eventKey);
		return strb.toString();
	}

	/**
	 * 匹配处理器
	 * 
	 * @Title: getWXThirdReplyProcessor
	 * @return WXThirdReplyProcessor 返回类型
	 */
	public WXThirdReplyProcessor getWXThirdReplyProcessor(String msgType, String event,
			String eventKey) {
		String key = getKey(msgType, event, eventKey);
		if (processorMap.containsKey(key)) {
			return processorMap.get(key);
		}
		key = getKey(msgType, event, null);
		if (processorMap.containsKey(key)) {
			return processorMap.get(key);
		}
		key = getKey(msgType, null, null);
		if (processorMap.containsKey(key)) {
			return processorMap.get(key);
		}
		key = getKey(null, null, null);
		if (processorMap.containsKey(key)) {
			return processorMap.get(key);
		}
		return null;
	}

	/**
	 * 回复文本消息
	 * 
	 * @param content
	 *            回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	public void responseText(String content) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_TEXT);
		msgResponse.setContent(content);
	}

	/**
	 * 回复图片消息
	 * 
	 * @param mediaId
	 *            通过上传多媒体文件，得到的id
	 */
	public void responseImage(String mediaId) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_IMAGE);
		WXThirdImageResponseXml image = new WXThirdImageResponseXml();
		image.setMediaId(mediaId);
		msgResponse.setImage(image);
	}

	/**
	 * 回复语音消息
	 * 
	 * @param mediaId
	 *            通过上传多媒体文件，得到的id
	 */
	public void responseVoice(String mediaId) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_VOICE);
		WXThirdVoiceResponseXml voice = new WXThirdVoiceResponseXml();
		voice.setMediaId(mediaId);
		msgResponse.setVoice(voice);
	}

	/**
	 * 回复视频消息
	 * 
	 * @param mediaId
	 *            通过上传多媒体文件，得到的id
	 * @param title
	 *            视频消息的标题
	 * @param description
	 *            视频消息的描述
	 */
	public void responseVideo(String mediaId, String title, String description) {
		WXThirdVideoResponseXml video = new WXThirdVideoResponseXml();
		video.setMediaId(mediaId);
		video.setTitle(title);
		video.setDescription(description);
		responseVideo(video);
	}

	/**
	 * 回复视频消息
	 * 
	 * @param video
	 *            视频消息
	 */
	public void responseVideo(WXThirdVideoResponseXml video) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_VIDEO);
		msgResponse.setVideo(video);
	}

	/**
	 * 回复音乐消息
	 * 
	 * @param title
	 *            音乐标题
	 * @param description
	 *            音乐描述
	 * @param musicURL
	 *            音乐链接
	 * @param hQMusicUrl
	 *            高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 * @param thumbMediaId
	 *            缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	public void responseMusic(String title, String description, String musicURL, String hQMusicUrl,
			String thumbMediaId) {
		WXThirdMusicResponseXml music = new WXThirdMusicResponseXml();
		music.setTitle(title);
		music.setDescription(description);
		music.setMusicURL(musicURL);
		music.setHQMusicUrl(hQMusicUrl);
		music.setThumbMediaId(thumbMediaId);
		responseMusic(music);
	}

	/**
	 * 回复音乐消息
	 * 
	 * @param music
	 *            音乐消息
	 */
	public void responseMusic(WXThirdMusicResponseXml music) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_MUSIC);
		msgResponse.setMusic(music);
	}

	/**
	 * 回复图文消息，单条图文消息
	 * 
	 * @param title
	 *            图文消息标题
	 * @param description
	 *            图文消息描述
	 * @param picUrl
	 *            图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 * @param url
	 *            点击图文消息跳转链接
	 */
	public void responseNew(String title, String description, String picUrl, String url) {
		WXThirdArticleResponseXml item = new WXThirdArticleResponseXml();
		item.setTitle(title);
		item.setDescription(description);
		item.setPicUrl(picUrl);
		item.setUrl(url);
		responseNews(item);
	}

	/**
	 * 回复图文消息单条
	 * 
	 * @param item
	 */
	public void responseNews(WXThirdArticleResponseXml item) {
		List<WXThirdArticleResponseXml> items = new ArrayList<WXThirdArticleResponseXml>();
		items.add(item);
		responseNews(items);
	}

	/**
	 * 回复图文消息
	 * 
	 * @param items
	 */
	public void responseNews(List<WXThirdArticleResponseXml> items) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_NEWS);
		msgResponse.setArticleCount(String.valueOf(items.size()));
		msgResponse.setArticle(items);
	}

	/**
	 * 消息转发到多客服
	 */
	public void responseCustomerService() {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_TRANSFER_CUSTOMER_SERVICE);
	}

	/**
	 * 消息转发到指定客服
	 * 
	 * @param kfAccount
	 *            客服账号
	 */
	public void responseCustomerService(String kfAccount) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_TRANSFER_CUSTOMER_SERVICE);
		msgResponse.setTransInfo(new WXThirdTransInfoResponseXml(kfAccount));
	}

	/**
	 * 消息转发到指定客服
	 * 
	 * @param kfAccount
	 *            客服
	 */
	public void responseCustomerService(WXThirdTransInfoResponseXml transInfo) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_TRANSFER_CUSTOMER_SERVICE);
		msgResponse.setTransInfo(transInfo);
	}

	public WXThirdEventMsgRequestXml getMsgRequest() {
		return this.msgRequest;
	}

	public String getSubAppid() {
		return subAppid;
	}

}
