/**
 * <ul>
 * <li>中央处理接口</li>
 * <li>1、包含添加、删除、通知处理器的三个方法</li>
 * <li>2、只负责接收请求并通知相印的处理器处理消息</li>
 * </ul>
 * 
 */

package org.wxmotor4j.mp.reply;

import javax.servlet.http.HttpServletRequest;

import org.wxmotor4j.mp.api.WxMpApi;

/**
 * 微信被动回复中央处理接口
 * 
 * @ClassName: WxMpCentralProcessing
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Tluo
 * @date 2017年1月13日
 *
 */

public interface WxMpCentralProcessing extends WxMpApi {
	/** 添加处理器 **/
	public void registerHandle(WxMpProcessor processor);

	/** 删除处理器 **/
	public void removeHandle(WxMpProcessor processor);

	/** 通知处理器 **/
	public String notifyHandle(HttpServletRequest request);

}
