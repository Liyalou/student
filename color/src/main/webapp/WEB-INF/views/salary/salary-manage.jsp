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
						<input type="text" id="userName" class="form-control" placeholder="学生名字模糊查询">
					</div> 
					<div class="col-xs-3">		
						<button type="button" id="search_SalaryManage" class="btn btn-info btn-sm"><i class="ace-icon glyphicon glyphicon-search"></i> 查询</button>
						<button type="button" onclick="window.location.reload()" class="btn btn-success btn-sm"><i class="icon glyphicon glyphicon-repeat"></i> 显示全部</button>						
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<button  id="add_SalaryManage"  class="btn btn-success btn-sm" type="button"><i class="ace-icon glyphicon glyphicon-plus bigger-110"></i>新增考勤管理</button>				
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
					<th style = "text-align: center;">班级名称</th>
					<th style = "text-align: center;">学生姓名</th>
					<th style = "text-align: center;">考勤时间</th>
					<th style = "text-align: center;">节次</th>
					<th style = "text-align: center;">课程名称</th>
					<th style = "text-align: center;">教室地址</th>
					<th style = "text-align: center;">考勤状态</th>
					<th style = "text-align: center;">任课老师</th>
					<th style = "text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="SalaryManage">
					<tr>
						<td>${SalaryManage.salaryClassName}</td>
						<td>${SalaryManage.studentUserName}</td>
						<td>${SalaryManage.salaryTime}</td>
						<td>${SalaryManage.salaryClassNumber}</td>
						<td>${SalaryManage.salaryCourseName}</td>
						<td>${SalaryManage.salaryClassAddress}</td>
						<td>
							<c:if test="${SalaryManage.salaryStatus == 1}">
								迟到
							</c:if>
							<c:if test="${SalaryManage.salaryStatus == 2}">
								请假
							</c:if>
							<c:if test="${SalaryManage.salaryStatus == 3}">
								旷课
							</c:if>
						</td>
						<td>${SalaryManage.teacherUserName}</td>
						<td><a href="${ctx}/admin/salaryManage/deleteSalaryManage?salaryManageId=${SalaryManage.salaryManageId}">删除</a>&nbsp;
						<a _id="${SalaryManage.salaryManageId}" class="modifySalaryManage" >修改</a>&nbsp;<a _id="${SalaryManage.salaryManageId}" class="infoSalaryManage" >详情</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>




