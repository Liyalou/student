package com.my.color.wait.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.my.color.base.common.BaseCondition;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.teacher.dao.po.TeachTeacher;
import com.my.color.teacher.service.TeachTeacherService;
import com.my.color.vacate.dao.po.StudentVacate;
import com.my.color.vacate.service.StudentVacateService;
import com.my.color.wait.dao.po.WaitDeal;
import com.my.color.wait.service.WaitDealService;

@Controller
@RequestMapping("/admin/waitDeal")
public class WaitDealController {

	private static final String MENU_ID = "MENU_WAIT_DEAL";
	
	@Autowired
	private MainLayout layout;
	
	@Autowired
	private WaitDealService waitDealService;
	
	@Autowired
	private StudentVacateService vacateService;
	
	@Autowired
	private TeachTeacherService teachTeacherService;
	
	/**
	 * 请假待处理列表查询
	 * @param model
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelMap model,Page<WaitDeal> page,BaseCondition condition){
		page.startPage(page);
		Map<String,Object> conditionMap = condition.getConditionMap(condition);
		conditionMap.put("waitDealState", "1");
		List<WaitDeal> list = waitDealService.getWaitDealList(conditionMap);
		PageInfo<WaitDeal> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/waitDeal/index");
		return layout.layout("waitDeal",MENU_ID);
	}
	
	/**
	 * 查看待办详情
	 * @param model
	 * @param waitDealId(待办id，必传)
	 * @param waitReferenceId(请假单id，必传)
	 * @return
	 */
	@RequestMapping("/selectWaitDeal")
	public ModelAndView selectWaitDeal(ModelMap model,String waitDealId,String waitReferenceId){
		StudentVacate studentVacate= vacateService.selectByPrimaryKey(waitReferenceId);
		model.put("waitDealId", waitDealId);//待办id
		model.put("schoolClassId", studentVacate.getVacateUserClass());//班级id
		model.put("studentVacate", studentVacate);
		return layout.layout("wait/wait-deal-info",MENU_ID);
	}
	
	/**
	 * 请假同意，弹窗选择通知老师
	 * @param model
	 * @param schoolClassId
	 * @param waitDealId
	 * @return
	 */
	@RequestMapping("/selectTeacher")
	public ModelAndView selectTeacher(ModelMap model,String schoolClassId,String waitDealId){
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("schoolClassId", schoolClassId);
		conditionMap.put("teacherType", "2");
		List<String> userIdList = teachTeacherService.getUserIdByClassId(conditionMap);
		conditionMap.put("userIdList", userIdList);
		List<TeachTeacher> teacherList = teachTeacherService.getTeachTeacherList(conditionMap);
		model.put("teacherList", teacherList);
		return layout.layout("wait/select-teacher");
	}
	
}
