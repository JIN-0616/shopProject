<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>guest.jsp</title>
	<style type="text/css">
		*{font-size: 20pt; font-weight: bold;}
		a{font-decoration: none; font-size:20pt; font-weight: bold;}
		a:hover{font-decoration: underLine; font-size:26pt; font-weight: bold; color: blue;}		
	</style>
</head>
<body>
	<font color=blue>[guest.jsp=write.do]</font><p>
	<form action="insert.do" method="get">
		사번:<input type=text name=sabun><br>
		이름:<input type=text name=name><br>
		제목:<input type=text name=title><br>
		급여:<input type=text name=pay><br>
			<input type="submit" value="spring저장">
			<input type="reset" value="입력취소">	
	</form>
	
	<p>
	<a href="index.jsp">[index.jsp]</a>
	<a href="write.do">[신규등록]</a>
	<a href="list.do">[전체출력]</a>
	<a href="home.do">[home.jsp]</a>
</body>
</html>