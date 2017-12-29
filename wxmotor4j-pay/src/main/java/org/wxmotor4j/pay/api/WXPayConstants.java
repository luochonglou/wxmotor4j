package org.wxmotor4j.pay.api;

/**
 * 
 * @ClassName: WXPayConstants
 * @author Tluo
 * @date 2017年11月6日
 *
 */
public interface WXPayConstants {

	/**
	 * 请求方式
	 * 
	 * @ClassName: ERequestType
	 * @author Tluo
	 * @date 2017年11月7日
	 *
	 */
	public enum ERequestType {
		GET, POST;
	}

	/**
	 * 签名方式
	 * 
	 * @ClassName: ESignType
	 * @author Tluo
	 * @date 2017年11月7日
	 *
	 */
	public enum ESignType {
		MD5, HMACSHA256
	}

	/**
	 * 通信标识
	 * 
	 * @ClassName: EreturnCode
	 * @author Tluo
	 * @date 2017年11月7日
	 *
	 */
	public enum EReturnCode {
		SUCCESS, FAIL

	}

	/**
	 * 业务结果
	 * 
	 * @ClassName: EResultCode
	 * @author Tluo
	 * @date 2017年11月7日
	 *
	 */
	public enum EResultCode {
		SUCCESS, FAIL
	}

	/**
	 * 交易状态
	 * 
	 * @ClassName: ETradeState
	 * @author Tluo
	 * @date 2017年11月7日
	 *
	 */
	public enum ETradeState {
		/** 支付成功 **/
		SUCCESS,
		/** 转入退款 **/
		REFUND,
		/** 未支付 **/
		NOTPAY,
		/** 已关闭 **/
		CLOSED,
		/** 已撤销(刷卡支付) **/
		REVOKED,
		/** 用户支付中 **/
		USERPAYING,
		/** 支付失败(其他原因，如银行返回失败) **/
		PAYERROR
	}

	/**
	 * 交易类型
	 * 
	 * @ClassName: ETradeType
	 * @author Tluo
	 * @date 2017年11月8日
	 *
	 */
	public enum ETradeType {
		/** 公众号支付 **/
		JSAPI,
		/** 原生扫码支付 **/
		NATIVE,
		/** app支付 **/
		APP,
		/** 刷卡支付 **/
		MICROPAY
	}

	// ////////////////////////请求字段/////////////////////////////
	/** 签名 **/
	public static final String FIELD_SIGN = "sign";
	/** 随机字符串 **/
	public static final String FIELD_NONCE_STR = "nonce_str";
	/** 子商户号 **/
	public static final String FIELD_SUB_MCH_ID = "sub_mch_id";
	/** 微信订单号 **/
	public static final String FIELD_TRANSACTION_ID = "transaction_id";
	/** 商户订单号 **/
	public static final String FIELD_OUT_TRADE_NO = "out_trade_no";
	/** 对账单日期,格式：20140603 **/
	public static final String FIELD_BILL_DATE = "bill_date";
	/** 刷卡授权码 **/
	public static final String FIELD_AUTH_CODE = "auth_code";
	/** 商品描述128 **/
	public static final String FIELD_BODY = "body";
	/** 总金额 **/
	public static final String FIELD_TOTAL_FEE = "total_fee";
	/** 终端IP **/
	public static final String FIELD_SPBILL_CREATE_IP = "spbill_create_ip";
	/** 通知地址 **/
	public static final String FIELD_NOTIFY_URL = "notify_url";
	/** 交易类型 **/
	public static final String FIELD_TRADE_TYPE = "trade_type";
	/** 商品ID,trade_type=NATIVE，此参数必传 **/
	public static final String FIELD_PRODUCT_ID = "product_id";
	/** 用户标识 **/
	public static final String FIELD_OPENID = "openid";
	/** 用户子标识 **/
	public static final String FIELD_SUB_OPENID = "sub_openid";
	/** 子商户公众账号ID **/
	public static final String FIELD_SUB_APPID = "sub_appid";

	// ////////////////////////响应字段/////////////////////////////
	/** 返回状态码 **/
	public static final String FIELD_RETURN_CODE = "return_code";
	/** 返回信息 **/
	public static final String FIELD_RETURN_MSG = "return_msg";
	/** 业务结果 **/
	public static final String FIELD_RESULT_CODE = "result_code";
	/** 错误代码 **/
	public static final String FIELD_ERR_CODE = "err_code";
	/** 错误代码描述 **/
	public static final String FIELD_ERR_CODE_DES = "err_code_des";

	/** 错误返回编码：需要用户输入支付密码 **/
	public static final String ERRCODE_USERPAYING = "USERPAYING";
}
