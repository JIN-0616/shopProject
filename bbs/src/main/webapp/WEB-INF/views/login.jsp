<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
	<meta charset="UTF-8">
	<title> [login.jsp]</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/default.css">
	<style type="text/css">
		html {
			height: 100%;
		}

		body {
			width: 100%;
			height: 100%;
			margin: 0;
			padding-top: 80px;
			padding-bottom: 40px;
			font-family: "Nanum Gothic", arial, helvetica, sans-serif;
			background-repeat: no-repeat;
			background: linear-gradient(to bottom right, rgb(16, 17, 17), rgb(118, 119, 121));
		}

		.card {
			margin: 0 auto;
			float: none;
			margin-bottom: 10px;
			box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
		}

		.form-signin .form-control {
			position: relative;
			height: auto;
			-webkit-box-sizing: border-box;
			-moz-box-sizing: border-box;
			box-sizing: border-box;
			padding: 10px;
			font-size: 16px;
		}
	</style>
</head>

<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center" bgcolor="#212529">

	<div class="card align-middle" style="width:20rem; border-radius:20px;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366;">로그인 폼</h2>
		</div>
		<div class="card-body">
			<form class="form-signin" method="post" action="loginprocess.do">
				<h5 class="form-signin-heading">로그인 정보를 입력하세요</h5>
				<label for="inputEmail" class="sr-only">Your ID</label>
				<input type="text" id="uid" name="userid" class="form-control" placeholder="Your ID" required autofocus><BR>
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="upw" class="form-control" name="pwd" placeholder="Password" required><br>
				<button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">로 그 인</button>
			</form>

		</div>
	</div>

</body>

</body>

</html>