<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>
<style type="text/css">
    *{ font-family:Comic Sans MS;  font-weight:bold; }
    
	header{	display: inline-block;	width: 100%;	}
	header .home_button{
		display: inline-block;
		margin: 5px 0px;
		border:1px solid gray;
		background:yellow;
		padding: 5px 15px;
		float: left;
	}
	
	header .login_state{ float:right;	width: 20%;		padding: 20px;	}
	
	nav ul.menu_bar>li{
		display: inline-block;
		width: 32%;
		text-align: center;
		text-decoration: none;
	}
</style>

<script>
	var login = "${login}";
	if(login === "1"){
		alert("로그인 성공");
	}else if(login === "0"){
		alert("로그인 실패");
	}else if(login === "-1"){
		alert("로그아웃 되었습니다.")
	}else if(login === "-2"){
		alert("로그인 시 이용 가능합니다.")
	}
</script>
</head>
<body>
	<header>
		<h1 class="home_button"><a href="<c:url value='/home.do'/>">HOME</a></h1>
		
		<fieldset class="login_state">
			<legend>LOGIN 상태</legend>
			<c:choose>
				<c:when test="${LoginVo!=null}">
				<div style="float: left;">
					<img alt="O" src="<c:url value='/resources/img/${LoginVo.photo}'/>">
				</div>
				<div style="float:left; padding:10px; line-height:2;">
					${LoginVo.name}(${LoginVo.id})님 로그인중...<br>
					<a href='<c:url value="/logout.do"/>'>로그아웃</a> / 
					<a href='<c:url value="/profile/update.do?mem_num=${LoginVo.num}"/>'>개인정보 수정</a>
				</div>
				</c:when>
				<c:otherwise>
					<a href='<c:url value="/login.do"/>'>로그인</a>
				</c:otherwise>
			</c:choose>
		</fieldset>
	</header>
	<nav>
		<ul class="menu_bar">
			<li><a href="<c:url value='/member/list.do'/>">회원관리</a></li>
			<li><a href="<c:url value='/board/boardList.do'/>">게시판</a></li>
			<li><a href='<c:url value="/member/insert.do"/>'>회원가입</a></li>
		</ul>
	</nav>
	<hr>
</body>
</html>