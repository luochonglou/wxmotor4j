package org.wxmotor4j.third.xml;

import org.wxmotor4j.third.utils.aes.WXBizMsgCrypt;

/**
 * 
 * @ClassName: WXThirdXml
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public abstract class WXThirdXml {
	/**
	 * 需要解密
	 * 
	 * @Title: isNeedDecrypt
	 * @return boolean 返回类型
	 */
	public abstract boolean isNeedDecrypt();

	/**
	 * 解密操作
	 * 
	 * @Title: decryptOperate
	 * @return void 返回类型
	 */
	public abstract void decryptOperate(WXBizMsgCrypt wXBizMsgCrypt);
}
