package org.wxmotor4j.third.api;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.wxmotor4j.core.utils.JAXBUtils;
import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.third.utils.aes.WXBizMsgCrypt;
import org.wxmotor4j.third.utils.aes.WXThirdAesException;
import org.wxmotor4j.third.xml.WXThirdXml;

/**
 * 默认XML解析器
 * 
 * @ClassName: DefaultXmlParsers
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class DefaultXmlParsers implements WXThirdXmlParsers {
	protected static Charset CHARSET = Charset.forName("utf-8");
	protected Base64 base64 = new Base64();
	protected byte[] aesKey;
	protected String token;
	protected String appId;
	protected WXBizMsgCrypt wXBizMsgCrypt;

	/**
	 * 创建一个新的实例 DefaultXmlParsers.
	 * 
	 * @param token
	 * @param encodingAesKey
	 * @param appId
	 * @throws WXThirdAesException
	 */
	public DefaultXmlParsers(String token, String encodingAesKey, String appId)
			throws WXThirdAesException {
		if (encodingAesKey.length() != 43) {
			throw new WXThirdAesException(WXThirdAesException.IllegalAesKey);
		}
		wXBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, appId);
		this.token = token;
		this.appId = appId;
		aesKey = Base64.decodeBase64(encodingAesKey + "=");
	}

	public <T extends WXThirdXml> T parsers(String xml, Class<T> clazz) {
		if (StringUtils.isEmpty(xml)) {
			return null;
		}
		T obj = JAXBUtils.toObject(clazz, xml);
		if (obj.isNeedDecrypt()) {
			obj.decryptOperate(wXBizMsgCrypt);
		}
		return obj;
	}

	@Override
	public String encryptMsg(String replyMsg, String timeStamp, String nonce)
			throws WXThirdAesException {

		return wXBizMsgCrypt.encryptMsg(replyMsg, timeStamp, nonce);

	}

}
