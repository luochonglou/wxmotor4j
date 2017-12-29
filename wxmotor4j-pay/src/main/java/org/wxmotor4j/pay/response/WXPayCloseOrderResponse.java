package org.wxmotor4j.pay.response;

import javax.xml.bind.annotation.XmlRootElement;

import org.wxmotor4j.pay.api.WXPayResponse;

/**
 * 微信支付：关闭订单返回对象
 * 
 * @ClassName: WXPayCloseOrderResponse
 * @author Tluo
 * @date 2017年11月7日
 *
 */
@XmlRootElement(name = "xml")
public class WXPayCloseOrderResponse extends WXPayResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = 5768927165845601408L;

}
