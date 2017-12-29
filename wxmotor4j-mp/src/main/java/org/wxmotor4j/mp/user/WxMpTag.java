package org.wxmotor4j.mp.user;

import java.util.List;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信标签对象
 * 
 * @ClassName: WxMpTag
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public class WxMpTag extends WxMpResponse {

	@JSONField(name = "tags")
	private List<Tag> tags;
	@JSONField(name = "tag")
	private Tag tag;

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public static class Tag {
		/* 标签id，由微信分配 */
		@JSONField(name = "id")
		private Integer id;
		/* 标签名，UTF8编码 */
		@JSONField(name = "name")
		private String name;
		/* 此标签下粉丝数 */
		@JSONField(name = "count")
		private Integer count;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

	}

}
