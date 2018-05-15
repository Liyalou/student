<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="page-content">
	<div class="well">
		<div class="page-header">
		  <h3><Strong>${user.userName}</Strong> <small>欢迎进入考勤管理系统</small></h3>
		  <p>当前系统时间为：${nowTime}</p>
		</div>
	</div>
</div>