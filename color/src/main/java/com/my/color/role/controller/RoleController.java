package com.my.color.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.role.dao.po.Role;
import com.my.color.role.service.RoleService;


/**
 * 角色管理
 * @author lyl
 *
 */
@RequestMapping("admin/role")
@Controller
public class RoleController {
	
	private static final String MENU_ID = "MENU_ROLE";
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private MainLayout layout;
	
	@RequestMapping("/roleIndex")
	public ModelAndView roleIndex(ModelMap model,Page<Role> page){
		page.startPage(page);
		List<Role> list = roleService.getRoleList();
		PageInfo<Role> pageList = page.listToPage(list);
		model.put(Constant.PAGE_LIST, pageList);
		model.put(Constant.PAGE_URL, "/admin/role/roleIndex");
		return layout.layout("role",MENU_ID);
	}
	
	@RequestMapping("/roleInput")
	public ModelAndView roleInput(ModelMap model){
		return layout.layout("role/role-input",MENU_ID);
	}
}
