<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div style = "display:inline-flex">
	<form action = "search-genre-servlet" method = "POST">
		<select name = "genre">
       		<option value="default">選択してください</option>
        	<option value="cake">ケーキ</option>
        	<option value="cokkie">クッキー</option>
        	<option value="chocolate">チョコレート</option>
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