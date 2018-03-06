package com.my.color.user.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.my.color.base.auth.UserZoneRealm;
import com.my.color.base.auth.UserZoneToken;
import com.my.color.base.common.Constant;
import com.my.color.base.util.PasswordUtils;
import com.my.color.user.dao.po.User;

/**
 * 用户登录验证
 * @author lyl
 *
 */
public class UserToken extends UsernamePasswordToken implements UserZoneToken{
	
	private static final long serialVersionUID = -2420822354088422742L;
	
	private UserService userService;
	
	public UserToken(final String username, final String password,UserService userService) {
		super(username, password);
		this.setRememberMe(false);
		this.userService = userService;
	}
	
	@Override
	public AuthenticationInfo doGetAuthenticationInfo(UserZoneRealm realm) throws AuthenticationException {
		String loginName = this.getUsername();
		User user = userService.getUserByAccount(loginName);
		if (user == null) {
			throw new AuthenticationException("无效的用户名");
		}
    	String loginPassWord = PasswordUtils.SHA1(new String(this.getPassword()), this.getUsername());
		if(!loginPassWord.equals(user.getUserPassword())){
			throw new AuthenticationException("密码错误");
		}
		Subject subject = SecurityUtils.getSubject();
		userService.updateLastLoginTime(user.getUserId());
		subject.getSession().setAttribute(Constant.SESSION_KEY, user);
		System.out.println("我保存了");
		return new SimpleAuthenticationInfo(user.getUserId(), this.getPassword(), realm.getName()); 
	}
	
	public static void updateLoginUser(User user) {
		Subject subject = SecurityUtils.getSubject();
    	subject.getSession().setAttribute(Constant.SESSION_KEY, user);
	}
	
	public static User getLoginUser(){
		Subject subject = SecurityUtils.getSubject();
    	return (User)subject.getSession().getAttribute(Constant.SESSION_KEY);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
