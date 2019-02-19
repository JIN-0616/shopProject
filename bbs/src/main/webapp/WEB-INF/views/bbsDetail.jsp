<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="home.jsp" />
<html>

<head>
	<title>[bbsDetail.jsp]</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/default.css">
</head>

<body>

	<table class="table table-dark table-striped table-responsive" width="800">
		<tr>
			<td colspan=4 rowspan=5>
				<a href="download.do?idx=${vo.b_sabun}&fidx=${vo.b_file1}">
					<img src="${pageContext.request.contextPath}/resources/upload/${vo.b_file1}" class="img-thumbnail" width="100%" height="300px"> 
				</a>
			</td>
			<th>no</th>
			<td>${vo.b_no}</td>
		<tr>
			<th>sabun</th>
			<td>${vo.b_sabun}</td>
		</tr>
		<tr>
			<th>name</th>
			<td>${vo.b_name}</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${vo.b_title}</td>
		</tr>
		<tr>
			<th>cnt</th>
			<td>${vo.b_cnt}</td>
		</tr>
		<tr>
			<th colspan=2>filename</th>
			<td colspan=2>${vo.b_file1}</td>
			<th>phone</th>
			<td>${vo.b_phone}</td>
		</tr>
		<tr>
			<th colspan=2>size</th>
			<td colspan=2>${vo.b_size1}byte</td>
			<th>pwd</th>
			<td>${vo.b_pwd}</td>
		</tr>
		<tr>
			<th colspan=3>juso</th>
			<th>wdate</th>
			<th>email</th>
			<th>url</th>

		</tr>
		<tr>

			<td colspan=3>${vo.b_juso1} ${vo.b_juso2}</td>
			<td>
				<fmt:formatDate value="${vo.b_wdate}" pattern="yyyy-MM-dd" />
			</td>
			<td>${vo.b_email}</td>
			<td>${vo.b_url}</td>
		</tr>
		<tr>
			<th colspan=6>content</th>
		</tr>
		<tr>
			<td colspan=6>${vo.b_content}</td>
		</tr>
		<tr>
			<td colspan=16>
			<c:choose>
							 
				<c:when test="${sessionScope.userid eq vo.b_name}">
					<input type="button" class="btn btn-secondary" onclick="location.href='delete.do?idx=${vo.b_sabun}'" value="삭제">
					<input type="button" class="btn btn-secondary" onclick="location.href='preEdit.do?idx=${vo.b_sabun}'" value="수정">
				</c:when>
				<c:when test="${sessionScope.userid eq 'admin'}">
					<input type="button" class="btn btn-secondary" onclick="location.href='delete.do?idx=${vo.b_sabun}'" value="삭제">
					<input type="button" class="btn btn-secondary" onclick="location.href='preEdit.do?idx=${vo.b_sabun}'" value="수정">
				</c:when>
				<c:otherwise>
					<input type="button" class="btn btn-secondary" value="삭제" disabled>
					<input type="button" class="btn btn-secondary" value="수정" disabled>
				</c:otherwise>
			</c:choose>
				<input type="button" class="btn btn-secondary" onclick="location.href='list.do'" value="목록">
			</td>
		</tr>
	</table>
</body>

</html>
<c:import url="/reply_list.do" />