package com.my.color.teach.student.dao;

import com.my.color.teach.student.dao.po.StudentRecord;

public interface StudentRecordMapper {
    
    int deleteByPrimaryKey(String studentRecordId);

    
    int insert(StudentRecord record);

    
    int insertSelective(StudentRecord record);

    
    StudentRecord selectByPrimaryKey(String studentRecordId);

    
    int updateByPrimaryKeySelective(StudentRecord record);

    
    int updateByPrimaryKey(StudentRecord record);
}