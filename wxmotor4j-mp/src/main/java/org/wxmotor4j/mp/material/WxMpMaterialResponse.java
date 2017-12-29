package org.wxmotor4j.mp.material;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 素材返回对象
 * 
 * @ClassName: WxMpMaterialResponse
 * @author Tluo
 * @date 2017年8月7日
 *
 */
public class WxMpMaterialResponse extends WxMpResponse {
	/*
	 * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
	 */
	@JSONField(name = "type")
	private String type;
	/*
	 * 媒体文件上传后，获取标识
	 */
	@JSONField(name = "media_id")
	private String mediaId;
	/*
	 * 媒体文件上传时间戳
	 */
	@JSONField(name = "created_at")
	private String createdAt;
	
	@JSONField(name = "url")
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
