package com.my.color.salary.manage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.salary.manage.dao.po.SalaryManage;

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
	
	@RequestMapping("/querySalaryIndex")
	public ModelAndView querySalaryIndex(ModelMap model,Page<SalaryManage> page){
		page.startPage(page);
		List<SalaryManage> list = new ArrayList<>();
		PageInfo<SalaryManage> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/querySalary/querySalaryIndex");
		return layout.layout("querySalary",MENU_ID);
	}
}
