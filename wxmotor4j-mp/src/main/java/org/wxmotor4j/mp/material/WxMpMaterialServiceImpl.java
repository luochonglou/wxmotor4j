package org.wxmotor4j.mp.material;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wxmotor4j.core.WXMotorConstsConfig;
import org.wxmotor4j.core.WXMotorException;
import org.wxmotor4j.core.utils.file.FileItem;
import org.wxmotor4j.core.utils.file.FileUtils;
import org.wxmotor4j.core.utils.http.WxHttpClient;
import org.wxmotor4j.mp.api.WxApiGateway;
import org.wxmotor4j.mp.api.WxConfigStorage;

import com.alibaba.fastjson.JSONObject;

/**
 * 素材服务实现
 * 
 * @ClassName: WxMpMaterialServiceImpl
 * @author Tluo
 * @date 2017年8月7日
 *
 */
public class WxMpMaterialServiceImpl implements WxMpMaterialService {
	private WxConfigStorage configStorage;

	public void setWxConfigStorage(WxConfigStorage configStorage) throws WXMotorException {
		this.configStorage = configStorage;

	}

	public WxMpMaterialResponse addTemporaryMaterial(File file) throws WXMotorException {
		try {
			String fileName = file.getName();
			String type = getType(fileName, file.length());
			byte[] content = FileUtils.getContent(file);
			String url = WxApiGateway.material_temporary_add.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken()).replaceAll("TYPE", type);
			Map<String, FileItem> fileParams = new HashMap<String, FileItem>();
			FileItem value = new FileItem(fileName, content);
			fileParams.put("media", value);
			String jsonData = WxHttpClient.doPost(url, fileParams);
			WxMpMaterialResponse res = JSONObject.parseObject(jsonData, WxMpMaterialResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	private String getType(String fileName, long fileLenth) throws WXMotorException {
		String[] suffixArr = fileName.split("\\.");
		String suffix = suffixArr[suffixArr.length - 1].toUpperCase();
		if ("JPEG".equals(suffix) || "PNG".equals(suffix) || "GIF".equals(suffix)
				|| "JPG".equals(suffix)) {
			long maxLenth = 2 * 1024 * 1024l;
			if (fileLenth > maxLenth) {
				throw new WXMotorException("图片素材文件大小超出2M！");
			}
			if ("JPG".equals(suffix) && fileLenth < 64 * 1024l) {
				return WXMotorConstsConfig.MATERIAL_THUMB;
			}
			return WXMotorConstsConfig.MATERIAL_IMAGE;
		}
		if ("AMR".equals(suffix) || "MP3".equals(suffix)) {
			long maxLenth = 2 * 1024 * 1024l;
			if (fileLenth > maxLenth) {
				throw new WXMotorException("语音素材文件大小超出2M！");
			}
			return WXMotorConstsConfig.MATERIAL_VOICE;
		}
		if ("MP4".equals(suffix)) {
			long maxLenth = 10 * 1024 * 1024l;
			if (fileLenth > maxLenth) {
				throw new WXMotorException("视频素材文件大小超出10M！");
			}
			return WXMotorConstsConfig.MATERIAL_VIDEO;
		}
		throw new WXMotorException("素材文件格式不支持！");
	}

	public String getTemporaryMaterialUrl(String mediaId) throws WXMotorException {
		try {
			String url = WxApiGateway.material_temporary_get.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken()).replaceAll("MEDIA_ID", mediaId);
			return url;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public String getTemporaryVideoMaterialVUrl(String mediaId) throws WXMotorException {
		try {
			String url = WxApiGateway.material_temporary_get.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken()).replaceAll("MEDIA_ID", mediaId);
			String jsonData = WxHttpClient.doGet(url, null);
			JSONObject res = JSONObject.parseObject(jsonData);
			return res.getString("video_url");
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpMaterialResponse addNewsForeverMaterial(List<WxMpArticles> articless) throws WXMotorException {
		try {
			String url = WxApiGateway.material_forever_addnews.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			String jsonParams = JSONObject.toJSONString(articless);
			String jsonData = WxHttpClient.doPost(url, jsonParams);
			WxMpMaterialResponse res = JSONObject.parseObject(jsonData, WxMpMaterialResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpMaterialResponse uploadImg(File file) throws WXMotorException {
		try {
			String fileName = file.getName();
			if (file.length() > 1 * 1024 * 1024) {
				throw new WXMotorException("上传失败，图片大小不能超过1M！");
			}
			byte[] content = FileUtils.getContent(file);
			String url = WxApiGateway.material_image_text_add.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, FileItem> fileParams = new HashMap<String, FileItem>();
			FileItem value = new FileItem(fileName, content);
			fileParams.put("media", value);
			String jsonData = WxHttpClient.doPost(url, fileParams);
			WxMpMaterialResponse res = JSONObject.parseObject(jsonData, WxMpMaterialResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpMaterialResponse addOtherForeverMaterial(File file, String title, String introduction)
			throws WXMotorException {
		try {
			String fileName = file.getName();
			String type = getType(fileName, file.length());
			byte[] content = FileUtils.getContent(file);
			String url = WxApiGateway.material_other_add.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken()).replaceAll("TYPE", type);
			Map<String, FileItem> fileParams = new HashMap<String, FileItem>();
			FileItem value = new FileItem(fileName, content);
			fileParams.put("media", value);
			String jsonData = null;
			if (WXMotorConstsConfig.MATERIAL_VIDEO.equals(type)) {
				Map<String, String> descriptionMap = new HashMap<String, String>();
				descriptionMap.put("title", title);
				descriptionMap.put("introduction", introduction);
				Map<String, String> params = new HashMap<String, String>();
				params.put("description", JSONObject.toJSONString(descriptionMap));
				jsonData = WxHttpClient.doPost(url, params, fileParams);
			} else {
				jsonData = WxHttpClient.doPost(url, fileParams);
			}
			WxMpMaterialResponse res = JSONObject.parseObject(jsonData, WxMpMaterialResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpMaterialForeverResponse getForeverMaterial(String mediaId) throws WXMotorException {
		try {
			String url = WxApiGateway.material_forever_get.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("media_id", mediaId);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpMaterialForeverResponse res = JSONObject.parseObject(jsonData,
					WxMpMaterialForeverResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpMaterialResponse delForeverMaterial(String mediaId) throws WXMotorException {
		try {
			String url = WxApiGateway.material_forever_del.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("media_id", mediaId);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpMaterialResponse res = JSONObject.parseObject(jsonData, WxMpMaterialResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpMaterialResponse updateNewsForeverMaterial(WxMpUpdateNewsRequest updateNewsRequest)
			throws WXMotorException {
		try {
			String url = WxApiGateway.material_image_text_update.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			String jsonData = WxHttpClient.doPost(url, JSONObject.toJSONString(updateNewsRequest));
			WxMpMaterialResponse res = JSONObject.parseObject(jsonData, WxMpMaterialResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpMaterialTotalCountResponse getForeverMaterialTotalCount() throws WXMotorException {
		try {
			String url = WxApiGateway.material_forever_total.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			String jsonData = WxHttpClient.doGet(url, null);
			WxMpMaterialTotalCountResponse res = JSONObject.parseObject(jsonData,
					WxMpMaterialTotalCountResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

	public WxMpForeverMaterialListResponse findForeverMaterialList(String type, Integer offset,
			Integer count) throws WXMotorException {
		try {
			String url = WxApiGateway.material_forever_list.replaceAll("ACCESS_TOKEN",
					configStorage.getAccessToken());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("type", type);
			params.put("offset", offset);
			params.put("count", count);
			String jsonData = WxHttpClient.doPostMap2Json(url, params);
			WxMpForeverMaterialListResponse res = JSONObject.parseObject(jsonData,
					WxMpForeverMaterialListResponse.class);
			res.setJsonData(jsonData);
			return res;
		} catch (Exception e) {
			throw new WXMotorException(e.getMessage(), e);
		}
	}

}
