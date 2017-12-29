package org.wxmotor4j.third.token;

import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.third.api.DefaultThirdClient;
import org.wxmotor4j.third.api.WXThirdClient;
import org.wxmotor4j.third.api.WXThirdService;
import org.wxmotor4j.third.request.WXThirdGetPreAuthCodeRequest;
import org.wxmotor4j.third.response.WXThirdGetPreAuthCodeResponse;
import org.wxmotor4j.third.token.aflorist.AFlower;

/**
 * 
 * @ClassName: WXThirdPreAuthCodeStorage
 * @author Tluo
 * @date 2017年9月26日
 *
 */
public class WXThirdPreAuthCodeStorage extends AFlower {

	private String preAuthCode;
	private Integer retentionTime = 30;
	private Integer expiresIn;

	private WXThirdService wXThirdService;

	public WXThirdPreAuthCodeStorage(WXThirdService wXThirdService) {
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
		String componentAccessToken = wXThirdService.getComponentAccessToken();
		WXThirdGetPreAuthCodeRequest request = new WXThirdGetPreAuthCodeRequest(
				componentAccessToken, componentAppid);
		WXThirdGetPreAuthCodeResponse res = c.execute(request);
		this.preAuthCode = res.getPreAuthCode();
		this.expiresIn = res.getExpiresIn();
	}

	public String getPreAuthCode() {
		if (StringUtils.isEmpty(preAuthCode) || this.nextPruneTime < System.currentTimeMillis()) {
			prune();
			setNextPruneTime();
		}
		return preAuthCode;
	}

}
