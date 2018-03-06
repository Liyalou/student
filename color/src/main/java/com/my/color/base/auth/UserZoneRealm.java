package com.my.color.base.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.my.color.base.auth.UserZoneToken;

public class UserZoneRealm extends AuthorizingRealm{

	public static final String AUTHORIZATION_INFO = "authorizationInfo";
	
	@Override
    public boolean supports(AuthenticationToken token) {
        return super.supports(token) && (token instanceof UserZoneToken);
    }
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Subject subject = SecurityUtils.getSubject();
		SimpleAuthorizationInfo info = (SimpleAuthorizationInfo)subject.getSession().getAttribute(AUTHORIZATION_INFO);
    	if (info == null) {
	    	info = new SimpleAuthorizationInfo();
    	}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UserZoneToken authtoken = (UserZoneToken) token;
    	return authtoken.doGetAuthenticationInfo(this);
	}

}
