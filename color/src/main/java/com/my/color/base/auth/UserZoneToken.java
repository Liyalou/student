package com.my.color.base.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;


public interface UserZoneToken {

	/**
	 * 验证
	 * @param realm
	 * @return
	 * @throws AuthenticationException
	 */
	public AuthenticationInfo doGetAuthenticationInfo(UserZoneRealm realm) 
			throws AuthenticationException;
}
