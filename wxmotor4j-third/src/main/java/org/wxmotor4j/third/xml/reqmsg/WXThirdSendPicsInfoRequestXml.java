/**
 * 
 */
package org.wxmotor4j.third.xml.reqmsg;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 
 * @ClassName: WXThirdSendPicsInfoXml
 * @author Tluo
 * @date 2017年9月28日
 *
 */
public class WXThirdSendPicsInfoRequestXml {
	private String Count;
	private List<WXThirdItemRequestXml> item;

	@XmlElement(name = "Count")
	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		Count = count;
	}

	@XmlElementWrapper(name = "PicList")
	@XmlElement(name = "item")
	public List<WXThirdItemRequestXml> getItem() {
		return item;
	}

	public void setItem(List<WXThirdItemRequestXml> item) {
		this.item = item;
	}

}
