package com.my.color.wait.dao;

import java.util.List;
import java.util.Map;

import com.my.color.wait.dao.po.WaitDeal;

public interface WaitDealMapper {
    
    int deleteByPrimaryKey(String waitDealId);

    
    int insert(WaitDeal record);

    
    int insertSelective(WaitDeal record);

    
    WaitDeal selectByPrimaryKey(String waitDealId);

    
    int updateByPrimaryKeySelective(WaitDeal record);

    
    int updateByPrimaryKey(WaitDeal record);
    
    
    List<WaitDeal> getWaitDealList(Map<String,Object> conditionMap);
}