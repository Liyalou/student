package com.my.color.system.dao;

import java.util.List;
import java.util.Map;

import com.my.color.system.dao.po.Menu;

public interface MenuMapper {
    
    int deleteByPrimaryKey(String menuId);

    
    int insert(Menu record);

    
    int insertSelective(Menu record);

    
    Menu selectByPrimaryKey(String menuId);

    
    int updateByPrimaryKeySelective(Menu record);

    
    int updateByPrimaryKey(Menu record);
    
    
    List<Menu> getMenuByIds(Map<String,Object> conditionMap);
    
    
    List<Menu> getMenuByParentId(String menuParentId);
}