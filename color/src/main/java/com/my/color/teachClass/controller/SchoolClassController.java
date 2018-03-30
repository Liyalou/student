package com.my.color.teachClass.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.github.pagehelper.PageInfo;
import com.my.color.base.common.BaseCondition;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.base.util.StringUtils;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.teachClass.service.SchoolClassService;

/**
 * 班级管理
 * @author lyl
 *
 */
@RequestMapping("/admin/schoolClass")
@Controller
public class SchoolClassController {

	private static final String MENU_ID = "MENU_SCHOOL_CLASS";
	
	@Autowired
	private MainLayout layout;
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	/**
	 * 列表查询
	 * 条件查询：
	 * 		辅导员：userName
	 * @param model
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView schoolClassIndex(ModelMap model,Page<SchoolClass> page,BaseCondition condition){
		page.startPage(page);
		Map<String,Object> conditionMap = condition.getConditionMap(condition);
		List<SchoolClass> list = schoolClassService.getSchoolClassList(conditionMap);
		PageInfo<SchoolClass> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/schoolClass/index");
		return layout.layout("schoolClass",MENU_ID);
	}
	
	/**
	 * 添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/addInput")
	public ModelAndView addInput(ModelMap model,String schoolClassId){
		SchoolClass schoolClass = new SchoolClass();
		if(!StringUtils.isEmpty(schoolClassId)){
			schoolClass = schoolClassService.selectByPrimaryKey(schoolClassId);
		}
		model.put("schoolClass", schoolClass);
		return layout.layout("teach/class/school-class-input",MENU_ID);
	}
	
	/**
	 * 保存修改
	 * @param request
	 * @param schoolClass
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/submitSchoolClass")
	public RedirectView submitSchoolClass(RedirectAttributes attributes,HttpServletRequest request,SchoolClass schoolClass){
		try {
			int result = schoolClassService.submitSchoolClass(attributes, schoolClass);
			if(result == 0){
				attributes.addFlashAttribute("schoolClass", schoolClass);
				return new RedirectView(request.getContextPath()+"/admin/schoolClass/addInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/schoolClass/index");
	}
	
	/**
	 * 删除班级
	 * 请求参数：
	 * 		老师id：teachTeacherId
	 * @param attributes
	 * @param request
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/deleteSchoolClass")
	public RedirectView deleteSchoolClass(RedirectAttributes attributes,HttpServletRequest request,String schoolClassId){
		try {
			schoolClassService.deleteSchoolClass(attributes, schoolClassId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/schoolClass/index");
	}
	
	/**
	 * 查看详情
	 * @param model
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/getSchoolClassInfo")
	public ModelAndView getSchoolClassInfo(ModelMap model,String schoolClassId){
		SchoolClass schoolClass = schoolClassService.selectByPrimaryKey(schoolClassId);
		model.put("schoolClass", schoolClass);
		return layout.layout("teach/class/school-class-info",MENU_ID);
	}
}
