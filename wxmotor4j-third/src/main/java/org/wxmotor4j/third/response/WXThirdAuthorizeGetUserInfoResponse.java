package org.wxmotor4j.third.response;

import java.util.List;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXThirdAuthorizeGetUserInfoResponse
 * @author Tluo
 * @date 2017年9月29日
 *
 */
public class WXThirdAuthorizeGetUserInfoResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 5615775745480852926L;

	@JSONField(name = "subscribe")
	private Integer subscribe;

	@JSONField(name = "openid")
	private String openId;

	@JSONField(name = "nickname")
	private String nickname;

	@JSONField(name = "sex")
	private Integer sex;

	@JSONField(name = "province")
	private String province;

	@JSONField(name = "city")
	private String city;

	@JSONField(name = "country")
	private String country;

	@JSONField(name = "headimgurl")
	private String headImgUrl;

	@JSONField(name = "privilege")
	private List<String> privilege;

	@JSONField(name = "unionid")
	private String unionId;

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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public List<String> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(List<String> privilege) {
		this.privilege = privilege;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

}
