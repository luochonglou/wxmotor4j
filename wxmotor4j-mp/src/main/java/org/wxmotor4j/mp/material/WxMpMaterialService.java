package org.wxmotor4j.mp.material;

import java.io.File;
import java.util.List;

import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.mp.api.WxMpApi;

/**
 * 素材服务接口
 * 
 * @ClassName: WxMpMaterialService
 * @author Tluo
 * @date 2017年8月7日
 *
 */
public interface WxMpMaterialService extends WxMpApi {
	/**
	 * 新增临时素材
	 * 
	 * @Title: addTemporaryMaterial
	 * @return MaterialResponse 返回类型
	 */
	public WxMpMaterialResponse addTemporaryMaterial(File file) throws WXMotorException;

	/**
	 * 获取临时素材URL
	 * 
	 * @Title: getTemporaryMaterialUrl
	 * @return String 返回类型
	 */
	public String getTemporaryMaterialUrl(String mediaId) throws WXMotorException;

	/**
	 * 获取视频临时素材URL
	 * 
	 * @Title: getTemporaryVideoMaterialVUrl
	 * @return String 返回类型
	 */
	public String getTemporaryVideoMaterialVUrl(String mediaId) throws WXMotorException;

	/**
	 * 新增图文永久素材
	 * 
	 * @Title: addNewsForeverMaterial
	 * @return MaterialResponse 返回类型
	 */
	public WxMpMaterialResponse addNewsForeverMaterial(List<WxMpArticles> articless) throws WXMotorException;

	/**
	 * 上传图文消息内的图片获取URL
	 * 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
	 * 
	 * @Title: uploadimg
	 * @return MaterialResponse 返回类型
	 */
	public WxMpMaterialResponse uploadImg(File file) throws WXMotorException;

	/**
	 * 新增其他类型永久素材
	 * 
	 * @Title: addOtherForeverMaterial
	 * @return MaterialResponse 返回类型
	 */
	public WxMpMaterialResponse addOtherForeverMaterial(File file, String title, String introduction)
			throws WXMotorException;

	/**
	 * 获取永久素材
	 * 
	 * @Title: getMaterialForever
	 * @return MaterialForeverResponse 返回类型
	 */
	public WxMpMaterialForeverResponse getForeverMaterial(String mediaId) throws WXMotorException;

	/**
	 * 删除永久素材
	 * 
	 * @Title: delMaterialForever
	 * @return MaterialResponse 返回类型
	 */
	public WxMpMaterialResponse delForeverMaterial(String mediaId) throws WXMotorException;

	/**
	 * 修改永久图文素材
	 * 
	 * @Title: updateNewsForeverMaterial
	 * @return MaterialResponse 返回类型
	 */
	public WxMpMaterialResponse updateNewsForeverMaterial(WxMpUpdateNewsRequest updateNewsRequest)
			throws WXMotorException;

	/**
	 * 获取素材总数
	 * 
	 * @Title: getForeverMaterialTotalCount
	 * @return MaterialTotalCountResponse 返回类型
	 */
	public WxMpMaterialTotalCountResponse getForeverMaterialTotalCount() throws WXMotorException;

	/**
	 * 获取素材列表
	 * 
	 * @Title: findForeverMaterialList
	 * @return ForeverMaterialListResponse 返回类型
	 */
	public WxMpForeverMaterialListResponse findForeverMaterialList(String type, Integer offset,
			Integer count) throws WXMotorException;

}
