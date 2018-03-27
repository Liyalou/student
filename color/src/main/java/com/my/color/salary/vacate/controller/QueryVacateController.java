package com.my.color.salary.vacate.controller;

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
import com.my.color.salary.vacate.dao.po.StudentVacate;

/**
 * 请假统计
 * @author lyl
 *
 */
@Controller
@RequestMapping("/amdin/queryVacate")
public class QueryVacateController {

	private static final String MENU_ID = "MENU_QUERY_VACATE";
	
	@Autowired
	private MainLayout layout;
	
	
	@RequestMapping("/queryIndex")
	public ModelAndView vacateIndex(ModelMap model,Page<StudentVacate> page){
		page.startPage(page);
		List<StudentVacate> list = new ArrayList<>();
		PageInfo<StudentVacate> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/amdin/queryVacate/queryIndex");
		return layout.layout("queryVacate",MENU_ID);
	}
}
