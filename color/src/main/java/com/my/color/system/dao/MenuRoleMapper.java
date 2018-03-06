package com.my.color.system.dao;

import java.util.List;
import java.util.Map;

import com.my.color.system.dao.po.MenuRole;

public interface MenuRoleMapper {
    
    int deleteByPrimaryKey(MenuRole record);

    
    int insert(MenuRole record);

    
    int insertSelective(MenuRole record);
    
    
    List<String> getMenuIdByRoleIds(Map<String,Object> conditionMap);
    
}