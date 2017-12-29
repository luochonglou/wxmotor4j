package org.wxmotor4j.third.api;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.third.api.entity.WXThirdJSConfig;
import org.wxmotor4j.third.api.entity.WXThirdTemplateMsg;
import org.wxmotor4j.third.response.WXGetUserInfoResponse;
import org.wxmotor4j.third.response.WXThirdAuthorizeGetUserInfoResponse;
import org.wxmotor4j.third.response.WXThirdAuthorizeSwapAccessTokenResponse;
import org.wxmotor4j.third.response.WXThirdCreateQRCodeResponse;
import org.wxmotor4j.third.response.WXThirdGetAuthorizerInfoResponse;
import org.wxmotor4j.third.response.WXThirdQueryComponentAuthResponse;
import org.wxmotor4j.third.response.WXThirdSendTemplateMsgResponse;
import org.wxmotor4j.third.utils.aes.WXThirdAesException;
import org.wxmotor4j.third.xml.WXThirdXml;

/**
 * 微信第三方服务接口
 * 
 * @ClassName: WXThirdService
 * @author Tluo
 * @date 2017年9月26日
 *
 */
public interface WXThirdService extends WXThirdTokenManage {
	/**
	 * 消息解析解密
	 * 
	 * @Title: parsers
	 * @return T 返回类型
	 */
	public <T extends WXThirdXml> T parsers(String xml, Class<T> clazz) throws WXThirdAesException;

	/**
	 * 执行请求
	 * 
	 * @Title: execute
	 * @return T 返回类型
	 */
	public <T extends WXThirdResponse> T execute(WXThirdRequest<T> request)
			throws WXMotorException;

	/**
	 * 回复消息加密
	 * 
	 * @Title: encryptMsg
	 * @return String 返回类型
	 * @param replyMsg
	 *            需要加密的数据
	 * @param timeStamp
	 *            时间戳
	 * @param nonce
	 *            随机字符串
	 */
	public String encryptMsg(String replyMsg, String timeStamp, String nonce)
			throws WXThirdAesException;

	/**
	 * 验证推送过来的消息的正确性，正确返回true
	 * 
	 * @Title: checkSignature
	 * @return boolean 返回类型
	 */
	public boolean checkSignature(String timestamp, String nonce, String signature)
			throws WXMotorException;

	/**
	 * 获取JS注入权限验证配置
	 * 
	 * @Title: getJSAuthorizerConfig
	 * @return WXThirdJSConfig 返回类型
	 * @param importUrl
	 *            引入JS-SDK的页面地址
	 * @param timeStamp
	 *            时间戳
	 * @param nonce
	 *            随机字符串
	 */
	public WXThirdJSConfig getJSAuthorizerConfig(String authorizerAppid, String importUrl,
			String timeStamp, String nonce) throws WXMotorException;

	/**
	 * 网页授权：获取JS授权URL
	 * 
	 * @Title: getJSAuthorizeUrl
	 * @return String 返回类型
	 * @param authorizeAppid
	 *            授权方APPID
	 * @param redirectUri
	 *            授权回调地址
	 * @param scope
	 */
	public String getJSAuthorizeUrl(String authorizeAppid, String redirectUri, String scope,
			String state) throws WXMotorException;

	/**
	 * 网页授权：通过code换取access_token
	 * 
	 * @Title: getJSAccessTokenRequest
	 * @return WXThirdAuthorizeSwapAccessTokenResponse 返回类型
	 */
	public WXThirdAuthorizeSwapAccessTokenResponse getJSAccessTokenRequest(String authorizerAppid,
			String code) throws WXMotorException;

	/**
	 * 网页授权：通过网页授权access_token获取用户基本信息（需授权作用域为snsapi_userinfo）
	 * 
	 * @Title: getJSUserInfo
	 * @return WXThirdAuthorizeGetUserInfoResponse 返回类型
	 */
	public WXThirdAuthorizeGetUserInfoResponse getJSUserInfo(String oauthAccessToken, String openId)
			throws WXMotorException;

	/**
	 * 获取公众号授权地址
	 * 
	 * @Title: getAuthorizeAuthorizeUrl
	 * @return String 返回类型
	 */
	public String getAuthorizeAuthorizeUrl(String redirectUri) throws WXMotorException;

	/**
	 * 使用授权码换取公众号或小程序的接口调用凭据和授权信息
	 * 
	 * @Title: queryComponentAuth
	 * @return WXThirdQueryComponentAuthResponse 返回类型
	 */
	public WXThirdQueryComponentAuthResponse queryComponentAuth(String authorizationCode)
			throws WXMotorException;

	/**
	 * 获取授权方的帐号基本信息
	 * 
	 * @Title: getAuthorizerInfo
	 * @return WXThirdGetAuthorizerInfoResponse 返回类型
	 */
	WXThirdGetAuthorizerInfoResponse getAuthorizerInfo(String authorizerAppid) throws WXMotorException;

	/**
	 * 发送模版消息，
	 * 
	 * @Title: sendTemplateMsg
	 * @return WXThirdSendTemplateMsgResponse 返回类型
	 * @param authorizeAppid
	 *            授权方APPID
	 * @param templateMsg
	 *            模版消息
	 */
	public WXThirdSendTemplateMsgResponse sendTemplateMsg(String authorizeAppid,
			WXThirdTemplateMsg templateMsg) throws WXMotorException;

	/**
	 * 基础功能：获取关注用户基本信息
	 * 
	 * @Title: getUserInfo
	 * @return WXGetUserInfoResponse 返回类型
	 */
	public WXGetUserInfoResponse getUserInfo(String authorizerAppid, String openId)
			throws WXMotorException;

	/**
	 * 创建临时二维码：场景id
	 * 
	 * @Title: createTmpQRCode
	 * @return WXThirdCreateQRCodeResponse 返回类型
	 */
	public WXThirdCreateQRCodeResponse createTmpQRCode(String authorizerAppid, Integer sceneId,
			Long expireSeconds) throws WXMotorException;

	/**
	 * 创建临时二维码：场景值
	 * 
	 * @Title: createTmpQRCode
	 * @return WXThirdCreateQRCodeResponse 返回类型
	 */
	public WXThirdCreateQRCodeResponse createTmpQRCode(String authorizerAppid, String sceneStr,
			Long expireSeconds) throws WXMotorException;

	/**
	 * 创建永久二维码：场景id
	 * 
	 * @Title: createForeverQRCode
	 * @return WXThirdCreateQRCodeResponse 返回类型
	 */
	public WXThirdCreateQRCodeResponse createForeverQRCode(String authorizerAppid, Integer sceneId)
			throws WXMotorException;

	/**
	 * 创建永久二维码：场景值
	 * 
	 * @Title: createForeverQRCode
	 * @return WXThirdCreateQRCodeResponse 返回类型
	 */
	public WXThirdCreateQRCodeResponse createForeverQRCode(String authorizerAppid, String sceneStr)
			throws WXMotorException;
}
