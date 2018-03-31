package com.my.color.${projectPakcageName}.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.my.color.$
import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.PasswordUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.role.dao.po.Role;
import com.my.color.teacher.dao.po.TeachTeacher;
import com.my.color.user.dao.po.User;
import com.my.color.user.dao.po.UserRole;
import com.my.color.user.service.UserToken;
import com.my.color.${projectPakcageName}.dao.po.${domain};

/**
 * ${domainName}
 * @author lyl
 *
 */
@Service
public class ${domain}Service {

	@Autowired
	private ${domain}Mapper ${lowerDomain}Mapper;
	
	public ${domain} selectByPrimaryKey(String recordId){
		return ${lowerDomain}Mapper.selectByPrimaryKey(recordId);
	}
	
	public int updateByPrimaryKeySelective(${domain} ${lowerDomain}){
		return ${lowerDomain}Mapper.updateByPrimaryKeySelective(${lowerDomain});
	}
	
	public int insertSelective (${domain} ${lowerDomain}){
		return ${lowerDomain}Mapper.insertSelective(${lowerDomain});
	}
	
	public List<${domain}> get${domain}List(Map<String,Object> conditionMap){
		return ${lowerDomain}Mapper.get${domain}List(conditionMap);
	}
	
	
	/**
	 * 保存修改
	 * @param role
	 * @return
	 */
	public Integer submit${domain}(RedirectAttributes attributes,${domain} ${lowerDomain})throws Exception{
		int result = 0;
		if(!StringUtils.isEmpty(${lowerDomain}.get${domain}Id())){
			result = ${lowerDomain}Mapper.updateByPrimaryKeySelective(${lowerDomain});
		}else{
			
			result = ${lowerDomain}Mapper.insertSelective(${lowerDomain});
		}
		MessageUtils.getMessage(attributes, result);
		return result;
	}
	
	/**
	 * 删除
	 */
	public void delete${domain}(RedirectAttributes attributes,String ${lowerDomain}Id){
		int type = 0;
		${domain} ${lowerDomain} = ${lowerDomain}Mapper.selectByPrimaryKey(${lowerDomain}Id);
		int result = ${lowerDomain}Mapper.updateByPrimaryKeySelective(${lowerDomain});
		MessageUtils.getMessage(attributes, type);
	}
	
}
