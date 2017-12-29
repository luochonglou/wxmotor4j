package org.wxmotor4j.third.request;

import java.lang.reflect.Field;

import com.alibaba.fastjson.JSONObject;

/**
 * 请求Request参数工具类
 * <ul>
 * <li>1、利用反射和权限限制获取请求对象属性并转换成JSON串</li>
 * <li>2、此类必须放在请求类同包的目录下</li>
 * <li>2、请求类需要提交参数必须使用protected关键字</li>
 * </ul>
 * 
 * @ClassName: RequestParamsUtil
 * @author Tluo
 * @date 2017年9月25日
 *
 */
public class RequestParamsUtil {

	public static String getJSONString(Object obj) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			String name = f.getName();
			Object value;
			try {
				value = f.get(obj);
			} catch (Exception e) {
				value = null;
			}
			if (null != value) {
				append(sb, name, value);
			}
		}
		sb.append("}");
		return sb.toString();
	}

	private static void append(StringBuilder sb, String name, Object value) {
		if (sb.length() > 1)
			sb.append(",");
		if(value instanceof JSONObject){
			sb.append("\"" + name + "\":" + value.toString());
		}else{
			sb.append("\"" + name + "\":\"" + value.toString() + "\"");
		}
	}

}
