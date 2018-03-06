package com.my.color.system.dao.po;

/**
 * 角色菜单关联
 * @author lyl
 *
 */
public class MenuRole {
    /**菜单id*/
    private String menuId;

    /**角色id*/
    private String roleId;

    
    public String getMenuId() {
        return menuId;
    }

    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    
    public String getRoleId() {
        return roleId;
    }

    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}