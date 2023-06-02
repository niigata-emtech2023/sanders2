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
		<% String user_id; String user_name; String password; String passcon; String user_address;
		try {  
			user_id = (String) request.getAttribute("id");
			if (user_id.equals(null)) {
				user_id = "";
			}
		} catch (NullPointerException e) { user_id = ""; }
		try {  
			user_name = (String) request.getAttribute("user_name"); 
			if (user_name.equals(null)) {
				user_name = "";
			}
		} catch (NullPointerException e) { user_name = ""; }
		try {  
			password = (String) request.getAttribute("password"); 
			if (password.equals(null)) {
				password = "";
			}
		} catch (NullPointerException e) { password = ""; }
		try {  
			passcon = (String) request.getAttribute("passcon"); 
			if (passcon.equals(null)) {
				passcon = "";
			}
		} catch (NullPointerException e) { passcon = ""; }
		try {  
			user_address = (String) request.getAttribute("user_address"); 
			if (user_address.equals(null)) {
				user_address = "";
			}
		} catch (NullPointerException e) { user_address = ""; }%>
	<div class = "wrapper">
		<div class = "contents">
			<img src = "image/amaats_logo.png" alt = "Amaats" id="logo"><br>
			<h2>ユーザー新規登録</h2>
			<span class = "alert">${alert}</span><br>
			<form action = "check-insert-user-account-servlet" method = "POST">
				<div class="textsize">
					名前：<input type = "text" name = "user_name" value = "<%=user_name%>"><br>
					ログインID：<input type = "text" name = "user_id" value = "<%=user_id%>"><br>
					パスワード：<input type = "password" name = "password" value = "<%=password%>"><br>
					パスワード確認：<input type = "password" name = "passcon" value = "<%=passcon%>"><br>
					住所：<input type = "text" name = "user_address" value = "<%=user_address%>"><br>
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