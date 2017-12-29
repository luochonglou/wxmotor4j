package org.wxmotor4j.third.utils.aes;

import java.util.Random;

/**
 * 
 * @ClassName: RandomUtils
 * @author Tluo
 * @date 2017年9月28日
 *
 */
public class RandomUtils {
	/**
	 * 随机32位字符串
	 * 
	 * @Title: getRandomStr32
	 * @return String 返回类型
	 */
	public static String getRandomStr32() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 32; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

}
