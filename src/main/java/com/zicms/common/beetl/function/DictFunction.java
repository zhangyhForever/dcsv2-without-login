/*
package com.zicms.web.common.beetl.function;

import com.google.common.collect.Table;
import com.zicms.web.sys.model.SysDict;
import com.zicms.web.sys.service.SysDictService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

*/
/**
 * 字典方法
 * 传入参数 type
 *//*

@Component
public class DictFunction{
	
	@Resource
	private SysDictService sysDictService;
	
	*/
/**
	 * 根据类型和键值得到字典实体
	* @param type 如sys_data_scope等
	* @param value 
	 *//*

	public SysDict getDictByTypeAndValue(String type,String value){
		Table<String,String, SysDict> tableDicts = sysDictService.findAllDictTable();
		return tableDicts.get(type, value);
	}
	
	*/
/**
	 * 根据类型得到字典列表
	* @param type 如sys_data_scope等
	 *//*

	public List<SysDict> getDictListByType(String type){
		return (List<SysDict>) sysDictService.findAllMultimap().get(type);
	}
	
	*/
/**
	 * 全部字典
	 *//*

	public Collection<String> getAllDictType(){
		return sysDictService.findAllMultimap().keySet();
	}

}
*/
