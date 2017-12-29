package org.wxmotor4j.mp.menu;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.mp.api.WxMpApi;

/**
 * 微信菜单管理服务
 * 
 * @ClassName: WxMpMenuService
 * @author Tluo
 * @date 2017年8月10日
 *
 */
public interface WxMpMenuService extends WxMpApi {

	public WxMpMenuResponse createMenu(WxMpMenu wxMenu) throws WXMotorException;

	public WxMpMenuQuery getMenu() throws WXMotorException;

	public WxMpMenuResponse deleteMenu() throws WXMotorException;

	public WxMpMenuResponse addconditionalMenu(WxMpMenu wxMenu) throws WXMotorException;

	public WxMpMenuResponse delconditionalMenu(String menuid) throws WXMotorException;

	public WxMpMenuResponse trymatchMenu(String userid) throws WXMotorException;

}
