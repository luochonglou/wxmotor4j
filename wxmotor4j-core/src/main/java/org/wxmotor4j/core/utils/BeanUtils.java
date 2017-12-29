package org.wxmotor4j.core.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public abstract class BeanUtils {
	/**
	 * 使用Introspector进行转换
	 * 
	 * @Title: mapToObject
	 * @return T 返回类型
	 */
	public static <T extends Object> T mapToObject(Map<String, Object> map, Class<T> beanClass)
			throws Exception {

		if (map == null)
			return null;

		T obj = beanClass.newInstance();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			Method setter = property.getWriteMethod();
			if (setter != null) {
				setter.invoke(obj, map.get(property.getName()));
			}
		}

		return obj;
	}

	/**
	 * 使用Introspector进行转换
	 * 
	 * @Title: objectToMap
	 * @return Map<String,Object> 返回类型
	 */
	public static <T extends Object> Map<String, Object> objectToMap(T obj) throws Exception {
		if (obj == null)
			return null;

		Map<String, Object> map = new HashMap<String, Object>();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (key.compareToIgnoreCase("class") == 0) {
				continue;
			}
			Method getter = property.getReadMethod();
			Object value = getter != null ? getter.invoke(obj) : null;
			map.put(key, value);
		}

		return map;
	}

	/**
	 * 使用reflect进行转换
	 * 
	 * @Title: mapToObject2
	 * @return T 返回类型
	 */
	public static <T extends Object> T mapToObject2(Map<String, Object> map, Class<T> beanClass)
			throws Exception {
		if (map == null)
			return null;

		T obj = beanClass.newInstance();

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			int mod = field.getModifiers();
			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}

			field.setAccessible(true);
			field.set(obj, map.get(field.getName()));
		}

		return obj;
	}

	/**
	 * 使用reflect进行转换
	 * 
	 * @Title: objectToMap2
	 * @return Map<String,Object> 返回类型
	 */
	public static <T extends Object> Map<String, Object> objectToMap2(T obj) throws Exception {
		if (obj == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Field[] declaredFields = obj.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(obj));
		}

		return map;
	}
}
