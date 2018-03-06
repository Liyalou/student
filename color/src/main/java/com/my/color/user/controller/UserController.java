package com.my.color.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.my.color.user.dao.po.UserLoginForm;
import com.my.color.user.service.UserService;
import com.my.color.user.service.UserToken;

/**
 * 用户
 * @author lyl
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 返回登录页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.GET,produces="text/html;charset=utf-8")
	public ModelAndView login(HttpServletRequest request,ModelMap model) {
		try {
			String loginMsg = request.getParameter("loginMsg");
			if(loginMsg !=null){
				model.addAttribute("loginMsg", loginMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("admin/index");
	}
	
	/**
	 * 登录
	 * @param request
	 * @param userLoginForm
	 * @return
	 */
	@RequestMapping("/login")
	public RedirectView login(HttpServletRequest request,UserLoginForm userLoginForm,RedirectAttributes flash){
		try {
			UserToken token = new UserToken(userLoginForm.getUsername(), userLoginForm.getPassword(),userService);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			return new RedirectView("/admin/main", true);
		} catch (AuthenticationException e) {
			e.printStackTrace();
			flash.addFlashAttribute("loginMsg", e.getMessage());
			return new RedirectView("login");
		}
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("logout")
	public RedirectView logout() {
		SecurityUtils.getSubject().logout();
		return new RedirectView("login");
	}
}
