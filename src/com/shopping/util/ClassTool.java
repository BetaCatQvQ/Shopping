package com.shopping.util;

public class ClassTool {
	/**
	 * 获取类名
	 * @param str
	 * @return
	 */
	public static String getSimpleClassName(String str) {
		String className = str.substring(str.lastIndexOf(".") + 1);
		return className;
	}
}
