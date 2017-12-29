package org.wxmotor4j.mp.reply;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.wxmotor4j.core.WXMotorConstsConfig;
import org.wxmotor4j.core.WXMotorLogger;
import org.wxmotor4j.core.utils.JAXBUtils;
import org.wxmotor4j.core.utils.SignUtil;
import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.mp.api.WxConfigStorage;
import org.wxmotor4j.mp.reply.reqmsg.WxMpEntireMsgRequest;
import org.wxmotor4j.mp.reply.resmsg.WxMpArticleResponse;
import org.wxmotor4j.mp.reply.resmsg.WxMpEntireMsgResponse;
import org.wxmotor4j.mp.reply.resmsg.WxMpImageResponse;
import org.wxmotor4j.mp.reply.resmsg.WxMpMusicResponse;
import org.wxmotor4j.mp.reply.resmsg.WxMpTransInfoResponse;
import org.wxmotor4j.mp.reply.resmsg.WxMpVideoResponse;
import org.wxmotor4j.mp.reply.resmsg.WxMpVoiceResponse;

/**
 * 微信被动回复默认中央处理器
 * 
 * @ClassName: WxMpDefaultCentralProcessing
 * @author Tluo
 * @date 2017年7月18日
 *
 */
public class WxMpDefaultCentralProcessing implements WxMpCentralProcessing {

	private WxConfigStorage configStorage;

	/**
	 * 具体处理对象，以ConcurrentHashMap方式储存
	 */
	private ConcurrentHashMap<String, WxMpProcessor> processorMap;

	/**
	 * 微信请求数据
	 */
	private WxMpEntireMsgRequest msgRequest;
	/**
	 * 微信响应数据
	 */
	private WxMpEntireMsgResponse msgResponse;

	public WxMpDefaultCentralProcessing() {
		super();
		processorMap = new ConcurrentHashMap<String, WxMpProcessor>();
	}

	public void registerHandle(WxMpProcessor processor) {
		String key = getKey(processor);
		if (processorMap.containsKey(key))
			return;
		processorMap.put(key, processor); // 添加处理器
	}

	public void removeHandle(WxMpProcessor processor) {
		String key = getKey(processor);
		if (processorMap.containsKey(key))
			processorMap.remove(key); // 删除处理器
	}

	public String notifyHandle(HttpServletRequest request) {
		try {

			// 微信加密签名
			String signature = request.getParameter("signature");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce");
			// 随机字符串，用于效验第一次连接请求
			String echostr = request.getParameter("echostr");

			if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(nonce)
					|| StringUtils.isEmpty(timestamp)) {
				WXMotorLogger
						.printError("request for service validation failed , parameter is empty...");
				return "error";
			}
			// 通过检验signature对请求进行校验
			if (!SignUtil.checkSignature(signature, timestamp, nonce, configStorage.getToken())) {
				WXMotorLogger
						.printError("request for service validation failed , signature error...");
				return "error";
			}
			if (StringUtils.isNotEmpty(echostr)) {
				return echostr;
			}
			msgRequest = JAXBUtils.inputStreamtoObject(request.getInputStream(),
					WxMpEntireMsgRequest.class);
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
			msgResponse = new WxMpEntireMsgResponse();
			msgResponse.setToUserName(fromUserName);
			msgResponse.setFromUserName(toUserName);
			msgResponse.setCreateTime(System.currentTimeMillis() + "");
			String key = getKey(msgType, event, eventKey);
			if (processorMap.containsKey(key)) {
				WxMpProcessor processor = processorMap.get(key);
				processor.handleMsg();
			} else {
				key = getKey(null, null, null);
				if (processorMap.containsKey(key)) {
					WxMpProcessor processor = processorMap.get(key);
					processor.handleMsg();
				}
			}
			return JAXBUtils.objectToXML(msgResponse);
		} catch (Exception e) {
			WXMotorLogger.printError(e.getMessage());
			return null;
		}

	}

	public void setWxConfigStorage(WxConfigStorage configStorage) {
		this.configStorage = configStorage;

	}

	/**
	 * 获取消息、事件的key
	 * 
	 * @Title: getKey
	 * @return String 返回类型
	 */
	private String getKey(WxMpProcessor processor) {
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
		strb.append("msgType:" + msgType);
		strb.append("event:" + event);
		strb.append("eventKey:" + eventKey);
		return strb.toString();
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
		WxMpImageResponse image = new WxMpImageResponse();
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
		WxMpVoiceResponse voice = new WxMpVoiceResponse();
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
		WxMpVideoResponse video = new WxMpVideoResponse();
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
	public void responseVideo(WxMpVideoResponse video) {
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
		WxMpMusicResponse music = new WxMpMusicResponse();
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
	public void responseMusic(WxMpMusicResponse music) {
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
		WxMpArticleResponse item = new WxMpArticleResponse();
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
	public void responseNews(WxMpArticleResponse item) {
		List<WxMpArticleResponse> items = new ArrayList<WxMpArticleResponse>();
		items.add(item);
		responseNews(items);
	}

	/**
	 * 回复图文消息
	 * 
	 * @param items
	 */
	public void responseNews(List<WxMpArticleResponse> items) {
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
		msgResponse.setTransInfo(new WxMpTransInfoResponse(kfAccount));
	}

	/**
	 * 消息转发到指定客服
	 * 
	 * @param kfAccount
	 *            客服
	 */
	public void responseCustomerService(WxMpTransInfoResponse transInfo) {
		msgResponse.setMsgType(WXMotorConstsConfig.CUSTOM_MSG_TRANSFER_CUSTOMER_SERVICE);
		msgResponse.setTransInfo(transInfo);
	}

}
