<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal">
				<div class="form-group">					
					<div class="col-lg-2">						
						<input type="text" id="teacerName" class="form-control" placeholder="教务人名模糊查询">						
					</div> 
					<div class="col-xs-3">		
						<button type="button" id="search_teacher" class="btn btn-info btn-sm"><i class="ace-icon glyphicon glyphicon-search"></i> 查询</button>
						<button type="button" onclick="window.location.reload()"  class="btn btn-success btn-sm"><i class="icon glyphicon glyphicon-repeat"></i> 显示全部</button>						
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<button  id="add_teacher"  class="btn btn-success btn-sm" type="button"><i class="ace-icon glyphicon glyphicon-plus bigger-110"></i>添加教务人员</button>				
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="hr hr10 hr-dotted"></div>
	<c:if test="${not empty alertType}">
		<div class="alert alert-${alertType}">
			<button type="button" class="close" data-dismiss="alert">×</button>
			<strong>提示:</strong>${alertMsg}
		</div>
	</c:if>
	<div class="well table-responsive" style="background-color: white;">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style = "text-align: center;">姓名</th>
					<th style = "text-align: center;">性别</th>
					<th style = "text-align: center;">身份号</th>
					<th style = "text-align: center;">联系电话</th>
					<th style = "text-align: center;">角色</th>
					<th style = "text-align: center;">职位</th>
					<th style = "text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="teacher">
					<tr>
						<td>${teacher.teachTeacherName}</td>
						<td>${teacher.teachTeacherSex}</td>
						<td>${teacher.teachTeacherIdCard}</td>
						<td>${teacher.teachTeacherPhone}</td>
						<td>
							<c:if test="${teacher.userType==2}">
                				教务管理员
                			</c:if>
                			<c:if test="${teacher.userType==3}">
                				辅导员
                			</c:if>
                			<c:if test="${teacher.userType==4}">
                				任课老师
                			</c:if>
                			<td>${teacher.teachTeacherPost}</td>
						</td>
						<td><a href="${ctx}/admin/teachTeacher/deleteTeacher?teachTeacherId=${teacher.teachTeacherId}">删除</a>&nbsp;
						<a _id="${teacher.teachTeacherId}" class="modifyTeacher" >修改</a>&nbsp;<a _id="${teacher.teachTeacherId}" class="infoTeacher" >详情</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>