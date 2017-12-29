package org.wxmotor4j.mp;

import org.wxmotor4j.mp.api.MemoryWxConfigStorage;
import org.wxmotor4j.mp.menu.WxMpMenu;
import org.wxmotor4j.mp.menu.WxMpMenuMatchrule;
import org.wxmotor4j.mp.menu.WxMpMenuResponse;
import org.wxmotor4j.mp.menu.WxMpMenuServiceImpl;

import com.alibaba.fastjson.JSONObject;

public class MenuDemo {
	// wx.appId=wx9a887bc4430da1c8
	// wx.secret=63fea0d92eda37455413704c50ccdfc9
	// wx.token=snkecelyong
	// wx.aesKey=
	// wx.partnerId=
	// wx.partnerKey=
	// wx.delayTime=7000
	public static void main(String[] args) throws Exception {
		MemoryWxConfigStorage config = new MemoryWxConfigStorage();
		config.setAppId("wx9a887bc4430da1c8");
		config.setSecret("63fea0d92eda37455413704c50ccdfc9");
		config.setToken("snkecelyong");
		config.setDelayTime(7000);
//		String acceessToken = config.getAccessToken();

//		String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=" + acceessToken
//				+ "&type=image";
//		Map<String, FileItem> fileParams = new HashMap<String, FileItem>();
//		FileItem value = new FileItem("D:\\img123\\a.png");
//
//		fileParams.put("media", value);
//		fileParams.put("media2", value);
//		String s = WxHttpClient.doPost(url, fileParams);
//		System.out.println(s);

		// Map<String, File> fileMap = new HashMap<String, File>();
		// File f = new File("D:\\img123\\a.png");
		// fileMap.put("media", f);
		// String res = HttpUtility.post(url, null, null, fileMap);
		// System.out.println(res);
		 WxMpMenuServiceImpl ser = new WxMpMenuServiceImpl();
		 ser.setWxConfigStorage(config);
		// System.out.println(JSONObject.toJSONString(ser.getMenu()));
		//
		// WxHttpResponse res = ser.deleteMenu();
		// System.out.println(res.getErrmsg());
		// System.out.println(res.getErrcode());
		// System.out.println(res.getDesc());
		//
		// System.out.println(JSONObject.toJSONString(ser.getMenu()));
		//
		 // 创建菜单
		 String str =
		 "{\"button\":[{\"name\":\"活动中心\",\"sub_button\":[{\"name\":\"官网\",\"sub_button\":[],\"type\":\"view\",\"url\":\"http://www.gc.com.cn/\"},{\"name\":\"游戏中心\",\"sub_button\":[],\"type\":\"view\",\"url\":\"http://gamecenter.egret-labs.org/20652\"},{\"name\":\"抽奖活动\",\"sub_button\":[],\"type\":\"view\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9a887bc4430da1c8&redirect_uri=http://wx.test.gc.com.cn/lotteryas.html&response_type=code&scope=snsapi_base&state=redfinger8#wechat_redirect\"}]},{\"name\":\"用户功能\",\"sub_button\":[{\"key\":\"21\",\"name\":\"帐号绑定\",\"sub_button\":[],\"type\":\"click\"},{\"key\":\"23\",\"name\":\"截图\",\"sub_button\":[],\"type\":\"click\"},{\"key\":\"24\",\"name\":\"状态查询\",\"sub_button\":[],\"type\":\"click\"}]},{\"name\":\"自助服务\",\"sub_button\":[{\"key\":\"31\",\"name\":\"联系客服\",\"sub_button\":[],\"type\":\"click\"},{\"key\":\"32\",\"name\":\"退出客服\",\"sub_button\":[],\"type\":\"click\"},{\"key\":\"33\",\"name\":\"意见反馈\",\"sub_button\":[],\"type\":\"click\"},{\"name\":\"操作教程\",\"sub_button\":[],\"type\":\"view\",\"url\":\"http://www.gc.com.cn/help/index.html\"}]}]}";
		 WxMpMenu wxMenu = JSONObject.parseObject(str, WxMpMenu.class);
//		  WxHttpResponse res = ser.createMenu(wxMenu);
		 WxMpMenuMatchrule matchrule = new WxMpMenuMatchrule();
		 matchrule.setTagId("1011");
		 wxMenu.setMatchrule(matchrule);
		 WxMpMenuResponse res = ser.delconditionalMenu("457109231");
		 System.out.println(res.getMenuid());
		 System.out.println(res.getErrmsg());
		 System.out.println(res.getErrcode());
		 System.out.println(res.getDesc());
	}

}
