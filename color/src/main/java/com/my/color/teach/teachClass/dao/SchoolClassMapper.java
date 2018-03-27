package com.my.color.teach.teachClass.dao;

import com.my.color.teach.teachClass.dao.po.SchoolClass;

public interface SchoolClassMapper {
    
    int deleteByPrimaryKey(String schoolClassId);

    
    int insert(SchoolClass record);

    
    int insertSelective(SchoolClass record);

    
    SchoolClass selectByPrimaryKey(String schoolClassId);

    
    int updateByPrimaryKeySelective(SchoolClass record);

    
    int updateByPrimaryKey(SchoolClass record);
}