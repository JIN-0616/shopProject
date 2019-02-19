<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [board_reply_edit.jsp]</title>
	<style type="text/css">
	   *{font-size:14pt; font-family: Comic Sans MS; }
	 
	   	#LOG-IN{
		 font-size:26pt; font-weight: bold; 
		 background:#FFFF00; height:550; 
		}
	</style>
</head>
<body>
  
 

  <!-- board_reply_edit문서  단독실행금지 -->
<br>
<form  method="get"  action="reply_edit.do" >
  <table width="700"  border='0' cellspacing="0">  
 	<input type="hidden"  name="hobby_idx"  value="${dto.hobby_idx}">
 	<input type="hidden"  name="rhobby_idx"  value="${dto.rhobby_idx}">
 	<tr>
 	  <td><b><img src="./resources/images/x1.gif">작성자:<img src="./resources/images/x1.gif"></b>
 		<input type="text"  name="rwriter" size=20 value="${dto.rwriter}">
 		<input type="submit"  value="게시판댓글저장 "  style="height:25pt;">     
 	  </td>
 	</tr>
 	
 	<tr align="center">
 	  <td>
 		내용:<textarea  name="rmemo" cols="60" rows=3>${dto.rmemo}</textarea>
 	  </td>
 	</tr>
  </table>
 </form>

</body>
</html>