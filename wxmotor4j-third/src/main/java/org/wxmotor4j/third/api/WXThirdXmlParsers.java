package org.wxmotor4j.third.api;

import org.wxmotor4j.third.utils.aes.WXThirdAesException;
import org.wxmotor4j.third.xml.WXThirdXml;

/**
 * 微信第三方XML解析器接口
 * 
 * @ClassName: WXThirdXmlParsers
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public interface WXThirdXmlParsers {
	/**
	 * 解析XML
	 * 
	 * @Title: parsers
	 * @return T 返回类型
	 */
	public <T extends WXThirdXml> T parsers(String xml, Class<T> clazz) throws WXThirdAesException;

	/**
	 * 加密消息
	 * 
	 * @Title: encryptMsg
	 * @return String 返回类型
	 */
	public String encryptMsg(String replyMsg, String timeStamp, String nonce)
			throws WXThirdAesException;

}
