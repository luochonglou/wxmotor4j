package org.wxmotor4j.mp.menu;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信MP按钮对象
 * 
 * @ClassName: WxMpMenuButton
 * @author Tluo
 * @date 2017年8月4日
 *
 */
public class WxMpMenuButton {
	/* 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型 */
	@JSONField(name = "type")
	private String type;
	/* 菜单标题，不超过16个字节，子菜单不超过60个字节 */
	@JSONField(name = "name")
	private String name;
	/* 菜单KEY值，用于消息接口推送，不超过128字节 */
	@JSONField(name = "key")
	private String key;
	/* 网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。 */
	@JSONField(name = "url")
	private String url;
	/* 调用新增永久素材接口返回的合法media_id */
	@JSONField(name = "media_id")
	private String mediaId;
	/* 小程序的appid（仅认证公众号可配置） */
	@JSONField(name = "appid")
	private String appid;
	/* 小程序的页面路径 */
	@JSONField(name = "pagepath")
	private String pagepath;
	/* 子按钮 */
	@JSONField(name = "sub_button")
	private List<WxMpMenuButton> subButton = new ArrayList<WxMpMenuButton>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

	public List<WxMpMenuButton> getSubButton() {
		return subButton;
	}

	public void setSubButton(List<WxMpMenuButton> subButton) {
		this.subButton = subButton;
	}

}
