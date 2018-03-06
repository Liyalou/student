<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div id="sidebar" class="sidebar responsive">
	<div class="col-sm-3 col-md-2 sidebar">
		<ul class="nav nav-list" >
			<li>
				<a href="#"> 
					 <i class="menu-icon fa fa-home"></i>
					<!-- <span class="menu-text">首页 </span> -->
				</a>
			</li>
			<c:forEach items="${menus.submenuList}" var="menu">
				<li <c:if test="${menus.current.menuId == menu.menuId}"> class="active" </c:if> >
					<a href="${ctx}/admin/menu?menuId=${menu.menuId}">${menu.menuName}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div> 



