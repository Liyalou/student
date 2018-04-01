<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="col-sm-12 center">
    <strong style="font-size:24px">添加班级</strong>
</div>
<div class="form-group" >
    <form id="schoolClass_form" role="form" method="post" action="${ctx}/admin/schoolClass/submitSchoolClass" class="form-horizontal ">
        <input type="hidden" name="schoolClassId" value="${schoolClass.schoolClassId}"/>
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <tr class="form-group" >
            	<td>辅导员</td>
            	<td>                    
                    <select class="form-control" name="classInstructorUid" id="classInstructorUid">
                    	<option value="">请选择</option>
                        <c:forEach items="${teacherList}" var="pro">
                            <option <c:if test='${schoolClass.classInstructorUid==pro.userId}'>selected='selected'</c:if> value="${pro.userId}" userName="${pro.userName}">${pro.userName}</option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="classInstructorUname" id="classInstructorUname" />
                </td>
                <td>年级</td>
                <td>                    
                    <input type="text" class="form-control" name="schoolGradeNumber" value="${schoolClass.schoolGradeNumber}" />
                </td>
                <td>班级</td>
                <td>
                    <input type="text" class="form-control"  name="schoolClassNumber" value="${schoolClass.schoolClassNumber}" />
                </td>
                
            </tr>
            <tr class="form-group">
                <td>专业</td>
                <td>
                    <input type="text" class="form-control" name="classSpecialty" value="${schoolClass.classSpecialty}" />
                </td>
                <td>人数</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>6)value=value.slice(0,6)'  name="classStudentNumber" value="${schoolClass.classStudentNumber}" />
                </td>
                <td>培训方案</td>
                <td>
                    <input type="text" class="form-control"  name="classTrainScheme" value="${schoolClass.classTrainScheme}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>毕业时间</td>
                <td>
                    <input class="form-control" type="date"  name="classGraduationTime" value="${schoolClass.classGraduationTime}" />
                </td> 
                <td colspan="5"></td>
                         
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
