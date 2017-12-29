/**
 * <ul>
 * <li>处理器</li>
 * <li>1、包含三个属性msgType 消息类型、event 事件类型、eventKey 事件key、centralProcessing中央处理，和一个抽象方法handleMsg().</li>
 * <li>2、使用时应保证每个msgType + event + eventKey 唯一。</li>
 * </ul>
 */

package org.wxmotor4j.third.api;

import org.wxmotor4j.core.WXMotorException;

/**
 * 微信被动回复消息处理器
 * 
 * @ClassName: WXThirdReplyProcessor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Tluo
 * @date 2017年1月13日
 *
 */

public abstract class WXThirdReplyProcessor {
	/**
	 * 处理微信消息的类型
	 */
	private String msgType;
	/**
	 * 处理微信事件消息的事件类型
	 */
	private String event;
	/**
	 * 处理微信event事件的key，只有事件消息才有，每个msgType+event+eventKey 唯一
	 */
	private String eventKey;
	/**
	 * 中央处理对象，即带头大哥，它负责接收微信消息解析后分发给Handle处理
	 */
	private WXThirdReplyCentralProcessing centralProcessing;

	/**
	 * 
	 * 创建一个新的实例 Handle.
	 *
	 * @param msgType
	 * @param eventKey
	 * @param centralProcessingSubject
	 */
	public WXThirdReplyProcessor(String msgType, String event, String eventKey,
			WXThirdReplyCentralProcessing centralProcessing) {
		this.msgType = msgType;
		this.event = event;
		this.eventKey = eventKey;
		if (null != centralProcessing) {
			this.centralProcessing = centralProcessing;
			centralProcessing.registerHandle(this); // 向中央处理对象中添加处理对象，即添加观察者
		}
	}

	public String getMsgType() {
		return msgType;
	}

	public String getEvent() {
		return event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public WXThirdReplyCentralProcessing getCentralProcessing() {
		return centralProcessing;
	}

	/**
	 * 处理方法
	 * 
	 * @Title: handleMsg
	 * @param 参数
	 * @return void 返回类型
	 * @throws 抛出异常
	 */
	public abstract void handleMsg() throws WXMotorException;
}
