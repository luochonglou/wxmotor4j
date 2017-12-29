package org.wxmotor4j.core.utils.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.WXMotorLogger;
import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.core.utils.WebUtils;
import org.wxmotor4j.core.utils.file.FileItem;

import com.alibaba.fastjson.JSONObject;

/**
 * 微信默认HTTP处理器
 * 
 * @ClassName: WxHttpClient
 * @author Tluo
 * @date 2017年8月5日
 *
 */
public abstract class WxHttpClient {
	private static final int connectTimeout = 5000;
	private static final int readTimeout = 30000;
	private static final String charset = "UTF-8";

	/**
	 * 执行GET请求
	 * 
	 * @Title: doGet
	 * @return String 返回类型
	 * @param url
	 *            请求地址
	 * @param params
	 *            请求参数
	 */
	public static String doGet(String url, Map<String, String> params) throws WXMotorException {
		try {
			return WebUtils.doGet(url, params, charset);
		} catch (IOException e) {
			WXMotorLogger.printError("HTTP请求异常==>" + e.getMessage());
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	/**
	 * 执行POST请求
	 * 
	 * @Title: doPost
	 * @return String 返回类型
	 * @param url
	 *            请求地址
	 * @param jsonStr
	 *            请求参数，json字符串原样写入
	 */
	public static String doPost(String url, String jsonParams) throws WXMotorException {
		try {
			System.out.println("jsonParams==>" + jsonParams);
			String ctype = "application/x-www-form-urlencoded;charset=" + charset;
			byte[] content = {};
			if (StringUtils.isNotEmpty(jsonParams)) {
				content = jsonParams.getBytes(charset);
			}
			return WebUtils.doPost(url, ctype, content, connectTimeout, readTimeout);
		} catch (IOException e) {
			WXMotorLogger.printError("HTTP请求异常==>" + e.getMessage());
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	/**
	 * 执行GET请求，参数最终JSON格式写入
	 * 
	 * @Title: doPostMap2Json
	 * @return String 返回类型
	 */
	public static String doPostMap2Json(String url, Map<String, Object> params)
			throws WXMotorException {
		return doPost(url, JSONObject.toJSONString(params));
	}

	/**
	 * 执行带文件Post请求
	 * 
	 * @Title: doPost
	 * @return String 返回类型
	 */
	public static String doPost(String url, Map<String, FileItem> fileParams)
			throws WXMotorException {
		return doPost(url, null, fileParams);
	}

	/**
	 * 执行带参数和文件Post请求
	 * 
	 * @Title: doPost
	 * @return String 返回类型
	 */
	public static String doPost(String url, Map<String, String> params,
			Map<String, FileItem> fileParams) throws WXMotorException {
		try {
			String ctype = "multipart/form-data;";
			return WebUtils.doPost(url, params, fileParams, charset, ctype, connectTimeout,
					readTimeout);
		} catch (IOException e) {
			WXMotorLogger.printError("HTTP请求异常==>" + e.getMessage());
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public static void doPost(String url, Map<String, String> params, String charset, String path)
			throws Exception {
		// String ctype = "application/x-www-form-urlencoded;charset=" +
		// charset;

		WebUtils.downloadFilePost(url, charset, getXMLEntry(params, charset), connectTimeout,
				readTimeout, path);

	}

	/**
	 * 使用指定的字符集编码请求参数值。
	 * 
	 * @Title: encode
	 * @return String 返回类型
	 */
	public static String encode(String value) throws WXMotorException {
		try {
			return WebUtils.encode(value, charset);
		} catch (Exception e) {
			WXMotorLogger.printError("URLEncoder.encode错误，value = " + value);
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	/**
	 * 使用指定的字符集反编码请求参数值。
	 * 
	 * @Title: decode
	 * @return String 返回类型
	 */
	public static String decode(String value) throws WXMotorException {
		try {
			return WebUtils.decode(value, charset);
		} catch (Exception e) {
			WXMotorLogger.printError("URLEncoder.decode错误，value = " + value);
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	private static byte[] getXMLEntry(Map<String, String> params, String charset)
			throws UnsupportedEncodingException {
		if (params == null || params.isEmpty())
			return null;
		StringBuilder entry = new StringBuilder("<xml>");
		for (Entry<String, String> para : params.entrySet()) {
			entry.append(String.format("<%s>%s</%s>", para.getKey(), para.getValue(), para.getKey()));
		}
		entry.append("</xml>");
		return entry.toString().getBytes(charset);
	}

}
