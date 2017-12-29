package org.wxmotor4j.core;

import java.io.Serializable;

import org.wxmotor4j.core.consts.WXMotorErrDesc;

/**
 * 
 * @ClassName: WXMotorResponse
 * @author Tluo
 * @date 2017年10月12日
 *
 */
public abstract class WXMotorResponse implements Serializable {

	private static final long serialVersionUID = 5640932186504508607L;

	/*
	 * 响应原字符串数据
	 */
	private String reslutStr;
	/*
	 * 响应编码
	 */
	private Integer errcode;
	/*
	 * 错误详情
	 */
	private String errmsg;
	/*
	 * 全局响应说明
	 */
	private String errCodeDesc;

	public String getReslutStr() {
		return reslutStr;
	}

	public void setReslutStr(String reslutStr) {
		this.reslutStr = reslutStr;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
		this.errCodeDesc = WXMotorErrDesc.getDesc(errcode);
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getErrCodeDesc() {
		return errCodeDesc;
	}

	public void setErrCodeDesc(String errCodeDesc) {
		this.errCodeDesc = errCodeDesc;
	}

}
