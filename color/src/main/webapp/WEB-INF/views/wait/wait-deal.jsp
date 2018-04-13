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
						<input type="text" id="studentName" class="form-control" placeholder="学生姓名">
					</div> 
					<div class="col-xs-3">		
						<button type="button" id="search_student" class="btn btn-info btn-sm"><i class="ace-icon glyphicon glyphicon-search"></i> 查询</button>
						<button type="button" onclick="window.location.reload()" class="btn btn-success btn-sm"><i class="icon glyphicon glyphicon-repeat"></i> 显示全部</button>						
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
					<th style = "text-align: center;">学生姓名</th>
					<th style = "text-align: center;">班级名称</th>
					<th style = "text-align: center;">处理状态</th>
					<th style = "text-align: center;">回复状态</th>
					<th style = "text-align: center;">申请时间</th>
					<th style = "text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="wait">
					<tr>
						<td>${wait.waitStudentUname}</td>
						<td>${wait.waitClassName}</td>
						<td>
							<c:if test="${wait.waitDealState == 0}">
								待处理
							</c:if>
							<c:if test="${wait.waitDealState == 1}">
								已处理
							</c:if>
						</td>
						<td>
							<c:if test="${wait.waitReplyResult == 1}">
								同意
							</c:if>
							<c:if test="${wait.waitReplyResult == 2}">
								不同意
							</c:if>
						</td>
						<td>${wait.waitCreateTime}</td>
						<td>
							<c:if test="${user.userType == 2}">
								<a href="javaScript:void(0);" id="${wait.waitDealId}" class="infoVacation">查看</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>
<div id="selectTeacher-input" class="modal"  data-show="false" data-backdrop='static'></div>


