<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal">
				<div class="form-group">
					<div class="col-xs-2">
						<div class="input-group">
							<input type="text" id="starCreateTime" class="form-control" placeholder="开始时间"/>
							<span class="input-group-addon">
								<i class="ace-icon fa fa-calendar"></i> &nbsp;至
							</span>
						</div>
					</div> 
					<div class="col-xs-2">
						<div class="input-group">
							<input type="text" id="endCreateTime" class="form-control" placeholder="结束时间"/>
							<span class="input-group-addon">
								<i class="ace-icon fa fa-calendar"></i>&nbsp; 结束
							</span>
						</div>
					</div>
					<div class="col-lg-2">
						<input type="text" class="form-control" id ="studentUserName" placeholder="学生姓名">
					</div> 					
					<div class="col-xs-3">		
						<button type="button" class="btn btn-info btn-sm" id="search_salary"><i class="ace-icon glyphicon glyphicon-search"></i> 查询</button>
						<button type="button" class="btn btn-success btn-sm" onclick="window.location.reload()"><i class="icon glyphicon glyphicon-repeat"></i> 显示全部</button>
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
    	<div class="row" >
		<div class="col-xs-2">
			<label  class="col-xs-4 control-label  no-padding-right">迟到/次：</label>
			<div class="col-xs-8">
				${salaryStatus1}
			</div>
		</div>
		<div class="col-xs-2">
			<label  class="col-xs-5 control-label  no-padding-right">请假/次：</label>
			<div class="col-xs-7">
				${salaryStatus2}
			</div>
		</div>
		<div class="col-xs-2">
			<label  class="col-xs-5 control-label  no-padding-right">旷课/次：</label>
			<div class="col-xs-7">
				${salaryStatus3}
			</div>
		</div>
	</div>
    
	<div class="well table-responsive" style="background-color: white;">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th style = "text-align: center;">创建时间</th>
					<th style = "text-align: center;">学生姓名</th>
					<th style = "text-align: center;">班级名称</th>
					<th style = "text-align: center;">考勤时间</th>
					<th style = "text-align: center;">节次</th>
					<th style = "text-align: center;">课程名称</th>
					<th style = "text-align: center;">教室地址</th>
					<th style = "text-align: center;">考勤状态</th>
					<th style = "text-align: center;">任课老师</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="SalaryManage">
					<tr>
						<td>${SalaryManage.salaryCreateTime}</td>
						<td>${SalaryManage.studentUserName}</td>
						<td>${SalaryManage.salaryClassName}</td>
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
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>
<script type="text/javascript" >
    $(document).ready(function() {
        Tables.loadPage();           
    });
</script>



