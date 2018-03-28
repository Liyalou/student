package com.my.color.teacher.controller;

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
import com.my.color.teacher.dao.po.TeachTeacher;

/**
 * 教务老师管理
 * @author lyl
 *
 */
@RequestMapping("admin/teachTeacher")
@Controller
public class TeachTeacherController {

	private static final String MENU_ID = "MENU_TEACHER";
	
	@Autowired
	private MainLayout layout;
	
	@RequestMapping("/index")
	public ModelAndView teachTeacherIndex(ModelMap model,Page<TeachTeacher> page){
		page.startPage(page);
		List<TeachTeacher> list = new ArrayList<>();
		PageInfo<TeachTeacher> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/teachTeacher/index");
		return layout.layout("teachTeacher",MENU_ID);
	}
	
}
