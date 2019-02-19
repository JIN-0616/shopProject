<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> scriptPaging.jsp </title>
<style type="text/css">
body{
	text-align:center;
}
#paging{
	font-size: 22pt;
}
</style>
</head>
<body>
<div id="paging">
<!-- AJAX로 페이징 하는 곳 action 태그의 href만 다르다.
	loadComments가 호출될때 AJAX로 호출되는 페이지 -->
<c:url var="action" value="${param.action}"/>
<c:if test="${param.prev}">
	<a href="javascript:${action}(${param.beginPage-1})">prev</a>
</c:if>
<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
	<c:choose>
		<c:when test="${param.page==index}">
			${index}
		</c:when>
		<c:otherwise>
			<a href="javascript:${action}(${index})">${index}</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<c:if test="${param.next}">
	<a href="javascript:${action}(${param.endPage+1})">next</a>
</c:if>
</div>
</body>
</html>