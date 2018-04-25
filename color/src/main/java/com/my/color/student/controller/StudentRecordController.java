package com.my.color.student.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.github.pagehelper.PageInfo;
import com.my.color.base.common.BaseCondition;
import com.my.color.base.common.Constant;
import com.my.color.base.layout.MainLayout;
import com.my.color.base.page.Page;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.student.dao.po.StudentRecord;
import com.my.color.student.service.StudentRecordService;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.teachClass.service.SchoolClassService;
import com.my.color.user.dao.po.User;
import com.my.color.user.service.UserToken;

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
			Map<String,Object> conditionMap = condition.getConditionMap(condition);
			
			User user = UserToken.getLoginUser();
			if(user.getUserType().equals("3")||user.getUserType().equals("4")){
				conditionMap.put("userId", user.getUserId());
			}
			page.startPage(page);
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
	
	
	/**
	 * 下载
	 * @param salesFileId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/downloadfile")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception {
		String downfilename = "studentRecordTemp.xlsx";
        HttpHeaders headers = new HttpHeaders();
        String docsPath = request.getSession().getServletContext().getRealPath("docs");
		String fileName = "export2007.xlsx";
		String filePath = docsPath +System.getProperties().getProperty("file.separator")+ fileName;
        File file = new File(filePath);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", downfilename);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	} 
	
	@ResponseBody
    @RequestMapping("/readexcel")
    public boolean readExcel(@RequestParam("file") CommonsMultipartFile file, String bidFileName, String tablenameNotice) throws Exception {
        boolean result = false;
        InputStream inputStream = file.getInputStream();
        String name = file.getOriginalFilename();
        Workbook workbook = null;
        String postfix = name.substring(name.lastIndexOf("."), name.length());
        try {
            if (".xls".equals(postfix)) {
                // 针对 2003 Excel 文件
                workbook = new HSSFWorkbook(new POIFSFileSystem(inputStream));
            } else {
                // 针对2007 Excel 文件
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (int s = 0; s < 1; s++) {
            Sheet sheet = workbook.getSheetAt(s);
            int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
            for (int r = 0; r < rowCount; r++) {
            	StudentRecord studentRecord = new StudentRecord();
            	
            	
            	User user = new User();
            	
            	
                Row row = sheet.getRow(r);
                if (row != null) {
                    int cellCount = row.getPhysicalNumberOfCells(); // 获取总列数
                    
                    
                    
                    if (cellCount == 5) {
                        
                        Cell cell0 = row.getCell(0);//获取审查内容
                        String v = cell0.getStringCellValue();
                        
                        Cell cell1 = row.getCell(1);//获取审查标准
                        try {
                            if (!StringUtils.isEmpty(cell1.getStringCellValue())) {
                            	
                            }
                        } catch (Exception e) {
                            double d = cell1.getNumericCellValue();
                        }
                        Cell cell2 = row.getCell(2);//获取审核
                        if (!StringUtils.isEmpty(cell2.getStringCellValue())) {
                        	
                        }
                        Cell cell3 = row.getCell(3);//获取通知整改记录
                        if (!StringUtils.isEmpty(cell3.getStringCellValue())) {
                        	
                        }
                        Cell cell4 = row.getCell(4);//获取备注
                        if (!StringUtils.isEmpty(cell4.getStringCellValue())) {
                        	
                        }
                        
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }
        }
        
        inputStream.close();
        workbook.close();
        return result;
    }
}
