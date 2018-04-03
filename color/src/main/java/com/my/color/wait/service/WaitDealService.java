package com.my.color.wait.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.color.wait.dao.WaitDealMapper;
import com.my.color.wait.dao.po.WaitDeal;

/**
 * 请假待办
 * @author lyl
 *
 */
@Service
public class WaitDealService {

	@Autowired
	private WaitDealMapper waitDealMapper;
	
	public WaitDeal selectByPrimaryKey(String recordId){
		return waitDealMapper.selectByPrimaryKey(recordId);
	}
	
	public int updateByPrimaryKeySelective(WaitDeal waitDeal){
		return waitDealMapper.updateByPrimaryKeySelective(waitDeal);
	}
	
	public int insertSelective (WaitDeal waitDeal){
		return waitDealMapper.insertSelective(waitDeal);
	}
	
	public List<WaitDeal> getWaitDealList(Map<String,Object> conditionMap){
		return waitDealMapper.getWaitDealList(conditionMap);
	}
	
}
