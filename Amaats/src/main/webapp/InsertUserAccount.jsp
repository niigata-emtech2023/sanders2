<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー新規登録</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<img src = "image/amaats_logo.png" alt = "Amaats"><br>
	<span class = "alert">${alert}</span><br>
	<form action = "check-insert-user-account-servlet" method = "POST">
		名前：<input type = "text" name = "user_name"><br>
		ログインID：<input type = "text" name = "user_id"><br>
		パスワード：<input type = "password" name = "password"><br>
		パスワード確認：<input type = "password" name = "passcon"><br>
		住所：<input type = "text" name = "user_address"><br>
		<input type = "submit" value = "登録">
	</form>
	<form action = "Login.jsp" method = "POST">
		<input type = "submit" value = "戻る">
	</form>
</body>
</html>