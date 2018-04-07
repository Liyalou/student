package com.my.color.vacate.controller;

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
import com.my.color.user.service.UserToken;
import com.my.color.vacate.dao.po.StudentVacate;
import com.my.color.vacate.service.StudentVacateService;

/**
 * 请假申请
 * @author lyl
 *
 */
@Controller
@RequestMapping("/admin/studentVacate")
public class StudentVacateController {
	
	private static final String MENU_ID = "MENU_STUDENT_VACATE";
	
	@Autowired
	private MainLayout layout;
	
	@Autowired
	private StudentVacateService studentVacateService;
	
	/**
	 * 列表查询
	 * @param model
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("/vacateIndex")
	public ModelAndView vacateIndex(ModelMap model,Page<StudentVacate> page,BaseCondition condition){
		page.startPage(page);
		Map<String,Object> conditionMap = condition.getConditionMap(condition);
		conditionMap.put("userId", UserToken.getLoginUser().getUserId());
		List<StudentVacate> list = studentVacateService.getStudentVacateList(conditionMap);
		PageInfo<StudentVacate> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/studentVacate/vacateIndex");
		return layout.layout("studentVacate",MENU_ID);
	}
	
	/**
	 * 添加修改页面
	 * 	请假状态为默认状态0时，可以修改
	 * @param model
	 * @return
	 */
	@RequestMapping("/addInput")
	public ModelAndView addInput(ModelMap model,String studentVacateId){
		StudentVacate studentVacate = new StudentVacate();
		if(!StringUtils.isEmpty(studentVacateId)){
			studentVacate = studentVacateService.selectByPrimaryKey(studentVacateId);
		}
		model.put("studentVacate", studentVacate);
		return layout.layout("vacate/vacate-input",MENU_ID);
	}
	
	/**
	 * 保存修改
	 * @param request
	 * @param role
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/submitStudentVacate")
	public RedirectView submitStudentVacate(RedirectAttributes attributes,HttpServletRequest request,StudentVacate studentVacate){
		try {
			int result = studentVacateService.submitStudentVacate(attributes, studentVacate);
			if(result == 0){
				attributes.addFlashAttribute("studentVacate", studentVacate);
				return new RedirectView(request.getContextPath()+"/admin/studentVacate/addInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/studentVacate/vacateIndex");
	}
	
	/**
	 * 删除请假
	 * 		请假状态为默认状态0时，可以删除
	 * @param attributes
	 * @param request
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/deleteStudentVacate")
	public RedirectView deleteStudentVacate(RedirectAttributes attributes,HttpServletRequest request,String studentVacateId){
		try {
			studentVacateService.deleteStudentVacate(attributes, studentVacateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/studentVacate/vacateIndex");
	}
	
	/**
	 * 发起请假审批
	 * @param studentVacateId
	 * @return
	 */
	@RequestMapping("/startVacateApply")
	public RedirectView startVacateApply(RedirectAttributes attributes,HttpServletRequest request,String studentVacateId){
		try {
			studentVacateService.startVacateApply(attributes, studentVacateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/studentVacate/vacateIndex");
	}
	
	/**
	 * 查看详情
	 * @param model
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/getVacateInfo")
	public ModelAndView getVacateInfo(ModelMap model,String studentVacateId){
		StudentVacate studentVacate = studentVacateService.selectByPrimaryKey(studentVacateId);
		model.put("studentVacate", studentVacate);
		return layout.layout("vacate/vacate-info",MENU_ID);
	}
	
}
