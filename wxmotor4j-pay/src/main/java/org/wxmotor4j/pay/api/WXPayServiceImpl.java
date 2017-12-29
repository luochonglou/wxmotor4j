package org.wxmotor4j.pay.api;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.wxmotor4j.pay.api.WXPayConstants.EResultCode;
import org.wxmotor4j.pay.api.WXPayConstants.EReturnCode;
import org.wxmotor4j.pay.api.WXPayConstants.ETradeState;
import org.wxmotor4j.pay.api.utils.StringUtils;
import org.wxmotor4j.pay.api.utils.WXPayUtil;
import org.wxmotor4j.pay.request.WXPayCloseOrderRequest;
import org.wxmotor4j.pay.request.WXPayMicropayRequest;
import org.wxmotor4j.pay.request.WXPayQueryOrderRequest;
import org.wxmotor4j.pay.request.WXPayUnifiedOrderRequest;
import org.wxmotor4j.pay.response.WXPayCloseOrderResponse;
import org.wxmotor4j.pay.response.WXPayMicropayResponse;
import org.wxmotor4j.pay.response.WXPayQueryOrderResponse;
import org.wxmotor4j.pay.response.WXPayUnifiedOrderResponse;

/**
 * 微信支付服务实现类
 * 
 * @ClassName: WXPayServiceImpl
 * @author Tluo
 * @date 2017年11月7日
 *
 */
public class WXPayServiceImpl implements WXPayService {

	private WXPayClient wXPayClient;
	private WXPayConfigManage wXPayConfigManage;

	/**
	 * 
	 * 创建一个新的实例 WXPayServiceImpl.
	 * 
	 * @param wXPayConfigManage
	 */
	public WXPayServiceImpl(WXPayConfigManage wXPayConfigManage) {
		super();
		this.wXPayConfigManage = wXPayConfigManage;
		this.wXPayClient = new DefaultWXPayClient();
	}

	/**
	 * 
	 * 创建一个新的实例 WXPayServiceImpl.
	 * 
	 * @param wXPayClient
	 * @param wXPayConfigManage
	 */
	public WXPayServiceImpl(WXPayClient wXPayClient, WXPayConfigManage wXPayConfigManage) {
		super();
		this.wXPayClient = wXPayClient;
		this.wXPayConfigManage = wXPayConfigManage;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param wXPayClient
	 * 
	 * @see
	 * org.wxmotor4j.pay.api.WXPayService#setWXPayClient(org.wxmotor4j.pay.api
	 * .WXPayClient)
	 */
	@Override
	public void setWXPayClient(WXPayClient wXPayClient) {
		this.wXPayClient = wXPayClient;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 
	 * @param wXPayConfigManage
	 * 
	 * @see
	 * org.wxmotor4j.pay.api.WXPayService#setWXPayConfigManage(org.wxmotor4j
	 * .pay.api.WXPayConfigManage)
	 */
	@Override
	public void setWXPayConfigManage(WXPayConfigManage wXPayConfigManage) {
		this.wXPayConfigManage = wXPayConfigManage;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 扫码支付
	 * 
	 * @param params
	 * 
	 * @return
	 * 
	 * @throws WXPayException
	 * 
	 * @see org.wxmotor4j.pay.api.WXPayService#barPayOrder(java.util.Map)
	 */
	@Override
	public WXPayQueryOrderResponse barPayOrder(Map<String, String> params) throws WXPayException {
		WXPayMicropayRequest micropayRequest = new WXPayMicropayRequest(wXPayConfigManage, params);
		WXPayMicropayResponse res = wXPayClient.execute(micropayRequest);
		String outTradeNo = params.get(WXPayConstants.FIELD_OUT_TRADE_NO);
		String subMchId = params.get(WXPayConstants.FIELD_SUB_MCH_ID);
		String retCode = res.getReturnCode();
		if (EReturnCode.FAIL.toString().equals(retCode)) {
			// 返回状态码失败
			String retMsg = res.getReturnMsg();
			WXPayUtil.printErrLog(outTradeNo, retCode, retMsg);
			WXPayQueryOrderResponse dest = new WXPayQueryOrderResponse();
			try {
				BeanUtils.copyProperties(dest, res);
				return dest;
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new WXPayException(e.getMessage(), e);
			}
		}
		String resCode = res.getResultCode();
		String errCode = res.getErrCode();
		if (EResultCode.FAIL.toString().equals(resCode) || StringUtils.isNotEmpty(errCode)) {
			if (errCode.equals(WXPayConstants.ERRCODE_USERPAYING)) {
				// 需要用户输入支付密码
				try {
					Thread.sleep(3000); // 等待用户输入密码
				} catch (Exception e) {
				}
			} else {
				// 业务结果失败 / 返回错误代码
				String errCodeDesc = res.getErrCodeDes();
				WXPayUtil.printErrLog(outTradeNo, resCode, errCode, errCodeDesc);
				WXPayQueryOrderResponse dest = new WXPayQueryOrderResponse();
				try {
					BeanUtils.copyProperties(dest, res);
					return dest;
				} catch (IllegalAccessException | InvocationTargetException e) {
					throw new WXPayException(e.getMessage(), e);
				}
			}
		}
		/*
		 * 支付成功，查询订单状态
		 */
		String transactionTd = res.getTransactionTd();
		WXPayQueryOrderResponse queryRes = queryOrder(transactionTd, outTradeNo, subMchId);
		if (ETradeState.SUCCESS.toString().equals(queryRes.getTradeState())) { // 订单成功
			return queryRes;
		}
		/*
		 * 轮询查询
		 */
		int mark = 0;// 轮询标记条件
		int time = 5000;// 轮询间隔时间5s 10s 20s
		do {
			try {
				Thread.sleep(time);
				queryRes = queryOrder(transactionTd, outTradeNo, subMchId);
				if (ETradeState.SUCCESS.toString().equals(queryRes.getTradeState())) { // 订单成功
					return queryRes;
				}
			} catch (Exception e) {
			} finally {
				time = time << mark;
				mark++;
			}
		} while (mark < 3);
		/*
		 * 关闭订单
		 */
		closeOrder(outTradeNo, subMchId);
		throw new WXPayException("WXPayment fail, the order is closed.");
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 查询订单
	 * 
	 * @param transactionId
	 * 
	 * @param outTradeNo
	 * 
	 * @return
	 * 
	 * @throws WXPayException
	 * 
	 * @see org.wxmotor4j.pay.api.WXPayService#queryOrder(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public WXPayQueryOrderResponse queryOrder(String transactionId, String outTradeNo,
			String subMchId) throws WXPayException {
		Map<String, String> params = new HashMap<String, String>();
		params.put(WXPayConstants.FIELD_SUB_MCH_ID, subMchId);
		params.put(WXPayConstants.FIELD_NONCE_STR, WXPayUtil.generateUUID());
		if (StringUtils.isNotEmpty(transactionId)) {
			params.put(WXPayConstants.FIELD_TRANSACTION_ID, transactionId);
		}
		if (StringUtils.isNotEmpty(outTradeNo)) {
			params.put(WXPayConstants.FIELD_OUT_TRADE_NO, outTradeNo);
		}
		WXPayQueryOrderRequest queryRequest = new WXPayQueryOrderRequest(wXPayConfigManage, params);
		return wXPayClient.execute(queryRequest);

	}

	/*
	 * (非 Javadoc)
	 * 
	 * 统一下单
	 * 
	 * @param params
	 * 
	 * @return
	 * 
	 * @throws WXPayException
	 * 
	 * @see org.wxmotor4j.pay.api.WXPayService#unifiedOrder(java.util.Map)
	 */
	@Override
	public WXPayUnifiedOrderResponse unifiedOrder(Map<String, String> params) throws WXPayException {
		WXPayUnifiedOrderRequest nifiedOrderRequest = new WXPayUnifiedOrderRequest(
				wXPayConfigManage, params);
		return wXPayClient.execute(nifiedOrderRequest);
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 关闭下单
	 * 
	 * @param params
	 * 
	 * @return
	 * 
	 * @throws WXPayException
	 * 
	 * @see org.wxmotor4j.pay.api.WXPayService#closeOrder(java.util.Map)
	 */
	@Override
	public WXPayCloseOrderResponse closeOrder(String outTradeNo, String subMchId)
			throws WXPayException {
		Map<String, String> params = new HashMap<String, String>();
		params.put(WXPayConstants.FIELD_SUB_MCH_ID, subMchId);
		params.put(WXPayConstants.FIELD_NONCE_STR, WXPayUtil.generateUUID());// 随机字符串
		params.put(WXPayConstants.FIELD_OUT_TRADE_NO, outTradeNo); // 商户订单号
		WXPayCloseOrderRequest closeOrderRequest = new WXPayCloseOrderRequest(wXPayConfigManage,
				params);
		return wXPayClient.execute(closeOrderRequest);
	}

	/*
	 * (非 Javadoc)
	 * 
	 * 处理支付回调
	 * 
	 * @param queryXml
	 * 
	 * @return
	 * 
	 * @throws WXPayException
	 * 
	 * @see
	 * org.wxmotor4j.pay.api.WXPayService#handleWxpayCallback(java.lang.String)
	 */
	@Override
	public Map<String, String> handleWxpayCallback(String queryXml) throws WXPayException {
		Map<String, String> resMap = WXPayUtil.xmlToMap(queryXml);
		boolean signStatus = WXPayUtil.isSignatureValid(resMap, wXPayConfigManage.getMchKey(),
				wXPayConfigManage.getSignType());
		if (!signStatus) {
			return null;
		}
		if (resMap.containsKey(WXPayConstants.FIELD_RESULT_CODE)) {
			String returnCode = resMap.get(WXPayConstants.FIELD_RESULT_CODE);
			if (EResultCode.SUCCESS.toString().equals(returnCode)) {
				return resMap;
			}
		}
		return null;
	}
}
