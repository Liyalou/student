package com.my.color.system.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.color.system.dao.MenuMapper;
import com.my.color.system.dao.MenuRoleMapper;
import com.my.color.system.dao.po.Menu;

/**
 * 系统菜单
 * @author lyl
 *
 */
@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private MenuRoleMapper menuRoleMapper;
	
	/**
	 * 查询登录人拥有的菜单
	 * @return
	 */
	public List<Menu> getMenuByIds(List<String> menuIds){
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("menuIdList", menuIds);
		return menuMapper.getMenuByIds(conditionMap);
	}
	
	/**
	 * 查询角色拥有的菜单id
	 * @param roleIds
	 * @return
	 */
	public List<String> getMenuByRoleIds(List<String> roleIds){
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("roleIdList", roleIds);
		return menuRoleMapper.getMenuIdByRoleIds(conditionMap);
	}
	
	/**
	 * 根据id查询菜单
	 * @param menuId
	 * @return
	 */
	public Menu selectByPrimaryKey(String menuId){
		return menuMapper.selectByPrimaryKey(menuId);
	}
	
}
