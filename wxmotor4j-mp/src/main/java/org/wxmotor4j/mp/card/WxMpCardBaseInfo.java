package org.wxmotor4j.mp.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信卡券基础信息对象
 * 
 * @ClassName: WxMpCardBaseInfo
 * @author Tluo
 * @date 2017年8月18日
 *
 */
public class WxMpCardBaseInfo {

	// /////////////////////////////////////////////////
	// ////////微信卡卷基础信息必选字段
	// ////////////////////////////////////////////////
	/* 卡券的商户logo，建议像素为300*300。 */
	@JSONField(name = "logo_url")
	private String logoUrl;

	/*
	 * 码型：
	 * 
	 * "CODE_TYPE_TEXT"文本；
	 * 
	 * "CODE_TYPE_BARCODE"一维码
	 * 
	 * "CODE_TYPE_QRCODE"二维码
	 * 
	 * "CODE_TYPE_ONLY_QRCODE",二维码无code显示；
	 * 
	 * "CODE_TYPE_ONLY_BARCODE",一维码无code显示；CODE_TYPE_NONE，
	 * 
	 * 不显示code和条形码类型
	 */
	@JSONField(name = "code_type")
	private String codeType;

	/* 商户名字,字数上限为12个汉字。 */
	@JSONField(name = "brand_name")
	private String brandName;

	/* 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。 */
	@JSONField(name = "title")
	private String title;

	/* 券颜色。按色彩规范标注填写Color010-Color100。 */
	@JSONField(name = "color")
	private String color;

	/* 卡券使用提醒，字数上限为16个汉字。 */
	@JSONField(name = "notice")
	private String notice;

	/* 卡券使用说明，字数上限为1024个汉字。 */
	@JSONField(name = "description")
	private String description;

	/* 商品信息。 */
	@JSONField(name = "sku")
	private Sku sku;

	/* 使用日期，有效期的信息。 */
	@JSONField(name = "date_info")
	private DateInfo dateInfo;

	// /////////////////////////////////////////////////
	// ////////微信卡卷基础信息非必选字段
	// ////////////////////////////////////////////////
	/*
	 * 是否自定义Code码。填写true或false，默认为false。通常自有优惠码系统的开发者选择自定义Code码，并在卡券投放时带入Code码，
	 * 详情见是否自定义Code码。
	 */
	@JSONField(name = "use_custom_code")
	private Boolean useCustomCode;

	/*
	 * 填入GET_CUSTOM_CODE_MODE_DEPOSIT表示该卡券为预存code模式卡券，须导入超过库存数目的自定义code后方可投放，填入该字段后
	 * ，quantity字段须为0,须导入code后再增加库存
	 */
	@JSONField(name = "get_custom_code_mode")
	private String getCustomCodeMode;

	/* 是否指定用户领取，填写true或false。默认为false。通常指定特殊用户群体投放卡券或防止刷券时选择指定用户领取。 */
	@JSONField(name = "bind_openid")
	private Boolean bindPpenid;

	/* 客服电话。 */
	@JSONField(name = "service_phone")
	private String servicePhone;

	/* 门店位置poiid。调用POI门店管理接口获取门店位置poiid。具备线下门店的商户为必填。 */
	@JSONField(name = "location_id_list")
	private Integer[] locationIdList;

	/* 设置本卡券支持全部门店，与location_id_list互斥 */
	@JSONField(name = "use_all_locations")
	private Boolean useAllLocations;

	/* 卡券顶部居中的按钮，仅在卡券状态正常(可以核销)时显示 */
	@JSONField(name = "center_title")
	private String centerTitle;

	/* 显示在入口下方的提示语，仅在卡券状态正常(可以核销)时显示。 */
	@JSONField(name = "center_sub_title")
	private String centerSubTitle;

	/* 顶部居中的url，仅在卡券状态正常(可以核销)时显示。 */
	@JSONField(name = "center_url")
	private String centerUrl;

	/* 卡券跳转的小程序的user_name，仅可跳转该公众号绑定的小程序。 */
	@JSONField(name = "center_app_brand_user_name")
	private String centerAppBrandUserName;

	/* 卡券跳转的小程序的path */
	@JSONField(name = "center_app_brand_pass")
	private String centerAppBrandPass;

	/* 自定义跳转外链的入口名字。 */
	@JSONField(name = "custom_url_name")
	private String customUrlName;

	/* 自定义跳转的URL。 */
	@JSONField(name = "custom_url")
	private String customUrl;

	/* 显示在入口右侧的提示语。 */
	@JSONField(name = "custom_url_sub_title")
	private String customUrlSubTitle;

	/* 卡券跳转的小程序的user_name，仅可跳转该公众号绑定的小程序。 */
	@JSONField(name = "custom_app_brand_user_name")
	private String customAppBrandUserName;

	/* 卡券跳转的小程序的path */
	@JSONField(name = "custom_app_brand_pass")
	private String customAppBrandPass;

	/* 营销场景的自定义入口名称。 */
	@JSONField(name = "promotion_url_name")
	private String promotionUrlName;

	/* 入口跳转外链的地址链接。 */
	@JSONField(name = "promotion_url")
	private String promotionUrl;

	/* 显示在营销入口右侧的提示语。 */
	@JSONField(name = "promotion_url_sub_title")
	private String promotionUrlSubTitle;

	/* 卡券跳转的小程序的user_name，仅可跳转该公众号绑定的小程序。 */
	@JSONField(name = "promotion_app_brand_user_name")
	private String promotionAppBrandUserName;

	/* 卡券跳转的小程序的path */
	@JSONField(name = "promotion_app_brand_pass")
	private String promotionAppBrandPass;

	/* 每人可领券的数量限制,不填写默认为50 */
	@JSONField(name = "get_limit")
	private Integer getLimit;

	/* 每人可核销的数量限制,不填写默认为50。 */
	@JSONField(name = "use_limit")
	private Integer useLimit;

	/* 卡券领取页面是否可分享。 */
	@JSONField(name = "can_share")
	private Boolean canShare;

	/* 卡券是否可转赠。 */
	@JSONField(name = "can_give_friend")
	private Boolean canGiveFriend;

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public DateInfo getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}

	public Boolean getUseCustomCode() {
		return useCustomCode;
	}

	public void setUseCustomCode(Boolean useCustomCode) {
		this.useCustomCode = useCustomCode;
	}

	public String getGetCustomCodeMode() {
		return getCustomCodeMode;
	}

	public void setGetCustomCodeMode(String getCustomCodeMode) {
		this.getCustomCodeMode = getCustomCodeMode;
	}

	public Boolean getBindPpenid() {
		return bindPpenid;
	}

	public void setBindPpenid(Boolean bindPpenid) {
		this.bindPpenid = bindPpenid;
	}

	public String getServicePhone() {
		return servicePhone;
	}

	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	public Integer[] getLocationIdList() {
		return locationIdList;
	}

	public void setLocationIdList(Integer[] locationIdList) {
		this.locationIdList = locationIdList;
	}

	public Boolean getUseAllLocations() {
		return useAllLocations;
	}

	public void setUseAllLocations(Boolean useAllLocations) {
		this.useAllLocations = useAllLocations;
	}

	public String getCenterTitle() {
		return centerTitle;
	}

	public void setCenterTitle(String centerTitle) {
		this.centerTitle = centerTitle;
	}

	public String getCenterSubTitle() {
		return centerSubTitle;
	}

	public void setCenterSubTitle(String centerSubTitle) {
		this.centerSubTitle = centerSubTitle;
	}

	public String getCenterUrl() {
		return centerUrl;
	}

	public void setCenterUrl(String centerUrl) {
		this.centerUrl = centerUrl;
	}

	public String getCenterAppBrandUserName() {
		return centerAppBrandUserName;
	}

	public void setCenterAppBrandUserName(String centerAppBrandUserName) {
		this.centerAppBrandUserName = centerAppBrandUserName;
	}

	public String getCenterAppBrandPass() {
		return centerAppBrandPass;
	}

	public void setCenterAppBrandPass(String centerAppBrandPass) {
		this.centerAppBrandPass = centerAppBrandPass;
	}

	public String getCustomUrlName() {
		return customUrlName;
	}

	public void setCustomUrlName(String customUrlName) {
		this.customUrlName = customUrlName;
	}

	public String getCustomUrl() {
		return customUrl;
	}

	public void setCustomUrl(String customUrl) {
		this.customUrl = customUrl;
	}

	public String getCustomUrlSubTitle() {
		return customUrlSubTitle;
	}

	public void setCustomUrlSubTitle(String customUrlSubTitle) {
		this.customUrlSubTitle = customUrlSubTitle;
	}

	public String getCustomAppBrandUserName() {
		return customAppBrandUserName;
	}

	public void setCustomAppBrandUserName(String customAppBrandUserName) {
		this.customAppBrandUserName = customAppBrandUserName;
	}

	public String getCustomAppBrandPass() {
		return customAppBrandPass;
	}

	public void setCustomAppBrandPass(String customAppBrandPass) {
		this.customAppBrandPass = customAppBrandPass;
	}

	public String getPromotionUrlName() {
		return promotionUrlName;
	}

	public void setPromotionUrlName(String promotionUrlName) {
		this.promotionUrlName = promotionUrlName;
	}

	public String getPromotionUrl() {
		return promotionUrl;
	}

	public void setPromotionUrl(String promotionUrl) {
		this.promotionUrl = promotionUrl;
	}

	public String getPromotionUrlSubTitle() {
		return promotionUrlSubTitle;
	}

	public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
		this.promotionUrlSubTitle = promotionUrlSubTitle;
	}

	public String getPromotionAppBrandUserName() {
		return promotionAppBrandUserName;
	}

	public void setPromotionAppBrandUserName(String promotionAppBrandUserName) {
		this.promotionAppBrandUserName = promotionAppBrandUserName;
	}

	public String getPromotionAppBrandPass() {
		return promotionAppBrandPass;
	}

	public void setPromotionAppBrandPass(String promotionAppBrandPass) {
		this.promotionAppBrandPass = promotionAppBrandPass;
	}

	public Integer getGetLimit() {
		return getLimit;
	}

	public void setGetLimit(Integer getLimit) {
		this.getLimit = getLimit;
	}

	public Integer getUseLimit() {
		return useLimit;
	}

	public void setUseLimit(Integer useLimit) {
		this.useLimit = useLimit;
	}

	public Boolean getCanShare() {
		return canShare;
	}

	public void setCanShare(Boolean canShare) {
		this.canShare = canShare;
	}

	public Boolean getCanGiveFriend() {
		return canGiveFriend;
	}

	public void setCanGiveFriend(Boolean canGiveFriend) {
		this.canGiveFriend = canGiveFriend;
	}

	/**
	 * 卡券基础信息Sku对象
	 * 
	 * @ClassName: Sku
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class Sku {
		/* 卡券库存的数量，上限为100000000。 */
		@JSONField(name = "quantity")
		private Integer quantity;

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

	}

	/**
	 * 卡券基础信息DateInfo对象
	 * 
	 * @ClassName: DateInfo
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class DateInfo {
		/*
		 * 使用时间的类型，旧文档采用的1和2依然生效。 DATE_TYPE_FIX_TIME_RANGE 表示固定日期区间，
		 * DATE_TYPE_FIX_TERM表示固定时长（自领取后按天算。
		 */
		@JSONField(name = "type")
		private String type;

		/*
		 * type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，
		 * 最终需转换为字符串形态传入。（东八区时间,UTC+8，单位为秒）
		 */
		@JSONField(name = "begin_timestamp")
		private Long beginTimestamp;

		/* 表示结束时间，建议设置为截止日期的23:59:59过期。（东八区时间,UTC+8，单位为秒） */
		@JSONField(name = "end_timstamp")
		private Long endTimstamp;

		/* type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。 */
		@JSONField(name = "fixed_term")
		private Integer fixedTerm;

		/* type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天） */
		@JSONField(name = "fixed_begin_term")
		private Integer fixedBeginTerm;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Long getBeginTimestamp() {
			return beginTimestamp;
		}

		public void setBeginTimestamp(Long beginTimestamp) {
			this.beginTimestamp = beginTimestamp;
		}

		public Long getEndTimstamp() {
			return endTimstamp;
		}

		public void setEndTimstamp(Long endTimstamp) {
			this.endTimstamp = endTimstamp;
		}

		public Integer getFixedTerm() {
			return fixedTerm;
		}

		public void setFixedTerm(Integer fixedTerm) {
			this.fixedTerm = fixedTerm;
		}

		public Integer getFixedBeginTerm() {
			return fixedBeginTerm;
		}

		public void setFixedBeginTerm(Integer fixedBeginTerm) {
			this.fixedBeginTerm = fixedBeginTerm;
		}

	}
}
