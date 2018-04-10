package com.my.color.manage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.base.util.StringUtils;
import com.my.color.manage.dao.po.SalaryManage;
import com.my.color.manage.service.SalaryManageService;

/**
 * 考勤统计
 * @author lyl
 *
 */
@Controller
@RequestMapping("/admin/querySalary")
public class QuerySalaryController {

	private static final String MENU_ID = "MENU_SALARY_MANAGE";
	
	@Autowired
	private MainLayout layout;
	
	@Autowired
	private SalaryManageService salaryManageService;
	@RequestMapping("/querySalaryIndex")
	public ModelAndView querySalaryIndex(ModelMap model,Page<SalaryManage> page,
			String userName,String starCreateTime,String endCreateTime){
		Map<String,Object> conditionMap = salaryManageService.getConditionForQuery();
		if(!StringUtils.isEmpty(userName)){
			conditionMap.put("userName", userName);
		}
		if(!StringUtils.isEmpty(starCreateTime)){
			conditionMap.put("starCreateTime", starCreateTime);
		}
		if(!StringUtils.isEmpty(endCreateTime)){
			conditionMap.put("endCreateTime", endCreateTime);
		}
		page.startPage(page);
		List<SalaryManage> list = salaryManageService.getSalaryManageList(conditionMap);
		PageInfo<SalaryManage> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/querySalary/querySalaryIndex");
		return layout.layout("querySalary",MENU_ID);
	}
}
