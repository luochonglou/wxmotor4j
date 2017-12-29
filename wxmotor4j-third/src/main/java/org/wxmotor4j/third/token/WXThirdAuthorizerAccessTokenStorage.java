package org.wxmotor4j.third.token;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.third.api.DefaultThirdClient;
import org.wxmotor4j.third.api.WXThirdClient;
import org.wxmotor4j.third.api.WXThirdService;
import org.wxmotor4j.third.request.WXThirdQueryComponentAuthRequest;
import org.wxmotor4j.third.request.WXThirdRefreshAuthorizerTokenRequest;
import org.wxmotor4j.third.response.WXThirdQueryComponentAuthResponse;
import org.wxmotor4j.third.response.WXThirdQueryComponentAuthResponse.AuthorizationInfo;
import org.wxmotor4j.third.response.WXThirdRefreshAuthorizerTokenResponse;
import org.wxmotor4j.third.token.aflorist.AFlower;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: WXThirdAuthorizerAccessTokenStorage
 * @author Tluo
 * @date 2017年9月26日
 *
 */
public class WXThirdAuthorizerAccessTokenStorage extends AFlower {

	private String authorizerAccessToken;
	private String authorizerRefreshToken;
	private String authorizerAppid;
	private Integer retentionTime = 200;
	private Integer expiresIn;

	private WXThirdService wXThirdService;

	public WXThirdAuthorizerAccessTokenStorage(WXThirdService wXThirdService,
			String authorizationCode) {
		this.wXThirdService = wXThirdService;
		/* 初始化获取 */
		WXThirdClient client = new DefaultThirdClient();
		WXThirdQueryComponentAuthRequest request = new WXThirdQueryComponentAuthRequest(
				wXThirdService.getComponentAccessToken(), wXThirdService.getConfigComponentAppid(),
				authorizationCode);
		WXThirdQueryComponentAuthResponse res = client.execute(request);
		if (null == res || null == res.getAuthorizationInfo()) {
			throw new WXMotorException("WXThirdAuthorizerAccessTokenStorage Create fail");
		}
		AuthorizationInfo info = res.getAuthorizationInfo();
		System.out.println("JSON===>" + JSONObject.toJSONString(info));
		this.authorizerAppid = info.getAuthorizerAppid();
		this.authorizerAccessToken = info.getAuthorizerAccessToken();
		this.authorizerRefreshToken = info.getAuthorizerRefreshToken();
		this.expiresIn = info.getExpiresIn();
		setNextPruneTime();
	}

	public WXThirdAuthorizerAccessTokenStorage(WXThirdService wXThirdService,
			String authorizerAppid, String authorizerRefreshToken) {
		this.wXThirdService = wXThirdService;
		this.authorizerAppid = authorizerAppid;
		this.authorizerRefreshToken = authorizerRefreshToken;
		/* 初始化刷新 */
		prune();
		setNextPruneTime();
	}

	@Override
	public void setNextPruneTime() {
		this.nextPruneTime = System.currentTimeMillis() + (expiresIn - retentionTime) * 1000l;

	}

	@Override
	public void prune() {
		WXThirdClient c = new DefaultThirdClient();
		String componentAppid = wXThirdService.getConfigComponentAppid();
		String componentAccessToken = wXThirdService.getComponentAccessToken();
		WXThirdRefreshAuthorizerTokenRequest request = new WXThirdRefreshAuthorizerTokenRequest(
				componentAccessToken, componentAppid, authorizerAppid, authorizerRefreshToken);
		WXThirdRefreshAuthorizerTokenResponse res = c.execute(request);
		this.authorizerAccessToken = res.getAuthorizerAccessToken();
		this.authorizerRefreshToken = res.getAuthorizerRefreshToken();
		this.expiresIn = res.getExpiresIn();

	}

	public String getAuthorizerAccessToken() {
		if (StringUtils.isEmpty(authorizerAccessToken)
				|| this.nextPruneTime < System.currentTimeMillis()) {
			prune();
			setNextPruneTime();
		}
		return authorizerAccessToken;
	}

	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}

}
