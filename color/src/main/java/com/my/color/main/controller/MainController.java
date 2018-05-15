package com.my.color.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.color.base.layout.MainLayout;
import com.my.color.base.util.DateUtils;

/**
 * 登录首页
 * @author lyl
 *
 */
@Controller
@RequestMapping("/admin")
public class MainController {

	@Autowired
	private MainLayout layout;
	
	/**
	 * 登录首页
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "admin/index";
	}
	
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping("/main")
	public ModelAndView main(ModelMap model){
		model.addAttribute("nowTime", DateUtils.getTime());
		return layout.layout("main","MENU_MAIN");
	}
	
	/**
	 * 菜单跳转
	 * @param menuId
	 * @return
	 */
	@RequestMapping("/menu")
	public String menu(String menuId) {
		return layout.menu(menuId);
	}
}
