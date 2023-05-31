<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "style.css">
</head>
<body class = "footer">
	<div style = "display:inline-flex">
	<form action = "search-genre-servlet" method = "POST">
		<select name = "genre">
       		<option value="default">ジャンル検索</option>
        	<option value="sweets1">ケーキ</option>
        	<option value="sweets2">チョコレート</option>
        	<option value="sweets3">クッキー</option>
        	<option value="sweets4">カヌレ</option>
        	<option value="sweets6">マカロン</option>
			<option value="sweets7">和菓子</option>
			<option value="sweets8">その他</option>
		</select>
		<input type = "submit" value = "検索">
	</form>　　　　　
	<form action = "search-value-servlet" method = "POST">
		<input type = "text" name = "minvalue">～
		<input type = "text" name = "maxvalue">
		<input type = "submit" value = "検索">
	</form>
	</div>
</body>
</html>