<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "style.css">
<link rel="stylesheet" href="css/header.css">
</head>
<body class = "footer">
	<div style = "display:inline-flex">
	<form action = "search-genre-servlet" method = "POST">
		<select name = "genre" class="genre">
       		<option value="default">ジャンル検索</option>
        	<option value="ケーキ">ケーキ</option>
        	<option value="チョコレート">チョコレート</option>
        	<option value="クッキー">クッキー</option>
        	<option value="カヌレ">カヌレ</option>
        	<option value="マカロン">マカロン</option>
			<option value="和菓子">和菓子</option>
			<option value="その他">その他</option>
		</select>
		<input type = "submit" value = "検索" class="searchbutton">
	</form>　　　　　
	<form action = "search-value-servlet" method = "POST">
			<input type = "text" name = "minvalue" class="price">～
			<input type = "text" name = "maxvalue" class="price">
			<input type = "submit" value = "検索" class="searchbutton">
	</form>
	</div>
</body>
</html>