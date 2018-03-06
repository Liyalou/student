<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<style>
.imageDiv {
	display: inline-block;
	width: 160px;
	height: 130px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	border: 1px dashed darkgray;
	background: #f8f8f8;
	position: relative;
	overflow: hidden;
	margin: 10px
}

.cover {
	position: absolute;
	z-index: 1;
	top: 0;
	left: 0;
	width: 160px;
	height: 130px;
	background-color: rgba(0, 0, 0, .3);
	display: none;
	line-height: 125px;
	text-align: center;
	cursor: pointer;
}

.cover .delbtn {
	color: red;
	font-size: 20px;
}

.imageDiv:hover .cover {
	display: block;
}

.addImages {
	display: inline-block;
	width: 160px;
	height: 130px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	border: 1px dashed darkgray;
	background: #f8f8f8;
	position: relative;
	overflow: hidden;
	margin: 10px;
}

.text-detail {
	margin-top: 40px;
	text-align: center;
}

.text-detail span {
	font-size: 40px;
}

.imgFile {
	position: absolute;
	top: 0;
	left: 0;
	width: 160px;
	height: 130px;
	opacity: 0;
}
</style>
<div class="page-content">
	<form method="post" action="" id="passForm" enctype="multipart/form-data">
	    <!--点击预览图片-->
	    <div id="Pic_pass" class="">
	        <p style="font-size: 20px;font-weight: bold;">请上传护照详细照片 </p>
	        <p><span style="color: red">注：每张照片大写不可超过4M，且最多可以传十张</span></p>
	        <div class="picDiv">
	            <div class="addImages">
	                <!--multiple属性可选择多个图片上传-->
	                <input class="imgFile" id="fileInput" multiple="multiple" accept="image/png, image/jpeg, image/gif, image/jpg" type="file">
	                <div class="text-detail">
	                    <span>+</span>
	                    <p>点击上传</p>
	                </div>
	            </div>
	        </div>
	    </div>
	    <button class="btn btn-default" type="submit">Button</button>
	    <div class="msg" style="display: none;"></div>
	</form>
</div>


