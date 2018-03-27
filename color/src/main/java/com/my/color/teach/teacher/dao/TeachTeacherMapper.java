package com.my.color.teach.teacher.dao;

import com.my.color.teach.teacher.dao.po.TeachTeacher;

public interface TeachTeacherMapper {
    
    int deleteByPrimaryKey(String teachTeacherId);

    
    int insert(TeachTeacher record);

    
    int insertSelective(TeachTeacher record);

    
    TeachTeacher selectByPrimaryKey(String teachTeacherId);

    
    int updateByPrimaryKeySelective(TeachTeacher record);

    
    int updateByPrimaryKey(TeachTeacher record);
}