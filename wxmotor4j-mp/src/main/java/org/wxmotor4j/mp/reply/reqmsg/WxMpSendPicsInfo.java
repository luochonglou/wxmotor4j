/**
 * 
 */
package org.wxmotor4j.mp.reply.reqmsg;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 
* @ClassName: WxMpSendPicsInfo
* @author Tluo
* @date 2016年12月29日
*
 */
public class WxMpSendPicsInfo {
	private String Count;
	private List<WxMpItem> item;
	
	@XmlElement(name="Count")
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	@XmlElementWrapper(name="PicList")
	@XmlElement(name="item")
	public List<WxMpItem> getItem() {
		return item;
	}
	public void setItem(List<WxMpItem> item) {
		this.item = item;
	}

	
	
	
}
