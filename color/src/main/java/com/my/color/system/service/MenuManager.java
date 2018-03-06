package com.my.color.system.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.my.color.system.dao.po.Menu;

/**
 * 菜单管理
 * @author lyl
 *
 */
public class MenuManager {
	
	private List<Menu> menuList;//当前登录人拥有的所有的菜单
	private List<Menu> topList;//当前登录人拥有的主菜单
	private List<Menu> submenuList;//当前登录人拥有的二级菜单
	private Menu current;//当前选中
	private Menu currentTop;//当前选中的主菜单
	public static String MENUS_ATTRIBUTE_NAME = "menus";
	
	
	private MenuManager() {
	}
	
	public static MenuManager get(List<Menu> menuList) {
		Subject subject = SecurityUtils.getSubject();
		MenuManager menus = (MenuManager)subject.getSession().getAttribute(MENUS_ATTRIBUTE_NAME);
		if (menus == null) {
			menus = new MenuManager();
			menus.loadData(menuList);
		}
		return menus;
	}
	
	public void loadData(List<Menu> menuList) {
		this.topList = new ArrayList<Menu>();
		for (Iterator<Menu> i = menuList.iterator(); i.hasNext();) {
			Menu menu = i.next();
			if (menu.getMenuParentId() == null) {
				this.topList.add(menu);
			}
		}
		this.menuList = menuList;
		this.submenuList = new ArrayList<Menu>();
	}
	
	public Menu touch(String menuId) {
		if (menuId == null) return null;
		// 查找点击的菜单
		for (Iterator<Menu> i = menuList.iterator(); i.hasNext();) {
			Menu menu = i.next();
			if (menuId.equals(menu.getMenuId())) {
				current = menu;
				break;
			}
		}
		//如果没找到则直接退出
		if (current == null) return null;
		if (current.getMenuParentId() == null) {
			//如果点击的是主菜单
			currentTop = current;
			this.submenuList.clear();
			for (Iterator<Menu> i = menuList.iterator(); i.hasNext();) {
				Menu menu = i.next();
				if (menu.getMenuParentId() != null) {
					if (menu.getMenuParentId().equals(currentTop.getMenuId())) {
						submenuList.add(menu);
					}
				}
			}
			//选中子菜单的第一个
			if ( ! submenuList.isEmpty()) {
				current = submenuList.get(0);
			} else {
				current = null;
			}
		} else {
			//点击的是子菜单
			this.submenuList.clear();
			this.currentTop = null;
			for (Iterator<Menu> i = menuList.iterator(); i.hasNext();) {
				Menu menu = i.next();
				if (menu.getMenuParentId() != null) {
					if (menu.getMenuParentId().equals(current.getMenuParentId())) {
						submenuList.add(menu);
					}
				} else {
					if (menu.getMenuId().equals(current.getMenuParentId())) {
						this.currentTop = menu;
					}
				}
			}
		}
		return current;
	}

	/**
	 * 获取登录人拥有的主菜单
	 * @param userId
	 * @return
	 */
	public List<Menu> getMenuListByUserId(){
		for (Iterator<Menu> iterator = menuList.iterator(); iterator.hasNext();) {
			Menu menu = (Menu) iterator.next();
			if(menu.getMenuParentId() != null){
				iterator.remove();
			}
		}
		return menuList;
	}
	
	public List<Menu> getMenuList() {
		return menuList;
	}

	public List<Menu> getTopList() {
		return topList;
	}

	public List<Menu> getSubmenuList() {
		return submenuList;
	}

	public Menu getCurrent() {
		return current;
	}

	public Menu getCurrentTop() {
		return currentTop;
	}
	

}
