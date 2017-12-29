package org.wxmotor4j.mp.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.utils.ListUtils;
import org.wxmotor4j.core.utils.StringUtils;
import org.wxmotor4j.core.utils.http.WxHttpClient;
import org.wxmotor4j.mp.WxMpResponse;
import org.wxmotor4j.mp.api.WxApiGateway;
import org.wxmotor4j.mp.api.WxConfigStorage;
import org.wxmotor4j.mp.user.WxMpTag.Tag;

import com.alibaba.fastjson.JSONObject;

public class WxUserServiceImpl implements WxUserService {
	private WxConfigStorage configStorage;

	public void setWxConfigStorage(WxConfigStorage configStorage) throws WXMotorException {
		this.configStorage = configStorage;
	}

	public WxMpTag createTag(String tagName) throws WXMotorException {
		try {
			WxMpTag userTag = new WxMpTag();
			Tag tag = new Tag();
			tag.setName(tagName);
			userTag.setTag(tag);
			String url = WxApiGateway.user_tag_create.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			String jsonData = WxHttpClient.doPost(url, JSONObject.toJSONString(userTag));
			userTag = JSONObject.parseObject(jsonData, WxMpTag.class);
			userTag.setJsonData(jsonData);
			return userTag;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpTag getTag() throws WXMotorException {
		try {
			String url = WxApiGateway.user_tag_get.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			String jsonData = WxHttpClient.doGet(url, null);
			WxMpTag userTag = JSONObject.parseObject(jsonData, WxMpTag.class);
			userTag.setJsonData(jsonData);
			return userTag;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpResponse updateTag(Integer tagId, String tagName) throws WXMotorException {
		try {
			WxMpTag userTag = new WxMpTag();
			Tag tag = new Tag();
			tag.setId(tagId);
			tag.setName(tagName);
			userTag.setTag(tag);
			String url = WxApiGateway.user_tag_update.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			String jsonData = WxHttpClient.doPost(url, JSONObject.toJSONString(userTag));
			WxMpResponse wxMpResponse = JSONObject.parseObject(jsonData, WxMpResponse.class);
			wxMpResponse.setJsonData(jsonData);
			return wxMpResponse;

		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpResponse deleteTag(Integer tagId) throws WXMotorException {
		try {
			WxMpTag userTag = new WxMpTag();
			Tag tag = new Tag();
			tag.setId(tagId);
			userTag.setTag(tag);
			String url = WxApiGateway.user_tag_delete.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			String jsonData = WxHttpClient.doPost(url, JSONObject.toJSONString(userTag));
			WxMpResponse wxMpResponse = JSONObject.parseObject(jsonData, WxMpResponse.class);
			wxMpResponse.setJsonData(jsonData);
			return wxMpResponse;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpTagUser getUsersByTag(Integer tagid, String nextOpenid) throws WXMotorException {
		try {
			String url = WxApiGateway.user_tag_getuserlist.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("tagid", tagid);
			params.put("next_openid", nextOpenid);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpTagUser users = JSONObject.parseObject(jsonData, WxMpTagUser.class);
			users.setJsonData(jsonData);
			return users;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpResponse markUsersTag(Integer tagid, List<String> openidList) throws WXMotorException {
		try {
			String url = WxApiGateway.user_tag_markuser.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("tagid", tagid);
			params.put("openid_list", openidList);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpResponse res = JSONObject.parseObject(jsonData, WxMpResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpResponse upmarkUsersTag(Integer tagid, List<String> openidList) throws WXMotorException {
		try {
			String url = WxApiGateway.user_tag_upmarkuser.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("tagid", tagid);
			params.put("openid_list", openidList);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpResponse res = JSONObject.parseObject(jsonData, WxMpResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public List<Integer> getUserTags(String openid) throws WXMotorException {
		try {
			String url = WxApiGateway.user_tag_getusertag.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("openid", openid);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			JSONObject res = JSONObject.parseObject(jsonData);
			@SuppressWarnings("unchecked")
			List<Integer> list = (List<Integer>) res.get("tagid_list");
			return list;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpResponse setUserRemark(String openid, String remark) throws WXMotorException {
		try {
			String url = WxApiGateway.user_set_remark.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("openid", openid);
			params.put("remark", remark);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpResponse res = JSONObject.parseObject(jsonData, WxMpResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpUser getWxMpUserByOpenid(String openid, String lang) throws WXMotorException {
		try {
			if (StringUtils.isEmpty(lang)) {
				lang = "zh_CN";
			}
			String url = WxApiGateway.user_get_userinfo
					.replaceAll("ACCESS_TOKEN", configStorage.getAccessToken())
					.replaceAll("OPENID", openid).replaceAll("LANG", lang);
			String jsonData = WxHttpClient.doGet(url, null);
			WxMpUser res = JSONObject.parseObject(jsonData, WxMpUser.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public List<WxMpUser> getWxMpUsersByOpenids(List<String> openids, String... lang)
			throws WXMotorException {
		try {
			String defLang = "zh_CN";
			if (ListUtils.isEmpty(openids)) {
				return new ArrayList<WxMpUser>();
			}
			WxMpUser params = new WxMpUser();
			List<WxMpUser> userList = new ArrayList<WxMpUser>();
			params.setUserList(userList);
			for (int i = 0; i < openids.size(); i++) {
				WxMpUser user = new WxMpUser();
				user.setOpenid(openids.get(i));
				if (null == lang || lang.length < i + 1) {
					user.setLang(defLang);
				} else {
					user.setLang(lang[i]);
				}
				userList.add(user);
			}
			String url = WxApiGateway.user_batchget_userinfo.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			String jsonData = WxHttpClient.doPost(url, JSONObject.toJSONString(params));
			WxMpUser res = JSONObject.parseObject(jsonData, WxMpUser.class);
			return res.getUserInfoList();
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpUserPull findWxMpUser(String nextOpenid) throws WXMotorException {
		try {
			if (null == nextOpenid) {
				nextOpenid = "";
			}
			String url = WxApiGateway.user_find_userinfo.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken()).replaceAll("NEXT_OPENID", nextOpenid);
			String jsonData = WxHttpClient.doGet(url, null);
			WxMpUserPull res = JSONObject.parseObject(jsonData, WxMpUserPull.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpUserPull findBlackWxMpUser(String beginOpenid) throws WXMotorException {
		try {
			String url = WxApiGateway.user_find_blackuser.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			if (null == beginOpenid) {
				beginOpenid = "";
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("begin_openid", beginOpenid);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpUserPull res = JSONObject.parseObject(jsonData, WxMpUserPull.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpResponse pullBlackWxMpUser(List<String> openedList) throws WXMotorException {
		try {
			WxMpResponse res = null;
			if (ListUtils.isEmpty(openedList)) {
				res = new WxMpResponse();
				res.setDesc("openedList is null ..");
			}
			String url = WxApiGateway.user_pull_blackuser.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("opened_list", openedList);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			res = JSONObject.parseObject(jsonData, WxMpResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpResponse upPullBlackWxMpUser(List<String> openedList) throws WXMotorException {
		try {
			WxMpResponse res = null;
			if (ListUtils.isEmpty(openedList)) {
				res = new WxMpResponse();
				res.setDesc("openedList is null ..");
			}
			String url = WxApiGateway.user_uppull_blackuser.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("opened_list", openedList);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			res = JSONObject.parseObject(jsonData, WxMpResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

}
