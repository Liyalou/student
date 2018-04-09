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
                <input type="hidden" value="${waitDealId}" name="waitDealId" />
                <div class="form-group">
                    <label class="col-sm-2 center" >审批意见：</label>
                    <div class="col-sm-10" >
                        <select class="form-control" id="waitReplyResult" name="waitReplyResult" >                            
                            <option value="1">同意</option>
                            <option value="2">不同意</option>
                        </select>
                    </div>
                </div>
                <br />
                <table id="teacherTable" class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th style = "text-align: center;"></th>
                            <th style = "text-align: center;">姓名</th>
                            <th style = "text-align: center;">性别</th>
                            <th style = "text-align: center;">身份号</th>
                            <th style = "text-align: center;">联系电话</th>
                            <th style = "text-align: center;">职位</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${teacherList}" var="teacher">
                            <tr>
                                <td><input type="radio" value="${teacher.teacherUserId}" name="teacherUserId" ></td>
                                <td>${teacher.teachTeacherName}</td>
                                <td>${teacher.teachTeacherSex}</td>
                                <td>${teacher.teachTeacherIdCard}</td>
                                <td>${teacher.teachTeacherPhone}</td>
                                <td>${teacher.teachTeacherPost}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="modal-footer">
                    <div class="col-md-offset-8 col-md-4">                
                        <button class="btn btn-sm btn-primary" type="submit" id="save">
                            <i class="icon-ok bigger-110"></i>
                            确定
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
