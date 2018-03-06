<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="breadcrumbs" id="breadcrumbs">
	<ul class="breadcrumb">
		<c:if test="${null != breadCrumb}">
			<c:forEach items="${breadCrumb}" var="bread">
				<li>${bread}</li>
			</c:forEach>
		</c:if>
	</ul>
</div>
