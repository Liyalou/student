package com.my.color.vacate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.user.service.UserToken;
import com.my.color.vacate.dao.StudentVacateMapper;
import com.my.color.vacate.dao.po.StudentVacate;

/**
 * 班级管理
 * @author lyl
 *
 */
@Service
public class StudentVacateService {

	@Autowired
	private StudentVacateMapper studentVacateMapper;
	
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
			studentVacate.setStudentVacateId(UUIDUtils.getUUID());
			studentVacate.setVacateUserId(UserToken.getLoginUser().getUserId());
			studentVacate.setVacateUserName(UserToken.getLoginUser().getUserName());
			studentVacate.setVacateIsVaild("1");
			studentVacate.setVacateCreateTime(DateUtils.getTime());
			studentVacate.setVacateState("0");
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
	
}
