<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="col-sm-12 center">
    <strong style="font-size:24px">班级详情</strong>
</div>
<div class="form-group" >
	<c:if test="${not empty alertType}">
		<div class="alert alert-${alertType}">
			<button type="button" class="close" data-dismiss="alert">×</button>
			<strong>提示:</strong>${alertMsg}
		</div>
	</c:if>
    <form id="schoolClass_form" role="form" method="post" action="${ctx}/admin/schoolClass/submitSchoolClass" class="form-horizontal ">
        <input type="hidden"  name="schoolClassId" value="${schoolClass.schoolClassId}" />
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <tr class="form-group" >
                <td>年级</td>
                <td>                    
                    <input type="text" class="form-control" readonly name="schoolGradeNumber" value="${schoolClass.schoolGradeNumber}" />
                </td>
                <td>班级</td>
                <td>
                    <input type="text" class="form-control"  readonly name="schoolClassNumber" value="${schoolClass.schoolClassNumber}" />
                </td>
                <td>专业</td>
                <td>
                    <input type="text" class="form-control" readonly name="classSpecialty" value="${schoolClass.classSpecialty}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>班级名称</td>
                <td>
                    <input class="form-control" type="text" readonly name="schoolClassName" value="${schoolClass.schoolClassName}" />
                </td>
                <td>人数</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>6)value=value.slice(0,6)'  readonly name="classStudentNumber" value="${schoolClass.classStudentNumber}" />
                </td>
                <td>培训方案</td>
                <td>
                    <input type="text" class="form-control"  readonly name="classTrainScheme" value="${schoolClass.classTrainScheme}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>毕业时间</td>
                <td>
                    <input class="form-control" type="text"  readonly name="classGraduationTime" value="${schoolClass.classGraduationTime}" />
                </td>            
            </tr>
        </table>
        <c:if test="${not empty teacherList}">
        	<h5>任课老师</h5>
        	<table id="teacherTable" class="table table-bordered table-hover">
	            <thead>
	                <tr>
	                    <th style = "text-align: center;">姓名</th>
	                    <th style = "text-align: center;">性别</th>
	                    <th style = "text-align: center;">身份号</th>
	                    <th style = "text-align: center;">联系电话</th>
	                    <th style = "text-align: center;">职位</th>
	                    <th style = "text-align: center;">操作</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach items="${teacherList}" var="teacher">
	                    <tr>
	                        <td>${teacher.teachTeacherName}</td>
	                        <td>${teacher.teachTeacherSex}</td>
	                        <td>${teacher.teachTeacherIdCard}</td>
	                        <td>${teacher.teachTeacherPhone}</td>
	                        <td>${teacher.teachTeacherPost}</td>
	                        <td>
	                        	<a href="javaScript:void(0);" schoolClassId=${schoolClass.schoolClassId} teacherId=${teacher.teacherUserId} id="deleteTeacherForClass">删除</a>
	                        </td>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
        </c:if>
        
        <div class="modal-footer">
            <div class="col-md-offset-8 col-md-4">               
                <button class="btn btn-sm btn-primary btn-grey" onclick="window.location.reload()" type="button" id="btn_close">
                    关闭
                </button>
            </div>
        </div>
    </form>     
</div>
<script type="text/javascript" >
    $(document).ready(function() {
        Tables.loadPage();    
    });
</script>