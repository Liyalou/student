package com.my.color.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.github.pagehelper.PageInfo;
import com.my.color.base.common.BaseCondition;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.base.util.StringUtils;
import com.my.color.manage.dao.po.SalaryManage;
import com.my.color.manage.service.SalaryManageService;
import com.my.color.student.dao.po.StudentRecord;
import com.my.color.student.service.StudentRecordService;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.teachClass.service.SchoolClassService;
import com.my.color.user.service.UserToken;

@Controller
@RequestMapping("/admin/salaryManage")
public class SalaryManageController {

private static final String MENU_ID = "MENU_SALARY";
	
	@Autowired
	private MainLayout layout;
	
	@Autowired
	private SalaryManageService salaryManageService;
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	@Autowired
	private StudentRecordService studentRecordService;
	
	/**
	 * 列表查询
	 * 条件查询：
	 * 		学生姓名：userName
	 * @param model
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView querySalaryIndex(ModelMap model,Page<SalaryManage> page,
			BaseCondition condition){
		page.startPage(page);
		Map<String,Object> conditionMap = condition.getConditionMap(condition);
		conditionMap.put("teacherUserId", UserToken.getLoginUser().getUserId());
		List<SalaryManage> list = salaryManageService.getSalaryManageList(conditionMap);
		PageInfo<SalaryManage> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/salaryManage/index");
		return layout.layout("salaryManage",MENU_ID);
	}
	
	/**
	 * 添加修改页面
	 * 	添加修改时，需要先选择班级；选择班级后，通过班级ID查询班级学生
	 * @param model
	 * @return
	 */
	@RequestMapping("/addInput")
	public ModelAndView addInput(ModelMap model,String salaryManageId){
		SalaryManage salaryManage = new SalaryManage();
		if(!StringUtils.isEmpty(salaryManageId)){
			salaryManage = salaryManageService.selectByPrimaryKey(salaryManageId);
		}
		model.put("salaryManage", salaryManage);
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		List<SchoolClass> classList = schoolClassService.getSchoolClassList(conditionMap);
		model.put("classList", classList);
		return layout.layout("salary/salary-manage-input",MENU_ID);
	}
	
	/**
	 * 根据班级ID查询学生
	 * @param schoolClassId
	 * @return
	 */
	@RequestMapping("/getStudentByClassId")
	@ResponseBody
	public List<StudentRecord> getStudentByClassId(String schoolClassId){
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("schoolClassId", schoolClassId);
		return studentRecordService.getStudentByClassId(conditionMap);
	}
	
	/**
	 * 保存修改
	 * @param request
	 * @param salaryManage
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/submitSalaryManage")
	public RedirectView submitSalaryManage(RedirectAttributes attributes,HttpServletRequest request,
			SalaryManage salaryManage){
		try {
			int result = salaryManageService.submitSalaryManage(attributes, salaryManage);
			if(result == 0){
				attributes.addFlashAttribute("salaryManage", salaryManage);
				return new RedirectView(request.getContextPath()+"/admin/salaryManage/addInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/salaryManage/index");
	}
	
	/**
	 * 删除考勤
	 * @param attributes
	 * @param request
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/deleteSalaryManage")
	public RedirectView deleteSalaryManage(RedirectAttributes attributes,HttpServletRequest request,String salaryManageId){
		try {
			salaryManageService.deleteSalaryManage(attributes, salaryManageId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/salaryManage/index");
	}
	
	/**
	 * 查看详情
	 * @param model
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/getSalaryInfo")
	public ModelAndView getSalaryInfo(ModelMap model,String salaryManageId){
		SalaryManage salaryManage = salaryManageService.selectByPrimaryKey(salaryManageId);
		model.put("salaryManage", salaryManage);
		return layout.layout("salary/salary-manage-info",MENU_ID);
	}
	
}
