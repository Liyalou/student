package com.my.color.contre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.my.color.base.layout.MainLayout;
import com.my.color.base.util.PasswordUtils;
import com.my.color.user.dao.po.User;
import com.my.color.user.service.UserService;

@RequestMapping("/admin/userContre")
@Controller
public class UserContreController {

	private static final String MENU_ID = "MENU_USER_CONTER";
	
	@Autowired
	private MainLayout layout;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 进入个人中心
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView userContreIndex(ModelMap model){
		return layout.layout("userContre",MENU_ID);
	}
	
	/**
	 * 修改密码
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatePasswordPage")
	public ModelAndView updatePasswordPage(ModelMap model){
		return layout.layout("contre/update-password");
	}
	
	
	/**
	 * 保存密码修改
	 * @param oldPassword String
	 * @param newPassword String
	 * @param reNewPassword String
	 * @param flash RedirectAttributes
	 * @return RedirectView
	 */
	@RequestMapping("/passwordChange")
	public RedirectView passwordChange(User user,String oldPassword, String newPassword,RedirectAttributes flash) {
		//获取当前登录用户信息
		User currentUser = userService.selectByPrimaryKey(user.getUserId());
		//原密码正确性验证
		if(!PasswordUtils.SHA1(oldPassword, user.getUserAccount()).equals(currentUser.getUserPassword())){
			flash.addFlashAttribute("alertType", "danger");
			flash.addFlashAttribute("alertMsg", "原密码输入错误");
		} else {
			//如果全部正确，则执行修改保存
			currentUser.setUserPassword(PasswordUtils.SHA1(newPassword, user.getUserAccount()));
			userService.updateByPrimaryKeySelective(currentUser);
			flash.addFlashAttribute("alertType", "success");
			flash.addFlashAttribute("alertMsg", "修改成功");
		}
		return new RedirectView("index");
	}
}
