package com.database.utils;




public class FileUtil {
	/**
	 * 获得文件类型
	 */
	public static String getType(String tpye){
		String[] img={"jpg", "gif","bmp","png"};
	for (int i = 0; i < img.length; i++) {
		if(tpye.split("\\.")[1].trim().equals(img[i])){
			return "img";
		}
	}
		return "file";
	}
}
