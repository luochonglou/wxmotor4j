package org.wxmotor4j.core.utils;

import java.util.List;

/**
 * List工具类
 * 
 * @ClassName: ListUtils
 * @author Tluo
 * @date 2017年2月24日
 *
 */
public class ListUtils {
	/**
	 * List集合为空
	 * 
	 * @Title: isEmpty
	 * @return boolean 返回类型
	 */
	public static boolean isEmpty(List<?> list) {
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * List集合不为空
	 * 
	 * @Title: isNotEmpty
	 * @return boolean 返回类型
	 */
	public static boolean isNotEmpty(List<?> list) {
		return !isEmpty(list);
	}

}
