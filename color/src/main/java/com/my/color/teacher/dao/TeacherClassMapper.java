package com.my.color.teacher.dao;

import java.util.List;
import java.util.Map;

import com.my.color.teacher.dao.po.TeacherClass;

public interface TeacherClassMapper {
    
    int deleteByPrimaryKey(String schoolClassId);

    
    int insert(TeacherClass record);

    
    int insertSelective(TeacherClass record);

    
    TeacherClass selectByPrimaryKey(String schoolClassId);

    
    int updateByPrimaryKeySelective(TeacherClass record);

    
    int updateByPrimaryKey(TeacherClass record);
    
    
    List<String> getClassIdByUserId(Map<String,Object> conditionMap);
    
    
    List<String> getUserIdByClassId(Map<String,Object> conditionMap);
}