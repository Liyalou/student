<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="form-group" >
    <form id="teachTeacher_form" role="form" method="post" action="${ctx}/admin/studentVacate/submitStudentVacate" class="form-horizontal ">
        <input type="hidden" name="studentVacateId" value="${studentVacate.studentVacateId}" />
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <tr class="form-group" >
                <td>请假类型</td>
                <td>
                    <select readonly name="vacateType"  class="form-control">
                        <option <c:if test='${studentVacate.vacateType==1}'>selected='selected'</c:if> value="1">节数</option>
                        <option <c:if test='${studentVacate.vacateType==2}'>selected='selected'</c:if> value="2">天数</option>
                    </select>
                </td>
                <td>节次/天数</td>
                <td>
                    <input type="number" class="form-control"  min='0' oninput='if(value.length>3)value=value.slice(0,3)' readonly name="vacateNumber" value="${studentVacate.vacateNumber}" />
                </td>
                <td>请假开始时间</td>
                <td>                    
                    <input type="text" class="form-control" readonly name="vacateStartTime" id="vacateStartTime" value="${studentVacate.vacateStartTime}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>请假结束时间</td>
                <td>                    
                    <input type="text" class="form-control" readonly name="vacateEndTime" id='vacateEndTime' value="${studentVacate.vacateEndTime}" />
                </td>
                <td>课时名称</td>
                <td colspan="3">
                    <input class="form-control" type="text" maxlength="100" readonly name="vacateCourseName" value="${studentVacate.vacateCourseName}" />
                </td>                
            </tr>   
            <tr class="form-group" >
                <td>请假理由</td>
                <td colspan="5">
                    <textarea readonly name="vacateReason" class="form-control">${studentVacate.vacateReason}</textarea>                 
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
<script type="text/javascript" >
    $(document).ready(function() {
        Tables.loadPage();           
    });
</script>
         