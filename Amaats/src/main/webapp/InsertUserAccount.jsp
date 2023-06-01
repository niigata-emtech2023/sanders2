<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー新規登録</title>
<link rel = "stylesheet" href = "css/insertuser.css">
</head>
<body>
	<div class = "wrapper">
		<div class = "contents">
			<img src = "image/amaats_logo.png" alt = "Amaats" id="logo"><br>
			<h2>ユーザー新規登録</h2>
			<span class = "alert">${alert}</span><br>
			<form action = "check-insert-user-account-servlet" method = "POST">
				<div class="textsize">
					名前：<input type = "text" name = "user_name"><br>
					ログインID：<input type = "text" name = "user_id"><br>
					パスワード：<input type = "password" name = "password"><br>
					パスワード確認：<input type = "password" name = "passcon"><br>
					住所：<input type = "text" name = "user_address"><br>
				</div>
				<br>
				<div class="register"><input type = "submit" value = "登録" class="send"></div>
			</form>
			<form action = "Login.jsp" method = "POST">
				<div class="return"><input type = "submit" value = "戻る" class="send"></div>
			</form>
		</div>
	</div>
</body>
</html>