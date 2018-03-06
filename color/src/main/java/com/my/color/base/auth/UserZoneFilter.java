package com.my.color.base.auth;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 判断当前用户是否登录
 * @author lyl
 *
 */
public class UserZoneFilter extends AccessControlFilter {
	
	private String loginUrl;
	private String sessionKey;
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = getSubject(request, response);
		Object user = subject.getSession().getAttribute(sessionKey);
		if (user == null){
			return false;
		} 
		return true;
	}
	
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		super.saveRequest(request);
		WebUtils.issueRedirect(request, response, loginUrl);
		return false;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
}
