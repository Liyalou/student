<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="navbar" class="navbar navbar-default">
	<div class="navbar-container" id="navbar-container">
	    <div class="navbar-header">
          <a class="navbar-brand" href="#">大学考勤管理系统</a>
        </div>
	    <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<c:forEach items="${menus.topList}" var="menu">
          		<li <c:if test="${menus.current.menuParentId == menu.menuId}"> class="active" </c:if> >
          			<a href="${ctx}/admin/menu?menuId=${menu.menuId}">${menu.menuName}</a>
          		</li>
          	</c:forEach> 
            <li>
				<a href="${ctx}/user/logout"><i class="ace-icon fa fa-power-off"></i>退出</a>
			</li>
            <li>
            	<a href="#"><i class="ace-icon glyphicon glyphicon-user"></i><span>${user.userName}</span>
				<span id="userId" style="display: none">${user.userId}</span>
				</a>
            </li>
          </ul>
        </div>
	</div>
</div> 


 


	