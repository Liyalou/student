package com.my.color.notice.controller;

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
import com.my.color.notice.dao.po.VacateNotice;
import com.my.color.notice.service.VacateNoticeService;
import com.my.color.user.service.UserToken;

/**
 * 请假通知消息
 * @author lyl
 *
 */
@Controller
@RequestMapping("/admin/vacateNotice")
public class VacateNoticeController {

	private static final String MENU_ID = "MENU_NOTICE";
	
	@Autowired
	private MainLayout layout;
	
	@Autowired
	private VacateNoticeService vacateNoticeService;
	
	/**
	 * 列表查询
	 * @param model
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView vacateNoticeIndex(ModelMap model,Page<VacateNotice> page,BaseCondition condition){
		try {
			page.startPage(page);
			Map<String,Object> conditionMap = condition.getConditionMap(condition);
			conditionMap.put("userId", UserToken.getLoginUser().getUserId());
			List<VacateNotice> list = vacateNoticeService.getVacateNoticeList(conditionMap);
			PageInfo<VacateNotice> pageList = page.listToPage(list);
			model.put(Constant.PAGE_LIST, pageList);
			model.put(Constant.PAGE_URL, "/admin/vacateNotice/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return layout.layout("vacateNotice",MENU_ID);
	}
	
	/**
	 * 查看已读通知
	 * @param request
	 * @param vacateNoticeId
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/checkVacate")
	public RedirectView checkVacate(RedirectAttributes attributes,HttpServletRequest request,
			String vacateNoticeId){
		try {
			vacateNoticeService.checkVacate(attributes, vacateNoticeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/vacateNotice/index");
	}
}
