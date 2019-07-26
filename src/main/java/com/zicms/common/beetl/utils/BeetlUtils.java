package com.zicms.common.beetl.utils;

import org.beetl.core.GroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class BeetlUtils {

	@Autowired
	private static GroupTemplate beetlGroupTemplate;

	private static final Map<String, Object> sharedVars = new HashMap<String, Object>();

	/**
	 * 设置beetl共享变量
	 * 
	 * @param key
	 * @param value
	*/

	public static void addBeetlSharedVars(String key, Object value) {
		sharedVars.put(key, value);
		beetlGroupTemplate.setSharedVars(sharedVars);
	}

	/**
	 * 获得beetl中的共享变量
	 * 
	 * @param key
	 * @return
	*/

	@SuppressWarnings("unchecked")
	public static <T> T getBeetlSharedVars(String key) {
		Map<String, Object> map = beetlGroupTemplate.getSharedVars();
		return (T) map.get(key);
	}

}
