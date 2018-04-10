package com.my.color.teachClass.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.my.color.base.util.MessageUtils;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.teachClass.service.SchoolClassService;
import com.my.color.teacher.dao.po.TeachTeacher;
import com.my.color.teacher.dao.po.TeacherClass;
import com.my.color.teacher.service.TeachTeacherService;
import com.my.color.user.dao.po.User;
import com.my.color.user.service.UserToken;

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
	
	@Autowired
	private TeachTeacherService teacherService;
	
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
		try {
			page.startPage(page);
			Map<String,Object> conditionMap = condition.getConditionMap(condition);
			User user = UserToken.getLoginUser();
			if(user.getUserType().equals("3") || user.getUserType().equals("4")){
				conditionMap.put("userId", user.getUserId());
			}
			List<SchoolClass> list = schoolClassService.getSchoolClassList(conditionMap);
			PageInfo<SchoolClass> pageList = page.listToPage(list);
			model.put(Constant.PAGE_LIST, pageList);
			model.put(Constant.PAGE_URL, "/admin/schoolClass/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return layout.layout("schoolClass",MENU_ID);
	}
	
	/**
	 * 添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/addInput")
	public ModelAndView addInput(ModelMap model,String schoolClassId){
		schoolClassService.addSchoolClassPage(model, schoolClassId);
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
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("schoolClassId", schoolClassId);
		conditionMap.put("teacherType", "4");
		List<String> userIdList = teacherService.getUserIdByClassId(conditionMap);
		conditionMap.put("userIdList", userIdList);
		List<TeachTeacher> teacherList = new ArrayList<TeachTeacher>();
		if(userIdList !=null && userIdList.size()>0){
			teacherList = teacherService.getTeachTeacherList(conditionMap);
		}
		model.put("teacherList", teacherList);//老师集合
		model.put("schoolClass", schoolClass);
		return layout.layout("teach/class/school-class-info",MENU_ID);
	}
	
	/**
	 * 进入为班级分配任课老师页面
	 * @param model
	 * @param schoolClassId
	 * @return
	 */
	@RequestMapping("/setTeacherForClass")
	public ModelAndView setTeacherForClass(ModelMap model,String schoolClassId){
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("schoolClassId", schoolClassId);
		List<TeachTeacher> teacherList = teacherService.getTeacherForClass(conditionMap);
		model.put("teacherList", teacherList);
		model.put("schoolClassId", schoolClassId);
		return layout.layout("teach/class/teacher-list",MENU_ID);
	}
	
	/**
	 * 分配确认
	 * @param attributes
	 * @param request
	 * @param teacherIdList
	 * @param schoolClassId
	 * @return
	 */
	@RequestMapping("/submitTeacherForClass")
	public RedirectView submitTeacherForClass(RedirectAttributes attributes,HttpServletRequest request,
			String[] teacherIdList,String schoolClassId){
		try {
			schoolClassService.submitTeacherForClass(attributes, teacherIdList, schoolClassId);
		} catch (Exception e) {
			e.printStackTrace();
			MessageUtils.getMessage(attributes, 0);
		}
		return new RedirectView(request.getContextPath()+"/admin/schoolClass/index");
	}
	
	@RequestMapping("/deleteTeacherForClass")
	public RedirectView deleteTeacherForClass(RedirectAttributes attributes,HttpServletRequest request,
	String teacherId,String schoolClassId){
		TeacherClass record = new TeacherClass();
		record.setSchoolClassId(schoolClassId);
		record.setTeacherUserId(teacherId);
		int result = schoolClassService.deleteTeacherClass(record);
		MessageUtils.getMessage(attributes, result);
		return new RedirectView(request.getContextPath()+"/admin/schoolClass/getSchoolClassInfo?schoolClassId="+schoolClassId);
	}
}
