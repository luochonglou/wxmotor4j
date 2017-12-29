package org.wxmotor4j.mp.api;

import org.wxmotor4j.core.WXMotorException;

public interface WxMpApi {

	/** 设置微信配置 **/
	public void setWxConfigStorage(WxConfigStorage configStorage) throws WXMotorException;

}
