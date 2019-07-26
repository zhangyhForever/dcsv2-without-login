package com.zicms.common.mybatis.mapper;

import com.zicms.common.mybatis.provider.CommonSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("baseMapper")
public interface BaseMapper{

	@SelectProvider(type= CommonSqlProvider.class,method="beforeDeleteTreeStructureSql")
	int beforeDeleteTreeStructure(Map<String, Object> params);
	
	@SelectProvider(type=CommonSqlProvider.class,method="findEntityListByDataScope")
	<T> List<Map<String, Object>> findEntityListByDataScope(@Param("record") T record);

	@SelectProvider(type=CommonSqlProvider.class,method="checkUniqueSql")
	int checkUnique(Map<String, Object> params);
	
}
