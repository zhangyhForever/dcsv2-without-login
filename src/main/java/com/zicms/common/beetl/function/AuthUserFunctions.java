/*
package com.zicms.web.common.beetl.function;

import com.zicms.common.beetl.utils.BeetlUtils;
import com.zicms.common.constant.Constant;
import com.zicms.web.sys.model.SysResource;
import com.zicms.web.sys.model.SysUser;
import com.zicms.web.sys.utils.SysUserUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthUserFunctions {

	*/
/**
	 * 判断用户是否具有指定权限
	 *//*

	public boolean hasPermission(String url) {
		Map<String, SysResource> allRes = BeetlUtils
				.getBeetlSharedVars(Constant.CACHE_ALL_RESOURCE);
		SysResource sysResource = allRes.get(url);
		if (sysResource == null	|| Constant.RESOURCE_COMMON.equals(sysResource.getCommon())) {
			return true;
		}

		Map<String, SysResource> userRes = SysUserUtils.getUserResources();
		if (userRes.containsKey(url)) return true;
		return false;
	}
	
	*/
/**
	 * 登录用户
	* @return
	 *//*

	public SysUser getLoginUser(){
		return SysUserUtils.getCacheLoginUser();
	}
	
	*/
/**
	 * 是否为超级管理员
	* @return
	 *//*

	public boolean isSuper(){
		return getLoginUser().getUserType().equals(Constant.SUPER_ADMIN)?true:false;
	}
	
	*/
/**
	 * 是否持有所有数据(数据范围，可认为是总管理)
	 *//*

	public boolean hasAllDataScope(){
		return SysUserUtils.getUserDataScope().contains(Constant.DATA_SCOPE_ALL);
	}

}
*/
