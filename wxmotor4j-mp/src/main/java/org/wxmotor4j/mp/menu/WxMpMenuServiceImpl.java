package org.wxmotor4j.mp.menu;

import java.util.HashMap;
import java.util.Map;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.utils.http.WxHttpClient;
import org.wxmotor4j.mp.api.WxApiGateway;
import org.wxmotor4j.mp.api.WxConfigStorage;

import com.alibaba.fastjson.JSONObject;

public class WxMpMenuServiceImpl implements WxMpMenuService {

	private WxConfigStorage configStorage;

	public WxMpMenuResponse createMenu(WxMpMenu wxMenu) throws WXMotorException {
		try {
			String accessToken = configStorage.getAccessToken();
			String url = WxApiGateway.menu_create_gateway.replaceAll("ACCESS_TOKEN", accessToken);
			String jsonParams = JSONObject.toJSONString(wxMenu);
			String jsonData = WxHttpClient.doPost(url, jsonParams);
			WxMpMenuResponse res = JSONObject.parseObject(jsonData, WxMpMenuResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpMenuQuery getMenu() throws WXMotorException {
		try {
			String accessToken = configStorage.getAccessToken();
			String url = WxApiGateway.menu_get_gateway.replaceAll("ACCESS_TOKEN", accessToken);
			String jsonData = WxHttpClient.doGet(url, null);
			WxMpMenuQuery res = JSONObject.parseObject(jsonData, WxMpMenuQuery.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	public WxMpMenuResponse deleteMenu() throws WXMotorException {
		try {
			String accessToken = configStorage.getAccessToken();
			String url = WxApiGateway.menu_delete_gateway.replaceAll("ACCESS_TOKEN", accessToken);
			String jsonData = WxHttpClient.doGet(url, null);
			WxMpMenuResponse res = JSONObject.parseObject(jsonData, WxMpMenuResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	public WxMpMenuResponse addconditionalMenu(WxMpMenu wxMenu) throws WXMotorException {
		try {
			String accessToken = configStorage.getAccessToken();
			String url = WxApiGateway.menu_addconditional_gateway.replaceAll("ACCESS_TOKEN",
					accessToken);
			String jsonParams = JSONObject.toJSONString(wxMenu);
			String jsonData = WxHttpClient.doPost(url, jsonParams);
			WxMpMenuResponse res = JSONObject.parseObject(jsonData, WxMpMenuResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	public WxMpMenuResponse delconditionalMenu(String menuid) throws WXMotorException {
		try {
			String accessToken = configStorage.getAccessToken();
			String url = WxApiGateway.menu_delconditional_gateway.replaceAll("ACCESS_TOKEN",
					accessToken);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("menuid", menuid);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpMenuResponse res = JSONObject.parseObject(jsonData, WxMpMenuResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	public WxMpMenuResponse trymatchMenu(String userid) throws WXMotorException {
		try {
			String accessToken = configStorage.getAccessToken();
			String url = WxApiGateway.menu_trymatch_gateway.replaceAll("ACCESS_TOKEN", accessToken);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userid", userid);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpMenuResponse res = JSONObject.parseObject(jsonData, WxMpMenuResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	public void setWxConfigStorage(WxConfigStorage configStorage) throws WXMotorException {
		this.configStorage = configStorage;

	}

}
