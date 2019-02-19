<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> member 회원 가입</title>
</head>
<body>
<script>
var insert = "${insert}";
if(insert=="0"){
	alert("db저장 실패");
}else if(insert=="1"){
	alert("이미지 파일만 저장 가능합니다.");
}else if(insert=="2"){
	alert("파일 저장 실패. 다시 시도하세요");
}else if(insert=="3"){
	alert("아이디 중복입니다.");
}
</script>
<c:import url="/template/header" />
	<h1>회원 가입</h1>
	<form action="insert.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="text" name="id" placeholder="아이디" size="30"></td>
			</tr>
			<tr>
				<td><input type="password" name="pwd" placeholder="비밀번호" size="30"></td>
			</tr>
			<tr>
				<td><input type="text" name="name" placeholder="이름" size="30"></td>
			</tr>
			<tr>
				<td><input type="email" name="email" placeholder="E-mail주소" size="30"></td>
			</tr>
			<tr>
				<td><input type="tel" name="phone" placeholder="전화번호 ex)010-1234-5678" size="30"></td>
			</tr>
			<tr>
				<td><label>file:</label></td>	
				<td><input type="file" name="newfile"></td>
			</tr>
			<!-- MemberController에서 MultipartFile newFile로 받는다. -->
			<tr>
				<td><label>관리자</label>
				<input type="radio" name="admin" value="1"></td>
				<td><label>일반유저</label>
				<input type="radio" name="admin" value="0" checked></td>	
			</tr>
		</table>
		<input type="submit" value="회원가입">
	</form>
	<c:import url="/template/footer" />
</body>
</html>