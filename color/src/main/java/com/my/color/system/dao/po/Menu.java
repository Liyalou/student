package com.my.color.system.dao.po;

/**
 * 菜单表
 * @author lyl
 *
 */
public class Menu {
    /**菜单id*/
    private String menuId;

    /**菜单名称*/
    private String menuName;

    /**菜单请求路径*/
    private String menuUrl;

    /**菜单排序*/
    private Integer menuOrder;

    /**父级id*/
    private String menuParentId;

    /**是否有效*/
    private String menuIsValid;

    /**菜单编码*/
    private String menuCode;

    
    public String getMenuId() {
        return menuId;
    }

    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    
    public String getMenuName() {
        return menuName;
    }

    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    
    public String getMenuUrl() {
        return menuUrl;
    }

    
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    
    public Integer getMenuOrder() {
        return menuOrder;
    }

    
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    
    public String getMenuParentId() {
        return menuParentId;
    }

    
    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    
    public String getMenuIsValid() {
        return menuIsValid;
    }

    
    public void setMenuIsValid(String menuIsValid) {
        this.menuIsValid = menuIsValid;
    }

    
    public String getMenuCode() {
        return menuCode;
    }

    
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}