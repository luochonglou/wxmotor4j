package org.wxmotor4j.core.utils;

import java.util.Random;

/**
 * 随机工具类
 * 
 * @ClassName: RandomUtils
 * @author Tluo
 * @date 2017年10月27日
 *
 */
public class RandomUtils {
	/**
	 * 随机指定长度字符串
	 * 
	 * @Title: randomStr
	 * @return String 返回类型
	 */
	public static String randomStr(int length) {
		String str = "qazwsxedcrfvtgbyhnujmikolp0123456789";
		char[] strArray = str.toCharArray();
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int len = ran.nextInt(str.length() - 1);
			sb.append(strArray[len]);
		}
		return sb.toString();
	}

	/**
	 * 随机20度字符串
	 * 
	 * @Title: randomStr
	 * @return String 返回类型
	 */
	public static String randomStr() {
		return randomStr(20);
	}

	public static void main(String[] args) {
		System.out.println(randomStr());
		System.out.println(randomStr(16));
	}

}
