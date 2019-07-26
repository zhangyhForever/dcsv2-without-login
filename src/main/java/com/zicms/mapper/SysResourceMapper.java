

package com.zicms.mapper;


import com.zicms.web.sys.model.SysResource;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author 
 */

public interface SysResourceMapper{
	
	public int updateParentIds(SysResource sysResource);
	
	public int deleteIdsByRootId(Long id);
   
	public List<SysResource> findPageInfo(Map<String, Object> params);
	
	//删除前验证
	public int beforeDeleteResource(Long resourceId);
	
	//根据userId获得持有的权限
	public List<SysResource> findUserResourceByUserId(Long userId);
	
}
