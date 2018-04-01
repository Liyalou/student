package com.my.color.teachClass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.teachClass.dao.SchoolClassMapper;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.teacher.dao.TeacherClassMapper;
import com.my.color.teacher.dao.po.TeacherClass;
import com.my.color.user.dao.po.User;
import com.my.color.user.service.UserService;
import com.my.color.user.service.UserToken;

/**
 * 班级管理
 * @author lyl
 *
 */
@Service
public class SchoolClassService {

	@Autowired
	private SchoolClassMapper schoolClassMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TeacherClassMapper teacherClassMapper;
	
	public SchoolClass selectByPrimaryKey(String recordId){
		return schoolClassMapper.selectByPrimaryKey(recordId);
	}
	
	public int updateByPrimaryKeySelective(SchoolClass schoolClass){
		return schoolClassMapper.updateByPrimaryKeySelective(schoolClass);
	}
	
	public int insertSelective (SchoolClass schoolClass){
		return schoolClassMapper.insertSelective(schoolClass);
	}
	
	public List<SchoolClass> getSchoolClassList(Map<String,Object> conditionMap){
		return schoolClassMapper.getSchoolClassList(conditionMap);
	}
	
	public void addSchoolClassPage(ModelMap model,String schoolClassId){
		SchoolClass schoolClass = new SchoolClass();
		if(!StringUtils.isEmpty(schoolClassId)){
			schoolClass = schoolClassMapper.selectByPrimaryKey(schoolClassId);
		}
		model.put("schoolClass", schoolClass);
		Map<String, Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("userType", "3");
		model.put("teacherList", userService.getUserByType(conditionMap));
	}
	
	/**
	 * 保存修改
	 * @param role
	 * @return
	 */
	public Integer submitSchoolClass(RedirectAttributes attributes,SchoolClass schoolClass)throws Exception{
		int result = 0;
		TeacherClass teacherClass = new TeacherClass();
		teacherClass.setTeacherUserId(schoolClass.getClassInstructorUid());
		teacherClass.setTeacherType("1");
		User user = UserToken.getLoginUser();
		String className = schoolClass.getSchoolGradeNumber()+schoolClass.getSchoolClassNumber()+schoolClass.getClassSpecialty();
		if(!StringUtils.isEmpty(schoolClass.getSchoolClassId())){
			schoolClass.setSchoolClassName(className);
			schoolClass.setClassLastUptime(DateUtils.getTime());
			schoolClass.setClassLastUpuid(user.getUserId());
			schoolClass.setClassLastUpuname(user.getUserName());
			teacherClass.setSchoolClassId(schoolClass.getSchoolClassId());
			result = schoolClassMapper.updateByPrimaryKeySelective(schoolClass);
			if(result == 1){
				teacherClassMapper.updateByPrimaryKeySelective(teacherClass);
			}
		}else{
			schoolClass.setSchoolClassName(className);
			schoolClass.setSchoolClassId(UUIDUtils.getUUID());
			schoolClass.setClassCreateTime(DateUtils.getTime());
			schoolClass.setClassCreateUid(user.getUserId());
			schoolClass.setClassCreateUname(user.getUserName());
			teacherClass.setSchoolClassId(schoolClass.getSchoolClassId());
			result = schoolClassMapper.insertSelective(schoolClass);
			if(result == 1){
				teacherClassMapper.insertSelective(teacherClass);
			}
		}
		MessageUtils.getMessage(attributes, result);
		return result;
	}
	
	/**
	 * 删除
	 */
	public void deleteSchoolClass(RedirectAttributes attributes,String schoolClassId){
		int result = schoolClassMapper.deleteByPrimaryKey(schoolClassId);
		MessageUtils.getMessage(attributes, result);
	}
	
}
