package org.wxmotor4j.mp.api;

/**
 * 微信接口网关
 * 
 * @ClassName: WxApiGateway
 * @author Tluo
 * @date 2017年8月3日
 *
 */
public interface WxApiGateway {

	// =========================================|基础接口|=========================================
	/* 获取accesstoken网关 */
	public String accesstoken_get_gateway = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
	/* 获取jsapiticket网关 */
	public String jsapiticket_get_gateway = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=ACCESS_TOKEN";

	// =========================================|菜单接口|=========================================
	/* 创建菜单网关 */
	public String menu_create_gateway = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	/* 查询菜单网关 */
	public String menu_get_gateway = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	/* 删除菜单网关 */
	public String menu_delete_gateway = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	/* 创建个性化菜单网关 */
	public String menu_addconditional_gateway = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
	/* 删除个性化菜单网关 */
	public String menu_delconditional_gateway = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
	/* 测试个性化菜单网关 */
	public String menu_trymatch_gateway = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";

	// =========================================|素材接口|=========================================
	/* 新增临时素材 */
	public String material_temporary_add = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	/* 获取临时素材 */
	public String material_temporary_get = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	/* 获取高清语音素材 */
	public String material_voice_get = "https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	/* 新增永久图文素材 */
	public String material_forever_addnews = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	/* 新增图文图片永久素材 */
	public String material_image_text_add = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	/* 修改图文图片永久素材 */
	public String material_image_text_update = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
	/* 新增其他永久素材 */
	public String material_other_add = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
	/* 获取永久素材 */
	public String material_forever_get = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
	/* 删除永久素材 */
	public String material_forever_del = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
	/* 获取永久素材总数 */
	public String material_forever_total = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
	/* 获取永久素材列表 */
	public String material_forever_list = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";

	// =========================================|用户接口|=========================================
	/* 创建用户标签 */
	public String user_tag_create = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";
	/* 获取用户标签 */
	public String user_tag_get = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
	/* 修改用户标签 */
	public String user_tag_update = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN";
	/* 删除用户标签 */
	public String user_tag_delete = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN";
	/* 获取标签下粉丝列表 */
	public String user_tag_getuserlist = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";
	/* 批量为用户打标签 */
	public String user_tag_markuser = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
	/* 批量为用户取消标签 */
	public String user_tag_upmarkuser = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=ACCESS_TOKEN";
	/* 获取用户身上的标签列表 */
	public String user_tag_getusertag = "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";
	/* 设置用户备注名 */
	public String user_set_remark = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
	/* 获取用户基本信息（包括UnionID机制） */
	public String user_get_userinfo = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=LANG";
	/* 批量获取用户基本信息 */
	public String user_batchget_userinfo = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
	/* 获取用户列表 */
	public String user_find_userinfo = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	/* 获取黑名单用户列表 */
	public String user_find_blackuser = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN";
	/* 拉黑用户 */
	public String user_pull_blackuser = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN";
	/* 取消拉黑用户 */
	public String user_uppull_blackuser = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN";

	// =========================================|帐号接口|=========================================
	/* 创建二维码ticket */
	public String account_qrcode_getticket = " https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	/* 通过ticket换取二维码 */
	public String account_qrcode_getqrcode = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	/* 长链接转短链接接口 */
	public String account_longurl_shorter = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
	
	// =========================================|卡卷接口|=========================================
	/*卡卷创建*/
	public String card_create="https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";

}
