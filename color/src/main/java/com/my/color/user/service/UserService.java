package com.my.color.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.color.base.util.DateUtils;
import com.my.color.system.dao.po.Menu;
import com.my.color.system.service.MenuService;
import com.my.color.user.dao.UserMapper;
import com.my.color.user.dao.UserRoleMapper;
import com.my.color.user.dao.po.User;

/**
 * user用户
 * @author lyl
 *
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 根据登录账号查询user
	 * @param userId
	 * @return
	 */
	public User getUserByAccount(String userName){
		return userMapper.getUserByAccount(userName);
	}
	
	/**
	 * 修改最后登录时间
	 * @param userId
	 * @return
	 */
	public int updateLastLoginTime(String userId){
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("userId", userId);
		conditionMap.put("userLastLoginTime", DateUtils.getTime());
		return userMapper.updateLastLogTime(conditionMap);
	}
	
	/**
	 * 根据userID查询拥有的角色id
	 * @param userId
	 * @return
	 */
	public List<String> getRoleIdByUserId(String userId){
		return userRoleMapper.getRoleIdByUserId(userId);
	}
	
	/**
	 * 查询登录人拥有的菜单
	 * @return
	 */
	public List<Menu> getMenuByUserId(){
		List<Menu> menuList = new ArrayList<Menu>();
		try {
			User user = UserToken.getLoginUser();
			if(user !=null){
				List<String> roleIds = userRoleMapper.getRoleIdByUserId(user.getUserId());//根据userID查询拥有的角色id
				List<String> menuIds = menuService.getMenuByRoleIds(roleIds);//根据角色id查询角色拥有的菜单id
				menuList = menuService.getMenuByIds(menuIds);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuList;
	}
	
	/**
	 * 查询导航栏
	 * @param menuId
	 * @return
	 */
	public List<String> getBreadCrumb(String menuId){
		List<String> breadCrumb = new ArrayList<String>();
		Menu menu = menuService.selectByPrimaryKey(menuId);
		if(menu !=null){
			if(menu.getMenuParentId() != null){
				Menu parentMenu = menuService.selectByPrimaryKey(menu.getMenuParentId());
				breadCrumb.add(parentMenu.getMenuName());
			}
			breadCrumb.add(menu.getMenuName());
		}
		return breadCrumb;
	}
	
	/**
	 * 保存
	 * @param user
	 * @return
	 */
	public int insertSelective(User user){
		return userMapper.insertSelective(user);
	}
	
	/**
	 * 查询
	 * @param user
	 * @return
	 */
	public User selectByPrimaryKey(String userId){
		return userMapper.selectByPrimaryKey(userId);
	}
	
	/**
	 * xiuagi
	 * @param user
	 * @return
	 */
	public int updateByPrimaryKeySelective(User user){
		return userMapper.updateByPrimaryKeySelective(user);
	}
}
