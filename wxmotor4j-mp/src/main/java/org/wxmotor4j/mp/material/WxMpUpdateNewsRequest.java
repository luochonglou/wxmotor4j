package org.wxmotor4j.mp.material;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 修改永久图文素材请求对象
 * 
 * @ClassName: WxMpUpdateNewsRequest
 * @author Tluo
 * @date 2017年8月9日
 *
 */
public class WxMpUpdateNewsRequest {
	@JSONField(name = "media_id")
	String mediaId;
	@JSONField(name = "index")
	Integer index;
	@JSONField(name = "articles")
	WxMpArticles articles;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public WxMpArticles getArticles() {
		return articles;
	}

	public void setArticles(WxMpArticles articles) {
		this.articles = articles;
	}

}
