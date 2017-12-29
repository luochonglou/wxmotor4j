package org.wxmotor4j.mp.menu;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信MP菜单对象
 * 
 * @ClassName: WxMpMenu
 * @author Tluo
 * @date 2017年8月4日
 *
 */
public class WxMpMenu {
	/* 微信菜单按钮 */
	@JSONField(name = "button")
	private List<WxMpMenuButton> button = new ArrayList<WxMpMenuButton>();
	/* 个性话菜单匹配规则 */
	@JSONField(name = "matchrule")
	private WxMpMenuMatchrule matchrule;
	/* 菜单id */
	@JSONField(name = "menuid")
	private String menuid;

	public List<WxMpMenuButton> getButton() {
		return button;
	}

	public void setButton(List<WxMpMenuButton> button) {
		this.button = button;
	}

	public WxMpMenuMatchrule getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(WxMpMenuMatchrule matchrule) {
		this.matchrule = matchrule;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

}
