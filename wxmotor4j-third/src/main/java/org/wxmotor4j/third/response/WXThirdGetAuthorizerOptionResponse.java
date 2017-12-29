package org.wxmotor4j.third.response;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXThirdGetAuthorizerOptionResponse
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class WXThirdGetAuthorizerOptionResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 7565817831552348958L;

	@JSONField(name = "authorizer_appid")
	private String authorizerAppid;

	@JSONField(name = "option_name")
	private String optionName;

	@JSONField(name = "option_value")
	private Integer optionValue;

	public String getAuthorizerAppid() {
		return authorizerAppid;
	}

	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Integer getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(Integer optionValue) {
		this.optionValue = optionValue;
	}

}
