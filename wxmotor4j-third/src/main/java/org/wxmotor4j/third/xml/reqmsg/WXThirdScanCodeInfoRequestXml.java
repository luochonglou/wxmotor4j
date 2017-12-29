/**
 * 
 */
package org.wxmotor4j.third.xml.reqmsg;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @ClassName: WXThirdScanCodeInfoXml
 * @author Tluo
 * @date 2017年9月28日
 *
 */
public class WXThirdScanCodeInfoRequestXml {
	private String ScanType; // 扫描类型，一般是qrcode
	private String ScanResult; // 扫描结果，即二维码对应的字符串信息

	@XmlElement(name = "ScanType")
	public String getScanType() {
		return ScanType;
	}

	public void setScanType(String scanType) {
		ScanType = scanType;
	}

	@XmlElement(name = "ScanResult")
	public String getScanResult() {
		return ScanResult;
	}

	public void setScanResult(String scanResult) {
		ScanResult = scanResult;
	}

}
