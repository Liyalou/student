package com.hd.hderp.${projectPakcageName}.${allLowerDomain}.dao.po;

public class Query${domain}Condition {
	
	//开始时间
    private String startCreateTime;
    
    //结束时间
    private String endCreateTime;
    
    
	public String getStartCreateTime() {
		return startCreateTime;
	}
	
	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}
	
	public String getEndCreateTime() {
		return endCreateTime;
	}
	
	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
}
