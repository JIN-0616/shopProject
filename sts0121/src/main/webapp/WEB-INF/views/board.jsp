<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
	<style type="text/css">
		*{font-size: 20pt; font-weight: bold;}
		a{font-decoration: none; font-size:20pt; font-weight: bold;}
		a:hover{font-decoration: underLine; font-size:26pt; font-weight: bold; color: blue;}		
	</style>
</head>
<body>
	<font color=blue>[board.jsp=write.do]</font><p>
	<form action="insert.do" method="post" enctype="multipart/form-data">
		이름:<input type=text name="name" value="spring"><br>		
		제목:<input type=text name="title" value="snow"><br>		
		내용:<textarea name="content" rows="4" cols="20">KgBank</textarea><br>
		
		성별:<input type="radio" name="gender" value="man" checked>남자
		     <input type="radio" name="gender" value="woman">여자<br>
		     
		취미:<input type="checkbox" name="hobby" value="game">게임
			 <input type="checkbox" name="hobby" value="study">공부
			 <input type="checkbox" name="hobby" value="movie" checked>영화
			 <input type="checkbox" name="hobby" value="ski" checked>스키<br>
			 
		파일:<input type="file" name="upload_f"><p>
			<!-- img_file_name이름대신 upload__f -->
			<input type="submit" value="hobbySpring전송">&nbsp;&nbsp;
			<input type="reset" value="입력취소">	
	</form>
	
	<p>
	<a href="index.jsp">[index.jsp]</a>
	<a href="write.do">[신규등록]</a>
	<a href="home.do">[home.jsp]</a>
</body>
</html>