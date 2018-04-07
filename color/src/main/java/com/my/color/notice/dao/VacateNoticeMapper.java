package com.my.color.notice.dao;

import java.util.List;
import java.util.Map;

import com.my.color.notice.dao.po.VacateNotice;

public interface VacateNoticeMapper {
    
    int deleteByPrimaryKey(String vacateNoticeId);

    
    int insert(VacateNotice record);

    
    int insertSelective(VacateNotice record);

    
    VacateNotice selectByPrimaryKey(String vacateNoticeId);

    
    int updateByPrimaryKeySelective(VacateNotice record);

    
    int updateByPrimaryKey(VacateNotice record);
    
    
    List<VacateNotice> getVacateNoticeList(Map<String,Object> conditionMap);
}