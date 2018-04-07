package com.my.color.vacate.controller;

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
import com.my.color.vacate.dao.po.StudentVacate;
import com.my.color.vacate.service.StudentVacateService;

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
	
	@Autowired
	private StudentVacateService studentVacateService;
	
	
	@RequestMapping("/queryIndex")
	public ModelAndView vacateIndex(ModelMap model,Page<StudentVacate> page,
			String studentClassName,String starCreateTime,String endCreateTime){
		Map<String,Object> conditionMap = studentVacateService.getConditionForQuery();
		if(!StringUtils.isEmpty(studentClassName)){
			conditionMap.put("studentClassName", studentClassName);
		}
		if(!StringUtils.isEmpty(starCreateTime)){
			conditionMap.put("starCreateTime", starCreateTime);
		}
		if(!StringUtils.isEmpty(endCreateTime)){
			conditionMap.put("endCreateTime", endCreateTime);
		}
		page.startPage(page);
		List<StudentVacate> list = studentVacateService.getStudentVacateList(conditionMap);
		PageInfo<StudentVacate> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/amdin/queryVacate/queryIndex");
		return layout.layout("queryVacate",MENU_ID);
	}
}
