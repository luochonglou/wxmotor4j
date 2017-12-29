/**
 * 
 */
package org.wxmotor4j.third.xml.reqmsg;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @ClassName: WXThirdItemXml
 * @author Tluo
 * @date 2017年9月28日
 *
 */
public class WXThirdItemRequestXml {
	private String PicMd5Sum;

	@XmlElement(name = "PicMd5Sum")
	public String getPicMd5Sum() {
		return PicMd5Sum;
	}

	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}

}
