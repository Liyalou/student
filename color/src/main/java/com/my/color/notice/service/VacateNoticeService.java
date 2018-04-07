package com.my.color.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.MessageUtils;
import com.my.color.notice.dao.VacateNoticeMapper;
import com.my.color.notice.dao.po.VacateNotice;

/**
 * 请假通知
 * @author lyl
 *
 */
@Service
public class VacateNoticeService {

	@Autowired
	private VacateNoticeMapper vacateNoticeMapper;
	
	public VacateNotice selectByPrimaryKey(String recordId){
		return vacateNoticeMapper.selectByPrimaryKey(recordId);
	}
	
	public int updateByPrimaryKeySelective(VacateNotice vacateNotice){
		return vacateNoticeMapper.updateByPrimaryKeySelective(vacateNotice);
	}
	
	public int insertSelective (VacateNotice vacateNotice){
		return vacateNoticeMapper.insertSelective(vacateNotice);
	}
	
	public List<VacateNotice> getVacateNoticeList(Map<String,Object> conditionMap){
		return vacateNoticeMapper.getVacateNoticeList(conditionMap);
	}
	
	
	public void checkVacate(RedirectAttributes attributes,String vacateNoticeId){
		VacateNotice vacateNotice = new VacateNotice();
		vacateNotice.setVacateNoticeId(vacateNoticeId);
		vacateNotice.setNoticeIsRead("1");
		int result = vacateNoticeMapper.updateByPrimaryKeySelective(vacateNotice);
		MessageUtils.getMessage(attributes, result);
	}
}
