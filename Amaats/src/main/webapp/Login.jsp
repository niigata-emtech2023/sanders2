<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<img src = "image/amaats_logo.png" alt = "Amaats" id="logo"><br>
	<span class = "alert">${alert}</span>
	<form action = "login-servlet" method = "POST">
<<<<<<< HEAD
		<div class="logintext">
			ログインID：<input type = "text" name = "id"><br>
			パスワード：<input type = "password" name = "password"><br>
			<a href = "InsertUser.jsp">新規会員登録</a><br>
		</div>
		<input type = "submit" value = "ログイン" class="loginbutton">
=======
		ログインID：<input type = "text" name = "id"><br>
		パスワード：<input type = "password" name = "password"><br>
		<a href = "InsertUserAccount.jsp">新規会員登録</a><br>
		<input type = "submit" value = "ログイン">
>>>>>>> branch 'master' of https://github.com/niigata-emtech2023/sanders2
	</form>
</body>
</html>