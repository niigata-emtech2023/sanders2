<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="hamburger.css">
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
	
	<div class="cp_cont">
	<div class="cp_offcm04">
		<input type="checkbox" id="cp_toggle04">
		<label for="cp_toggle04"><span></span></label>
		<div class="cp_menu">
		<ul>
		<li><a href="#">店舗情報一覧</a></li>
		<li><a href="#">アカウント</a></li>
		<li><a href="logout-servlet">ログアウト</a></li>
		</ul>
		</div>
	</div>
	</div>
</body>
</html>