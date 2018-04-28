package com.my.color.vacate.dao;

import java.util.List;
import java.util.Map;

import com.my.color.vacate.dao.po.StudentVacate;

public interface StudentVacateMapper {
    
    int deleteByPrimaryKey(String studentVacateId);

    
    int insert(StudentVacate record);

    
    int insertSelective(StudentVacate record);

    
    StudentVacate selectByPrimaryKey(String studentVacateId);

    
    int updateByPrimaryKeySelective(StudentVacate record);

    
    int updateByPrimaryKey(StudentVacate record);
    
    
    List<StudentVacate> getStudentVacateList(Map<String,Object> conditionMap);
    
    
    Integer getStudentVacateNumber(Map<String,Object> conditionMap);
}