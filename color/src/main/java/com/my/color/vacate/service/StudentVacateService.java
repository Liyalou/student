package com.my.color.vacate.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.teachClass.service.SchoolClassService;
import com.my.color.teacher.service.TeachTeacherService;
import com.my.color.user.dao.po.User;
import com.my.color.user.service.UserToken;
import com.my.color.vacate.dao.StudentVacateMapper;
import com.my.color.vacate.dao.po.StudentVacate;
import com.my.color.wait.service.WaitDealService;

/**
 * 班级管理
 * @author lyl
 *
 */
@Service
public class StudentVacateService {

	@Autowired
	private StudentVacateMapper studentVacateMapper;
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	@Autowired
	private TeachTeacherService teachTeacherService;
	
	@Autowired
	private WaitDealService waitDealService;
	
	public StudentVacate selectByPrimaryKey(String recordId){
		return studentVacateMapper.selectByPrimaryKey(recordId);
	}
	
	public int updateByPrimaryKeySelective(StudentVacate studentVacate){
		return studentVacateMapper.updateByPrimaryKeySelective(studentVacate);
	}
	
	public int insertSelective (StudentVacate studentVacate){
		return studentVacateMapper.insertSelective(studentVacate);
	}
	
	public List<StudentVacate> getStudentVacateList(Map<String,Object> conditionMap){
		return studentVacateMapper.getStudentVacateList(conditionMap);
	}
	
	public Integer getStudentVacateNumber(Map<String,Object> conditionMap){
		return studentVacateMapper.getStudentVacateNumber(conditionMap);
	}
	
	/**
	 * 保存修改
	 * @param role
	 * @return
	 */
	public Integer submitStudentVacate(RedirectAttributes attributes,StudentVacate studentVacate)throws Exception{
		int result = 0;
		if(!StringUtils.isEmpty(studentVacate.getStudentVacateId())){
			result = studentVacateMapper.updateByPrimaryKeySelective(studentVacate);
		}else{
			User user = UserToken.getLoginUser();
			SchoolClass schoolClass = schoolClassService.selectByStudentUserId(user.getUserId());
			studentVacate.setStudentVacateId(UUIDUtils.getUUID());
			studentVacate.setVacateUserId(user.getUserId());
			studentVacate.setVacateUserName(user.getUserName());
			studentVacate.setVacateIsVaild("1");
			studentVacate.setVacateCreateTime(DateUtils.getTime());
			studentVacate.setVacateState("0");
			studentVacate.setStudentInstructorUid(schoolClass.getClassInstructorUid());
			studentVacate.setStudentInstructorUname(schoolClass.getClassInstructorUname());
			studentVacate.setStudentClassId(schoolClass.getSchoolClassId());
			studentVacate.setStudentClassName(schoolClass.getSchoolClassName());
			result = studentVacateMapper.insertSelective(studentVacate);
		}
		MessageUtils.getMessage(attributes, result);
		return result;
	}
	
	/**
	 * 删除
	 */
	public void deleteStudentVacate(RedirectAttributes attributes,String studentVacateId){
		StudentVacate studentVacate = studentVacateMapper.selectByPrimaryKey(studentVacateId);
		studentVacate.setVacateIsVaild("0");
		int result = studentVacateMapper.updateByPrimaryKeySelective(studentVacate);
		MessageUtils.getMessage(attributes, result);
	}
	
	
	public Map<String,Object> getConditionForQuery(){
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		User user = UserToken.getLoginUser();
		String userType = user.getUserType();
		if(userType.equals("3") || userType.equals("4")){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", user.getUserId());
			map.put("teacherType", userType);
			List<String> classIdList = teachTeacherService.getClassIdByUserId(conditionMap);
			if(classIdList != null && classIdList.size()>0){
				conditionMap.put("classIdList", classIdList);
			}
		}
		return conditionMap;
	}
	
	/**
	 * 发起请假审批
	 * @param studentVacateId
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void startVacateApply(RedirectAttributes attributes,String studentVacateId)throws Exception{
		StudentVacate studentVacate = studentVacateMapper.selectByPrimaryKey(studentVacateId);
		studentVacate.setVacateState("1");
		int result = studentVacateMapper.updateByPrimaryKeySelective(studentVacate);
		if(result == 1){
			waitDealService.insertWaitDeal(studentVacate);
		}
		MessageUtils.getMessage(attributes, result);
	}
}
