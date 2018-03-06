package com.my.color.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.my.color.system.dao.po.Menu;
import com.my.color.user.service.UserService;


public class MenuManager {
	public static String MENUS_ATTRIBUTE_NAME = "menus";
	private List<Menu> menuList;
	private List<Menu> topList;
	private List<Menu> submenuList;
	private List<String> breadCrumb;
	private Menu current;
	private Menu currentTop;
	
	private MenuManager() {
	}
	
	public static MenuManager get(UserService userService) {
		Subject subject = SecurityUtils.getSubject();
		MenuManager menus = (MenuManager)subject.getSession().getAttribute(MENUS_ATTRIBUTE_NAME);
		if (menus == null) {
			menus = new MenuManager();
			menus.loadData(userService);
			subject.getSession().setAttribute(MENUS_ATTRIBUTE_NAME, menus);
		}
		return menus;
	}
	
	private void loadData(UserService authService) {
		List<Menu> menuList = authService.getMenuByUserId();
		this.topList = new ArrayList<Menu>();
		for (Iterator<Menu> i = menuList.iterator(); i.hasNext();) {
			Menu menu = i.next();
			if (menu.getMenuParentId() == null) {
				this.topList.add(menu);
			}
		}
		this.menuList = menuList;
		//romeveEmptyTopMenu();
		this.submenuList = new ArrayList<Menu>();
	}
	
	/*private void romeveEmptyTopMenu() {
		for (Iterator<Menu> i = this.topList.iterator(); i.hasNext();) {
			Menu top = i.next();
			boolean flag = false;
			for (Menu menu : this.menuList) {
				if(top.getMenuId().equals(menu.getMenuParentId())) {
					flag = true;
				}
			}
			if(!flag){
				i.remove();
				this.menuList.remove(top);
			}
		}
	}*/
	
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

	public List<String> getBreadCrumb() {
		return breadCrumb;
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
