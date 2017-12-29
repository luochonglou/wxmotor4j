package org.wxmotor4j.mp.account;

import org.wxmotor4j.core.WXMotorConstsConfig;
import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.utils.http.WxHttpClient;
import org.wxmotor4j.mp.account.WxMpQrcode.WxMpScene;
import org.wxmotor4j.mp.api.WxApiGateway;
import org.wxmotor4j.mp.api.WxConfigStorage;

import com.alibaba.fastjson.JSONObject;

public class WxMpAccountServiceImpl implements WxMpAccountService {
	private WxConfigStorage configStorage;

	public void setWxConfigStorage(WxConfigStorage configStorage) throws WXMotorException {
		this.configStorage = configStorage;

	}

	public WxMpQrcode createTemporaryQrcode(Integer sceneId, Long expireSeconds)
			throws WXMotorException {
		WxMpScene scene = new WxMpScene();
		scene.setSceneId(sceneId);
		if (null == expireSeconds || 0 == expireSeconds) {
			expireSeconds = WXMotorConstsConfig.QR_EXPIRESECONDS;
		}
		WxMpScene sceneParams = new WxMpScene();
		sceneParams.setScene(scene);
		return createQrcode(sceneParams, WXMotorConstsConfig.QR_SCENE, expireSeconds);
	}

	public WxMpQrcode createTemporaryQrcode(String sceneStr, Long expireSeconds)
			throws WXMotorException {
		WxMpScene scene = new WxMpScene();
		scene.setSceneStr(sceneStr);
		if (null == expireSeconds || 0 == expireSeconds) {
			expireSeconds = WXMotorConstsConfig.QR_EXPIRESECONDS;
		}
		WxMpScene sceneParams = new WxMpScene();
		sceneParams.setScene(scene);
		return createQrcode(sceneParams, WXMotorConstsConfig.QR_STR_SCENE, expireSeconds);
	}

	public WxMpQrcode createForeverQrcode(Integer sceneId) throws WXMotorException {
		WxMpScene scene = new WxMpScene();
		scene.setSceneId(sceneId);
		WxMpScene sceneParams = new WxMpScene();
		sceneParams.setScene(scene);
		return createQrcode(sceneParams, WXMotorConstsConfig.QR_LIMIT_SCENE, null);
	}

	public WxMpQrcode createForeverQrcode(String sceneStr) throws WXMotorException {
		WxMpScene scene = new WxMpScene();
		scene.setSceneStr(sceneStr);
		WxMpScene sceneParams = new WxMpScene();
		sceneParams.setScene(scene);
		return createQrcode(sceneParams, WXMotorConstsConfig.QR_LIMIT_STR_SCENE, null);
	}

	private WxMpQrcode createQrcode(WxMpScene scene, String actionName, Long expireSeconds)
			throws WXMotorException {
		try {
			String url = WxApiGateway.account_qrcode_getticket.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			WxMpQrcode params = new WxMpQrcode();
			params.setActionInfo(scene);
			params.setActionName(actionName);
			if (null != expireSeconds && expireSeconds > 0) {
				params.setExpireSeconds(expireSeconds);
			}
			String jsonData = WxHttpClient.doPost(url, JSONObject.toJSONString(params));
			WxMpQrcode res = JSONObject.parseObject(jsonData, WxMpQrcode.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}

	}

	public String getQrcodeUrlByTicket(String ticket) throws WXMotorException {
		try {
			ticket = WxHttpClient.encode(ticket);
			String url = WxApiGateway.account_qrcode_getqrcode.replaceAll("TICKET", ticket);
			return url;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpLink longlinkToShortlink(String longUrl) throws WXMotorException {
		try {
			String url = WxApiGateway.account_longurl_shorter.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			WxMpLink link = new WxMpLink();
			link.setLongUrl(longUrl);
			String jsonData = WxHttpClient.doPost(url, JSONObject.toJSONString(link));
			WxMpLink res = JSONObject.parseObject(jsonData, WxMpLink.class);
			res.setLongUrl(longUrl);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

}
