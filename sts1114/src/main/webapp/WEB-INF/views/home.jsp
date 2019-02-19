<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style type="text/css">
* {
	font-size: 20pt;
	font-weight: bold;
}

a {
	font-decoration: none;
	font-size: 20pt;
	font-weight: bold;
}

a:hover {
	font-decoration: underLine;
	font-size: 26pt;
	font-weight: bold;
	color: blue;
}
</style>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
