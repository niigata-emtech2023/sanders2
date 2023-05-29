<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<img src = "image/amaats_logo.jpg" alt = "Amaats">
	<form action = "login-servlet" method = "POST">
		ログインID：<input type = "text" name = "id"><br>
		パスワード：<input type = "password" name = "password"><br>
		<a href = "InsertUser.jsp">新規会員登録</a><br>
		<input type = "submit" value = "ログイン">
	</form>
</body>
</html>