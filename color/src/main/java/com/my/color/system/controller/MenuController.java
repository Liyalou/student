package com.my.color.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.color.base.layout.MainLayout;

/**
 * 系统菜单
 * @author lyl
 *
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuController {
	
	public static final String menuId = "MENU_MANGE";
	
	@Autowired
	private MainLayout layout;
	
	/**
	 * 点击主菜单跳转
	 * @param menuId
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
		
		return layout.layout("menu", menuId);
	}
	
	
}
