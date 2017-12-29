package org.wxmotor4j.pay.api.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wxmotor4j.pay.api.WXPayConfigManage;
import org.wxmotor4j.pay.api.WXPayConstants;
import org.wxmotor4j.pay.api.WXPayConstants.ESignType;
import org.wxmotor4j.pay.api.WXPayException;
import org.wxmotor4j.pay.api.WXPayResponse;

/**
 * 微信支付工具类
 * 
 * @ClassName: WXPayUtil
 * @author Tluo
 * @date 2017年11月7日
 *
 */
public class WXPayUtil {
	/**
	 * XML字符串转换为对象
	 * 
	 * @Title: xmlToObject
	 * @return T 返回类型
	 */
	public static <T extends WXPayResponse> T xmlToObject(String xmlString, Class<T> clazz) {
		JAXBContext jc;
		StringReader reader = new StringReader(xmlString);
		try {
			jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			@SuppressWarnings("unchecked")
			T o = (T) u.unmarshal(reader);
			return o;
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}
		return null;
	}

	/**
	 * 验证必需参数
	 * 
	 * @Title: verificationRequired
	 * @return String 返回类型
	 */
	public static void verificationRequired(String[] required, Map<String, String> params)
			throws WXPayException {
		if (null == required || required.length == 0) {
			WXPayUtil.getLogger().info("No essential parameter.");
			return;
		}
		if (null == params) {
			throw new WXPayException("request params is null.");
		}
		StringBuffer sb = new StringBuffer();
		for (String key : required) {
			if (StringUtils.isEmpty(params.get(key))) {
				sb.append(key);
				sb.append(",");
			}
		}
		if (sb.length() > 0) {
			throw new WXPayException(sb.toString() + "request params is null.");
		}
	}

	/**
	 * 签名并返回XML数据
	 * 
	 * @Title: generateSignedXml
	 * @return String 返回类型
	 */
	public static String generateSignedXml(final Map<String, String> params,
			WXPayConfigManage wXPayConfigManage) throws WXPayException {
		if (wXPayConfigManage.isServiceProvider()) {
			if (!params.containsKey(WXPayConstants.FIELD_SUB_MCH_ID)
					|| StringUtils.isEmpty(params.get(WXPayConstants.FIELD_SUB_MCH_ID))) {
				throw new WXPayException("sub_mch_id does not exist in params.");
			}
		}
		params.put("appid", wXPayConfigManage.getAppid());
		params.put("mch_id", wXPayConfigManage.getMchId());
		try {
			String sign = generateSignature(params, wXPayConfigManage.getMchKey(),
					wXPayConfigManage.getSignType());
			params.put(WXPayConstants.FIELD_SIGN, sign);
		} catch (Exception e) {
			throw new WXPayException(e.getMessage(), e);
		}
		StringBuilder request = new StringBuilder("<xml>");
		for (Entry<String, String> para : params.entrySet()) {
			request.append(String.format("<%s>%s</%s>", para.getKey(), para.getValue(),
					para.getKey()));
		}
		request.append("</xml>");
		return request.toString();
	}

	/**
	 * XML格式字符串转换为Map
	 *
	 * @param strXML
	 *            XML字符串
	 * @return XML数据转换后的Map
	 * @throws WXPayException
	 */
	public static Map<String, String> xmlToMap(String strXML) throws WXPayException {
		try {
			Map<String, String> data = new HashMap<String, String>();
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
			org.w3c.dom.Document doc = documentBuilder.parse(stream);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getDocumentElement().getChildNodes();
			for (int idx = 0; idx < nodeList.getLength(); ++idx) {
				Node node = nodeList.item(idx);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					org.w3c.dom.Element element = (org.w3c.dom.Element) node;
					data.put(element.getNodeName(), element.getTextContent());
				}
			}
			try {
				stream.close();
			} catch (Exception ex) {
				// do nothing
			}
			return data;
		} catch (Exception e) {
			WXPayUtil.getLogger().warn(
					"Invalid XML, can not convert to map. Error message: {}. XML content: {}",
					e.getMessage(), strXML);
			throw new WXPayException(e.getMessage(), e);
		}

	}

	/**
	 * 判断签名是否正确
	 *
	 * @param xmlStr
	 *            XML格式数据
	 * @param key
	 *            API密钥
	 * @return 签名是否正确
	 * @throws WXPayException
	 */
	public static boolean isSignatureValid(String xmlStr, String key) throws WXPayException {
		Map<String, String> data = xmlToMap(xmlStr);
		if (!data.containsKey(WXPayConstants.FIELD_SIGN)) {
			return false;
		}
		String sign = data.get(WXPayConstants.FIELD_SIGN);
		return generateSignature(data, key).equals(sign);
	}

	/**
	 * 判断签名是否正确，必须包含sign字段，否则返回false。使用MD5签名。
	 *
	 * @param data
	 *            Map类型数据
	 * @param key
	 *            API密钥
	 * @return 签名是否正确
	 * @throws WXPayException
	 */
	public static boolean isSignatureValid(Map<String, String> data, String key)
			throws WXPayException {
		return isSignatureValid(data, key, ESignType.MD5);
	}

	/**
	 * 判断签名是否正确，必须包含sign字段，否则返回false。
	 *
	 * @param data
	 *            Map类型数据
	 * @param key
	 *            API密钥
	 * @param signType
	 *            签名方式
	 * @return 签名是否正确
	 * @throws WXPayException
	 */
	public static boolean isSignatureValid(Map<String, String> data, String key, ESignType signType)
			throws WXPayException {
		if (!data.containsKey(WXPayConstants.FIELD_SIGN)) {
			return false;
		}
		String sign = data.get(WXPayConstants.FIELD_SIGN);
		return generateSignature(data, key, signType).equals(sign);
	}

	/**
	 * 生成签名
	 *
	 * @param data
	 *            待签名数据
	 * @param key
	 *            API密钥
	 * @return 签名
	 */
	public static String generateSignature(final Map<String, String> data, String key)
			throws WXPayException {
		return generateSignature(data, key, ESignType.MD5);
	}

	/**
	 * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
	 *
	 * @param data
	 *            待签名数据
	 * @param key
	 *            API密钥
	 * @param ESignType
	 *            签名方式
	 * @return 签名
	 */
	public static String generateSignature(final Map<String, String> data, String key,
			ESignType signType) throws WXPayException {
		try {
			Set<String> keySet = data.keySet();
			String[] keyArray = keySet.toArray(new String[keySet.size()]);
			Arrays.sort(keyArray);
			StringBuilder sb = new StringBuilder();
			for (String k : keyArray) {
				if (k.equals(WXPayConstants.FIELD_SIGN)) {
					continue;
				}
				if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
					sb.append(k).append("=").append(data.get(k).trim()).append("&");
			}
			sb.append("key=").append(key);
			if (ESignType.MD5.equals(signType)) {
				return MD5(sb.toString()).toUpperCase();
			} else if (ESignType.HMACSHA256.equals(signType)) {
				return HMACSHA256(sb.toString(), key);
			} else {
				throw new WXPayException(String.format("Invalid sign_type: %s", signType));
			}
		} catch (Exception e) {
			WXPayUtil.getLogger().warn(e.getMessage(), e);
			throw new WXPayException(e.getMessage(), e);
		}

	}

	/**
	 * 获取随机字符串 Nonce Str
	 *
	 * @return String 随机字符串
	 */
	public static String generateNonceStr() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}

	/**
	 * 生成 MD5
	 *
	 * @param data
	 *            待处理数据
	 * @return MD5结果
	 */
	private static String MD5(String data) throws Exception {

		java.security.MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 生成 HMACSHA256
	 * 
	 * @param data
	 *            待处理数据
	 * @param key
	 *            密钥
	 * @return 加密结果
	 * @throws WXPayException
	 */
	private static String HMACSHA256(String data, String key) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte item : array) {
			sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 日志
	 * 
	 * @return
	 */
	public static Logger getLogger() {
		Logger logger = LoggerFactory.getLogger("wxpay java motor");
		return logger;
	}

	/**
	 * 获取当前时间戳，单位秒
	 * 
	 * @return
	 */
	public static long getCurrentTimestamp() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * 获取当前时间戳，单位毫秒
	 * 
	 * @return
	 */
	public static long getCurrentTimestampMs() {
		return System.currentTimeMillis();
	}

	/**
	 * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
	 * 
	 * @return
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}

	/**
	 * 去除空格和空
	 * 
	 * @Title: tirm
	 * @return void 返回类型
	 */
	public static void tirm(Map<String, String> params) {
		if (null == params || params.size() == 0) {
			return;
		}
		for (Entry<String, String> en : params.entrySet()) {
			String key = en.getKey();
			String value = en.getValue();
			if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
				params.remove(key);
				continue;
			}
			key = key.trim();
			value = value.trim();
			params.put(key, value);
		}
	}

	/**
	 * 打印交易错误日志
	 * 
	 * @Title: printErrLog
	 * @return void 返回类型
	 */
	public static void printErrLog(String outTradeNo, String retCode, String retMsg) {
		getLogger().error(
				"WXPay request error, out_trade_no>>>" + outTradeNo + " return_code>>>" + retCode
						+ ", return_msg>>>" + retMsg);
	}

	/**
	 * 打印交易错误日志
	 * 
	 * @Title: printErrLog
	 * @return void 返回类型
	 */

	public static void printErrLog(String outTradeNo, String resultCode, String errCode,
			String errCodeDesc) {
		getLogger().error(
				"WXPay business failure, out_trade_no>>>" + outTradeNo + " result_code>>>"
						+ resultCode + ", err_code>>>" + errCode + ", err_code_desc>>>"
						+ errCodeDesc);
	}
}