package com.my.color.createcode;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> class1 = Class.forName("com.hd.hderp.materialmanagement.materialpurchasedetails.dao.po.MaterialPurchaseDetails");
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			String methodName = field.getName();
			String trimMethodName = methodName.trim();
			char[] methodNames = trimMethodName.toCharArray();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < methodNames.length; i++) {
				if (methodNames[i] >= 'A' && methodNames[i] <= 'Z') {
					sb.append(("_" + methodNames[i]).toLowerCase());
				} else {
					sb.append(methodNames[i]);
				}
			}
			//System.out.println(sb.toString()+",");
			System.out.println(trimMethodName);
		}
	}
	
	public static List<String> getFiled(String domainPackageName) throws Exception{
		Class<?> class1 = Class.forName(domainPackageName);
		List<String> list = new ArrayList<>();
		Field[] fields = class1.getDeclaredFields();
		for (Field field : fields) {
			String methodName = field.getName();
			String trimMethodName = methodName.trim();
			list.add(trimMethodName);
			char[] methodNames = trimMethodName.toCharArray();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < methodNames.length; i++) {
				if (methodNames[i] >= 'A' && methodNames[i] <= 'Z') {
					sb.append(("_" + methodNames[i]).toLowerCase());
				} else {
					sb.append(methodNames[i]);
				}
			}
			//System.out.println(sb.toString());
			//System.out.println("=#"+"{"+trimMethodName+"},");
		}
		
		return list;
	}

}
