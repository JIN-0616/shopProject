<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.net.URLEncoder"  %>

<html>
<head>
<title>[boardDetail.jsp]</title>
  <style type="text/css">
	*{font-size:18pt; font-weight:bold; }
	a{text-decoration:none ;font-size:20pt; font-weight:bold;}
	a:hover{ text-decoration:underline ;font-size:22pt; font-weight:bold;}
  </style>
	
</head>
<body>
  <table width=900 border=1 cellspacing="0" cellpadding="5">
   <tr>
	  <td colspan='2' align="center"> 
	    <font  color='blue' style="font-size:30pt" > [${dto.name}]님  게시판상세정보 </font>  
	  </td>
   </tr>
	
   <tr>
	 <td rowspan="5" align="center"> <!-- prc -->
	   <a href="download.do?fidx=${dto.img_file_name}&idx=${dto.hobby_idx}">  
	   <img src ='${pageContext.request.contextPath}/resources/upload/${dto.img_file_name}' width=300 heigh=350 border=0>   
	   </a>
	 </td>
     <td>번호 : ${dto.hobby_idx}  </td>
   </tr>
  
   <tr><td>제목 : ${dto.title}  </td></tr>
   <tr><td>내용 : ${dto.content} </td></tr>
   <tr><td>성벌 : ${dto.gender} </td></tr>
   <tr><td>취미 : ${dto.hobby} </td></tr>
</table>
     
  <p>
    <a href="delete.do?idx=${dto.hobby_idx}">[삭제]</a>
	<a href="index.jsp">[index.jsp]</a>
	<a href="preEdit.do?idx=${dto.hobby_idx}">[수정]</a>
	<a href="write.do">[신규등록]</a>
	<a href="list.do">[전체출력]</a>  
<hr>
	
</body>
</html>

<c:import url="/reply_list.do"/>
