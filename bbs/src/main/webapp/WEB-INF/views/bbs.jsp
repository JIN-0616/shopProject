<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="home.jsp"/>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>게시판 글목록 보기</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/default.css">
</head>

<body>
	<table class="table table-dark table-hover table-striped table-responsive-lg">
		<thead class="thead-inverse">
			<tr>
				<form action="list.do" method="get">
					<td colspan=5 align="center">
						<div class="form-row input-group-sm">
							<div class="form-group input-group-sm">
								<select class="form-control" name="skey" id="exampleFormControlSelect1">
									<option value="title" selected>제목</option>
									<option value="name" <c:if test="${skey eq 'name'}">selected</c:if>>이름</option>
									<option value="content" <c:if test="${skey eq 'content'}">selected</c:if>>내용</option>
								</select>
							</div>&nbsp;
							<input class="form-control col-sm-10" type="text" name="sval">&nbsp;
					</td>
					<td><input type="submit" class="btn btn-secondary btn-sm" value="검색">
					</td>					
					</div>
					<td colspan=2 align="right"><font style="font-size: 22px; font-size-adjust: inherit;">검색 갯수/총 갯수 : ${p.qtotal}/${p.total}</font></td>
				</form>
			</tr>
			<tr align="center">
				<th>rn</th>
				<th>no</th>
				<th>sabun</th>
				<th>name</th>
				<th>title</th>
				<th>cnt</th>
				<th>wdate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td align="center" scope="row">${vo.rn}</td>
					<td>${vo.b_no}</td>
					<td>${vo.b_sabun}</td>
					<td>${vo.b_name}</td>
					<td><a href="detail.do?idx=${vo.b_sabun}">${vo.b_title}
							<c:if test="${vo.recnt>0}">
								<font color=red>[${vo.recnt}]</font>
							</c:if>
						</a></td>
					<td>${vo.b_cnt}</td>
					<td>
						<fmt:formatDate value="${vo.b_wdate}" pattern="yyyy-MM-dd" />
					</td>
				</tr>
		</tbody>
		</c:forEach>
		<tr align="center">
			<td colspan=9 align="center">
				<div class="btn-toolbar" role="toolbar" aria-label="버튼 그룹이 있는 툴바">

					<c:if test="${p.startpage>10}">
						<div class="btn-group mr-2" role="group" aria-label="이전">
							<button type="button" class="btn btn-secondary" onclick="location.href='list.do?index=${p.startpage-10}${p.returnpage}'">이전</button>
						</div>
					</c:if>

					<div class="btn-group mr-2" role="group">
						<c:forEach begin="${p.startpage}" end="${p.endpage}" var="i">
							<c:choose>
								<c:when test="${i==p.index}">
									<button type="button" class="btn btn-secondary btn btn-danger">${i}</button>
								</c:when>
								<c:otherwise>
									<button type="button" class="btn btn-secondary" onclick="location.href='list.do?index=${i}${p.returnpage}'">${i}</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
					<c:if test="${p.endpage<p.pagecount}">
						<div class="btn-group" role="group" aria-label="다음">
							<button type="button" class="btn btn-secondary" onclick="location.href='list.do?index=${p.startpage+10}${p.returnpage}'">다음</button>
						</div>
					</c:if>
				</div>
			</td>
		</tr>
	</table>
	<input type="button" class="btn btn-secondary" onclick="location.href='write.do'" value="글쓰기">
	<input type="button" class="btn btn-secondary" onclick="location.href='index.jsp'" value="index">
</body>

</html>