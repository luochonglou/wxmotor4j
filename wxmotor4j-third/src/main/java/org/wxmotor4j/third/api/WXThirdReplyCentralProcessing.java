/**
 * <ul>
 * <li>中央处理接口</li>
 * <li>1、包含添加、删除、通知处理器的三个方法</li>
 * <li>2、只负责接收请求并通知相印的处理器处理消息</li>
 * </ul>
 * 
 */

package org.wxmotor4j.third.api;

/**
 * 微信被动回复中央处理接口
 * 
 * @ClassName: WXThirdReplyCentralProcessing
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Tluo
 * @date 2017年1月13日
 *
 */

public interface WXThirdReplyCentralProcessing {
	/** 添加处理器 **/
	public void registerHandle(WXThirdReplyProcessor processor);

	/** 删除处理器 **/
	public void removeHandle(WXThirdReplyProcessor processor);

	/** 通知处理器 **/
	public String notifyHandle(String requestXml, String subAppid);

}
