package com.my.color.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
