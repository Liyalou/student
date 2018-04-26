<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div style="width:40%" class="modal-dialog">
    <div class="modal-content">
        <div class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix">
            <span id="ui-id-26" class="ui-dialog-title">
                <div class="widget-header widget-header-small">
                    <h4 class="smaller">
                        <span class="icon-ok" id="input-image-title">选择通知老师</span>
                    </h4>
                </div>
            </span>
        </div>      
        <form ole="form" method="post" action="${ctx}/admin/waitDeal/submitVacateApply" class="form-horizontal ">
            <div class="well table-responsive" style="background-color: white;">
                <div class="form-group">
                    <label class="col-sm-2 center" >选择班级：</label>
                    <div class="col-sm-10" >
                        <select class="form-control" id="studentClassId" name="studentClassId" >                            
                            <option value="">请选择</option>
                            <c:forEach items="${classList}" var="schoolClass">
                            	<option value="${schoolClass.schoolClassId}">${schoolClass.schoolClassName}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="studentClassName" id="studentClassName">
                    </div>
                </div>
                <br />
                <div class="modal-footer">
                    <div class="col-md-offset-8 col-md-4">                
                        <button class="btn btn-sm btn-primary" type="submit" id="save">
                            <i class="icon-ok bigger-110"></i> 确定
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button class="btn btn-sm btn-primary btn-grey" onclick="window.location.reload()" type="button" id="btn_close">
                           	 关闭
                        </button>
                    </div>
                </div>
            </div>            
        </form>
    </div>
</div>
<script type="text/javascript" >
    $(document).ready(function() {
        Tables.loadPage();
    });
</script>