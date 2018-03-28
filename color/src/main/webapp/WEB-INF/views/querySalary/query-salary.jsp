<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<script src="${pageContext.request.contextPath}/static/js/role/role.js"></script>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal">
				<div class="form-group">
					<div class="col-xs-2">
						<div class="input-group">
							<input type="text" name="starCreateTime" class="form-control" placeholder="开始时间"/>
							<span class="input-group-addon">
								<i class="ace-icon fa fa-calendar"></i> &nbsp;至
							</span>
						</div>
					</div> 
					<div class="col-xs-2">
						<div class="input-group">
							<input type="text" name="endCreateTime" class="form-control" placeholder="结束时间"/>
							<span class="input-group-addon">
								<i class="ace-icon fa fa-calendar"></i>&nbsp; 结束
							</span>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="模糊查询">
						</div>
					</div> 
					<div class="col-xs-3">		
						<button type="button" class="btn btn-info btn-sm"><i class="ace-icon glyphicon glyphicon-search"></i> 查询</button>
						<button type="button" class="btn btn-success btn-sm"><i class="icon glyphicon glyphicon-repeat"></i> 显示全部</button>
						<button class="btn btn-success btn-sm" type="button" id="roleAdd"><i class="ace-icon glyphicon glyphicon-plus"></i>添加 </button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="hr hr10 hr-dotted"></div>
	<c:if test="${alertMsg}">
		<div class="alert alert-${alertType}">
			<button type="button" class="close" data-dismiss="alert">×</button>
			<strong>提示:</strong>${alertMsg}
		</div>
	</c:if>
	<div class="well table-responsive" style="background-color: white;">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style = "text-align: center;">姓名(考勤统计)</th>
					<th style = "text-align: center;">性别</th>
					<th style = "text-align: center;">籍贯</th>
					<th style = "text-align: center;">身份号</th>
					<th style = "text-align: center;">班级</th>
					<th style = "text-align: center;">联系电话</th>
					<th style = "text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="student">
					<tr>
						<td>${student.studentRecordName}</td>
						<td>${student.studentRecordSex}</td>
						<td>${student.studentNativePlace}</td>
						<td>${student.studentIdCard}</td>
						<td>${student.studentClassName}</td>
						<td>${student.studentPatriarchPhone}</td>
						<td><a>删除</a>&nbsp;<a>修改</a>&nbsp;<a>考勤</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>




