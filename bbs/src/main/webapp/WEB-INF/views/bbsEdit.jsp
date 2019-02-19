<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>글 수정</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/default.css">
</head>

<body>
	<form action="edit.do" method="post" enctype="multipart/form-data">
		<table class="table table-dark table-striped table-responsive" border="1">
			<tr>
				<div class="form-group">
					<th><label for="sabun">수정할 Sabun</label></th>
					<td><input type="text" name="b_sabun" value="${vo.b_sabun}" class="form-control" id="sabun" placeholder="1111"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="name">수정할 Name</label></th>
					<td><input type="text" name="b_name" value="${vo.b_name}" class="form-control" id="name" placeholder="yourname"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="title">수정할 Title</label></th>
					<td><input type="text" name="b_title" value="${vo.b_title}" class="form-control" id="title" placeholder="title"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="content">수정할 Content</label></th>
					<td><textarea name="b_content" class="form-control" id="content" rows="3">${vo.b_content}</textarea></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="phone">수정할 Phone</label></th>
					<td><input type="text" name="b_phone" value="${vo.b_phone}" class="form-control" id="phone" placeholder="010-1234-5678"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="pwd">수정할 Pwd</label></th>
					<td><input type="password" name="b_pwd" value="${vo.b_pwd}" class="form-control" id="pwd" placeholder=""></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="juso1">수정할 Juso1</label></th>
					<td><input type="text" name="b_juso1" value="${vo.b_juso1}" class="form-control" id="juso1" placeholder="경기도 서울시"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="juso2">수정할 Juso2</label></th>
					<td><input type="text" name="b_juso2" value="${vo.b_juso2}" class="form-control" id="juso2" placeholder="강남구 XX번지"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="email">수정할 Email</label></th>
					<td><input type="email" name="b_email" value="${vo.b_email}" class="form-control" id="email" placeholder="name@example.com"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="url">수정할 Url</label></th>
					<td><input type="url" name="b_url" value="${vo.b_url}" class="form-control" id="url" placeholder="http://www.google.com"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="file">수정할 File</label></th>
					<td><input type="file" name="b_file" value="${vo.b_file}" class="form-control-file" id="file"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="file1">Filename</label></th>
					<td><input type="text" name="b_file1" value="${vo.b_file1}" class="form-control" id="file1" readonly></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="size1">Filesize</label></th>
					<td><input type="text" name="b_size1" value="${vo.b_size1}" class="form-control" id="size1" readonly></td>
				</div>
			</tr>
			<tr>
				<td colspan=2 align="center">
					<input type="submit" class="btn btn-secondary" value="전송">&nbsp;
					<input type="reset" class="btn btn-secondary" value="취소">
			</tr>
		</table>
	</form>
</body>

</html>