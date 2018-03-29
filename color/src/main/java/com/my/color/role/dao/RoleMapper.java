package com.my.color.role.dao;

import java.util.List;

import com.my.color.role.dao.po.Role;

public interface RoleMapper {
    
    int deleteByPrimaryKey(String roleId);

    
    int insert(Role record);

    
    int insertSelective(Role record);

    
    Role selectByPrimaryKey(String roleId);

    
    int updateByPrimaryKeySelective(Role record);

    
    int updateByPrimaryKey(Role record);
    
    
    List<Role> getRoleList();
    
    
    Role selectByRoleCode(String roleCode);
}