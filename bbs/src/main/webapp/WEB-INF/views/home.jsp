<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="resources/css/default.css">
</head>
<body>
	<img src="./resources/images/bar.gif">
	<br>
	<c:if test="${LOGIN == null}">		
		<input type="button" class="btn btn-secondary" onclick="location.href='login.do'" value="로그인">
	</c:if>
	<c:if test="${LOGIN!=null}">
            <font color=white>${LOGIN.userid}님 환영합니다</font>
		<input type="button" class="btn btn-secondary" onclick="location.href='logout.do'" value="로그아웃">
	</c:if>
	<input type="button" class="btn btn-secondary" onclick="location.href='list.do'" value="게시물 목록보기">	
	<input type="button" class="btn btn-secondary" onclick="location.href='write.do'" value="게시물 작성">
	<input type="button" class="btn btn-secondary" onclick="location.href='index.jsp'" value="시작페이지로 돌아가기">
</body>
</html>
