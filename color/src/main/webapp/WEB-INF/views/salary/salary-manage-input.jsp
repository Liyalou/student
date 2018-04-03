<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="col-sm-12 center">
    <strong style="font-size:24px">考勤管理</strong>
</div>
<div class="form-group" >
    <form id="teachTeacher_form" role="form" method="post" action="${ctx}/admin/salaryManage/submitSalaryManage" class="form-horizontal ">
        <input type="hidden" name="salaryManageId" value="${salaryManage.salaryManageId}" />
        <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
            <tr class="form-group" >
                <td>班级名称</td>
                <td>
                    <select name="salaryClassId" id="salaryClassId" class="form-control">
                        <c:forEach items='${classList}' var='pro'>
                            <option <c:if test="${salaryManage.salaryClassId==pro.schoolClassId}">selected='selected'</c:if> value="${pro.schoolClassId}">${pro.schoolClassName}</option>                            
                        </c:forEach>
                    </select>
                    <c:choose >
                        <c:when test='${empty salaryManage.salaryManageId}'>
                            <input type="hidden" name="salaryClassName" id="salaryClassName" value="${classList[0].schoolClassName}" />
                        </c:when>
                        <c:otherwise>
                             <input type="hidden" name="salaryClassName" id="salaryClassName" value="${salaryManage.salaryClassName}" />
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>学生名称</td>
                <td>                    
                    <select class="form-control" name="studentUserId"  id="studentUserId">                        
                        <c:choose >
                            <c:when test='${not empty salaryManage.salaryManageId}'>
                                <option value="${salaryManage.studentUserId}">${salaryManage.studentUserName}</option>
                            </c:when>
                            <c:otherwise>
                                 <option value="">选择班级之后选择</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                    <input type="hidden"  name="studentUserName" id="studentUserName" value="${salaryManage.studentUserName}" />
                </td>
                <td>考勤时间</td>
                <td>                    
                    <input type="text" required="required" class="form-control" name="salaryTime" id="salaryTime" value="${salaryManage.salaryTime}" />
                </td>
            </tr>
            <tr class="form-group">
                <td>节次</td>
                <td>                    
                    <input type="number" class="form-control" name="salaryClassNumber"  value="${salaryManage.salaryClassNumber}" />
                </td>
                <td>课程名称</td>
                <td >
                    <input class="form-control" type="text"  name="salaryCourseName" value="${salaryManage.salaryCourseName}" />
                </td>         
                <td>考勤状态</td>
                <td >
                    <select name="salaryStatus" class="form-control" >
                        <option <c:if test='${salaryManage.salaryStatus==1}'>selected='selected'</c:if> value="1">迟到</option>
                        <option <c:if test='${salaryManage.salaryStatus==2}'>selected='selected'</c:if> value="2">请假</option>
                        <option <c:if test='${salaryManage.salaryStatus==3}'>selected='selected'</c:if> value="3">旷课</option>
                    </select>
                </td>           
            </tr>  
            <tr class="form-group">
                <td>教室地址</td>
                <td colspan="5">                    
                    <input type="text" class="form-control" name="salaryClassAddress" id='salaryClassAddress' value="${salaryManage.salaryClassAddress}" />
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
        $( "#salaryTime" ).datepicker({
            format:"yyyy-mm-dd",
            showOtherMonths: true,
            selectOtherMonths: true,
            autoclose:true,
            todayHighlight:true,
        });
    });
</script>
<!-- /**考勤管理id*/                       
private String salaryManageId;    
/**学生id*/                         
private String studentUserId;     
/**学生姓名*/                         
private String studentUserName;   
/**班级ID*/                         
private String salaryClassId;     
/**班级名称*/                         
private String salaryClassName;   
/**考勤时间*/                         
private String salaryTime;        
/**节次*/                           
private Double salaryClassNumber; 
/**课程名称*/                         
private String salaryCourseName;  
/**教室地址*/                         
private String salaryClassAddress;
/**考勤状态：1迟到，2请假、3旷课*/             
private String salaryStatus;      
/**任课老师ID*/                       
private String teacherUserId;     
/**任课老师*/                         
private String teacherUserName;    -->