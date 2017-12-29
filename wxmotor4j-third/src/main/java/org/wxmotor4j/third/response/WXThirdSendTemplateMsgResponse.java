package org.wxmotor4j.third.response;

import org.wxmotor4j.third.api.WXThirdResponse;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: WXThirdSendTemplateMsgResponse
 * @author Tluo
 * @date 2017年9月29日
 *
 */
public class WXThirdSendTemplateMsgResponse extends WXThirdResponse {

	/**
	 * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	 */

	private static final long serialVersionUID = -6924681364950545784L;

	@JSONField(name = "msgid")
	private Integer msgid;

	public Integer getMsgid() {
		return msgid;
	}

	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}

}
