<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:import url="home.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 쓰기</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
	<link rel="stylesheet" href="resources/css/default.css">
<script type="text/javascript">
/* 업로드 체크 */
function fileCheck( file ){
    // 사이즈체크
    var maxSize  = 5 * 1024 * 1024    //30MB
    var fileSize = 0;
	// 브라우저 확인
	var browser=navigator.appName;	
	// 익스플로러일 경우
	if (browser=="Microsoft Internet Explorer")
	{
		var oas = new ActiveXObject("Scripting.FileSystemObject");
		fileSize = oas.getFile( file.value ).size;
	}else{
		// 익스플로러가 아닐경우
		fileSize = file.files[0].size;
	}
	alert("파일사이즈 : "+ fileSize +", 최대파일사이즈 : 5MB");
        if(fileSize > maxSize){
            alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.    ");
            return;
    }
    document.queryselecter("b_size1").value = document.iform.b_file.files[0].size;        
}
</script>
</head>
<body>
	<form name="iform" action="insert.do" method="post" enctype="multipart/form-data">
		<table class="table table-dark table-striped table-responsive" border="1">
			<tr>
				<div class="form-group">
					<th><label for="sabun">Sabun</label></th>
					<td><input type="text" name="b_sabun" value="${vo.b_sabun}" class="form-control" id="sabun" placeholder="4number"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="name">Name</label></th>
					<td><input type="text" name="b_name" value="${vo.b_name}" class="form-control" id="name" placeholder="yourname"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="title">Title</label></th>
					<td><input type="text" name="b_title" value="${vo.b_title}" class="form-control" id="title" placeholder="title"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="content">Content</label></th>
					<td><textarea name="b_content" class="form-control" id="content" rows="3">${vo.b_content}</textarea></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="phone">Phone</label></th>
					<td><input type="text" name="b_phone" value="${vo.b_phone}" class="form-control" id="phone" placeholder="010-1234-5678"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="pwd">Pwd</label></th>
					<td><input type="password" name="b_pwd" value="${vo.b_pwd}" class="form-control" id="pwd" placeholder=""></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="juso1">Juso1</label></th>
					<td><input type="text" name="b_juso1" value="${vo.b_juso1}" class="form-control" id="juso1" placeholder="경기도 서울시"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="juso2">Juso2</label></th>
					<td><input type="text" name="b_juso2" value="${vo.b_juso2}" class="form-control" id="juso2" placeholder="강남구 XX번지"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="email">Email</label></th>
					<td><input type="email" name="b_email" value="${vo.b_email}" class="form-control" id="email" placeholder="name@example.com"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="url">Url</label></th>
					<td><input type="url" name="b_url" value="${vo.b_url}" class="form-control" id="url" placeholder="http://www.google.com"></td>
				</div>
			</tr>
			<tr>
				<div class="form-group">
					<th><label for="file">File</label></th>
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