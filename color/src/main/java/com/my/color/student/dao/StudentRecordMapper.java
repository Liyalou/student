package com.my.color.student.dao;

import java.util.List;
import java.util.Map;

import com.my.color.student.dao.po.StudentRecord;

public interface StudentRecordMapper {
    
    int deleteByPrimaryKey(String studentRecordId);

    
    int insert(StudentRecord record);

    
    int insertSelective(StudentRecord record);

    
    StudentRecord selectByPrimaryKey(String studentRecordId);

    
    int updateByPrimaryKeySelective(StudentRecord record);

    
    int updateByPrimaryKey(StudentRecord record);
    
    
    List<StudentRecord> getStudentRecordList(Map<String,Object> conditionMap);
    
    
    List<StudentRecord> getStudentByClassId(Map<String,Object> conditionMap);
}