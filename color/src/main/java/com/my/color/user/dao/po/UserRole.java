package com.my.color.user.dao.po;

/**
 * 用户角色关联
 * @author lyl
 *
 */
public class UserRole {
    /***/
    private String userId;

    /***/
    private String roleId;

    
    public String getUserId() {
        return userId;
    }

    
    public void setUserId(String userId) {
        this.userId = userId;
    }


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
 
}