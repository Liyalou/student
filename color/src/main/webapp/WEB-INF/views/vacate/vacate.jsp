<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal">
				<div class="form-group">					
					<div class="col-lg-2">
						<input type="text" id="studentName" class="form-control" placeholder="学生姓名模糊查询">
					</div> 
					<div class="col-xs-3">		
						<button type="button" id="search_student" class="btn btn-info btn-sm"><i class="ace-icon glyphicon glyphicon-search"></i> 查询</button>
						<button type="button" onclick="window.location.reload()" class="btn btn-success btn-sm"><i class="icon glyphicon glyphicon-repeat"></i> 显示全部</button>						
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<button  id="add_vacation"  class="btn btn-success btn-sm" type="button"><i class="ace-icon glyphicon glyphicon-plus bigger-110"></i>请假申请</button>				
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
					<th style = "text-align: center;">姓名（请假申请）</th>
					<th style = "text-align: center;">班级</th>
					<th style = "text-align: center;">辅导员</th>
					<th style = "text-align: center;">请假类型</th>
					<th style = "text-align: center;">节次/天数</th>
					<th style = "text-align: center;">请假开始时间</th>
					<th style = "text-align: center;">请假结束时间</th>
					<th style = "text-align: center;">课时名称</th>
					<th style = "text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="vacation">
					<tr>
						<td>${vacation.vacateUserName}</td>
						<td>${vacation.vacateUserClass}</td>
						<td>${vacation.studentInstructorUname}</td>
						<td>${vacation.vacateType}</td>
						<td>${vacation.vacateNumber}</td>
						<td>${vacation.vacateStartTime}</td>
						<td>${vacation.vacateEndTime}</td>
						<td>${vacation.vacateCourseName}</td>
						<td><a href="${ctx}/admin/studentVacate/deleteTeacher?studentVacateId=${vacation.studentVacateId}">删除</a>&nbsp;
						<a _id="${vacation.studentVacateId}" class="modifyVacation" >修改</a>&nbsp;<a _id="${vacation.studentVacateId}" class="infoVacation" >详情</a>&nbsp;<a _id="${vacation.studentVacateId}" class="approvalVacation" >请假审批</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>



