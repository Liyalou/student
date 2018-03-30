package com.my.color.teachClass.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.teachClass.dao.SchoolClassMapper;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.user.dao.po.User;
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
	
	/**
	 * 保存修改
	 * @param role
	 * @return
	 */
	public Integer submitSchoolClass(RedirectAttributes attributes,SchoolClass schoolClass)throws Exception{
		int result = 0;
		User user = UserToken.getLoginUser();
		if(!StringUtils.isEmpty(schoolClass.getSchoolClassId())){
			schoolClass.setClassLastUptime(DateUtils.getTime());
			schoolClass.setClassLastUpuid(user.getUserId());
			schoolClass.setClassLastUpuname(user.getUserName());
			result = schoolClassMapper.updateByPrimaryKeySelective(schoolClass);
		}else{
			schoolClass.setSchoolClassId(UUIDUtils.getUUID());
			schoolClass.setClassCreateTime(DateUtils.getTime());
			schoolClass.setClassCreateUid(user.getUserId());
			schoolClass.setClassCreateUname(user.getUserName());
			result = schoolClassMapper.insertSelective(schoolClass);
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
