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
	<div class="wrapper">
		<div id="contents">
			<img src = "image/amaats_logo.png" alt = "Amaats" id="logo"><br>
			<h2>ログイン</h2>
			<span class = "alert">${alert}</span><br>
			<form action = "login-servlet" method = "POST">
				<div class="textsize">
					ログインID：<input type = "text" name = "id" value = "${id}"><br>
					パスワード：<input type = "password" name = "password" value = "<%=request.getParameter("id")%>"><br>
				</div>
				<br>
				<div class="sign"><a href = "InsertUserAccount.jsp">新規会員登録</a></div><br>
				<input type = "submit" value = "ログイン" class="send">
			</form>
		</div>
	</div>
</body>
</html>