package org.wxmotor4j.mp.menu;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 菜单请求响应对象
 * 
 * @ClassName: WxMpMenuResponse
 * @author Tluo
 * @date 2017年8月5日
 *
 */
public class WxMpMenuResponse extends WxMpResponse {
	/*
	 * 菜单id
	 */
	@JSONField(name = "menuid")
	private String menuid;

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

}
