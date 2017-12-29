package org.wxmotor4j.mp.account;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信二维码对象
 * 
 * @ClassName: WxMpQrcode
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public class WxMpQrcode extends WxMpResponse {

	/* 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。 */
	@JSONField(name = "expire_seconds")
	private Long expireSeconds;
	/*
	 * 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，
	 * QR_LIMIT_STR_SCENE为永久的字符串参数值
	 */
	@JSONField(name = "action_name")
	private String actionName;

	/* 二维码详细信息 */
	@JSONField(name = "action_info")
	private WxMpScene actionInfo;
	/* 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。 */

	@JSONField(name = "ticket")
	private String ticket;
	/* 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天） */

	/* 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片 */
	@JSONField(name = "url")
	private String url;

	public Long getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(Long expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public WxMpScene getActionInfo() {
		return actionInfo;
	}

	public void setActionInfo(WxMpScene actionInfo) {
		this.actionInfo = actionInfo;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static class WxMpScene {

		@JSONField(name = "scene")
		private WxMpScene scene;
		/* 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000） */
		@JSONField(name = "scene_id")
		private Integer sceneId;

		/* 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64 */
		@JSONField(name = "scene_str")
		private String sceneStr;

		public WxMpScene getScene() {
			return scene;
		}

		public void setScene(WxMpScene scene) {
			this.scene = scene;
		}

		public Integer getSceneId() {
			return sceneId;
		}

		public void setSceneId(Integer sceneId) {
			this.sceneId = sceneId;
		}

		public String getSceneStr() {
			return sceneStr;
		}

		public void setSceneStr(String sceneStr) {
			this.sceneStr = sceneStr;
		}

	}
}
