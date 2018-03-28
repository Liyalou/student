package com.my.color.teachClass.controller;

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
import com.my.color.teachClass.dao.po.SchoolClass;

/**
 * 班级管理
 * @author lyl
 *
 */
@RequestMapping("admin/schoolClass")
@Controller
public class SchoolClassController {

	private static final String MENU_ID = "MENU_SCHOOL_CLASS";
	
	@Autowired
	private MainLayout layout;
	
	@RequestMapping("/index")
	public ModelAndView schoolClassIndex(ModelMap model,Page<SchoolClass> page){
		page.startPage(page);
		List<SchoolClass> list = new ArrayList<>();
		PageInfo<SchoolClass> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/schoolClass/index");
		return layout.layout("schoolClass",MENU_ID);
	}
}
