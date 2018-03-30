package com.my.color.${projectPakcageName}.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.pagehelper.PageInfo;
import com.my.color.base.common.BaseCondition;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.base.util.StringUtils;
import com.my.color.teacher.dao.po.TeachTeacher;
import com.my.color.${projectPakcageName}.dao.po.${domain};
import com.my.color.${projectPakcageName}.service.${domain}Service;

/**
 * ${domainName}
 * @author lyl
 *
 */
@Controller
@RequestMapping("/admin/${lowTableName}")
public class ${domain}Controller {
	
	private static final String MENU_ID = "菜单";

	@Autowired
	private ${domain}Service ${lowerDomain}Service;
	
	@Autowired
	private MainLayout layout;
	
	/**
	 * 列表查询
	 * 条件查询：
	 * 		老师姓名：userName
	 * @param model
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView teachTeacherIndex(ModelMap model,Page<TeachTeacher> page,BaseCondition condition){
		try {
			page.startPage(page);
			Map<String,Object> conditionMap = condition.getConditionMap(condition);
			List<TeachTeacher> list = teachTeacherService.getTeachTeacherList(conditionMap);
			PageInfo<TeachTeacher> pageList = page.listToPage(list);
			model.put(Constant.PAGE_LIST, pageList);
			model.put(Constant.PAGE_URL, "/admin/teachTeacher/index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return layout.layout("teachTeacher",MENU_ID);
	}
	
	/**
	 * 添加页面
	 * 角色类型下拉选择值：
	 * 		辅导员：role_instructor
	 * 		任课老师：role_teacher
	 * 角色类型变量名：roleCode
	 * @param model
	 * @return
	 */
	@RequestMapping("/addInput")
	public ModelAndView addInput(ModelMap model,String Id){
		
		return layout.layout("",MENU_ID);
	}
	
	/**
	 * 保存修改
	 * @param request
	 * @param role
	 * @param attributes
	 * @return
	 */
	@RequestMapping("/submitTeacher")
	public RedirectView submitTeacher(RedirectAttributes attributes,HttpServletRequest request){
		try {
			int result = 
			if(result == 0){
				attributes.addFlashAttribute("teachTeacher", );
				attributes.addFlashAttribute("roleCode", roleCode);
				return new RedirectView(request.getContextPath()+"/admin/teachTeacher/teacherInput");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/teachTeacher/index");
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
	@RequestMapping("/deleteTeacher")
	public RedirectView deleteTeacher(RedirectAttributes attributes,HttpServletRequest request,String Id){
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(request.getContextPath()+"/admin/teachTeacher/index");
	}
	
	/**
	 * 查看详情
	 * @param model
	 * @param teachTeacherId
	 * @return
	 */
	@RequestMapping("/getTeacherInfo")
	public ModelAndView getTeacherInfo(ModelMap model,String id){
		
		return layout.layout("teach/teacher/teacher-info",MENU_ID);
	}
}
