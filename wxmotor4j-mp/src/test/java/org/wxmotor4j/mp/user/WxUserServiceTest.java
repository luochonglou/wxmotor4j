package org.wxmotor4j.mp.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.wxmotor4j.mp.WxMpResponse;
import org.wxmotor4j.mp.api.MemoryWxConfigStorage;

import com.alibaba.fastjson.JSONObject;

public class WxUserServiceTest {

	@Test
	public void createUserTag() {
		WxUserService service = getService();
		WxMpTag tag = service.createTag("广东44");
		System.out.println(tag.getJsonData());
		System.out.println(tag.getTag().getId());
		System.out.println(tag.getDesc());
	}

	@Test
	public void getUserTag() {
		WxUserService service = getService();
		WxMpTag tag = service.getTag();
		System.out.println(tag.getJsonData());
		System.out.println(JSONObject.toJSON(tag.getTags()));
		System.out.println(tag.getDesc());
	}

	@Test
	public void updateUserTag() {
		WxUserService service = getService();
		WxMpResponse tag = service.updateTag(100, "测试111");
		System.out.println(tag.getJsonData());
		System.out.println(tag.getDesc());
	}

	@Test
	public void deleteUserTag() {
		WxUserService service = getService();
		WxMpResponse tag = service.deleteTag(100);
		System.out.println(tag.getJsonData());
		System.out.println(tag.getDesc());
	}

	@Test
	public void getUsersByTag() {
		WxUserService service = getService();
		WxMpTagUser users = service.getUsersByTag(101, null);
		System.out.println(users.getJsonData());
		System.out.println(users.getDesc());
		System.out.println(users.getOpenids().toString());
	}

	@Test
	public void markUsersTag() {
		WxUserService service = getService();
		List<String> list = new ArrayList<String>();
		list.add("oI5Zzsw14lt1kY34zQNpe6Inl5-Q");
		list.add("oI5Zzs96Idh82gyASnHyLXSqE6nY");
		list.add("oI5Zzs9wXTVMOrtODmSnTJ-EdHzA");
		list.add("oI5Zzsx_cjy0WJpirjz3zTtW7TvI");
		WxMpResponse users = service.markUsersTag(103, list);
		System.out.println(users.getJsonData());
		System.out.println(users.getDesc());
	}

	@Test
	public void upmarkUsersTag() {
		WxUserService service = getService();
		List<String> list = new ArrayList<String>();
		list.add("oI5Zzs3oB7eGqbYSk1EaVOeHXPrc");
		WxMpResponse users = service.upmarkUsersTag(101, list);
		System.out.println(users.getJsonData());
		System.out.println(users.getDesc());
	}

	@Test
	public void getUserTags() {
		WxUserService service = getService();
		List<Integer> res = service.getUserTags("oI5Zzs3oB7eGqbYSk1EaVOeHXPrc");

		System.out.println(res.size() + "=" + res.toString());
	}

	@Test
	public void getWxMpUserByOpenid() {
		WxUserService service = getService();
		WxMpUser res = service.getWxMpUserByOpenid("oI5Zzs3oB7eGqbYSk1EaVOeHXPrc", null);
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(JSONObject.toJSONString(res));
	}

	@Test
	public void getWxMpUsersByOpenids() {
		WxUserService service = getService();
		List<String> openids = new ArrayList<String>();
		openids.add("oI5Zzs3oB7eGqbYSk1EaVOeHXPrc");
		openids.add("oI5Zzs96Idh82gyASnHyLXSqE6nY");
		List<WxMpUser> res = service.getWxMpUsersByOpenids(openids, "d");

		System.out.println(JSONObject.toJSONString(res));
	}

	@Test
	public void findWxMpUser() {
		WxUserService service = getService();
		WxMpUserPull res = service.findWxMpUser("");
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(JSONObject.toJSONString(res));
	}

	@Test
	public void findBlackWxMpUser() {
		WxUserService service = getService();
		WxMpUserPull res = service.findBlackWxMpUser("");
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(JSONObject.toJSONString(res));
	}

	@Test
	public void pullBlackWxMpUser() {
		WxUserService service = getService();
		List<String> openedList = new ArrayList<String>();
		openedList.add("oI5Zzsx_cjy0WJpirjz3zTtW7TvI");
		openedList.add("oI5Zzs9wXTVMOrtODmSnTJ-EdHzA");
		WxMpResponse res = service.pullBlackWxMpUser(openedList);
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(JSONObject.toJSONString(res));
	}

	@Test
	public void upPullBlackWxMpUser() {
		WxUserService service = getService();
		List<String> openedList = new ArrayList<String>();
		openedList.add("");
		WxMpResponse res = service.upPullBlackWxMpUser(openedList);
		System.out.println(res.getJsonData());
		System.out.println(res.getDesc());
		System.out.println(JSONObject.toJSONString(res));
	}

	private WxUserService getService() {
		MemoryWxConfigStorage configStorage = new MemoryWxConfigStorage();
		configStorage.setAppId("wx9a887bc4430da1c8");
		configStorage.setSecret("63fea0d92eda37455413704c50ccdfc9");
		configStorage.setToken("snkecelyong");
		configStorage.setDelayTime(7000);
		WxUserService service = new WxUserServiceImpl();
		service.setWxConfigStorage(configStorage);
		return service;
	}
}
