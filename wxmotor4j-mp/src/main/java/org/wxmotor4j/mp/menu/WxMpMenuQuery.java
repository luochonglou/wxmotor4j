package org.wxmotor4j.mp.menu;

import java.util.List;

import org.wxmotor4j.mp.WxMpResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 菜单查询对象
 * 
 * @ClassName: WxMpMenuQuery
 * @author Tluo
 * @date 2017年8月5日
 *
 */
public class WxMpMenuQuery extends WxMpResponse{
	@JSONField(name = "menu")
	private WxMpMenu menu;
	@JSONField(name = "conditionalmenu")
	private List<WxMpMenu> conditionalmenu;

	public WxMpMenu getMenu() {
		return menu;
	}

	public void setMenu(WxMpMenu menu) {
		this.menu = menu;
	}

	public List<WxMpMenu> getConditionalmenu() {
		return conditionalmenu;
	}

	public void setConditionalmenu(List<WxMpMenu> conditionalmenu) {
		this.conditionalmenu = conditionalmenu;
	}

}
