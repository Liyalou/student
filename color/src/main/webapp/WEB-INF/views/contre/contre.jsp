<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<style>
	.msg td{border-top:none}
	label{font-size:12px;color:gray}
	label{font-size:12px}
	.table .righttd{width:100px;text-align:right}
	.table .lefttd{text-align:left}
</style>
<div class="page-content">
	<div class="block">
		<a href="javascript:void(0)" class="block-heading" data-toggle="collapse">个人信息</a>
		<div id="page-stats" class="block-body collapse in">
			<table class="table msg" >
				<tr>
					<td class="righttd"><label>登录账号：</label></td>
					<td class="lefttd">${user.userAccount }</td>
					<td class="righttd"><label>真实姓名：</label></td>
					<td class="lefttd">${user.userName }</td>
				</tr>
				<tr>
					<td class="righttd"><label>身份证号码：</label></td>
					<td class="lefttd">${user.userIdCard }</td>
					<td class="righttd"><label>手机号码：</label></td>
					<td class="lefttd">${user.userPhone }</td>
				</tr>
				<tr>
					<td class="righttd"><label>注册时间：</label></td>
					<td class="lefttd">${user.userCreateTime }</td>
					<td class="righttd"><label>最后登录时间：</label></td>
					<td class="lefttd">${user.userLastLoginTime }</td>
				</tr>
				<tr>
					<td class="righttd"><label>角色：</label></td>
					<td class="lefttd">
						<c:if test="${user.userType ==1 }">
							系统管理员
						</c:if>
						<c:if test="${user.userType ==2 }">
							教务管理员
						</c:if>
						<c:if test="${user.userType ==3 }">
							辅导员
						</c:if>
						<c:if test="${user.userType ==4 }">
							任课老师
						</c:if>
						<c:if test="${user.userType ==5 }">
							学生
						</c:if>
		          	</td>
				</tr>
			</table>
		</div>
	</div>
</div>



