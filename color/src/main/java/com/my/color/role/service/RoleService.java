package com.my.color.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.role.dao.RoleMapper;
import com.my.color.role.dao.po.Role;

/**
 * 角色管理
 * @author lyl
 *
 */
@Service
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public List<Role> getRoleList(){
		return roleMapper.getRoleList();
	}
	
	public Role getRoleByCode(String roleCode){
		return roleMapper.selectByRoleCode(roleCode);
	}
	
	/**
	 * 保存修改
	 * @param role
	 * @return
	 */
	public void submitRole(RedirectAttributes attributes,Role role){
		int result = 0;
		if(!StringUtils.isEmpty(role.getRoleId())){
			result = roleMapper.updateByPrimaryKeySelective(role);
		}else{
			role.setRoleIsValid(1);
			role.setRoleId(UUIDUtils.getUUID());
			role.setRoleCreateTime(DateUtils.getTime());
			result = roleMapper.insertSelective(role);
		}
		MessageUtils.getMessage(attributes, result);
	}
}
