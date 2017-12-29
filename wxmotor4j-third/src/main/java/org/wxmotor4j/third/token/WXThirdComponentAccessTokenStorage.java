package org.wxmotor4j.third.token;

import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.third.api.DefaultThirdClient;
import org.wxmotor4j.third.api.WXThirdClient;
import org.wxmotor4j.third.api.WXThirdService;
import org.wxmotor4j.third.request.WXThirdGetComponentTokenRequest;
import org.wxmotor4j.third.response.WXThirdGetComponentTokenResponse;
import org.wxmotor4j.third.token.aflorist.AFlower;

/**
 * 
 * @ClassName: WXThirdComponentAccessTokenStorage
 * @author Tluo
 * @date 2017年9月26日
 *
 */
public class WXThirdComponentAccessTokenStorage extends AFlower {

	private String componentAccessToken;
	private Integer retentionTime = 200;
	private Integer expiresIn;

	private WXThirdService wXThirdService;

	public WXThirdComponentAccessTokenStorage(WXThirdService wXThirdService) {
		this.wXThirdService = wXThirdService;
	}

	@Override
	public void setNextPruneTime() {
		this.nextPruneTime = System.currentTimeMillis() + (expiresIn - retentionTime) * 1000l;
	}

	@Override
	public void prune() {
		WXThirdClient c = new DefaultThirdClient();
		String componentAppid = wXThirdService.getConfigComponentAppid();
		String componentAppsecret = wXThirdService.getConfigComponentAppsecret();
		String componentVerifyTicket = wXThirdService.getComponentVerifyTicket();
		WXThirdGetComponentTokenRequest request = new WXThirdGetComponentTokenRequest(
				componentAppid, componentAppsecret, componentVerifyTicket);
		WXThirdGetComponentTokenResponse res = c.execute(request);
		this.componentAccessToken = res.getComponentAccessToken();
		this.expiresIn = res.getExpiresIn();
	}

	public String getComponentAccessToken() {
		if (StringUtils.isEmpty(componentAccessToken)
				|| this.nextPruneTime < System.currentTimeMillis()) {
			prune();
			setNextPruneTime();
		}
		return componentAccessToken;
	}

}
