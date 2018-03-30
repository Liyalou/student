package com.my.color.base.common;

import java.util.HashMap;
import java.util.Map;

import com.my.color.base.util.StringUtils;

public class BaseCondition {

	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Map<String,Object> getConditionMap(BaseCondition condition){
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		if(!StringUtils.isEmpty(condition.getUserName())){
			conditionMap.put("userName", condition.getUserName());
		}
		return conditionMap;
	}
	
}
