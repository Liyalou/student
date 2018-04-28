package com.my.color.base.common;

import java.util.HashMap;
import java.util.Map;

import com.my.color.base.util.StringUtils;

public class BaseCondition {

	private String userName;
	
	/**
	 * 请假次数
	 */
	private Integer vacateNumber;
	
	private Integer salaryStatus1;
	private Integer salaryStatus2;
	private Integer salaryStatus3;
	
	public Integer getVacateNumber() {
		return vacateNumber;
	}

	public void setVacateNumber(Integer vacateNumber) {
		this.vacateNumber = vacateNumber;
	}

	public Integer getSalaryStatus1() {
		return salaryStatus1;
	}

	public void setSalaryStatus1(Integer salaryStatus1) {
		this.salaryStatus1 = salaryStatus1;
	}

	public Integer getSalaryStatus2() {
		return salaryStatus2;
	}

	public void setSalaryStatus2(Integer salaryStatus2) {
		this.salaryStatus2 = salaryStatus2;
	}

	public Integer getSalaryStatus3() {
		return salaryStatus3;
	}

	public void setSalaryStatus3(Integer salaryStatus3) {
		this.salaryStatus3 = salaryStatus3;
	}

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
