package com.my.color.teacher.dao;

import java.util.List;
import java.util.Map;

import com.my.color.teacher.dao.po.TeachTeacher;

public interface TeachTeacherMapper {
    
    int deleteByPrimaryKey(String teachTeacherId);

    
    int insert(TeachTeacher record);

    
    int insertSelective(TeachTeacher record);

    
    TeachTeacher selectByPrimaryKey(String teachTeacherId);

    
    int updateByPrimaryKeySelective(TeachTeacher record);

    
    int updateByPrimaryKey(TeachTeacher record);
    
    
    List<TeachTeacher> getTeachTeacherList(Map<String,Object> conditionMap);
    
    
    List<TeachTeacher> getTeacherForClass(Map<String,Object> conditionMap);
}