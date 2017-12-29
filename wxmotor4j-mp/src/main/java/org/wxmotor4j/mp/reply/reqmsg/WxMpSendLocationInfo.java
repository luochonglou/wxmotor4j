/**
 * 
 */
package org.wxmotor4j.mp.reply.reqmsg;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
* @ClassName: WxMpSendLocationInfo
* @author Tluo
* @date 2016年12月29日
*
 */
public class WxMpSendLocationInfo {
	private String Location_X;
	private String Location_Y;
	private String Scale;
	private String Label;
	private String Poiname;

	@XmlElement(name="Location_X")
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	@XmlElement(name="Location_Y")
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	@XmlElement(name="Scale")
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	@XmlElement(name="Label")
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	@XmlElement(name="Poiname")
	public String getPoiname() {
		return Poiname;
	}
	public void setPoiname(String poiname) {
		Poiname = poiname;
	}
	
	
	
	
}
