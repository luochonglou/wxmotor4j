package org.wxmotor4j.mp.material;

import java.util.List;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 素材列表返回对象
 * 
 * @ClassName: WxMpForeverMaterialListResponse
 * @author Tluo
 * @date 2017年8月9日
 *
 */
public class WxMpForeverMaterialListResponse extends WxMpResponse {
	@JSONField(name = "total_count")
	private Integer totalCount;
	@JSONField(name = "item_count")
	private Integer itemCount;
	@JSONField(name = "item")
	private List<item> item;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	public List<item> getItem() {
		return item;
	}

	public void setItem(List<item> item) {
		this.item = item;
	}

	public class item {
		@JSONField(name = "media_id")
		private Integer mediaId;
		@JSONField(name = "content")
		private content content;

		public Integer getMediaId() {
			return mediaId;
		}

		public void setMediaId(Integer mediaId) {
			this.mediaId = mediaId;
		}

		public content getContent() {
			return content;
		}

		public void setContent(content content) {
			this.content = content;
		}

	}

	public class content {
		@JSONField(name = "news_item")
		private List<WxMpArticles> newsItem;
		@JSONField(name = "update_time")
		private long updateTime;

		public List<WxMpArticles> getNewsItem() {
			return newsItem;
		}

		public void setNewsItem(List<WxMpArticles> newsItem) {
			this.newsItem = newsItem;
		}

		public long getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(long updateTime) {
			this.updateTime = updateTime;
		}

	}

}
