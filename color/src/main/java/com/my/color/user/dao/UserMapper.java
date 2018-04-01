package com.my.color.user.dao;

import java.util.List;
import java.util.Map;

import com.my.color.user.dao.po.User;

public interface UserMapper {
    
    int deleteByPrimaryKey(String userId);

    
    int insert(User record);

    
    int insertSelective(User record);

    
    User selectByPrimaryKey(String userId);

    
    int updateByPrimaryKeySelective(User record);

    
    int updateByPrimaryKey(User record);
    
    
    User getUserByAccount(String userAccount);
    
    
    int updateLastLogTime(Map<String,Object> conditionMap);
    
    
    List<User> getUserByType(Map<String,Object> conditionMap);
}