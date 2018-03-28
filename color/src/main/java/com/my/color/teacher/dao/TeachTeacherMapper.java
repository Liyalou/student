package com.my.color.teacher.dao;

import com.my.color.teacher.dao.po.TeachTeacher;

public interface TeachTeacherMapper {
    
    int deleteByPrimaryKey(String teachTeacherId);

    
    int insert(TeachTeacher record);

    
    int insertSelective(TeachTeacher record);

    
    TeachTeacher selectByPrimaryKey(String teachTeacherId);

    
    int updateByPrimaryKeySelective(TeachTeacher record);

    
    int updateByPrimaryKey(TeachTeacher record);
}