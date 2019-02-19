<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
    a:hover{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }                
  </style>
<title> [guestEdit.jsp]</title> </head>
<body>
	<font color=blue> [guestEdit.jsp=preEdit.do] </font><p>
	<form name="myform" action="edit.do">
	   수정사번: <input type="text" name="sabun" readonly value="${bean.sabun}" >  <br>
	   수정이름: <input type="text" name="name"  value="${bean.name}"> <br>
	   수정제목: <input type="text" name="title" value="${bean.title}" > <br>
	   수정급여: <input type="text" name="pay"  value="${bean.pay}" > <p> 
	      <input type="submit" value="spring데이터수정" >
	      <input type="reset"  value="수정취소">
	</form>
<p>
<a href="index.jsp">[index.jsp]</a>
<a href="write.do">[신규등록]</a>
<a href="list.do">[전체출력]</a>

</body>
</html>













