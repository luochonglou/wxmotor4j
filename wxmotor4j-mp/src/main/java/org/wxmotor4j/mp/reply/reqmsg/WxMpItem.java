/**
 * 
 */
package org.wxmotor4j.mp.reply.reqmsg;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
* @ClassName: WxMpItem
* @author Tluo
* @date 2016年12月29日
*
 */
public class WxMpItem {
	private String PicMd5Sum;

	@XmlElement(name="PicMd5Sum")
	public String getPicMd5Sum() {
		return PicMd5Sum;
	}
	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}
	
}
