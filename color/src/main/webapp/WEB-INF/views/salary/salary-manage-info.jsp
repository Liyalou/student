<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="col-sm-12 center">
    <strong style="font-size:24px">考勤管理详情</strong>
</div>
<div class="form-group" >
    <form id="teachTeacher_form" role="form" method="post" action="${ctx}/admin/salaryManage/submitSalaryManage" class="form-horizontal ">
        <input type="hidden" name="salaryManageId" value="${salaryManage.salaryManageId}" />
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <tr class="form-group" >
                <td>班级名称</td>
                <td>                    
                    <input type="text" readonly name="salaryClassName" class="form-control" value="${salaryManage.salaryClassName}" />
                </td>
                <td>学生名称</td>
                <td>                   
                    <input type="text" readonly name="studentUserName" class="form-control" value="${salaryManage.studentUserName}" />
                </td>
                <td>考勤时间</td>
                <td>                    
                    <input type="text" readonly required="required" class="form-control" name="salaryTime" id="salaryTime" value="${salaryManage.salaryTime}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>节次</td>
                <td>                    
                    <input readonly type="number" class="form-control" name="salaryClassNumber"  value="${salaryManage.salaryClassNumber}" />
                </td>
                <td>课程名称</td>
                <td >
                    <input readonly class="form-control" type="text"  name="salaryCourseName" value="${salaryManage.salaryCourseName}" />
                </td>         
                <td>考勤状态</td>
                <td >
                    <select disabled name="salaryStatus" class="form-control" >
                        <option <c:if test='${salaryManage.salaryStatus==1}'>selected='selected'</c:if> value="1">迟到</option>
                        <option <c:if test='${salaryManage.salaryStatus==2}'>selected='selected'</c:if> value="2">请假</option>
                        <option <c:if test='${salaryManage.salaryStatus==3}'>selected='selected'</c:if> value="3">旷课</option>
                    </select>
                </td>           
            </tr>  
            <tr class="form-group">
                <td>教室地址</td>
                <td colspan="5">                    
                    <input type="text" readonly class="form-control" name="salaryClassAddress" id='salaryClassAddress' value="${salaryManage.salaryClassAddress}" />
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
        $( "#salaryTime" ).datepicker({
            format:"yyyy-mm-dd",
            showOtherMonths: true,
            selectOtherMonths: true,
            autoclose:true,
            todayHighlight:true,
        });
    });
</script>