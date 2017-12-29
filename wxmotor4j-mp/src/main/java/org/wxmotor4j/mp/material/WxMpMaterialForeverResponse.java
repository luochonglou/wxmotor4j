package org.wxmotor4j.mp.material;

import java.util.List;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 永久素材查询返回对象
 * 
 * @ClassName: WxMpMaterialForeverResponse
 * @author Tluo
 * @date 2017年8月9日
 *
 */
public class WxMpMaterialForeverResponse extends WxMpResponse {
	@JSONField(name = "news_item")
	private List<WxMpArticles> newsItem;
	@JSONField(name = "title")
	private String title;
	@JSONField(name = "description")
	private String description;
	@JSONField(name = "down_url")
	private String downUrl;

	public List<WxMpArticles> getNewsItem() {
		return newsItem;
	}

	public void setNewsItem(List<WxMpArticles> newsItem) {
		this.newsItem = newsItem;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDownUrl() {
		return downUrl;
	}

	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}

}
