package com.my.color.contre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.my.color.base.layout.MainLayout;
import com.my.color.user.dao.po.User;
import com.my.color.user.service.UserToken;

@RequestMapping("/admin/userContre")
@Controller
public class UserContreController {

	private static final String MENU_ID = "MENU_USER_CONTER";
	
	@Autowired
	private MainLayout layout;
	
	/**
	 * @param model
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView userContreIndex(ModelMap model){
		User user = UserToken.getLoginUser();
		model.put("user", user);
		return layout.layout("userContre",MENU_ID);
	}
}
