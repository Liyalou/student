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
						<input type="text" id="studentUserName" class="form-control" placeholder="学生姓名">
					</div> 
					<div class="col-xs-3">		
						<button type="button" id="search_student" class="btn btn-info btn-sm"><i class="ace-icon glyphicon glyphicon-search"></i> 查询</button>
						<button type="button" onclick="window.location.reload()" class="btn btn-success btn-sm"><i class="icon glyphicon glyphicon-repeat"></i> 显示全部</button>
						<c:if test="${user.userType == 2 }">
							<button id="add_class" class="btn btn-success btn-sm" type="button" title="添加学生"><i class="ace-icon glyphicon glyphicon-plus bigger-110"></i>添加</button>
							<button id="download" class="btn btn-success btn-sm" type="button" title="下载模板"><i class="ace-icon glyphicon glyphicon-save bigger-110"></i>下载</button>
							<button id="upload" class="btn btn-success btn-sm" type="button" title="导入学生"><i class="ace-icon glyphicon glyphicon-open bigger-110"></i>导入</button>
						</c:if>
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
			<c:if test="${not empty failureStudentRecord}">
				导入失败的学生有：${failureStudentRecord}
			</c:if>
		</div>
	</c:if>
	<div class="well table-responsive" style="background-color: white;">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style = "text-align: center;">创建时间</th>
					<th style = "text-align: center;">班级名称</th>
					<th style = "text-align: center;">姓名</th>
					<th style = "text-align: center;">性别</th>
					<th style = "text-align: center;">出生年月</th>
					<th style = "text-align: center;">身高</th>
					<th style = "text-align: center;">民族</th>
					<th style = "text-align: center;">籍贯</th>
					<th style = "text-align: center;">联系电话</th>
					<th style = "text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="student">
					<tr>
						<td>${student.studentCreateTime}</td>
						<td>${student.studentClassName}</td>
						<td>${student.studentRecordName}</td>
						<td>${student.studentRecordSex}</td>
						<td>${student.studentBirthYears}</td>
						<td>${student.studentRecordHeight}</td>
						<td>${student.studentRecordNation}</td>
						<td>${student.studentNativePlace}</td>
						<td>${student.studentPhone}</td>
						<td>
						<c:if test="${user.userType == 2 }">
							<a href="${ctx}/admin/studentRecord/deleteStudent?studentRecordId=${student.studentRecordId}">删除</a>&nbsp;
							<a _id="${student.studentRecordId}" class="modifyStudent" href="javaScript:void(0);">修改</a>&nbsp;
						</c:if>
						<a _id="${student.studentRecordId}" class="infoStudent" href="javaScript:void(0);">详情</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>

<div id="uploadStudent" class="modal"  data-show="false" data-backdrop='static'></div>