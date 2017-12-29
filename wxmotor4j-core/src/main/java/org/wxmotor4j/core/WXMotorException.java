package org.wxmotor4j.core;

/**
 * 异常类
 * 
 * @ClassName: WXMotorException
 * @author Tluo
 * @date 2017年10月12日
 *
 */
public class WXMotorException extends RuntimeException {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -7831761482423859335L;

	public WXMotorException() {
		super();
	}

	public WXMotorException(String message) {
		super(message, null);

	}

	public WXMotorException(String message, Throwable cause) {
		super(message, cause);
	}

}
