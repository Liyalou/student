<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="col-sm-12 center">
    <strong style="font-size:24px">添加学生</strong>
</div>
<div class="form-group" >
    <form id="studentRecord_form" role="form" method="post" action="${ctx}/admin/studentRecord/submitStudent" class="form-horizontal ">
        <input type="hidden" name="studentRecordId" value="${studentRecord.studentRecordId}" />
        <input type="hidden" name="studentUserId" value="${studentRecord.studentUserId}" />
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <tr class="form-group" >
            	<td>班级名称</td>
                <td>                
                    <select class="form-control" name="studentClassId" id="studentClassId">
                    	<option value="">请选择</option>
                        <c:forEach items="${classList}" var="pro">
                            <option <c:if test='${studentRecord.studentClassId==pro.schoolClassId}'>selected='selected'</c:if> value="${pro.schoolClassId}" studentClassName='${pro.schoolClassName}'>${pro.schoolClassName}</option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="studentClassName" id="studentClassName" />
                </td>
                <td>姓名</td>
                <td>                    
                    <input type="text" class="form-control" name="studentRecordName" value="${studentRecord.studentRecordName}" />
                </td>
                <td>性别</td>
                <td>
                    <select name="studentRecordSex" class="form-control">
                        <option <c:if test='${studentRecord.studentRecordSex==男}'></c:if> value="男">男</option>
                        <option <c:if test='${studentRecord.studentRecordSex==女}'></c:if> value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr class="form-group">
                <td>身高(cm)</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>3)value=value.slice(0,3)' name="studentRecordHeight" value="${studentRecord.studentRecordHeight}" />
                </td>
                <td>出生年月</td>
                <td>
                    <input type="date" class="form-control" name="studentBirthYears" value="${studentRecord.studentBirthYears}" />
                </td>
                <td>身份证</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>18)value=value.slice(0,18)'  name="studentIdCard" value="${studentRecord.studentIdCard}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>籍贯</td>
                <td>
                    <input class="form-control" type="text" name="studentNativePlace" value="${studentRecord.studentNativePlace}" />
                </td>
                <td>民族</td>
                <td>
                    <input type="text" class="form-control" maxlength="10" name="studentRecordNation" value="${studentRecord.studentRecordNation}" />
                </td>
                <td>联系电话</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>11)value=value.slice(0,11)'  name="studentPhone" value="${studentRecord.studentPhone}" />
                </td>
                
            </tr>
            <tr class="form-group">
                <td>家长联系电话</td>
                <td>
                    <input type="number" class="form-control"  oninput='if(value.length>11)value=value.slice(0,11)' name="studentPatriarchPhone" value="${studentRecord.studentPatriarchPhone}" />
                </td>
                <td>家庭住址</td>
                <td colspan="3">
                    <input class="form-control" type="text" name="studentFamilyAddress" value="${studentRecord.studentFamilyAddress}" />
                </td>                
            </tr>     
            <tr class="form-group" >
                <td>个人简介</td>
                <td colspan="5">
                    <textarea name="studentRemark" style="overflow:scroll" class="form-control">${studentRecord.studentRemark}</textarea>
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