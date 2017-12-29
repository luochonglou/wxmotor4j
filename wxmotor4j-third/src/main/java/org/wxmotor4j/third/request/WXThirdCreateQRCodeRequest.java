package org.wxmotor4j.third.request;

import org.wxmotor4j.third.api.WXThirdRequest;
import org.wxmotor4j.third.response.WXThirdCreateQRCodeResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * 创建二维码请求对象
 * 
 * @ClassName: WXThirdCreateQRCodeRequest
 * @author Tluo
 * @date 2017年9月28日
 *
 */
public class WXThirdCreateQRCodeRequest implements WXThirdRequest<WXThirdCreateQRCodeResponse> {
	private String authorizerAccessToken;
	protected Long expire_seconds;
	protected String action_name;
	protected JSONObject action_info;

	/**
	 * 
	 * 创建临时QR_SCENE二维码
	 * 
	 * @param authorizerAccessToken
	 * @param sceneId
	 * @param expireSeconds
	 */
	public WXThirdCreateQRCodeRequest(String authorizerAccessToken, Integer sceneId,
			Long expireSeconds) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.expire_seconds = expireSeconds;
		this.action_name = "QR_SCENE";
		assembleActionInfo(sceneId);
	}

	/**
	 * 
	 * 创建临时QR_STR_SCENE二维码
	 * 
	 * @param authorizerAccessToken
	 * @param sceneStr
	 * @param expireSeconds
	 */
	public WXThirdCreateQRCodeRequest(String authorizerAccessToken, String sceneStr,
			Long expireSeconds) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.expire_seconds = expireSeconds;
		this.action_name = "QR_STR_SCENE";
		assembleActionInfo(sceneStr);
	}

	/**
	 * 创建永久QR_LIMIT_SCENE二维码
	 * 
	 * @param authorizerAccessToken
	 * @param sceneId
	 */
	public WXThirdCreateQRCodeRequest(String authorizerAccessToken, Integer sceneId) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.action_name = "QR_LIMIT_SCENE";
		assembleActionInfo(sceneId);
	}

	/**
	 * 
	 * 创建永久QR_LIMIT_STR_SCENE二维码
	 * 
	 * @param authorizerAccessToken
	 * @param sceneStr
	 */
	public WXThirdCreateQRCodeRequest(String authorizerAccessToken, String sceneStr) {
		super();
		this.authorizerAccessToken = authorizerAccessToken;
		this.action_name = "QR_LIMIT_STR_SCENE";
		assembleActionInfo(sceneStr);
	}

	private void assembleActionInfo(Integer sceneId) {
		this.action_info = new JSONObject();
		JSONObject scene = new JSONObject();
		scene.put("scene_id", sceneId);
		action_info.put("scene", scene);
	}

	private void assembleActionInfo(String sceneStr) {
		this.action_info = new JSONObject();
		JSONObject scene = new JSONObject();
		scene.put("scene_str", sceneStr);
		action_info.put("scene", scene);
	}

	@Override
	public String getURL() {
		return "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="
				+ this.authorizerAccessToken;
	}

	@Override
	public String getJsonParams() {
		return RequestParamsUtil.getJSONString(this);
	}

	@Override
	public Class<WXThirdCreateQRCodeResponse> getResponseClass() {
		return WXThirdCreateQRCodeResponse.class;
	}

	@Override
	public String getRequestType() {
		return WXThirdRequest.requestType_POST;
	}

	@Override
	public boolean isNeedEncrypt() {
		return false;
	}
}
