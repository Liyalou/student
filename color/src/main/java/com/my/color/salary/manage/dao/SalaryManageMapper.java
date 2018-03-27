package com.my.color.salary.manage.dao;

import com.my.color.salary.manage.dao.po.SalaryManage;

public interface SalaryManageMapper {
    
    int deleteByPrimaryKey(String salaryManageId);

    
    int insert(SalaryManage record);

    
    int insertSelective(SalaryManage record);

    
    SalaryManage selectByPrimaryKey(String salaryManageId);

    
    int updateByPrimaryKeySelective(SalaryManage record);

    
    int updateByPrimaryKey(SalaryManage record);
}