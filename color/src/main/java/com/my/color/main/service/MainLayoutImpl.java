package com.my.color.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.my.color.base.layout.MainLayout;
import com.my.color.system.MenuManager;
import com.my.color.system.dao.po.Menu;
import com.my.color.user.service.UserService;
import com.my.color.user.service.UserToken;

@Service
public class MainLayoutImpl implements MainLayout{

	@Autowired
	private UserService userService;
	
	@Override
	public ModelAndView layout(String contentView) {
		return layout(contentView, null);
	}

	@Override
	public ModelAndView layout(String contentView, String menuId) {
		ModelAndView model = new ModelAndView();
		model.setViewName(contentView);
		model.addObject("menuId", menuId);
		model.addObject("user", UserToken.getLoginUser());
		MenuManager menus = MenuManager.get(userService);
		menus.touch(menuId);
		model.addObject("menus", menus);
		if(menuId != null){
			List<String> breadCrumb = userService.getBreadCrumb(menuId);
			model.addObject("breadCrumb", breadCrumb);
		}
		return model;
	}

	@Override
	public String menu(String menuId) {
		Menu menu = MenuManager.get(userService).touch(menuId);
		if (menu != null && menu.getMenuUrl() != null) {
			return "redirect:.." + menu.getMenuUrl();
		} else {
			return "redirect:/admin/main";
		}
	}

}
