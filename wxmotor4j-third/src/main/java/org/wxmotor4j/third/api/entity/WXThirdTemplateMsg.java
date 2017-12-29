package org.wxmotor4j.third.api.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信模版消息
 * 
 * @ClassName: WXThirdTemplateMsg
 * @author Tluo
 * @date 2017年9月29日
 *
 */
public class WXThirdTemplateMsg {
	private String touser;
	private String templateId;
	private String url;
	private String topColor;
	private Miniprogram miniprogram;
	private TemplateData data;

	public String getTouser() {
		return touser;
	}

	@JSONField(name = "touser")
	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplateId() {
		return templateId;
	}

	@JSONField(name = "template_id")
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	@JSONField(name = "url")
	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopColor() {
		return topColor;
	}

	@JSONField(name = "top_color")
	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}

	public Miniprogram getMiniprogram() {
		return miniprogram;
	}

	@JSONField(name = "miniprogram")
	public void setMiniprogram(Miniprogram miniprogram) {
		this.miniprogram = miniprogram;
	}

	public TemplateData getData() {
		return data;
	}

	@JSONField(name = "data")
	public void setData(TemplateData data) {
		this.data = data;
	}

	/**
	 * 模版消息静态内部类：跳小程序所需数据，不需跳小程序可不用传该数据
	 * 
	 * @ClassName: Miniprogram
	 * @author Tluo
	 * @date 2017年9月29日
	 *
	 */
	public static class Miniprogram {
		private String appid;
		private String pagepath;

		public String getAppid() {
			return appid;
		}

		@JSONField(name = "appid")
		public void setAppid(String appid) {
			this.appid = appid;
		}

		public String getPagepath() {
			return pagepath;
		}

		@JSONField(name = "pagepath")
		public void setPagepath(String pagepath) {
			this.pagepath = pagepath;
		}

	}

	/**
	 * 模版消息静态内部类： 模板数据
	 * 
	 * @ClassName: TemplateData
	 * @author Tluo
	 * @date 2017年9月29日
	 *
	 */
	public static class TemplateData {
		private DataInfo first;
		private DataInfo keynote1;
		private DataInfo keynote2;
		private DataInfo keynote3;
		private DataInfo keynote4;
		private DataInfo remark;

		public DataInfo getFirst() {
			return first;
		}

		@JSONField(name = "first")
		public void setFirst(DataInfo first) {
			this.first = first;
		}

		public DataInfo getKeynote1() {
			return keynote1;
		}

		@JSONField(name = "keynote1")
		public void setKeynote1(DataInfo keynote1) {
			this.keynote1 = keynote1;
		}

		public DataInfo getKeynote2() {
			return keynote2;
		}

		@JSONField(name = "keynote2")
		public void setKeynote2(DataInfo keynote2) {
			this.keynote2 = keynote2;
		}

		public DataInfo getKeynote3() {
			return keynote3;
		}

		@JSONField(name = "keynote3")
		public void setKeynote3(DataInfo keynote3) {
			this.keynote3 = keynote3;
		}

		public DataInfo getKeynote4() {
			return keynote4;
		}

		@JSONField(name = "keynote4")
		public void setKeynote4(DataInfo keynote4) {
			this.keynote4 = keynote4;
		}

		public DataInfo getRemark() {
			return remark;
		}

		@JSONField(name = "remark")
		public void setRemark(DataInfo remark) {
			this.remark = remark;
		}

	}

	/**
	 * 模版消息静态内部类： 模版数据详情
	 * 
	 * @ClassName: DataInfo
	 * @author Tluo
	 * @date 2017年9月29日
	 *
	 */
	public static class DataInfo {
		private String name;
		private String value;
		private String color;

		public DataInfo() {
		}

		public DataInfo(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public DataInfo(String name, String value, String color) {
			this.name = name;
			this.value = value;
			this.color = color;
		}

		public String getName() {
			return name;
		}

		@JSONField(name = "name")
		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		@JSONField(name = "value")
		public void setValue(String value) {
			this.value = value;
		}

		public String getColor() {
			return color;
		}

		@JSONField(name = "color")
		public void setColor(String color) {
			this.color = color;
		}

	}
}
