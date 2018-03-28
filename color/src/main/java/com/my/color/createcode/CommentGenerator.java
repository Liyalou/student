package com.my.color.createcode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.internal.DefaultCommentGenerator;

public class CommentGenerator extends DefaultCommentGenerator {

	public CommentGenerator() {
	}

	@Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 添加字段注释
        if (introspectedColumn.getRemarks() != null)
        	field.addJavaDocLine("/**" + introspectedColumn.getRemarks() +"*/");
    }
	
	@Override
	public void addSetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		method.addJavaDocLine("");
	}
	
	@Override
	public void addGetterComment(Method method, IntrospectedTable introspectedTable,
			IntrospectedColumn introspectedColumn) {
		method.addJavaDocLine("");
	}
	
	@Override
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
		method.addJavaDocLine("");
	}
	
	@Override
	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
		// TODO Auto-generated method stub
		javaElement.addJavaDocLine("");
	}
}
