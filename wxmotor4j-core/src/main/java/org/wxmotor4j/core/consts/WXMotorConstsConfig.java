package org.wxmotor4j.core.consts;

/**
 * 微信常量
 * 
 * @ClassName: WXMotorConstsConfig
 * @author Tluo
 * @date 2017年10月12日
 *
 */
public interface WXMotorConstsConfig {
	/**
	 * 请求类型
	 * 
	 * @ClassName: RequestType
	 * @author Tluo
	 * @date 2017年11月6日
	 *
	 */
	public enum RequestType {
		GET, POST
	}

	// =========================================|素材相关|=========================================
	public String MATERIAL_NEWS = "news"; // 素材类型：图文
	public String MATERIAL_VOICE = "voice";// 素材类型：语音
	public String MATERIAL_IMAGE = "image";// 素材类型：图片
	public String MATERIAL_THUMB = "thumb";// 素材类型：缩略图
	public String MATERIAL_VIDEO = "video";// 素材类型：视频

	// =========================================|二维码相关|=========================================
	public String QR_SCENE = "QR_SCENE"; // 二维码类型：临时的整型参数
	public String QR_STR_SCENE = "QR_STR_SCENE"; // 二维码类型：临时的字符串参数
	public String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";// 二维码类型：永久的整型参数
	public String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";// 二维码类型：永久的字符串参数
	public static Long QR_EXPIRESECONDS = 2592000l;// 临时二维码有效期

	// =========================================|被动消息相关|=========================================
	public String CUSTOM_MSG_TEXT = "text";
	public String CUSTOM_MSG_IMAGE = "image";
	public String CUSTOM_MSG_VOICE = "voice";
	public String CUSTOM_MSG_VIDEO = "video";
	public String CUSTOM_MSG_MUSIC = "music";
	public String CUSTOM_MSG_NEWS = "news";
	public String CUSTOM_MSG_FILE = "file";
	public String CUSTOM_MSG_TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";
	public String CUSTOM_MSG_SAFE_NO = "0";
	public String CUSTOM_MSG_SAFE_YES = "1";

	// /////////////////////
	// 微信推送过来的消息的类型，和发送给微信xml格式消息的消息类型
	// /////////////////////
	public String XML_MSG_TEXT = "text";
	public String XML_MSG_IMAGE = "image";
	public String XML_MSG_VOICE = "voice";
	public String XML_MSG_VIDEO = "video";
	public String XML_MSG_NEWS = "news";
	public String XML_MSG_MUSIC = "music";
	public String XML_MSG_LOCATION = "location";
	public String XML_MSG_LINK = "link";
	public String XML_MSG_EVENT = "event";
	public String XML_TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";

	// /////////////////////
	// 群发消息的消息类型
	// /////////////////////
	public String MASS_MSG_NEWS = "mpnews";
	public String MASS_MSG_TEXT = "text";
	public String MASS_MSG_VOICE = "voice";
	public String MASS_MSG_IMAGE = "image";
	public String MASS_MSG_VIDEO = "mpvideo";

	// /////////////////////
	// 群发消息后微信端推送给服务器的反馈消息
	// /////////////////////
	public String MASS_ST_SUCCESS = "send success";
	public String MASS_ST_FAIL = "send fail";
	public String MASS_ST_涉嫌广告 = "err(10001)";
	public String MASS_ST_涉嫌政治 = "err(20001)";
	public String MASS_ST_涉嫌社会 = "err(20004)";
	public String MASS_ST_涉嫌色情 = "err(20002)";
	public String MASS_ST_涉嫌违法犯罪 = "err(20006)";
	public String MASS_ST_涉嫌欺诈 = "err(20008)";
	public String MASS_ST_涉嫌版权 = "err(20013)";
	public String MASS_ST_涉嫌互推_互相宣传 = "err(22000)";
	public String MASS_ST_涉嫌其他 = "err(21000)";

	// /////////////////////
	// 微信端推送过来的事件类型
	// /////////////////////
	public String EVT_SUBSCRIBE = "subscribe";
	public String EVT_UNSUBSCRIBE = "unsubscribe";
	public String EVT_SCAN = "SCAN";
	public String EVT_LOCATION = "LOCATION";
	public String EVT_CLICK = "CLICK";
	public String EVT_VIEW = "VIEW";
	public String EVT_MASS_SEND_JOB_FINISH = "MASSSENDJOBFINISH";
	public String EVT_SCANCODE_PUSH = "scancode_push";
	public String EVT_SCANCODE_WAITMSG = "scancode_waitmsg";
	public String EVT_PIC_SYSPHOTO = "pic_sysphoto";
	public String EVT_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	public String EVT_PIC_WEIXIN = "pic_weixin";
	public String EVT_LOCATION_SELECT = "location_select";
	public String EVT_TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";
	public String EVT_ENTER_AGENT = "enter_agent";

	// /////////////////////
	// 上传多媒体文件的类型
	// /////////////////////
	public String MEDIA_IMAGE = "image";
	public String MEDIA_VOICE = "voice";
	public String MEDIA_VIDEO = "video";
	public String MEDIA_THUMB = "thumb";
	public String MEDIA_FILE = "file";

	// /////////////////////
	// 文件类型
	// /////////////////////
	public String FILE_JPG = "jpeg";
	public String FILE_MP3 = "mp3";
	public String FILE_AMR = "amr";
	public String FILE_MP4 = "mp4";

	// /////////////////////
	// 自定义菜单的按钮类型
	// /////////////////////
	/** 点击推事件 */
	public String BUTTON_CLICK = "click";
	/** 跳转URL */
	public String BUTTON_VIEW = "view";
	/** 扫码推事件 */
	public String BUTTON_SCANCODE_PUSH = "scancode_push";
	/** 扫码推事件且弹出“消息接收中”提示框 */
	public String BUTTON_SCANCODE_WAITMSG = "scancode_waitmsg";
	/** 弹出系统拍照发图 */
	public String PIC_SYSPHOTO = "pic_sysphoto";
	/** 弹出拍照或者相册发图 */
	public String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	/** 弹出微信相册发图器 */
	public String PIC_WEIXIN = "pic_weixin";
	/** 弹出地理位置选择器 */
	public String LOCATION_SELECT = "location_select";

	// /////////////////////
	// oauth2网页授权的scope
	// /////////////////////
	/** 不弹出授权页面，直接跳转，只能获取用户openid */
	public String OAUTH2_SCOPE_BASE = "snsapi_base";
	/** 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息 */
	public String OAUTH2_SCOPE_USER_INFO = "snsapi_userinfo";
	// public String OAUTH2_SCOPE_USER_INFO =
	// "snsapi_base";//暂时用需要用户关注的形式来进行访问

	// /////////////////////

}
