package com.my.color.base.page;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class Page<T> {
	
	protected int              pageNum;                 // 页码
    protected int              pageRows      = 5;                // 每页显示数量
    
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}
    
	public void startPage(Page<T> page){
		if(page.getPageNum()==0){
    		page.setPageNum(1);
    	}
    	PageHelper.startPage(page.getPageNum(), pageRows);
	}
	
	
    public PageInfo<T> listToPage(List<T> list){
    	PageInfo<T> pageList = new PageInfo<T>(list);
    	return pageList;
    }
    
}
