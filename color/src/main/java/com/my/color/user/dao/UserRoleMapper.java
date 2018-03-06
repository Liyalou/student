package com.my.color.user.dao;

import java.util.List;

import com.my.color.user.dao.po.UserRole;

public interface UserRoleMapper {
    
    int deleteByPrimaryKey(UserRole record);

    
    int insert(UserRole record);

    
    int insertSelective(UserRole record);
    
    
    List<String> getRoleIdByUserId(String userId);
}