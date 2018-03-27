<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-12 center">
    <strong style="font-size:24px">角色编码</strong>
</div>
<form id="wrapForm" class="form-horizontal" action="${pageContext.request.contextPath}/admin/role/submitRole" method="post">
	<input name="roleId" type="hidden" value="${role.roleId}">
    <table id="simple-table" class="table  table-bordered table-hover">
        <tr>
            <td>角色名称：<span class="red">*</span></td>
            <td>
                <input type="text" name="roleName" class="form-control" value="${role.roleName}" placeholder="角色名称"/>
            </td>
            <td>角色编码：<span class="red">*</span></td>
            <td>
                <input type="text" class="form-control" name="roleCode" ${role.roleCode} placeholder="角色编码"/>
            </td>
            <td><span class="red"></span></td>
            <td>
                <!-- <input type="text" class="form-control" name="" value="" /> -->
            </td>
        </tr>
        <!-- <tr>
            <td class="col-sm-1">工程名称 <span class="red">*</span></td>
            <td class="col-sm-3">
                <div class="input-group ">
                    <input type="text" readonly class="form-control must_in" name="itemContractName" value="" placeholder="工程名称">
                    <span id="itemContractName1" style="cursor:pointer;" class="input-group-addon">请选择</span>
                </div>
            </td>
            <td>账户金额：</td>
            <td>
                <input type="text" class="form-control" name="" value="" />
            </td>
            <td class="col-sm-1">借款金额：<span class="red">*</span></td>
            <td class="col-sm-3">
                <div class="input-group ">
                    <span style="cursor:pointer;" class="input-group-addon ">小写</span>
                    <input type="number" oninput="if(value.length>9)value=value.slice(0,9)"
                           class="input form-control must_in" name="" value="" placeholder="只保留两位小数"  />
                </div>
            </td>
        </tr>
        <tr>
            <td>借款事由：<span class="red">*</span></td>
            <td colspan="5">
                <textarea class="col-sm-12 must_in" name=""></textarea>
            </td>
        </tr> -->
    </table>
    <div class="modal-footer">
	    <div class="center">
	        <button class="btn btn-sm btn-primary" type="submit"  id="submitRole">
	            <i class="icon-ok bigger-110"></i>保存
	        </button>
	        <button class="btn btn-sm btn-primary btn-grey btn_close" type='button' data-dismiss="modal">取消</button>
	    </div>
	</div>
</form>
