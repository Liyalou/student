package com.my.color.teacher.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.common.Constant;
import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.PasswordUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.role.dao.po.Role;
import com.my.color.role.service.RoleService;
import com.my.color.teacher.dao.TeachTeacherMapper;
import com.my.color.teacher.dao.TeacherClassMapper;
import com.my.color.teacher.dao.po.TeachTeacher;
import com.my.color.user.dao.UserRoleMapper;
import com.my.color.user.dao.po.User;
import com.my.color.user.dao.po.UserRole;
import com.my.color.user.service.UserService;
import com.my.color.user.service.UserToken;

/**
 * 教务人员管理
 * @author lyl
 *
 */
@Service
public class TeachTeacherService {

	@Autowired
	private TeachTeacherMapper teachTeacherMapper;
	
	@Autowired
	private TeacherClassMapper teacherClassMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	
	public int insertSelective(TeachTeacher record){
		return teachTeacherMapper.insertSelective(record);
	}
	
	public TeachTeacher selectByPrimaryKey(String teachTeacherId){
		return teachTeacherMapper.selectByPrimaryKey(teachTeacherId);
	}
	
	public int updateByPrimaryKeySelective(TeachTeacher record){
		return teachTeacherMapper.updateByPrimaryKeySelective(record);
	}
	
	public List<TeachTeacher> getTeachTeacherList(Map<String,Object> conditionMap){
		return teachTeacherMapper.getTeachTeacherList(conditionMap);
	}
	
	public List<TeachTeacher> getTeacherForClass(Map<String,Object> conditionMap){
		return teachTeacherMapper.getTeacherForClass(conditionMap);
	}
	
	/**
	 * 保存修改
	 * @param role
	 * @return
	 */
	public Integer submitTeacher(RedirectAttributes attributes,TeachTeacher teachTeacher,
			String roleCode)throws Exception{
		int result = 0;
		User user = new User();
		user.setUserName(teachTeacher.getTeachTeacherName());
		user.setUserAccount(teachTeacher.getTeachTeacherPhone());
		user.setUserIdCard(teachTeacher.getTeachTeacherIdCard());
		user.setUserPhone(teachTeacher.getTeachTeacherPhone());
		user.setUserId(teachTeacher.getTeacherUserId());
		if(!StringUtils.isEmpty(teachTeacher.getTeachTeacherId())){
			teachTeacher.setTeacherUpdateTime(DateUtils.getTime());
			teachTeacher.setTeacherUpdateUserId(UserToken.getLoginUser().getUserId());
			teachTeacher.setTeacherUpdateUserName(UserToken.getLoginUser().getUserName());
			result = teachTeacherMapper.updateByPrimaryKeySelective(teachTeacher);
			if(result == 1){
				userService.updateByPrimaryKeySelective(user);
			}
		}else{
			user.setUserId(UUIDUtils.getUUID());
			teachTeacher.setTeacherUserId(user.getUserId());
			teachTeacher.setTeachTeacherId(UUIDUtils.getUUID());
			teachTeacher.setTeacherIsValid("1");
			teachTeacher.setTeacherCreateTime(DateUtils.getTime());
			teachTeacher.setTeacherCreateUserId(UserToken.getLoginUser().getUserId());
			teachTeacher.setTeacherCreateUserName(UserToken.getLoginUser().getUserName());
			result = teachTeacherMapper.insertSelective(teachTeacher);
			if(result == 1){
				user.setUserPassword(PasswordUtils.SHA1("123456", teachTeacher.getTeachTeacherPhone()));
				user.setUserSex(teachTeacher.getTeachTeacherSex());
				user.setUserLoginNumber(0);
				user.setUserIsValid("1");
				user.setUserCreateTime(DateUtils.getTime());
				if(roleCode.equals(Constant.ROLE_TYPE_INSTRUCTOR)){
					user.setUserType("3");
				}else if(roleCode.equals(Constant.ROLE_TYPE_TEACHER)){
					user.setUserType("4");
				}else{
					user.setUserType("2");
				}
				userService.insertSelective(user);
				Role role = roleService.getRoleByCode(roleCode);
				UserRole useRole = new UserRole();
				useRole.setRoleId(role.getRoleId());
				useRole.setUserId(user.getUserId());
				userRoleMapper.insertSelective(useRole);
			}
		}
		MessageUtils.getMessage(attributes, result);
		return result;
	}
	
	/**
	 * 删除老师
	 * @param attributes
	 * @param teachTeacherId
	 */
	public void deleteTeacher(RedirectAttributes attributes,String teachTeacherId){
		int type = 0;
		TeachTeacher teacher = teachTeacherMapper.selectByPrimaryKey(teachTeacherId);
		teacher.setTeacherIsValid("0");
		teacher.setTeacherUpdateTime(DateUtils.getTime());
		teacher.setTeacherUpdateUserId(UserToken.getLoginUser().getUserId());
		teacher.setTeacherUpdateUserName(UserToken.getLoginUser().getUserName());
		int result = teachTeacherMapper.updateByPrimaryKeySelective(teacher);
		if(result == 1){
			User user = userService.selectByPrimaryKey(teacher.getTeacherUserId());
			user.setUserIsValid("0");
			user.setUserLastUpdatetime(DateUtils.getTime());
			type = userService.updateByPrimaryKeySelective(user);
		}
		MessageUtils.getMessage(attributes, type);
	}
	
	
	public List<String> getUserIdByClassId(Map<String,Object> conditionMap){
		return teacherClassMapper.getUserIdByClassId(conditionMap);
	}
	
	public List<String> getClassIdByUserId(Map<String,Object> conditionMap){
		return teacherClassMapper.getClassIdByUserId(conditionMap);
	}
	
	
	public String getTeacherType(String teacherUserId){
		User user = userService.selectByPrimaryKey(teacherUserId);
		return user.getUserType();
	}
}
