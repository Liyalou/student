package com.my.color.student.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.github.pagehelper.PageInfo;
import com.my.color.base.common.BaseCondition;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.base.util.StringUtils;
import com.my.color.student.dao.po.StudentRecord;
import com.my.color.student.service.StudentRecordService;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.teachClass.service.SchoolClassService;

/**
 * 学生管理
 * @author lyl
 *
 */
@Controller
@RequestMapping("/admin/studentRecord")
public class StudentRecordController {

	private static final String MENU_ID = "MENU_STUDENT_RECORD";
	
	@Autowired
	private MainLayout layout;
	
	@Autowired
	private StudentRecordService recordService;
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	/**
	 * 列表添加查询
	 * 	学生姓名：userName
	 * @param model
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView studentRecordIndex(ModelMap model,Page<StudentRecord> page,BaseCondition condition){
		try {
			page.startPage(page);
			Map<String,Object> conditionMap = condition.getConditionMap(condition);
			List<StudentRecord> list = recordService.getStudentRecordList(conditionMap);
			PageInfo<StudentRecord> pageList = page.listToPage(list);
			model.put(Constant.PAGE_LIST, pageList);
			model.put(Constant.PAGE_URL, "/admin/studentRecord/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return layout.layout("studentRecord",MENU_ID);
	}
	
	/**
	 * 添加页面
	 * 添加学生时，需要先选择班级（下拉选择）
	 * 		班级id：schoolClassId
	 * 		班级名称：schoolClassName
	 * @param model
	 * @return
	 */
	@RequestMapping("/addInput")
	public ModelAndView addInput(ModelMap model,String studentRecordId){
		StudentRecord studentRecord = new StudentRecord();
		if(!StringUtils.isEmpty(studentRecordId)){
			studentRecord =  recordService.selectByPrimaryKey(studentRecordId);
		}
		Map<String,Object> conditionMap = new HashMap<String,Object>();
		List<SchoolClass> classList = schoolClassService.getSchoolClassList(conditionMap);
		model.put("studentRecord", studentRecord);
		model.put("classList", classList);//班级集合
		return layout.layout("teach/student/student-record-input",MENU_ID);
	}
	
	/**
	 * 保存修改
	 * @param request
	 * @param role
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/submitStudent")
	public RedirectView submitStudent(RedirectAttributes attributes,HttpServletRequest request,StudentRecord studentRecord){
		try {
			int result = recordService.submitStudentRecord(attributes, studentRecord);
			if(result == 0){
				attributes.addFlashAttribute("studentRecord", studentRecord);
				return new RedirectView(request.getContextPath()+"/admin/studentRecord/addInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/studentRecord/index");
	}
	
	/**
	 * 删除教师
	 * 请求参数：
	 * 		老师id：teachTeacherId
	 * @param attributes
	 * @param request
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/deleteStudent")
	public RedirectView deleteStudent(RedirectAttributes attributes,HttpServletRequest request,String studentRecordId){
		try {
			recordService.deleteStudentRecord(attributes, studentRecordId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/studentRecord/index");
	}
	
	/**
	 * 查看详情
	 * @param model
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/getStudentInfo")
	public ModelAndView getStudentInfo(ModelMap model,String studentRecordId){
			StudentRecord studentRecord =  recordService.selectByPrimaryKey(studentRecordId);
		model.put("studentRecord", studentRecord);
		return layout.layout("teach/student/student-record-info",MENU_ID);
	}
}
