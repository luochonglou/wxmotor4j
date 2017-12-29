/**
 * 
 */
package org.wxmotor4j.third.xml.resmsg;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxmotor4j.core.utils.xml.CDATAAdapter;

/**
 * 被动回复：图片消息
 * 
 * @ClassName: WxMpImageResponse
 * @author Tluo
 * @date 2016年12月29日
 *
 */
public class WXThirdImageResponseXml {
	private String MediaId;

	@XmlElement(name = "MediaId")
	public String getMediaId() {
		return MediaId;
	}
	@XmlJavaTypeAdapter(CDATAAdapter.class)
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
