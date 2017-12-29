package org.wxmotor4j.mp.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信卡卷对象
 * 
 * @ClassName: WxMpCard
 * @author Tluo
 * @date 2017年8月18日
 *
 */
public class WxMpCard {
	/* 团购券类型。 */
	@JSONField(name = "card_type")
	private String cardType;

	/* 团购券 */
	@JSONField(name = "groupon")
	private WxMpCardGroupon groupon;

	/* 代金券 */
	@JSONField(name = "cash")
	private WxMpCardCash cash;

	/* 折扣券 */
	@JSONField(name = "discount")
	private WxMpCardDiscount discount;

	/* 兑换券 */
	@JSONField(name = "gift")
	private WxMpCardGift gift;

	/* 优惠券 */
	@JSONField(name = "general_coupon")
	private WxMpCardGeneralCoupon generalCoupon;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public WxMpCardGroupon getGroupon() {
		return groupon;
	}

	public void setGroupon(WxMpCardGroupon groupon) {
		this.groupon = groupon;
	}

	public WxMpCardCash getCash() {
		return cash;
	}

	public void setCash(WxMpCardCash cash) {
		this.cash = cash;
	}

	public WxMpCardDiscount getDiscount() {
		return discount;
	}

	public void setDiscount(WxMpCardDiscount discount) {
		this.discount = discount;
	}

	public WxMpCardGift getGift() {
		return gift;
	}

	public void setGift(WxMpCardGift gift) {
		this.gift = gift;
	}

	public WxMpCardGeneralCoupon getGeneralCoupon() {
		return generalCoupon;
	}

	public void setGeneralCoupon(WxMpCardGeneralCoupon generalCoupon) {
		this.generalCoupon = generalCoupon;
	}

	/**
	 * 微信卡卷团购卷对象
	 * 
	 * @ClassName: Groupon
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class WxMpCardGroupon {
		/* 基本的卡券数据，见下表，所有卡券类型通用。 */
		@JSONField(name = "base_info")
		private WxMpCardBaseInfo baseInfo;

		/* 高级的卡券数据 */
		@JSONField(name = "advanced_info")
		private WxMpCardAdvancedInfo advancedInfo;

		/* 团购券专用，团购详情。 */
		@JSONField(name = "deal_detail")
		private String dealDetail;

		public WxMpCardBaseInfo getBaseInfo() {
			return baseInfo;
		}

		public void setBaseInfo(WxMpCardBaseInfo baseInfo) {
			this.baseInfo = baseInfo;
		}

		public WxMpCardAdvancedInfo getAdvancedInfo() {
			return advancedInfo;
		}

		public void setAdvancedInfo(WxMpCardAdvancedInfo advancedInfo) {
			this.advancedInfo = advancedInfo;
		}

		public String getDealDetail() {
			return dealDetail;
		}

		public void setDealDetail(String dealDetail) {
			this.dealDetail = dealDetail;
		}

	}

	/**
	 * 微信卡卷代金券对象
	 * 
	 * @ClassName: WxMpCardCash
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class WxMpCardCash {
		/* 基本的卡券数据，见下表，所有卡券类型通用。 */
		@JSONField(name = "base_info")
		private WxMpCardBaseInfo baseInfo;

		/* 高级的卡券数据 */
		@JSONField(name = "advanced_info")
		private WxMpCardAdvancedInfo advancedInfo;

		/* 代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0 */
		@JSONField(name = "least_cost")
		private Integer leastCost;

		/* 代金券专用，表示减免金额。（单位为分） */
		@JSONField(name = "reduce_cost")
		private Integer reduceCost;

		public WxMpCardBaseInfo getBaseInfo() {
			return baseInfo;
		}

		public void setBaseInfo(WxMpCardBaseInfo baseInfo) {
			this.baseInfo = baseInfo;
		}

		public WxMpCardAdvancedInfo getAdvancedInfo() {
			return advancedInfo;
		}

		public void setAdvancedInfo(WxMpCardAdvancedInfo advancedInfo) {
			this.advancedInfo = advancedInfo;
		}

		public Integer getLeastCost() {
			return leastCost;
		}

		public void setLeastCost(Integer leastCost) {
			this.leastCost = leastCost;
		}

		public Integer getReduceCost() {
			return reduceCost;
		}

		public void setReduceCost(Integer reduceCost) {
			this.reduceCost = reduceCost;
		}

	}

	/**
	 * 微信卡卷折扣券对象
	 * 
	 * @ClassName: WxMpCardDiscount
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class WxMpCardDiscount {
		/* 基本的卡券数据，见下表，所有卡券类型通用。 */
		@JSONField(name = "base_info")
		private WxMpCardBaseInfo baseInfo;

		/* 高级的卡券数据 */
		@JSONField(name = "advanced_info")
		private WxMpCardAdvancedInfo advancedInfo;

		/* 折扣券专用，表示打折额度（百分比）。填30就是七折。 */
		@JSONField(name = "discount")
		private Integer discount;

		public WxMpCardBaseInfo getBaseInfo() {
			return baseInfo;
		}

		public void setBaseInfo(WxMpCardBaseInfo baseInfo) {
			this.baseInfo = baseInfo;
		}

		public WxMpCardAdvancedInfo getAdvancedInfo() {
			return advancedInfo;
		}

		public void setAdvancedInfo(WxMpCardAdvancedInfo advancedInfo) {
			this.advancedInfo = advancedInfo;
		}

		public Integer getDiscount() {
			return discount;
		}

		public void setDiscount(Integer discount) {
			this.discount = discount;
		}

	}

	/**
	 * 微信卡卷兑换券对象
	 * 
	 * @ClassName: WxMpCardGift
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class WxMpCardGift {
		/* 基本的卡券数据，见下表，所有卡券类型通用。 */
		@JSONField(name = "base_info")
		private WxMpCardBaseInfo baseInfo;

		/* 高级的卡券数据 */
		@JSONField(name = "advanced_info")
		private WxMpCardAdvancedInfo advancedInfo;

		/* 兑换券专用，填写兑换内容的名称。 */
		@JSONField(name = "gift")
		private String gift;

		public WxMpCardBaseInfo getBaseInfo() {
			return baseInfo;
		}

		public void setBaseInfo(WxMpCardBaseInfo baseInfo) {
			this.baseInfo = baseInfo;
		}

		public WxMpCardAdvancedInfo getAdvancedInfo() {
			return advancedInfo;
		}

		public void setAdvancedInfo(WxMpCardAdvancedInfo advancedInfo) {
			this.advancedInfo = advancedInfo;
		}

		public String getGift() {
			return gift;
		}

		public void setGift(String gift) {
			this.gift = gift;
		}

	}

	/**
	 * 微信卡卷优惠券对象
	 * 
	 * @ClassName: WxMpCardGeneralCoupon
	 * @author Tluo
	 * @date 2017年8月18日
	 *
	 */
	public static class WxMpCardGeneralCoupon {
		/* 基本的卡券数据，见下表，所有卡券类型通用。 */
		@JSONField(name = "base_info")
		private WxMpCardBaseInfo baseInfo;

		/* 高级的卡券数据 */
		@JSONField(name = "advanced_info")
		private WxMpCardAdvancedInfo advancedInfo;

		/* 优惠券专用，填写优惠详情。 */
		@JSONField(name = "default_detail")
		private String defaultDetail;

		public WxMpCardBaseInfo getBaseInfo() {
			return baseInfo;
		}

		public void setBaseInfo(WxMpCardBaseInfo baseInfo) {
			this.baseInfo = baseInfo;
		}

		public WxMpCardAdvancedInfo getAdvancedInfo() {
			return advancedInfo;
		}

		public void setAdvancedInfo(WxMpCardAdvancedInfo advancedInfo) {
			this.advancedInfo = advancedInfo;
		}

		public String getDefaultDetail() {
			return defaultDetail;
		}

		public void setDefaultDetail(String defaultDetail) {
			this.defaultDetail = defaultDetail;
		}

	}

}
