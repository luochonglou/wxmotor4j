package org.wxmotor4j.mp.material;

import java.io.File;

import org.junit.Test;
import org.wxmotor4j.mp.api.MemoryWxConfigStorage;

public class MaterialServiceTest {
	@Test
	public void addTemporaryMaterial() {
		WxMpMaterialService service = getService();

		WxMpMaterialResponse res = service.addTemporaryMaterial(new File("D:\\img123\\a.png"));
		System.out.println(res.getDesc());
		System.out.println(res.getCreatedAt());
		System.out.println(res.getJsonData());
	}
	@Test
	public void uploadImg(){
		WxMpMaterialService service = getService();
		WxMpMaterialResponse res = service.uploadImg(new File("D:\\img123\\a.png"));
		System.out.println(res.getJsonData());
	}
	@Test
	public void get(){
		WxMpMaterialService service = getService();

		String url = service.getTemporaryMaterialUrl("8Fp2G7f7HGy2nAESrYEoNGP_3RfB5jn5P7d2H71BKlMQss0c4F49uxXktW1VLZE3");
		System.out.println(url);
	}

	private WxMpMaterialService getService() {
		MemoryWxConfigStorage configStorage = new MemoryWxConfigStorage();
		configStorage.setAppId("wx9a887bc4430da1c8");
		configStorage.setSecret("63fea0d92eda37455413704c50ccdfc9");
		configStorage.setToken("snkecelyong");
		configStorage.setDelayTime(7000);
		WxMpMaterialService service = new WxMpMaterialServiceImpl();
		service.setWxConfigStorage(configStorage);
		return service;
	}

}
