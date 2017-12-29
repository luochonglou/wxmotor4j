package org.wxmotor4j.third.token.aflorist;

/**
 * 一个异常类
 * 
 * @ClassName: AFloristException
 * @author Tluo
 * @date 2017年9月23日
 *
 */
public class AFloristException extends RuntimeException {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -6326013479519608457L;

	public AFloristException() {
		super();
	}

	public AFloristException(String message) {
		super(message, null);

	}

	public AFloristException(String message, Throwable cause) {
		super(message, cause);
	}
}
