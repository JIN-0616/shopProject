<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>[boardList.jsp]</title>
 	<style type="text/css">
		*{font-size:16pt; font-weight:bold; }
		a{text-decoration:none ;font-size:20pt; font-weight:bold;}
		a:hover{text-decoration:underline ;font-size:22pt; font-weight:bold;}
	</style>
	<script type="text/javascript">
	function changeclear() {
		myform.sval.value = "";
		myform.sval.focus();
	}//end
</script>
</head>
<body>
	<table width=700 border=1 cellpadding="0">
		<tr align="right">
			<td colspan=8>레코드갯수: &nbsp;&nbsp;${Stotal}/${Gtotal}</td>
		</tr>
		<tr bgcolor=yellow height=50 align="center">
			<td>rn</td>
			<td>idx</td>
			<td>name</td>
			<td>title</td>
			<td>content</td>
			<td>gender</td>
			<td>hobby</td>
			<td>img_file_name</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.rn}</td>
				<td>${dto.hobby_idx}</td>
				<td>${dto.name}</td>
				<td><a href="detail.do?idx=${dto.hobby_idx}">${dto.title}</a>
				<c:if test="${dto.rcnt>0}">
						<font color=red>[${dto.rcnt}]</font>
					</c:if></td>
				<td>${dto.content}</td>
				<td>${dto.gender}</td>
				<td>${dto.hobby}</td>
				<td><a
					href="${pageContext.request.contextPath}/resources/upload/${dto.img_file_name}">${dto.img_file_name}</a></td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="8">
				<form name="myform" action="list.do">
					검색 : <select name="skey" onchange="changeclear();">
						<option value="" selected>전체검색</option>
						<option value="name" <c:if test="${skey eq 'name'}">selected</c:if>>이름조회</option>
						<option value="title" <c:if test="${skey eq 'title'}">selected</c:if>>제목검색</option>
						<option value="content" <c:if test="${skey eq 'content'}">selected</c:if>>내용검색</option>
					</select>
					<input type="text" name="sval" size=10 value="${sval}">
					<input type="submit" value="검 색 "> 
					<input type="button" value="index" onclick="location.href='index.jsp'"> 
					<input type="button" value="등록" onclick="location.href='write.do'">
					<input type="button" value="list" onclick="location.href='list.do'">
				</form>
			</td>
		</tr>
		<!-- 페이징 -->
		<tr align="center">
			<td colspan="8">
			
			<!-- 이전 -->
			<c:if test="${startpage>10}">
				<a href="list.do?pageNum=${startpage-10}${returnpage}">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startpage}"	end="${endpage}">
			  <c:choose>
			    <c:when test="${i==pageNUM}">
			      <font style="font-size:18pt; color:red;">[${i}]</font>
			    </c:when>					
				<c:otherwise>
				  <a href="list.do?pageNum=${i}${returnpage}">[${i}] </a>
				</c:otherwise>
			  </c:choose>
			</c:forEach>
			
			<!-- 다음 -->
			<c:if test="${endpage<pagecount}">
				<a href="list.do?pageNum=${startpage+10}${returnpage}">[다음]</a>
			</c:if>
			
			</td>
		</tr>
	</table>  
</body>
</html>



