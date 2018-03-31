<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="form-group" >
    <form id="schoolClass_form" role="form" method="post" action="${ctx}/admin/schoolClass/submitSchoolClass" class="form-horizontal ">
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <input type="hidden"  name="schoolClassId" value="${schoolClass.schoolClassId}" />
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
        <div class="modal-footer">
            <div class="col-md-offset-8 col-md-4">               
                <button class="btn btn-sm btn-primary btn-grey" onclick="window.location.reload()" type="button" id="btn_close">
                    关闭
                </button>
            </div>
        </div>
    </form>     
</div>