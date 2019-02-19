<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title> [board_reply.jsp]</title>
	<style type="text/css">
	   *{font-size:14pt; font-family: Comic Sans MS; }
	 
	   	#LOG-IN{
		 font-size:26pt; font-weight: bold; 
		 background:#FFFF00; height:550; 
		}
	</style>
</head>
<body>
  
 <!-- board_reply.jsp문서  단독실행금지 -->
<br>
<form  method="get"  action="reply.do" >
  <table width="700"  border='0' cellspacing="0">
  	<tr>
 	<td>idx데이터:<input type="text"  name="hobby_idx"  value="${dto.hobby_idx}"></td>
 	</tr>
 	<tr>
 	  <td><b>작성자:</b>
 		<input type="text"  name="rwriter" size=20>
 		<input type="submit"  value="게시판댓글저장"  style="height:25pt;">     
 	  </td>
 	</tr>
 	
 	<tr>
 	  <td>
 		메모용: <textarea  name="rmemo" cols="60" rows=3>color</textarea>
 	  </td>
 	</tr>
  </table>
 </form>


	<p>
	
	<table width="650" border='0' cellspacing="0">
		<tr bgcolor="pink" height='30' align="center">
			<td colspan=4>댓글 데이타 내용 표시</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr onMouseOver="style.background='#00FFFF'" onMouseOut="style.background='' ">
				<td width=100>${dto.rrn}</td>
				<td width=100>${dto.rwriter}</td>
				<td width=300>${dto.rmemo}</td>
				<td width=150><input type="button" value="삭제" onClick="location.href='reply_del.do?idx=${dto.rhobby_idx}&hobby_idx=${dto.hobby_idx}'">
							  <input type="button" value="수정" onClick="location.href='reply_preEdit.do?idx=${dto.rhobby_idx}&hobby_idx=${dto.hobby_idx}'"></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>