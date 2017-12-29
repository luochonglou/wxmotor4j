package org.wxmotor4j.mp.account;

import org.junit.Test;
import org.wxmotor4j.mp.api.MemoryWxConfigStorage;

public class WxMpAccountServiceTest {

	@Test
	public void createTemporaryQrcode() {
		WxMpAccountService service = getService();
		WxMpQrcode res = service.createTemporaryQrcode(1, 30l);
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(res.getUrl());
	}

	@Test
	public void createTemporaryQrcodestr() {
		WxMpAccountService service = getService();
		WxMpQrcode res = service.createTemporaryQrcode("sss", 30l);
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(res.getUrl());
	}

	@Test
	public void createForeverQrcode() {
		WxMpAccountService service = getService();
		WxMpQrcode res = service.createForeverQrcode(1211);
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(res.getUrl());
	}

	@Test
	public void createForeverQrcodestr() {
		WxMpAccountService service = getService();

		WxMpQrcode res = service.createForeverQrcode("sdfasdf23488sdf");
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(res.getUrl());
	}

	@Test
	public void getQrcodeUrlByTicket() {
		WxMpAccountService service = getService();

		String res = service
				.getQrcodeUrlByTicket("gQGQ8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAycjZWdnhQem05UFAxMDAwMGcwN2oAAgQxXY1ZAwQAAAAA");
		System.out.println(res);

	}

	@Test
	public void longlinkToShortlink() {
		WxMpAccountService service = getService();
		WxMpLink res = service
				.longlinkToShortlink("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGQ8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAycjZWdnhQem05UFAxMDAwMGcwN2oAAgQxXY1ZAwQAAAAA");
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(res.getShortUrl());
	}

	private WxMpAccountService getService() {
		MemoryWxConfigStorage configStorage = new MemoryWxConfigStorage();
		configStorage.setAppId("wx9a887bc4430da1c8");
		configStorage.setSecret("63fea0d92eda37455413704c50ccdfc9");
		configStorage.setToken("snkecelyong");
		configStorage.setDelayTime(7000);
		WxMpAccountService service = new WxMpAccountServiceImpl();
		service.setWxConfigStorage(configStorage);
		return service;
	}
}
