package com.my.color.manage.dao;

import java.util.List;
import java.util.Map;

import com.my.color.manage.dao.po.SalaryManage;

public interface SalaryManageMapper {
    
    int deleteByPrimaryKey(String salaryManageId);

    
    int insert(SalaryManage record);

    
    int insertSelective(SalaryManage record);

    
    SalaryManage selectByPrimaryKey(String salaryManageId);

    
    int updateByPrimaryKeySelective(SalaryManage record);

    
    int updateByPrimaryKey(SalaryManage record);
    
    
    List<SalaryManage> getSalaryManageList(Map<String,Object> conditionMap);
}