<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>댓글 입력</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/default.css">
</head>

<body>
	<form method="get" action="reply.do">
		<table class="table table-dark table-striped table-responsive" width="700" border='0' cellspacing="0">
	<tr><td colspan=4></td></tr>
	<tr height='30' align="center">
		<td width=300 colspan=4>댓글 데이타 내용 표시</td>
	</tr>
	<c:forEach var="rvo" items="${rlist}">
		<tr onMouseOver="style.background='#00FFFF'" onMouseOut="style.background='' ">
			<td width=100>${rvo.rrn}</td>
			<td width=100>${rvo.br_writer}</td>
			<td width=300>${rvo.br_content}</td>
			<c:if test="${null ne rvo}">
				<td width=150>
					<input type="button" class="btn btn-secondary" value="삭제" onClick="location.href='reply_del.do?idx=${rvo.br_num}&bidx=${rvo.br_sabun}'">
					<input type="button" class="btn btn-secondary" value="수정" onClick="location.href='reply_preEdit.do?idx=${rvo.br_num}&bidx=${rvo.br_sabun}'">
				</td>
			</c:if>
		</tr>
	</c:forEach>
			<tr>
				<div class="form-group">
					<th><label for="br_sabun">원글idx:</label></th>
					<td colspan=3><input type="text" name="br_sabun" value="${vo.b_sabun}" class="form-control" id="br_sabun"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="br_writer">작성자:</label></th>
					<td colspan=3><input type="text" name="br_writer" value="Writer" class="form-control" id="br_writer"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="br_content">메모용:</label></th>
					<td colspan=3><textarea name="br_content" class="form-control" id="br_content" rows="3">Content</textarea></td>
				</div>
			</tr>
			<tr>
				<td colspan=4><input type="submit" class="btn btn-secondary btn-block" value="댓글입력" style="height:25pt;"></td>
			</tr>
	</form>
	</table>
</body>

</html>