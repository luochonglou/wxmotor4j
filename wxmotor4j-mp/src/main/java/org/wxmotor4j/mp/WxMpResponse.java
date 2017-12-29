package org.wxmotor4j.mp;

import org.wxmotor4j.core.WXMotorErrDesc;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信HTTP请求继承响应对象
 * 
 * @ClassName: WxHttpResponse
 * @author Tluo
 * @date 2017年8月5日
 *
 */
public class WxMpResponse {
	/*
	 * 响应原字符串数据
	 */
	@JSONField(name = "jsonData")
	private String jsonData;
	/*
	 * 响应编码
	 */
	@JSONField(name = "errcode")
	private Integer errcode;
	/*
	 * 错误详情
	 */
	@JSONField(name = "errmsg")
	private String errmsg;
	/*
	 * 全局响应说明
	 */
	@JSONField(name = "desc")
	private String desc;

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
		this.desc = WXMotorErrDesc.getDesc(errcode);
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
