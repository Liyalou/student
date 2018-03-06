<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-12 center">
    <strong style="font-size:24px">项目借款</strong>
</div>
<form id="wrapForm" role="form" class="form-horizontal ">
    <table id="simple-table" class="table  table-bordered table-hover">
        <tr>
            <td>职位名称<span class="red">*</span></td>
            <td>
                <input type="text" name="" class="form-control" value="" placeholder="职位名称"/>
            </td>
            <td>单位名称：<span class="red">*</span></td>
            <td>
                <input type="text" class="form-control" name="" value="" />
            </td>
            <td>部门名称：<span class="red">*</span></td>
            <td>
                <input type="text" class="form-control" name="" value="" />
            </td>
        </tr>
        <tr>
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
        </tr>
    </table>
    <div class="modal-footer">
	    <div class="center">
	        <button class="btn btn-sm btn-primary" type="button" id="wrapSave_btn">
	            <i class="icon-ok bigger-110"></i>保存
	        </button>
	        <button class="btn btn-sm btn-primary btn-grey btn_close" data-dismiss="modal">取消</button>
	    </div>
	</div>
</form>
