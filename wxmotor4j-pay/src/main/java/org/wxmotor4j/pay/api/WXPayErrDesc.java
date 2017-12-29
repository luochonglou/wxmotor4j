package org.wxmotor4j.pay.api;

import java.util.Objects;

/**
 * 微信支付错误返回码解释枚举
 * 
 * @ClassName: WXPayErrDesc
 * @author Tluo
 * @date 2017年10月27日
 *
 */
public enum WXPayErrDesc {
	/**/E_SUCCESS("SUCCESS", "成功。"),
	/**/E_FAIL("FAIL", "失败。"),
	/**/E_NOTENOUGH("NOTENOUGH", "用户帐号余额不足。"),
	/**/E_ORDERPAID("ORDERPAID", "商户订单已支付，无需重复操作。"),
	/**/E_ORDERCLOSED("ORDERCLOSED", "当前订单已关闭，无法支付。"),
	/**/E_SYSTEMERROR("SYSTEMERROR", "系统超时。"),
	/**/E_APPID_NOT_EXIST("APPID_NOT_EXIST", "参数中缺少APPID。"),
	/**/E_MCHID_NOT_EXIST("MCHID_NOT_EXIST", "参数中缺少MCHID。"),
	/**/E_APPID_MCHID_NOT_MATCH("APPID_MCHID_NOT_MATCH", "appid和mch_id不匹配。"),
	/**/E_LACK_PARAMS("LACK_PARAMS", "缺少必要的请求参数。"),
	/**/E_OUT_TRADE_NO_USED("OUT_TRADE_NO_USED", "商户订单号重复。"),
	/**/E_SIGNERROR("SIGNERROR", " 	签名错误。"),
	/**/E_XML_FORMAT_ERROR("XML_FORMAT_ERROR", "XML格式错误。"),
	/**/E_REQUIRE_POST_METHOD("REQUIRE_POST_METHOD", "请使用post方法。"),
	/**/E_POST_DATA_EMPTY("POST_DATA_EMPTY", "post数据不能为空。"),
	/**/E_NOT_UTF8("NOT_UTF8", "编码格式错误。");
	private String errcode;
	private String desc;

	private WXPayErrDesc(String errcode, String desc) {
		this.errcode = errcode;
		this.desc = desc;
	}

	public static String getDesc(String errcode) {
		String desc = "看不懂的错误(^_^)!";
		for (WXPayErrDesc enumDesc : WXPayErrDesc.values()) {
			if (Objects.equals(errcode, enumDesc.getErrcode())) {
				desc = enumDesc.getDesc();
				break;
			}
		}
		return desc;
	}

	private String getErrcode() {
		return errcode;
	}

	private String getDesc() {
		return desc;
	}
}
