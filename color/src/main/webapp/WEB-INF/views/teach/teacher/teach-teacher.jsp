<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/static/js/role/role.js"></script>
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
					<th style = "text-align: center;">姓名（老师管理）</th>
					<th style = "text-align: center;">性别</th>
					<th style = "text-align: center;">年龄</th>
					<th style = "text-align: center;">身份号</th>
					<th style = "text-align: center;">职位</th>
					<th style = "text-align: center;">联系电话</th>
					<th style = "text-align: center;">住址</th>
					<th style = "text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="teacher">
					<tr>
						<td>${teacher.teachTeacherName}</td>
						<td>${teacher.teachTeacherSex}</td>
						<td>${teacher.teachTeacherAge}</td>
						<td>${teacher.teachTeacherIdCard}</td>
						<td>${teacher.teachTeacherPost}</td>
						<td>${teacher.teachTeacherPhone}</td>
						<td>${teacher.teachTeacherAddress}</td>
						<td><a href="${ctx}/admin/teachTeacher/deleteTeacher?teachTeacherId=${teacher.teachTeacherId}">删除</a>&nbsp;
						<a _id="${teacher.teachTeacherId}" class="modifyTeacher" >修改</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	    <jsp:include page="/WEB-INF/views/common/pagination.jsp"/>
	</div>
</div>
<!-- /**教务老师档案id*/                         
private String teachTeacherId;        
                                      
/**userid*/                           
private String teacherUserId;         
                                      
/**姓名*/                               
private String teachTeacherName;      
                                      
/**性别*/                               
private String ;       
                                      
/**年龄*/                               
private Integer teachTeacherAge;      
                                      
/**民族*/                               
private String teachTeacherNation;    
                                      
/**身份证号码*/                            
private String teachTeacherIdCard;    
                                      
/**学历*/                               
private String teachTeacherDiploma;   
                                      
/**教龄*/                               
private String teachSchoolAge;        
                                      
/**职位*/                               
private String teachTeacherPost;      
                                      
/**联系电话*/                             
private String teachTeacherPhone;     
                                      
/**住址*/                               
private String teachTeacherAddress;   --> 