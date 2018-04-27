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
                        <span class="icon-ok" id="input-image-title">导入学生信息</span>
                    </h4>
                    <h5 class="smaller">
                        <span >提示：姓名和手机号不能为空</span>
                    </h5>
                </div>
            </span>
        </div>      
        <form ole="form" method="post" action="${ctx}/admin/studentRecord/readexcel" class="form-horizontal " enctype="multipart/form-data"
        >
            <div class="well table-responsive" style="background-color: white;">
                <div class="form-group">
                    <label class="col-sm-2 center" >选择班级：</label>
                    <div class="col-sm-10" >
                        <select class="form-control" id="studentClassId" required="required" name="studentClassId" >                            
                            <option value="">请选择</option>
                            <c:forEach items="${classList}" var="schoolClass">
                            	<option value="${schoolClass.schoolClassId}" studentClassName="${schoolClass.schoolClassName}">${schoolClass.schoolClassName}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="studentClassName" id="studentClassName">
                    </div>
                </div>
                <div class="form-group" >
                    <label for="" class="col-sm-2 control-label  no-padding-right">选择文件：</label>
                    <div class="col-sm-10">
                        <input id="file-input" required="required" name="file" type="file"  >
                    </div>                          
                </div>
                <br />
                <div class="modal-footer">
                    <div class="col-md-offset-8 col-md-4">         
                    	<button class="btn btn-sm btn-primary" type='submit' >提交</button>       
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