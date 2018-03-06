<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<tiles:insertAttribute name="head-resource" />
<tiles:insertAttribute name="custom-css" /> 
</head>
<body class="no-skin">
	<tiles:insertAttribute name="header" />
	<div class="main-container ace-save-state" id="main-container">
		<tiles:insertAttribute name="menu" /> 
		<div class="main-content">
			<div class="main-content-inner">
				<tiles:insertAttribute name="breadcrumb" /> 
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
	<tiles:insertAttribute name="js-resource" />
	<tiles:insertAttribute name="custom-js" /> 
</body>