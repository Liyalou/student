package com.my.color.createcode;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class CreateCode {
	// 1.那些domain需要生成代码
	private String[] domains = { "VacateNotice" };
	private String[] domainName = { "请假通知" };
	private String[] projectPakcageName = {"notice"};
	private String[] packagePath = {"com.my.color.notice"};
	private String[] tableName = {"e_vacate_notice"};
	private String[] lowTableName = {"vacateNotice"};
	private String[] pageName = {"vacateNotice"};
	// 2.定义固定的目录路径:都是使用相对路径,规范：路径前面都不加/,路径的后面都加/
	private static final String SRC = "src/main/java/";
	private static final String PACKAGE = "com/my/color/notice/";//相应的类的路径
	private static final String RESOURCES = "src/main/resources/";
	private static final String WEBAPP = "src/main/webapp/";
	// 3.有那些模板需要生成
	private String[] templates = {/*"Controller.java", "Condition.java", "Mapper.java",*/"Service.java"/*, "test.txt"*/};
	// 4.模板文件对应的生成文件路径
	private String[] filePath = { /*SRC + PACKAGE + "ledger/controller/",*/
			/*SRC + PACKAGE + "teachClass/dao/po/", *//*SRC + PACKAGE + "borrowing/dao/",*/
			SRC + PACKAGE + "service/"/*,
			SRC + PACKAGE + "ledger/server/"*/
	};

	public static void main(String[] args) throws Exception {
		CreateCode createCode = new CreateCode();
		String table ="e_vacate_notice";
		createCode.create(table);
	}

	public void create(String table) throws Exception {
		String driver = "com.mysql.jdbc.Driver"; 
        String user = "root"; 
        //String pwd = "Erp#2017"; 
        String pwd = "root";
        //String url = "jdbc:mysql://192.168.1.220:3306/hderp"+"?useUnicode=true&characterEncoding=UTF-8"; 
        String url = "jdbc:mysql://localhost:3306/mycolor"+"?useUnicode=true&characterEncoding=UTF-8";
        String domainPackageName = "com.my.color.notice.dao.po.VacateNotice";
		List<String> list = DbInfoUtil.getTableInfo(driver, url, user, pwd, table);
		List<String> fields = Test.getFiled(domainPackageName);
		VelocityContext context = new VelocityContext();
		// 5.外循环：domains
		for (int i = 0; i < domains.length; i++) {
			context.put("domain", domains[i]);
			context.put("domainName", domainName[i]);
			context.put("packagePath", packagePath[i]);
			context.put("tableName", tableName[i]);
			context.put("lowTableName", lowTableName[i]);
			context.put("projectPakcageName", projectPakcageName[i]);
			// 6.处理domain首字母小写
			String lowerDomain = StringUtils.uncapitalize(domains[i]);
			context.put("lowerDomain", lowerDomain);
			//String allLowerDomain = domains[i].toLowerCase();
			context.put("allLowerDomain", pageName[i]);
			//context.put("mappingUrl", value)
			context.put("list" ,  list);
			context.put("fields" ,  fields);
			// 7.内循环：templates和files
			for (int j = 0; j < templates.length; j++) {
				// 8.实例化文件存放的路径
				File file = new File(filePath[j] + domains[i] + templates[j]);
				// 9.处理特殊的文件名称
				if ("Controller.java".equals(templates[j])) {
					file = new File(filePath[j] + domains[i] + templates[j]);
				} else if ("Condition.java".equals(templates[j])) {
					file = new File(filePath[j] + "Query" + domains[i] + templates[j]);
				}else if ("Mapper.java".equals(templates[j])) {
					file = new File(filePath[j] + domains[i] + templates[j]);
				}else if ("Service.java".equals(templates[j])) {
					file = new File(filePath[j] + domains[i] + templates[j]);
				}else if ("test.txt".equals(templates[j])) {
					file = new File(filePath[j] + domains[i] + templates[j]);
				}
				System.out.println(file.getAbsolutePath());
				Template template = Velocity.getTemplate("temp/" + templates[j], "UTF-8");
				// 10.判断父目录是否存在
				File paretnFile = file.getParentFile();
				if (!paretnFile.exists()) {
					paretnFile.mkdirs();
				}
				// 11.必须关闭流，写入内容
				FileWriter fileWriter = new FileWriter(file);
				template.merge(context, fileWriter);
				fileWriter.close();
				// System.out.println(template.getName());
				// template.merge(context,);

			}
			// 12.开关：默认情况下已经存在的文件不需要生成代码 true:覆盖所有代码
		}
	}
}
