<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<div class="message">
                    共<i class="blue">${pageList.total}</i>条记录，当前显示第&nbsp;
    <i class="blue">${pageList.pageNum}/${pageList.pages}</i>&nbsp;页
</div>
<div style="text-align:center;">
	<form action="${ctx}${pageUrl}" method="post">
		<input type="hidden" name="pageNum">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<c:if test="${!pageList.isFirstPage}">
		            <li><a href="javascript:void(0);" onClick="page('${pageList.firstPage}',this)">首页</a></li>
		            <li><a href="javascript:void(0);" onClick="page('${pageList.prePage}',this)">上一页</a></li>
		        </c:if>
		        <c:forEach items="${pageList.navigatepageNums}" var="navigatepageNum">
		            <c:if test="${navigatepageNum==pageList.pageNum}">
		                <li class="active"><a href="javascript:void(0);" onClick="page('${navigatepageNum}',this)">${navigatepageNum}</a></li>
		            </c:if>
		            <c:if test="${navigatepageNum!=pageList.pageNum}">
		                <li><a href="javascript:void(0);" onClick="page('${navigatepageNum}',this)">${navigatepageNum}</a></li>
		            </c:if>
		        </c:forEach>
		        <c:if test="${!pageList.isLastPage}">
		            <li><a href="javascript:void(0);" onClick="page('${pageList.nextPage}',this)">下一页</a></li>
		            <li><a href="javascript:void(0);" onClick="page('${pageList.lastPage}',this)">最后一页</a></li>
		        </c:if>
			</ul>
		</nav>
	</form>
</div>
<script type="text/javascript">
	function page(pageNum,sender){
		var form = jQuery(sender).parents('form');
		form.find("input[name=pageNum]").val(pageNum);
		form.submit();
	}
</script>
