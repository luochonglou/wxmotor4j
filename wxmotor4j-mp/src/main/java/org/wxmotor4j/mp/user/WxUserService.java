package org.wxmotor4j.mp.user;

import java.util.List;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.mp.WxMpResponse;
import org.wxmotor4j.mp.api.WxMpApi;

/**
 * 微信用户管理服务
 * 
 * @ClassName: WxUserService
 * @author Tluo
 * @date 2017年8月11日
 *
 */
public interface WxUserService extends WxMpApi {
	/**
	 * 创建标签
	 * 
	 * @Title: createTag
	 * @return WxMpTag 返回类型
	 */
	public WxMpTag createTag(String tagName) throws WXMotorException;

	/**
	 * 获取标签
	 * 
	 * @Title: getTag
	 * @return WxMpTag 返回类型
	 */
	public WxMpTag getTag() throws WXMotorException;

	/**
	 * 编辑标签
	 * 
	 * @Title: updateTag
	 * @return WxMpResponse 返回类型
	 */
	public WxMpResponse updateTag(Integer tagId, String tagName) throws WXMotorException;

	/**
	 * 删除标签
	 * 
	 * @Title: WxMpResponse
	 * @return WxMpTag 返回类型
	 */
	public WxMpResponse deleteTag(Integer tagId) throws WXMotorException;

	/**
	 * 获取标签下粉丝列表
	 * 
	 * @Title: getUsersByTag
	 * @return WxMpTagUser 返回类型
	 */
	public WxMpTagUser getUsersByTag(Integer tagid, String nextOpenid) throws WXMotorException;

	/**
	 * 批量为用户打标签
	 * 
	 * @Title: WxMpResponse
	 * @return WxMpTag 返回类型
	 */
	public WxMpResponse markUsersTag(Integer tagid, List<String> openidList) throws WXMotorException;

	/**
	 * 批量为用户取消标签
	 * 
	 * @Title: WxMpResponse
	 * @return WxMpTag 返回类型
	 */
	public WxMpResponse upmarkUsersTag(Integer tagid, List<String> openidList) throws WXMotorException;

	/**
	 * 获取用户身上的标签列表
	 * 
	 * @Title: getUserTags
	 * @return List<Integer> 返回类型
	 */
	public List<Integer> getUserTags(String openid) throws WXMotorException;

	/**
	 * 设置用户备注名 ,该接口暂时开放给微信认证的服务号
	 * 
	 * @Title: setUserRemark
	 * @return WxMpResponse 返回类型
	 */
	public WxMpResponse setUserRemark(String openid, String remark) throws WXMotorException;

	/**
	 * 获取用户基本信息（包括UnionID机制）,国家地区语言版本lang可为空， 默认zh_CN
	 * 
	 * @Title: getWxMpUserByOpenid
	 * @return void 返回类型
	 */
	public WxMpUser getWxMpUserByOpenid(String openid, String lang) throws WXMotorException;

	/**
	 * 批量获取用户基本信息，国家地区语言版本lang可为空， 默认zh_CN，如需指定顺序与openids一一对应
	 * 
	 * @Title: getWxMpUsersByOpenids
	 * @return List<WxMpUser> 返回类型
	 */
	public List<WxMpUser> getWxMpUsersByOpenids(List<String> openids, String... lang)
			throws WXMotorException;

	/**
	 * 拉取用户列表
	 * 
	 * @Title: findWxMpUser
	 * @return WxMpUserPull 返回类型
	 */
	public WxMpUserPull findWxMpUser(String nextOpenid) throws WXMotorException;

	/**
	 * 获取公众号的黑名单列表
	 * 
	 * @Title: findBlackWxMpUser
	 * @return WxMpUserPull 返回类型
	 */
	public WxMpUserPull findBlackWxMpUser(String beginOpenid) throws WXMotorException;

	/**
	 * 拉黑用户
	 * 
	 * @Title: pullBlackWxMpUser
	 * @return WxMpResponse 返回类型
	 */
	public WxMpResponse pullBlackWxMpUser(List<String> openedList) throws WXMotorException;

	/**
	 * 取消拉黑用户
	 * 
	 * @Title: upPullBlackWxMpUser
	 * @return WxMpResponse 返回类型
	 */
	public WxMpResponse upPullBlackWxMpUser(List<String> openedList) throws WXMotorException;
}
