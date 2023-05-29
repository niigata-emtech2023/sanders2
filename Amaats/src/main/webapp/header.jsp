<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style = "text-align:left">
		<form action = "logout-servlet" method = "POST">
			<input type = "submit" value = "ログアウト">
		</form>
	</div>
	<div style = "text-align:center">
		<form action = "search-name-servlet" method = "POST">
			<input type = "text" name = "sweets_name">
			<input type = "submit" value = "検索">
		</form>
	</div>
	<div style = "text-align:right">
		<input type = "button">
	</div>
</body>
</html>