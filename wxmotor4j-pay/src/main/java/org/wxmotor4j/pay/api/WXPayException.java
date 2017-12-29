package org.wxmotor4j.pay.api;

import org.wxmotor4j.pay.api.utils.StringUtils;

/**
 * 
 * @ClassName: WXPayException
 * @author Tluo
 * @date 2017年9月30日
 *
 */
public class WXPayException extends RuntimeException {
	/** 微信支付请求错误状态 **/
	public static final int REQUEST_ERROR = -2;
	/** 微信支付请求业务错误状态 **/
	public static final int BUSINESS_FAILURE = -3;

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -6326013479519608457L;
	private int status = -1;
	private String returnCode;
	private String returnMsg;
	private String resultCode;
	private String errCode;
	private String errCodeDesc;

	public WXPayException() {
		super();
	}

	public WXPayException(String message) {
		super(message, null);

	}

	public WXPayException(String message, Throwable cause) {
		super(message, cause);
	}

	public WXPayException(String returnCode, String returnMsg, Throwable cause) {
		super("WXPayClient request error, returnCode=" + returnCode + ", returnMsg=" + returnMsg,
				cause);
		this.status = REQUEST_ERROR;
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public WXPayException(String resultCode, String errCode, String errCodeDesc, Throwable cause) {
		super("WXPayClient Business failure, resultCode=" + resultCode + ",errCode=" + errCode
				+ ", errCodeDesc=" + errCodeDesc, null);
		this.status = BUSINESS_FAILURE;
		this.resultCode = resultCode;
		this.errCode = errCode;
		if (StringUtils.isEmpty(errCodeDesc)) {
			errCodeDesc = WXPayErrDesc.getDesc(errCode);
		}
		this.errCodeDesc = errCodeDesc;
	}

	public int getStatus() {
		return status;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrCodeDesc() {
		return errCodeDesc;
	}

	public String getResultCode() {
		return resultCode;
	}

}
