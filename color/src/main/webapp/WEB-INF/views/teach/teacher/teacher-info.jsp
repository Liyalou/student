<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="form-group" >
    <form id="teachTeacher_form" role="form" method="post" action="${ctx}/admin/teachTeacher/submitTeacher" class="form-horizontal ">
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <input type="hidden"  name="teachTeacherId" value="${teachTeacher.teachTeacherId}" />
            <tr class="form-group" >
                <td>教务人员类型</td>
                <td>
                    <select readonly name="roleCode" class="form-control">
                        <option value="role_teacher">任课老师</option>
                        <option value="role_instructor">辅导员</option>
                    </select>
                </td>
                <td>姓名</td>
                <td>
                    <input type="text" class="form-control" maxlength="7" readonly name="teachTeacherName" value="${teachTeacher.teachTeacherName}" />
                </td>
                <td>性别</td>
                <td>
                    <select readonly name="teachTeacherSex" class="form-control" >
                        <option <c:if test='${teachTeacher.teachTeacherSex==男}'></c:if> value="男">男</option>
                        <option <c:if test='${teachTeacher.teachTeacherSex==女}'></c:if> value="女">女</option>
                    </select>
                </td>
            </tr>
            <tr class="form-group">
                <td>年龄</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>2)value=value.slice(0,2)' readonly name="teachTeacherAge" value="${teachTeacher.teachTeacherAge}" />
                </td>
                <td>民族</td>
                <td>
                    <input class="form-control" type="text" maxlength="4" readonly name="teachTeacherNation" value="${teachTeacher.teachTeacherNation}" />
                </td>
                <td>身份证号码</td>
                <td>
                    <input type="number" class="form-control" oninput='if(value.length>18)value=value.slice(0,18)' readonly name="teachTeacherIdCard" value="${teachTeacher.teachTeacherIdCard}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>学历</td>
                <td>
                    <input class="form-control" type="text"  readonly name="teachTeacherDiploma" value="${teachTeacher.teachTeacherDiploma}" />
                </td>
                <td>教龄</td>
                <td>
                    <input class="form-control" type="number" oninput='if(value.length>2)value=value.slice(0,2)' readonly name="teachSchoolAge" value="${teachTeacher.teachSchoolAge}" />
                </td>
                <td>职位</td>
                <td>
                    <input type="text" class="form-control"  readonly name="teachTeacherPost" value="${teachTeacher.teachTeacherPost}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>联系电话</td>
                <td>
                    <input type="number" class="form-control" oninput='if(value.length>11)value=value.slice(0,11)' readonly name="teachTeacherPhone"  value="${teachTeacher.teachTeacherPhone}"/>
                </td>
                <td>住址</td>
                <td colspan="3">
                    <input type="text" class="form-control" maxlength="50" readonly name="teachTeacherAddress" value="${teachTeacher.teachTeacherAddress}" />
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