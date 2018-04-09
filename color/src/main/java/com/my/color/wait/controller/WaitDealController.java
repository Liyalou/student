package com.my.color.wait.controller;

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
import com.my.color.teacher.dao.po.TeachTeacher;
import com.my.color.teacher.service.TeachTeacherService;
import com.my.color.user.service.UserToken;
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
		conditionMap.put("userId", UserToken.getLoginUser().getUserId());
		List<WaitDeal> list = waitDealService.getWaitDealList(conditionMap);
		PageInfo<WaitDeal> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/waitDeal/index");
		return layout.layout("waitDeal",MENU_ID);
	}
	
	/**
	 * 查看待办详情
	 * @param model
	 * @param waitDealId
	 * @return
	 */
	@RequestMapping("/selectWaitDeal")
	public ModelAndView selectWaitDeal(ModelMap model,String waitDealId){
		waitDealService.selectWaitDeal(model,waitDealId);
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
		conditionMap.put("teacherType", "4");
		List<String> userIdList = teachTeacherService.getUserIdByClassId(conditionMap);
		conditionMap.put("userIdList", userIdList);
		List<TeachTeacher> teacherList = new ArrayList<TeachTeacher>();
		if(userIdList !=null && userIdList.size()>0){
			teacherList = teachTeacherService.getTeachTeacherList(conditionMap);
		}
		model.put("teacherList", teacherList);//老师集合
		model.put("waitDealId", waitDealId);//待办ID
		return layout.layout("wait/select-teacher");
	}
	
	/**
	 * 保存修改
	 * @param request
	 * @param role
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/submitVacateApply")
	public RedirectView submitVacateApply(RedirectAttributes attributes,HttpServletRequest request,
			String waitDealId,String waitReplyResult,String teacherUserId){
		try {
			waitDealService.submitVacateApply(attributes, request, waitDealId, waitReplyResult, teacherUserId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/waitDeal/index");
	}
}
