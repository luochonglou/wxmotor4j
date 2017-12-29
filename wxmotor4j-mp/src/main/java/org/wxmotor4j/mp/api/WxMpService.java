package org.wxmotor4j.mp.api;

import javax.servlet.http.HttpServletRequest;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.mp.jsapi.WxMpJsService;
import org.wxmotor4j.mp.jsapi.WxMpJsServiceImpl;
import org.wxmotor4j.mp.jsapi.WxMpOAuth2AccessToken;
import org.wxmotor4j.mp.menu.WxMpMenu;
import org.wxmotor4j.mp.menu.WxMpMenuQuery;
import org.wxmotor4j.mp.menu.WxMpMenuResponse;
import org.wxmotor4j.mp.menu.WxMpMenuService;
import org.wxmotor4j.mp.menu.WxMpMenuServiceImpl;
import org.wxmotor4j.mp.reply.WxMpCentralProcessing;
import org.wxmotor4j.mp.reply.WxMpDefaultCentralProcessing;
import org.wxmotor4j.mp.reply.WxMpProcessor;

public class WxMpService implements WxMpCentralProcessing, WxMpJsService, WxMpMenuService {
	private WxMpCentralProcessing centralProcessing = new WxMpDefaultCentralProcessing();
	private WxMpJsService wxJsService = new WxMpJsServiceImpl();
	private WxMpMenuService wxMenuService = new WxMpMenuServiceImpl();

	public WxMpService(WxConfigStorage configStorage) {
		initWxConfigStorage(configStorage);
	}

	private void initWxConfigStorage(WxConfigStorage configStorage) {
		centralProcessing.setWxConfigStorage(configStorage);
		wxJsService.setWxConfigStorage(configStorage);
		wxMenuService.setWxConfigStorage(configStorage);
	}

	@Deprecated
	public void setWxConfigStorage(WxConfigStorage configStorage) {
		initWxConfigStorage(configStorage);
	}

	/*
	 * CentralProcessing 被动回复消息
	 */
	public void registerHandle(WxMpProcessor processor) {
		centralProcessing.registerHandle(processor);
	}

	public void removeHandle(WxMpProcessor processor) {
		centralProcessing.removeHandle(processor);
	}

	public String notifyHandle(HttpServletRequest request) {
		return centralProcessing.notifyHandle(request);
	}

	/*
	 * wxJsService接口
	 */

	public String oauth2buildAuthorizationUrl(String redirectURI, String scope, String state)
			throws WXMotorException {
		return wxJsService.oauth2buildAuthorizationUrl(redirectURI, scope, state);
	}

	public WxMpOAuth2AccessToken oauth2getAccessToken(String code) throws WXMotorException {
		return wxJsService.oauth2getAccessToken(code);
	}

	/*
	 * wxMenuService接口
	 */
	public WxMpMenuResponse createMenu(WxMpMenu wxMenu) throws WXMotorException {
		return wxMenuService.createMenu(wxMenu);
	}

	public WxMpMenuQuery getMenu() throws WXMotorException {

		return wxMenuService.getMenu();
	}

	public WxMpMenuResponse deleteMenu() throws WXMotorException {
		return wxMenuService.deleteMenu();
	}

	public WxMpMenuResponse addconditionalMenu(WxMpMenu wxMenu) throws WXMotorException {
		return wxMenuService.addconditionalMenu(wxMenu);
	}

	public WxMpMenuResponse delconditionalMenu(String menuid) throws WXMotorException {
		return wxMenuService.delconditionalMenu(menuid);
	}

	public WxMpMenuResponse trymatchMenu(String userid) throws WXMotorException {
		return wxMenuService.trymatchMenu(userid);
	}

}
