package org.wxmotor4j.third.response;

import java.util.List;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXGetUserInfoResponse
 * @author Tluo
 * @date 2017年10月9日
 *
 */
public class WXGetUserInfoResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -2906695260932709680L;

	@JSONField(name = "subscribe")
	private Integer subscribe;

	@JSONField(name = "openid")
	private String openId;

	@JSONField(name = "nickname")
	private String nickname;

	@JSONField(name = "sex")
	private Integer sex;

	@JSONField(name = "language")
	private String language;

	@JSONField(name = "city")
	private String city;

	@JSONField(name = "province")
	private String province;

	@JSONField(name = "country")
	private String country;

	@JSONField(name = "headimgurl")
	private String headImgUrl;

	@JSONField(name = "subscribe_time")
	private Long subscribeTime;

	@JSONField(name = "unionid")
	private String unionId;

	@JSONField(name = "remark")
	private String remark;

	@JSONField(name = "groupid")
	private Integer groupId;

	@JSONField(name = "tagid_list")
	private List<Integer> tagidList;

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public Long getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Long subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public List<Integer> getTagidList() {
		return tagidList;
	}

	public void setTagidList(List<Integer> tagidList) {
		this.tagidList = tagidList;
	}

}
