package com.hd.hderp.${projectPakcageName}.${allLowerDomain}.dao;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hd.hderp.${projectPakcageName}.${allLowerDomain}.dao.po.${domain};

public interface ${domain}Mapper {

	public void deleteByPrimaryKey(String ${lowerDomain}Id);

	public void  insert(${domain} ${allLowerDomain});

	${domain} selectByPrimaryKey(String ${lowerDomain}Id);

	public void  updateByPrimaryKey(${domain} ${allLowerDomain});

	// 列表数据
	PageList<${domain}> get${allLowerDomain}PageList(Map<String, Object> conditionMap, PageBounds pageBounds);
}