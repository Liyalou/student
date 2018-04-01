package com.my.color.student.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.PasswordUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.role.dao.po.Role;
import com.my.color.role.service.RoleService;
import com.my.color.student.dao.StudentRecordMapper;
import com.my.color.student.dao.po.StudentRecord;
import com.my.color.teacher.dao.TeacherClassMapper;
import com.my.color.user.dao.UserRoleMapper;
import com.my.color.user.dao.po.User;
import com.my.color.user.dao.po.UserRole;
import com.my.color.user.service.UserService;
import com.my.color.user.service.UserToken;

/**
 * 班级管理
 * @author lyl
 *
 */
@Service
public class StudentRecordService {

	@Autowired
	private StudentRecordMapper studentRecordMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Autowired
	private TeacherClassMapper teacherClassMapper;
	
	public StudentRecord selectByPrimaryKey(String recordId){
		return studentRecordMapper.selectByPrimaryKey(recordId);
	}
	
	public int updateByPrimaryKeySelective(StudentRecord studentRecord){
		return studentRecordMapper.updateByPrimaryKeySelective(studentRecord);
	}
	
	public int insertSelective (StudentRecord studentRecord){
		return studentRecordMapper.insertSelective(studentRecord);
	}
	
	public List<StudentRecord> getStudentRecordList(Map<String,Object> conditionMap){
		User user = UserToken.getLoginUser();
		conditionMap.put("userId", user.getUserId());
		if(user.getUserType().equals("3")){
			conditionMap.put("teacherType", "1");
		}
		if(user.getUserType().equals("4")){
			conditionMap.put("teacherType", "2");
		}
		List<String> classIdList = teacherClassMapper.getClassIdByUserId(conditionMap);
		conditionMap.put("classIdList", classIdList);
		return studentRecordMapper.getStudentRecordList(conditionMap);
	}
	
	public List<StudentRecord> getStudentByClassId(Map<String,Object> conditionMap){
		return studentRecordMapper.getStudentByClassId(conditionMap);
	}
	
	
	/**
	 * 保存修改
	 * @param role
	 * @return
	 */
	public Integer submitStudentRecord(RedirectAttributes attributes,StudentRecord studentRecord)throws Exception{
		int result = 0;
		User user = new User();
		user.setUserId(UUIDUtils.getUUID());
		user.setUserName(studentRecord.getStudentRecordName());
		user.setUserAccount(studentRecord.getStudentPhone());
		user.setUserIdCard(studentRecord.getStudentIdCard());
		user.setUserPhone(studentRecord.getStudentPhone());
		if(!StringUtils.isEmpty(studentRecord.getStudentRecordId())){
			studentRecord.setStudentLastUptime(DateUtils.getTime());
			studentRecord.setStudentLastUpuid(UserToken.getLoginUser().getUserId());
			studentRecord.setStudentLastUpuname(UserToken.getLoginUser().getUserName());
			result = studentRecordMapper.updateByPrimaryKeySelective(studentRecord);
			if(result == 1){
				userService.updateByPrimaryKeySelective(user);
			}
		}else{
			studentRecord.setStudentUserId(user.getUserId());
			studentRecord.setStudentRecordId(UUIDUtils.getUUID());
			studentRecord.setStudentIsVaild("1");
			studentRecord.setStudentCreateTime(DateUtils.getTime());
			studentRecord.setStudentCreateUid(UserToken.getLoginUser().getUserId());
			studentRecord.setStudentCreateUname(UserToken.getLoginUser().getUserName());
			result = studentRecordMapper.insertSelective(studentRecord);
			if(result == 1){
				user.setUserPassword(PasswordUtils.SHA1("123456", studentRecord.getStudentPhone()));
				user.setUserSex(studentRecord.getStudentRecordSex());
				user.setUserLoginNumber(0);
				user.setUserIsValid("1");
				user.setUserCreateTime(DateUtils.getTime());
				user.setUserType("5");
				userService.insertSelective(user);
				Role role = roleService.getRoleByCode("role_student");
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
	 * 删除
	 */
	public void deleteStudentRecord(RedirectAttributes attributes,String studentRecordId){
		StudentRecord studentRecord = studentRecordMapper.selectByPrimaryKey(studentRecordId);
		studentRecord.setStudentLastUptime(DateUtils.getTime());
		studentRecord.setStudentLastUpuid(UserToken.getLoginUser().getUserId());
		studentRecord.setStudentLastUpuname(UserToken.getLoginUser().getUserName());
		studentRecord.setStudentIsVaild("0");
		int result = studentRecordMapper.updateByPrimaryKeySelective(studentRecord);
		MessageUtils.getMessage(attributes, result);
	}
	
}
