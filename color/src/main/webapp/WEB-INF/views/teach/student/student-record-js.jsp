<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/static/js/teach/student/student-record.js"></script>
<script type="text/javascript" >
    $(document).ready(function() {
        Tables.loadPage();   
    });
</script>
