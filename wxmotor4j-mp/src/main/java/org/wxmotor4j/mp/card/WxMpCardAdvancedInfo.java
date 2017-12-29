package org.wxmotor4j.mp.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信卡券高级信息对象
 * <ul>
 * <li>1.高级字段为商户额外展示信息字段，非必填,但是填入某些结构体后，须填充完整方可显示：如填入text_image_list结构体时，
 * 须同时传入image_url和text，否则也会报错；
 * <li>
 * <li>2.填入时间限制字段（time_limit）,只控制显示，不控制实际使用逻辑，不填默认不显示；
 * <li>
 * <li>3.创建卡券时，开发者填入的时间戳须注意时间戳溢出时间，设置的时间戳须早于2038年1月19日；
 * <li>
 * <li>4.预存code模式的卡券须设置quantity为0，导入code后方可增加库存；
 * <li>
 * <li>5.卡券自定义cell跳转小程序支持的最低微信客户端版本为6.5.8，低版本用户仍然会跳转url，高版本会跳转小程序；
 * <li>
 * <ul>
 * 
 * @ClassName: WxMpCardAdvancedInfo
 * @author Tluo
 * @date 2017年8月18日
 */
public class WxMpCardAdvancedInfo {
	/*
	 * 使用门槛（条件）字段，若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；并在使用说明显示： 可与其他优惠共享
	 */
	@JSONField(name = "use_condition")
	private UseCondition useCondition;

	/* 封面摘要结构体名称 */
	@JSONField(name = "abstract")
	private AbstractInfo abstractInfo;

	/*
	 * 图文列表，显示在详情内页 ，优惠券券开发者须至少传入 一组图文列表
	 */
	@JSONField(name = "text_image_list")
	private TextImage[] textImageList;

	/* 使用时段限制，包含以下字段 */
	@JSONField(name = "time_limit")
	private TimeLimit[] timeLimit;

	/*
	 * 商家服务类型： BIZ_SERVICE_DELIVER 外卖服务； BIZ_SERVICE_FREE_PARK 停车位；
	 * BIZ_SERVICE_WITH_PET 可带宠物； BIZ_SERVICE_FREE_WIFI 免费wifi，
	 * 
	 * 可多选
	 */
	@JSONField(name = "business_service")
	private String[] businessService;

	public UseCondition getUseCondition() {
		return useCondition;
	}

	public void setUseCondition(UseCondition useCondition) {
		this.useCondition = useCondition;
	}

	public AbstractInfo getAbstractInfo() {
		return abstractInfo;
	}

	public void setAbstractInfo(AbstractInfo abstractInfo) {
		this.abstractInfo = abstractInfo;
	}

	public TextImage[] getTextImageList() {
		return textImageList;
	}

	public void setTextImageList(TextImage[] textImageList) {
		this.textImageList = textImageList;
	}

	public TimeLimit[] getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(TimeLimit[] timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String[] getBusinessService() {
		return businessService;
	}

	public void setBusinessService(String[] businessService) {
		this.businessService = businessService;
	}

	/**
	 * 微信卡券高级信息UseCondition对象
	 * 
	 * @ClassName: UseCondition
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class UseCondition {
		/*
		 * 指定可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写适用于xxx
		 */
		@JSONField(name = "accept_category")
		private String acceptCategory;

		/*
		 * 指定不可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写不适用于xxxx
		 */
		@JSONField(name = "reject_category")
		private String rejectCategory;

		/*
		 * 满减门槛字段，可用于兑换券和代金券 ，填入后将在全面拼写消费满xx元可用。
		 */
		@JSONField(name = "least_cost")
		private Integer leastCost;

		/* 购买xx可用类型门槛，仅用于兑换，填入后自动拼写购买xxx可用。 */
		@JSONField(name = "object_use_for")
		private String objectUseFor;

		/*
		 * 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”，填写true时系统将在使用须知里拼写“可与其他优惠共享
		 * ”，默认为true
		 */
		@JSONField(name = "can_use_with_other_discount")
		private Boolean canUseWithOtherDiscount;

		public String getAcceptCategory() {
			return acceptCategory;
		}

		public void setAcceptCategory(String acceptCategory) {
			this.acceptCategory = acceptCategory;
		}

		public String getRejectCategory() {
			return rejectCategory;
		}

		public void setRejectCategory(String rejectCategory) {
			this.rejectCategory = rejectCategory;
		}

		public Integer getLeastCost() {
			return leastCost;
		}

		public void setLeastCost(Integer leastCost) {
			this.leastCost = leastCost;
		}

		public String getObjectUseFor() {
			return objectUseFor;
		}

		public void setObjectUseFor(String objectUseFor) {
			this.objectUseFor = objectUseFor;
		}

		public Boolean getCanUseWithOtherDiscount() {
			return canUseWithOtherDiscount;
		}

		public void setCanUseWithOtherDiscount(Boolean canUseWithOtherDiscount) {
			this.canUseWithOtherDiscount = canUseWithOtherDiscount;
		}

	}

	/**
	 * 微信卡券高级信息Abstract对象
	 * 
	 * @ClassName: AbstractInfo
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class AbstractInfo {
		/* 封面摘要简介 */
		@JSONField(name = "abstract")
		private String abstractInfo;
		/*
		 * 封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，填写非CDN链接会报错，并在此填入。建议图片尺寸像素850*350
		 */
		@JSONField(name = "icon_url_list")
		private String iconUrlList;

		public String getAbstractInfo() {
			return abstractInfo;
		}

		public void setAbstractInfo(String abstractInfo) {
			this.abstractInfo = abstractInfo;
		}

		public String getIconUrlList() {
			return iconUrlList;
		}

		public void setIconUrlList(String iconUrlList) {
			this.iconUrlList = iconUrlList;
		}

	}

	/**
	 * 微信卡券高级信息TextImage对象
	 * 
	 * @ClassName: TextImage
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class TextImage {
		/* 图片链接，必须调用上传图片接口上传图片获得链接，并在此填入，否则报错 */
		@JSONField(name = "image_url")
		private String imageUrl;
		/* 图文描述 */
		@JSONField(name = "text")
		private String text;

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}

	/**
	 * 微信卡券高级信息TimeLimit对象
	 * 
	 * @ClassName: TimeLimit
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class TimeLimit {
		/*
		 * 限制类型枚举值：支持填入 MONDAY 周一 TUESDAY 周二 WEDNESDAY 周三 THURSDAY 周四 FRIDAY 周五
		 * SATURDAY 周六 SUNDAY 周日 此处只控制显示， 不控制实际使用逻辑，不填默认不显示
		 */
		@JSONField(name = "type")
		private String type;

		/* 当前type类型下的起始时间（小时），如当前结构体内填写了MONDAY，此处填写了10，则此处表示周一 10:00可用 */
		@JSONField(name = "begin_hour")
		private Integer beginHour;

		/*
		 * 当前type类型下的起始时间（分钟），如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一
		 * 10:59可用
		 */
		@JSONField(name = "begin_minute")
		private Integer beginMinute;

		/* 当前type类型下的结束时间（小时），如当前结构体内填写了MONDAY，此处填写了20，则此处表示周一 10:00-20:00可用 */
		@JSONField(name = "end_hour")
		private Integer endHour;

		/*
		 * 当前type类型下的结束时间（分钟），如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一
		 * 10:59-00:59可用
		 */
		@JSONField(name = "end_minute")
		private Integer endMinute;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getBeginHour() {
			return beginHour;
		}

		public void setBeginHour(Integer beginHour) {
			this.beginHour = beginHour;
		}

		public Integer getBeginMinute() {
			return beginMinute;
		}

		public void setBeginMinute(Integer beginMinute) {
			this.beginMinute = beginMinute;
		}

		public Integer getEndHour() {
			return endHour;
		}

		public void setEndHour(Integer endHour) {
			this.endHour = endHour;
		}

		public Integer getEndMinute() {
			return endMinute;
		}

		public void setEndMinute(Integer endMinute) {
			this.endMinute = endMinute;
		}

	}

}
