package com.my.color.student.controller;

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
import com.my.color.student.dao.po.StudentRecord;

/**
 * 学生管理
 * @author lyl
 *
 */
@Controller
@RequestMapping("/admin/studentRecord")
public class StudentRecordController {

	private static final String MENU_ID = "MENU_STUDENT_RECORD";
	
	@Autowired
	private MainLayout layout;
	
	@RequestMapping("/index")
	public ModelAndView studentRecordIndex(ModelMap model,Page<StudentRecord> page){
		page.startPage(page);
		List<StudentRecord> list = new ArrayList<>();
		PageInfo<StudentRecord> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/studentRecord/index");
		return layout.layout("studentRecord",MENU_ID);
	}
}
