<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>댓글 수정</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/default.css">
</head>

<body>
	<form method="get" action="reply_edit.do">
		<table class="table table-dark table-striped table-responsive" width="700" border='0' cellspacing="0">
			<input type="hidden" name="hobby_idx" value="${rvo.br_sabun}">
			<input type="hidden" name="rhobby_idx" value="${rvo.br_num}">
			<tr>
				<div class="form-group">
					<th><b><label for="br_writer">작성자:</label><b></th>
					<td colspan=3><input type="text" name="br_writer" value="${rvo.br_writer}" class="form-control" id="br_writer"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="br_content">메모용:</label></th>
					<td colspan=3><textarea name="br_content" class="form-control" id="br_content" rows="3">${rvo.br_content}</textarea></td>
				</div>
			</tr>
			<tr>
				<td colspan=4 align="center">
					<input type="submit" class="btn btn-secondary btn-block" value="게시판댓글저장 " style="height: 25pt;">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>