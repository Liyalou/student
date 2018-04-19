<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="col-sm-12 center">
    <strong style="font-size:24px">添加教务老师</strong>
</div>
<div class="form-group" >
    <form id="teachTeacher_form" role="form" method="post" action="${ctx}/admin/teachTeacher/submitTeacher" class="form-horizontal ">
        <input type="hidden" name="teachTeacherId" value="${teachTeacher.teachTeacherId}" />
        <input type="hidden" name="teacherUserId" value="${teachTeacher.teacherUserId}" />
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <tr class="form-group" >
                <td>教务人员类型</td>
                <td>
                	<c:choose>
                		<c:when test="${not empty teachTeacher.teachTeacherId}">
                			<c:if test="${teacherType==2}">
                				<input type="text" class="form-control" readonly  value="教务管理员" />
                			</c:if>
                			<c:if test="${teacherType==3}">
                				<input type="text" class="form-control" readonly  value="辅导员" />
                			</c:if>
                			<c:if test="${teacherType==4}">
                				<input type="text" class="form-control" readonly  value="任课老师" />
                			</c:if>
                		</c:when>
                		<c:otherwise>
		                	<select name="roleCode" class="form-control">
		                    	<option value="">请选择</option>
		                    	<c:if test="${userType == 1 }">
		                    		<option value="role_teach">教务管理员</option>
		                    	</c:if>
		                    	<c:if test="${userType == 2 }">
		                        	<option value="role_instructor">辅导员</option>
		                        	<option value="role_teacher">任课老师</option>
		                    	</c:if>
		                    </select>
	                	</c:otherwise>
                	</c:choose>
                </td>
                <td>姓名</td>
                <td>
                    <input type="text" class="form-control" maxlength="7" name="teachTeacherName" value="${teachTeacher.teachTeacherName}" />
                </td>
                <td>性别</td>
                <td>
                    <select name="teachTeacherSex" class="form-control" >
                        <option <c:if test='${teachTeacher.teachTeacherSex==男}'></c:if> value="男">男</option>
                        <option <c:if test='${teachTeacher.teachTeacherSex==女}'></c:if> value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr class="form-group">
                <td>年龄</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>2)value=value.slice(0,2)' name="teachTeacherAge" value="${teachTeacher.teachTeacherAge}" />
                </td>
                <td>民族</td>
                <td>
                    <input class="form-control" type="text" maxlength="4" name="teachTeacherNation" value="${teachTeacher.teachTeacherNation}" />
                </td>
                <td>身份证号码</td>
                <td>
                    <input type="number" class="form-control" oninput='if(value.length>18)value=value.slice(0,18)' name="teachTeacherIdCard" value="${teachTeacher.teachTeacherIdCard}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>学历</td>
                <td>
                    <input class="form-control" type="text"  name="teachTeacherDiploma" value="${teachTeacher.teachTeacherDiploma}" />
                </td>
                <td>教龄</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>2)value=value.slice(0,2)' name="teachSchoolAge" value="${teachTeacher.teachSchoolAge}" />
                </td>
                <td>职位</td>
                <td>
                    <input type="text" class="form-control"  name="teachTeacherPost" value="${teachTeacher.teachTeacherPost}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>联系电话</td>
                <td>
                    <input type="number" class="form-control" oninput='if(value.length>11)value=value.slice(0,11)' name="teachTeacherPhone"  value="${teachTeacher.teachTeacherPhone}"/>
                </td>
                <td>住址</td>
                <td colspan="3">
                    <input type="text" class="form-control" maxlength="50" name="teachTeacherAddress" value="${teachTeacher.teachTeacherAddress}" />
                </td>
            </tr>
        </table>
        <div class="modal-footer">
            <div class="col-md-offset-8 col-md-4">                
                <button class="btn btn-sm btn-primary" type="submit" id="save">
                    <i class="icon-ok bigger-110"></i>
                    保存
                </button>
                &nbsp; &nbsp; &nbsp;
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