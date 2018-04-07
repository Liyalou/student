<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="col-sm-12 center">
    <strong style="font-size:24px">请假待办详情</strong>
</div>
<div class="form-group" >
    <table style="border:none" id="simple-table" class="table table-bordered table-hover" >
        <tr class="form-group">
            <td>请假类型</td>
            <td>
            <c:if test='${studentVacate.vacateType==1}'>
    			<input type="text" class="form-control"  readonly  value="节数" />        
            </c:if>
            <c:if test='${studentVacate.vacateType==2}'>
    			<input type="text" class="form-control"  readonly  value="天数" />         
            </c:if>
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
        	<c:if test="${waitDealState == 0 }">
        		<button class="btn btn-sm btn-primary" onclick="" type="button" >
	                	同意
	            </button>
	            <!-- 
	            	审批同意，进入弹窗页面，然后选择请假通知的老师：
	            		进入弹窗页面，
	            			请求参数：
	            		 		待办ID：waitDealId
	            		 		班级ID：schoolClassId
	            		 	请求路径：/admin/waitDeal/selectTeacher
	            		审批提交： 
	            		 	请求参数：
	            			 	待办ID：waitDealId
	            			 	审批结果：waitReplyResult（1同意，2不同意）
	            			 	老师teacherUserId
	            			请求路径：/admin/waitDeal/submitVacateApply
	            -->
	            <input type="hidden" name="waitDealId" value="${waitDealId}" /><!-- 待办ID -->
	            <input type="hidden" name="studentClassId" value="${studentVacate.studentClassId}" /><!-- 班级ID -->
	            <button class="btn btn-sm btn-primary btn-grey" onclick="" type="button" >
	                	不同意
	            </button>
	            <!-- 
	            	审批不同意，
	            		请求参数：
	            			 待办ID：waitDealId
	            			 审批结果：waitReplyResult（1同意，2不同意）
	            		请求路径：/admin/waitDeal/submitVacateApply
	            -->
        	</c:if>    
            <button class="btn btn-sm btn-primary btn-grey" onclick="window.location.reload()" type="button" id="btn_close">
               	 关闭
            </button>
        </div>
    </div>
</div>
<script type="text/javascript" >
    $(document).ready(function() {
        Tables.loadPage();           
    });
</script>
         