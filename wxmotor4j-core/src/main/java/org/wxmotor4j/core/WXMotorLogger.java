package org.wxmotor4j.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志输出
 * 
 * @ClassName: WXMotorLogger
 * @author Tluo
 * @date 2017年10月12日
 *
 */
public class WXMotorLogger {
	private static final Logger logger = LoggerFactory.getLogger(WXMotorLogger.class);

	public static void printError(String msg) {
		logger.error(msg);
	}

	public static void printDebug(String msg) {
		logger.debug(msg);
	}

	public static void printInfo(String msg) {
		logger.info(msg);
	}

}
