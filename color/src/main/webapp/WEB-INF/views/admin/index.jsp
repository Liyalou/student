<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
    <title>高校学生考勤管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="${ctx}/static/assets/css/bootstrap.min.css" >
	<link rel="stylesheet" type="text/css" href="${ctx}/static/assets/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/assets/font-awesome/4.2.0/css/font-awesome.min.css"> 
	
	<script src="${ctx}/static/assets/js/jquery.2.1.1.min.js"></script>
	<script src="${ctx}/static/assets/js/jquery.validate.js" type="text/javascript"></script>
	<script src="${ctx}/static/assets/js/jquery.validate.msg.js" type="text/javascript"></script>
	
	<style type="text/css">
        #content {
			width:100%;
			height:69.5em;
			margin:0;
			padding:0;
			background-image:url(${pageContext.request.contextPath}/images/index/index.png);
			background-position:center;
			background-repeat:no-repeat;
		}
    </style> 
</head>
<body>
<div id="content">
	<div class="row-fluid">
		<div class="dialog" style="margin-top: 0em;padding-top:15em;">
			<div class="center">
				<h1>
					<!-- <span style="font-size:30px;font-family: georgia, serif;"><Strong></Strong></span>  -->
					<span style="font-size:30px;margin-left: 2.3em;font-family: georgia, serif;"><Strong>高校学生考勤管理系统</Strong></span>
				</h1>
			</div>
			<div class="block" style="border-radius: 5px;">
	            <p class="block-heading">登录</p>
	            <div class="block-body">
	                <form id="login-form" action="${ctx}/user/login" method="post">
	                    <div class="form-group">
							<label for="username">账号</label> 
							<input type="text" class="form-control" id="username" name="username" >
						</div>
						<div class="form-group">
							<label for="password">密码</label> 
							<input type="password" class="form-control" id="password" name="password" >
						</div>
						<div class="form-group">
							<p class="text-right" style="font-size: 12px;" onclick = "alterMsg()"><a>忘记密码</a></p>
							<button type="submit" class="btn btn-default form-control">登&nbsp;录</button>
						</div>
						<div class="form-group">
							<p class="help-block">${loginMsg}</p>
						</div>
	                </form>
	            </div>
	        </div>
		</div>
	</div>

</div>	
</body>

<script type="text/javascript">
$(function(){
	$("#login-form").validate({
		rules:{
			username:{required:true},
			password:{required:true}
		},
		messages:{
			username:{required:"请输入用户名"},
			password:{required:"请输入密码"}
		}
	});
});

function alterMsg(){
	alert("请联系教务处");
}

</script>
</html>

