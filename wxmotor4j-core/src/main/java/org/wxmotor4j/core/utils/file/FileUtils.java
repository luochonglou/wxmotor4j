package org.wxmotor4j.core.utils.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.wxmotor4j.core.utils.StringUtils;

/**
 * 系统工具类。
 * 
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public abstract class FileUtils {
	// private static String localIp;

	private FileUtils() {
	}

	/**
	 * 获取文件的真实后缀名。目前只支持JPG, GIF, PNG, BMP四种图片文件。
	 * 
	 * @param bytes
	 *            文件字节流
	 * @return JPG, GIF, PNG or null
	 */
	private static String getFileSuffix(byte[] bytes) {
		if (bytes == null || bytes.length < 10) {
			return null;
		}

		if (bytes[0] == 'G' && bytes[1] == 'I' && bytes[2] == 'F') {
			return "GIF";
		} else if (bytes[1] == 'P' && bytes[2] == 'N' && bytes[3] == 'G') {
			return "PNG";
		} else if (bytes[6] == 'J' && bytes[7] == 'F' && bytes[8] == 'I' && bytes[9] == 'F') {
			return "JPG";
		} else if (bytes[0] == 'B' && bytes[1] == 'M') {
			return "BMP";
		} else {
			return null;
		}
	}

	/**
	 * 
	 * 
	 * @param bytes
	 *            文件字节流
	 * @return 媒体类型(MEME-TYPE)
	 */
	public static String getMimeType(byte[] bytes) {
		String suffix = getFileSuffix(bytes);
		String mimeType;

		if ("JPG".equals(suffix)) {
			mimeType = "image/jpeg";
		} else if ("GIF".equals(suffix)) {
			mimeType = "image/gif";
		} else if ("PNG".equals(suffix)) {
			mimeType = "image/png";
		} else if ("BMP".equals(suffix)) {
			mimeType = "image/bmp";
		} else {
			mimeType = "application/octet-stream";
		}

		return mimeType;
	}

	/**
	 * 图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式
	 * 
	 * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
	 * 
	 * 视频（video）：10MB，支持MP4格式
	 * 
	 * 缩略图（thumb）：64KB，支持JPG格式
	 * 
	 * @Title: getMimeType
	 * @return String 返回类型
	 */
	public static String getMimeType(String fileName) {
		String mimeType = "application/octet-stream";
		if (StringUtils.isEmpty(fileName) || !fileName.contains(".")) {
			return mimeType;
		}
		String[] suffixArr = fileName.split("\\.");
		String suffix = suffixArr[suffixArr.length - 1].toUpperCase();
		if ("JPG".equals(suffix)) {
			mimeType = "image/jpeg";
		} else if ("GIF".equals(suffix)) {
			mimeType = "image/gif";
		} else if ("PNG".equals(suffix)) {
			mimeType = "image/png";
		} else if ("MP4".equals(suffix)) {
			mimeType = "video/mp4";
		} else if ("MP3".equals(suffix)) {
			mimeType = "audio/x-mpeg";
		}
		return mimeType;
	}

	public static byte[] getContent(File file) throws IOException {
		byte[] content = new byte[0];
		if (file == null || !file.exists()) {
			return content;
		}
		InputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new FileInputStream(file);
			out = new ByteArrayOutputStream();
			int ch;
			while ((ch = in.read()) != -1) {
				out.write(ch);
			}
			content = out.toByteArray();
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}

		return content;
	}

}
