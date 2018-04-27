package com.my.color.student.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
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
import com.my.color.base.util.DateUtils;
import com.my.color.base.util.PasswordUtils;
import com.my.color.base.util.StringUtils;
import com.my.color.base.util.UUIDUtils;
import com.my.color.student.dao.po.StudentRecord;
import com.my.color.student.service.StudentRecordService;
import com.my.color.teachClass.dao.po.SchoolClass;
import com.my.color.teachClass.service.SchoolClassService;
import com.my.color.user.dao.po.User;
import com.my.color.user.service.UserService;
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
	
	@Autowired
	private UserService userService;
	
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
		//conditionMap.put("userId", UserToken.getLoginUser().getUserId());
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
	
	/**
	 * 导入
	 * @param attributes
	 * @param request
	 * @param file
	 * @param studentClassId
	 * @param studentClassName
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/readexcel")
    public RedirectView readExcel(RedirectAttributes attributes,HttpServletRequest request,@RequestParam("file") CommonsMultipartFile file, 
    		String studentClassId, String studentClassName) throws Exception {
    	int failureNumber = 0;
    	StringBuffer stringBuffer = new StringBuffer();
    	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
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
        int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
		for (int s = 0; s < sheetCount; s++) {
			Sheet sheet = workbook.getSheetAt(s);
			int rowCount = sheet.getPhysicalNumberOfRows(); // 获取总行数
			// 遍历每一行
			for (int r = 0; r < rowCount; r++) {
				String userId = UUIDUtils.getUUID();
            	StudentRecord studentRecord = new StudentRecord();
            	studentRecord.setStudentRecordId(UUIDUtils.getUUID());
            	studentRecord.setStudentUserId(userId);
            	studentRecord.setStudentIsVaild("1");
            	studentRecord.setStudentCreateTime(DateUtils.getTime());
            	studentRecord.setStudentCreateUid(UserToken.getLoginUser().getUserId());
            	studentRecord.setStudentCreateUname(UserToken.getLoginUser().getUserName());
            	studentRecord.setStudentClassId(studentClassId);
            	studentRecord.setStudentClassName(studentClassName);
            	User user = new User();
            	user.setUserId(userId);
            	user.setUserType("5");
            	user.setUserLoginNumber(0);
            	user.setUserIsValid("1");
            	user.setUserCreateTime(DateUtils.getTime());
				Row row = sheet.getRow(r + 1);
				if (row != null) {
					int cellCount = row.getPhysicalNumberOfCells(); // 获取总列数
					// 遍历每一列
					int i = 0;
					for (int c = 0; c < cellCount + 1; c++) {
						Cell cell = row.getCell(c);
						String cellValue = null;
						if (cell != null) {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							int cellType = cell.getCellType();
							if (cellType == Cell.CELL_TYPE_NUMERIC) {
								if (DateUtil.isCellDateFormatted(cell)) {
									cellValue = fmt.format(cell.getDateCellValue()); // 日期型
								} else {
									cellValue = String.valueOf(cell.getNumericCellValue()); // 数字
								}
							}
							if (cellType == Cell.CELL_TYPE_STRING) {
								cellValue = cell.getStringCellValue();
							}
						}
						try {
							switch (i) {
							case 0:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentRecordName(cellValue);
				                	user.setUserName(cellValue);								
								}
								++i;
								break;
							case 1:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentPhone(cellValue);
				                	user.setUserAccount(cellValue);
				                	user.setUserPhone(cellValue);
				                	user.setUserPassword(PasswordUtils.SHA1("123456", cellValue));
								}
								++i;
								break;
							case 3:
								if (!StringUtils.isEmpty(cellValue)) {										
									studentRecord.setStudentRecordHeight(Integer.valueOf(cellValue));
								}
								++i;
								break;
							case 4:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentBirthYears(cellValue);
								}
								++i;
								break;
							case 5:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentIdCard(cellValue);
			                    	user.setUserIdCard(cellValue);
								}
								++i;
								break;
							case 6:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentNativePlace(cellValue);
								}
								++i;
								break;
							case 7:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentRecordNation(cellValue);																				
								}
								++i;
								break;
							case 2:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentRecordSex(cellValue);
			                    	user.setUserSex(cellValue);
								}
								++i;
								break;
							case 8:
								if (!StringUtils.isEmpty(cellValue)) {			
									studentRecord.setStudentPatriarchPhone(cellValue);
								}
								++i;
								break;
							case 9:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentFamilyAddress(cellValue);
								}
								++i;
								break;
							case 10:
								if (!StringUtils.isEmpty(cellValue)) {
									studentRecord.setStudentRemark(cellValue);
								}
								++i;
								break;
							default:
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if(user.getUserPhone() != null && user.getUserName() != null){
						 User newUser = userService.getUserByAccount(user.getUserPhone());
						 if(newUser == null){
							 recordService.insertSelective(studentRecord);
				             userService.insertSelective(user);
						 }else{
							 failureNumber++;
							 stringBuffer.append(user.getUserName()).append(":").append("电话号码重复;");
						 }
					}else{
						failureNumber++;
						if(user.getUserPhone() == null){
							stringBuffer.append(user.getUserName()).append(":").append("电话号码不能为空;");
						}
						if(user.getUserName() == null){
							stringBuffer.append(user.getUserPhone()).append(":").append("姓名不能为空;");
						}
					}
				}
			}
		}
        inputStream.close();
        workbook.close();
        if(failureNumber>0){
        	attributes.addFlashAttribute("alertMsg", "失败个数："+failureNumber+";"+stringBuffer.toString());
        	attributes.addFlashAttribute("alertType", "danger");
        }else{
        	attributes.addFlashAttribute("alertMsg", "操作成功");
        	attributes.addFlashAttribute("alertType", Constant.ALERT_SUCCESS);
        }
        return new RedirectView(request.getContextPath()+"/admin/studentRecord/index");
    }
    
    /**
     * 导入弹窗
     * @param model
     * @return
     */
    @RequestMapping("/uploadStudentPage")
	public ModelAndView uploadStudentPage(ModelMap model){
    	Map<String,Object> conditionMap = new HashMap<String,Object>();
    	//conditionMap.put("userId", UserToken.getLoginUser().getUserId());
		List<SchoolClass> classList = schoolClassService.getSchoolClassList(conditionMap);
		model.put("classList", classList);//班级集合	
		return layout.layout("teach/student/upload-student-record");
	}
}
