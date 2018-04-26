<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%-- <script src="${ctx}/static/assets/js/jquery.2.1.1.min.js"></script> --%>
<script src="${ctx}/static/assets/js/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/static/assets/js/jquery.validate.msg.js" type="text/javascript"></script>


<div style="width:30%" class="modal-dialog">
	<div class="modal-content" >
         <div class="well table-responsive" style="background-color: white;">
             <form id="change-form" action="${ctx}/admin/userContre/passwordChange" method="post">
                <div class="form-group">
					<label for="username">账号</label> 
					<input type="text" class="form-control" readOnly id="userAccount" name="userAccount" value="${user.userAccount}">
				</div> 
				<input type="hidden" name="userId" value="${user.userId}">
				<div class="form-group">
					<label for="password">原密码</label> 
					<input type="password" class="form-control" id="oldPassword" name="oldPassword" >
				</div>
				<div class="form-group">
					<label for="password">新密码</label> 
					<input type="password" class="form-control" id="newPassword" name="newPassword" >
				</div>
				<div class="form-group">
					<label for="password">重复新密码</label> 
					<input type="password" class="form-control" id="reNewPassword" name="reNewPassword" >
				</div>
				<div class="form-group">
					<p class="help-block">${loginMsg}</p>
				</div>
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
             </form>
         </div>
     </div>
</div>

<script>
	$("#change-form").validate({
		rules:{
			oldPassword:{required:true},
			newPassword:{required:true},
			reNewPassword:{required:true,equalTo:"#newPassword"}
		},
		messages:{
			oldPassword:{required:"请输入原密码"},
			newPassword:{required:"请输入新密码"},
			reNewPassword:{required:"请重复输入一次新密码",equalTo:'两次密码不一致'}
		}
	});
</script>
