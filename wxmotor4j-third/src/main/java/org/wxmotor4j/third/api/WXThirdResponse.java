package org.wxmotor4j.third.api;

import java.io.Serializable;

import org.wxmotor4j.core.consts.WXMotorErrDesc;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信第三方基础请求返回类
 * 
 * @ClassName: WXThirdResponse
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public  abstract class  WXThirdResponse implements Serializable {
	
	private static final long serialVersionUID = 5640932186504508607L;
	
	/*
	 * 响应原字符串数据
	 */
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


}
