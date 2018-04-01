package com.my.color.manage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.manage.dao.SalaryManageMapper;
import com.my.color.manage.dao.po.SalaryManage;
import com.my.color.user.dao.po.User;
import com.my.color.user.service.UserToken;

/**
 * 考勤管理
 * @author lyl
 *
 */
@Service
public class SalaryManageService {

	@Autowired
	private SalaryManageMapper salaryManageMapper;
	
	public SalaryManage selectByPrimaryKey(String recordId){
		return salaryManageMapper.selectByPrimaryKey(recordId);
	}
	
	public int updateByPrimaryKeySelective(SalaryManage salaryManage){
		return salaryManageMapper.updateByPrimaryKeySelective(salaryManage);
	}
	
	public int insertSelective (SalaryManage salaryManage){
		return salaryManageMapper.insertSelective(salaryManage);
	}
	
	public List<SalaryManage> getSalaryManageList(Map<String,Object> conditionMap){
		return salaryManageMapper.getSalaryManageList(conditionMap);
	}
	
	/**
	 * 保存修改
	 * @param role
	 * @return
	 */
	public Integer submitSalaryManage(RedirectAttributes attributes,SalaryManage salaryManage)throws Exception{
		int result = 0;
		User user = UserToken.getLoginUser();
		if(!StringUtils.isEmpty(salaryManage.getSalaryManageId())){
			salaryManage.setSalaryLastUptime(DateUtils.getTime());
			salaryManage.setSalaryLastUpuid(user.getUserId());
			salaryManage.setSalaryLastUptime(user.getUserName());
			result = salaryManageMapper.updateByPrimaryKeySelective(salaryManage);
		}else{
			salaryManage.setSalaryManageId(UUIDUtils.getUUID());
			salaryManage.setSalaryIsVaild("1");
			salaryManage.setSalaryCreateTime(DateUtils.getTime());
			salaryManage.setTeacherUserId(user.getUserId());
			salaryManage.setTeacherUserName(user.getUserName());
			result = salaryManageMapper.insertSelective(salaryManage);
		}
		MessageUtils.getMessage(attributes, result);
		return result;
	}
	
	/**
	 * 删除
	 */
	public void deleteSalaryManage(RedirectAttributes attributes,String salaryManageId){
		User user = UserToken.getLoginUser();
		SalaryManage salaryManage = salaryManageMapper.selectByPrimaryKey(salaryManageId);
		salaryManage.setSalaryLastUptime(DateUtils.getTime());
		salaryManage.setSalaryLastUpuid(user.getUserId());
		salaryManage.setSalaryLastUptime(user.getUserName());
		salaryManage.setSalaryIsVaild("0");
		int result = salaryManageMapper.updateByPrimaryKeySelective(salaryManage);
		MessageUtils.getMessage(attributes, result);
	}
	
}
