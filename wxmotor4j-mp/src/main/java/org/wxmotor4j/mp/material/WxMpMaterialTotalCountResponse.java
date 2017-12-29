package org.wxmotor4j.mp.material;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 素材总数返回对象
 * 
 * @ClassName: WxMpMaterialTotalCountResponse
 * @author Tluo
 * @date 2017年8月9日
 *
 */
public class WxMpMaterialTotalCountResponse extends WxMpResponse{
	@JSONField(name = "voice_count")
	private Integer voiceCount;
	@JSONField(name = "video_count")
	private Integer videoCount;
	@JSONField(name = "image_count")
	private Integer imageCount;
	@JSONField(name = "news_count")
	private Integer newsCount;

	public Integer getVoiceCount() {
		return voiceCount;
	}

	public void setVoiceCount(Integer voiceCount) {
		this.voiceCount = voiceCount;
	}

	public Integer getVideoCount() {
		return videoCount;
	}

	public void setVideoCount(Integer videoCount) {
		this.videoCount = videoCount;
	}

	public Integer getImageCount() {
		return imageCount;
	}

	public void setImageCount(Integer imageCount) {
		this.imageCount = imageCount;
	}

	public Integer getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(Integer newsCount) {
		this.newsCount = newsCount;
	}

}
