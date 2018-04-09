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
						<input type="text" id="teacerName" class="form-control" placeholder="辅导员模糊查询">
					</div> 
					<div class="col-xs-3">		
						<button type="button" id="search_teacher" class="btn btn-info btn-sm"><i class="ace-icon glyphicon glyphicon-search"></i> 查询</button>
						<button type="button" onclick="window.location.reload()" class="btn btn-success btn-sm"><i class="icon glyphicon glyphicon-repeat"></i> 显示全部</button>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<button  id="add_class"  class="btn btn-success btn-sm" type="button"><i class="ace-icon glyphicon glyphicon-plus bigger-110"></i>添加班级</button>				
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
					<th style = "text-align: center;">年级</th>
					<th style = "text-align: center;">班级</th>
					<th style = "text-align: center;">专业</th>
					<th style = "text-align: center;">班级名称</th>
					<th style = "text-align: center;">人数</th>
					<th style = "text-align: center;">培训方案</th>
					<th style = "text-align: center;">毕业时间</th>
					<th style = "text-align: center;">辅导员</th>
					<th style = "text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="schoolClass">
					<tr>
						<td>${schoolClass.schoolGradeNumber}</td>
						<td>${schoolClass.schoolClassNumber}</td>
						<td>${schoolClass.classSpecialty}</td>
						<td>${schoolClass.schoolClassName}</td>
						<td>${schoolClass.classStudentNumber}</td>
						<td>${schoolClass.classTrainScheme}</td>
						<td>${schoolClass.classGraduationTime}</td>
						<td>${schoolClass.classInstructorUname}</td>
						<td>
							<a href="${ctx}/admin/schoolClass/deleteSchoolClass?schoolClassId=${schoolClass.schoolClassId}">删除</a>&nbsp;
							<a _id="${schoolClass.schoolClassId}" class="modifyClass" href="javaScript:void(0);">修改</a>&nbsp;
							<a _id="${schoolClass.schoolClassId}" class="infoClass" href="javaScript:void(0);">详情</a>&nbsp;
							<a _id="${schoolClass.schoolClassId}" class="setTeacher" href="javaScript:void(0);" title="分配任课老师">分配</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>
<div id="teacherList-input" class="modal"  data-show="false" data-backdrop='static'></div>
