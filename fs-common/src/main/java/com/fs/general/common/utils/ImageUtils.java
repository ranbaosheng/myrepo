package com.fs.general.common.utils;

import java.util.Locale;

/**
 * 图片辅助类
 */
public abstract class ImageUtils {
	/**
	 * 图片的后缀
	 */
	public static final String[] IMAGE_EXT = new String[] { "jpg", "jpeg",
			"gif", "png", "bmp" };

	/**
	 * 是否是图片
	 * 
	 * @param ext
	 * @return "jpg", "jpeg", "gif", "png", "bmp" 为文件后缀名者为图片
	 */
	public static boolean isValidImageExt(String ext) {
		ext = ext.toLowerCase(Locale.ENGLISH);
		for (String s : IMAGE_EXT) {
			if (s.equalsIgnoreCase(ext)) {
				return true;
			}
		}
		return false;
	}

}