package com.my.color.role.dao.po;

/**
 * 角色
 * @author lyl
 *
 */
public class Role {
    /**角色id*/
    private String roleId;

    /**角色名称*/
    private String roleName;

    /**角色编码*/
    private String roleCode;

    /**是否有效（1有效，0无效）*/
    private Integer roleIsValid;

    /**创建时间*/
    private String roleCreateTime;

    
    public String getRoleId() {
        return roleId;
    }

    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    
    public String getRoleName() {
        return roleName;
    }

    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    
    public String getRoleCode() {
        return roleCode;
    }

    
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    
    public Integer getRoleIsValid() {
        return roleIsValid;
    }

    
    public void setRoleIsValid(Integer roleIsValid) {
        this.roleIsValid = roleIsValid;
    }

    
    public String getRoleCreateTime() {
        return roleCreateTime;
    }

    
    public void setRoleCreateTime(String roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
    }
}