package com.my.color.wait.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.color.base.util.DateUtils;
import com.my.color.base.util.MessageUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.notice.dao.po.VacateNotice;
import com.my.color.notice.service.VacateNoticeService;
import com.my.color.vacate.dao.po.StudentVacate;
import com.my.color.vacate.service.StudentVacateService;
import com.my.color.wait.dao.WaitDealMapper;
import com.my.color.wait.dao.po.WaitDeal;

/**
 * 请假待办
 * @author lyl
 *
 */
@Service
public class WaitDealService {

	@Autowired
	private WaitDealMapper waitDealMapper;
	
	@Autowired
	private StudentVacateService vacateService;
	
	@Autowired
	private VacateNoticeService noticeService;
	
	public WaitDeal selectByPrimaryKey(String recordId){
		return waitDealMapper.selectByPrimaryKey(recordId);
	}
	
	public int updateByPrimaryKeySelective(WaitDeal waitDeal){
		return waitDealMapper.updateByPrimaryKeySelective(waitDeal);
	}
	
	public int insertSelective (WaitDeal waitDeal){
		return waitDealMapper.insertSelective(waitDeal);
	}
	
	public List<WaitDeal> getWaitDealList(Map<String,Object> conditionMap){
		return waitDealMapper.getWaitDealList(conditionMap);
	}
	
	/**
	 * 添加保存信息
	 * @param studentVacate
	 * @return
	 */
	public int insertWaitDeal (StudentVacate studentVacate){
		WaitDeal waitDeal = new WaitDeal();
		waitDeal.setWaitDealId(UUIDUtils.getUUID());
		waitDeal.setWaitReferenceId(studentVacate.getStudentVacateId());
		waitDeal.setWaitInstructorUid(studentVacate.getStudentInstructorUid());
		waitDeal.setWaitInstructorUname(studentVacate.getStudentInstructorUname());
		waitDeal.setWaitStudentUid(studentVacate.getVacateUserId());
		waitDeal.setWaitStudentUname(studentVacate.getVacateUserName());
		waitDeal.setWaitClassId(studentVacate.getStudentClassId());
		waitDeal.setWaitClassName(studentVacate.getStudentClassName());
		waitDeal.setWaitIsVaild("1");
		waitDeal.setWaitCreateTime(DateUtils.getTime());
		waitDeal.setWaitDealState("0");
		return waitDealMapper.insertSelective(waitDeal);
	}
	
	/**
	 * 审批结果
	 * @param attributes
	 * @param request
	 * @param waitDealId
	 * @param waitReplyResult
	 * @param teacherId
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public void submitVacateApply(RedirectAttributes attributes,HttpServletRequest request,
			String waitDealId,String waitReplyResult,String teacherId)throws Exception{
		WaitDeal waitDeal = waitDealMapper.selectByPrimaryKey(waitDealId);
		waitDeal.setWaitReplyResult(waitReplyResult);
		waitDeal.setWaitDealState("1");
		int result = waitDealMapper.updateByPrimaryKeySelective(waitDeal);
		if(result == 1){
			StudentVacate studentVacate= vacateService.selectByPrimaryKey(waitDeal.getWaitReferenceId());
			if(waitReplyResult.equals("2")){
				studentVacate.setVacateState("3");
			}else{
				studentVacate.setVacateState("2");
				addVacateNotice(waitDealId, studentVacate, teacherId);
			}
			result = vacateService.updateByPrimaryKeySelective(studentVacate);
		}
		MessageUtils.getMessage(attributes, result);
	}
	
	/**
	 * 查看详情
	 * @param model
	 * @param waitDealId
	 */
	public void selectWaitDeal(ModelMap model,String waitDealId){
		WaitDeal waitDeal = waitDealMapper.selectByPrimaryKey(waitDealId);
		StudentVacate studentVacate= vacateService.selectByPrimaryKey(waitDeal.getWaitReferenceId());
		model.put("waitDealId", waitDealId);//待办id
		model.put("waitDealState", waitDeal.getWaitDealState());
		model.put("studentVacate", studentVacate);
	}
	
	
	public void addVacateNotice(String waitDealId,StudentVacate studentVacate,String teacherId){
		VacateNotice notice = new VacateNotice();
		notice.setVacateNoticeId(UUIDUtils.getUUID());
		notice.setWaitDealId(waitDealId);
		notice.setNoticeReferenceId(studentVacate.getStudentVacateId());
		notice.setNoticeTeacherUid(teacherId);
		notice.setVacateStudentUid(studentVacate.getVacateUserId());
		notice.setVacateStudentUname(studentVacate.getVacateUserName());
		notice.setVacateStartTime(studentVacate.getVacateStartTime());
		notice.setVacateEndTime(studentVacate.getVacateEndTime());
		notice.setNoticeIsVaild("1");
		notice.setNoticeIsRead("2");
		notice.setNoticeCreateTime(DateUtils.getTime());
		noticeService.insertSelective(notice);
	}
}
