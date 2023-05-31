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
			<% String authority = (String) session.getAttribute("authority");
			   if (authority.equals("admin")) {%>
			   	<li><a href="show-insert-shop-account-servlet">店舗アカウント登録</a></li>
			   	<li><a href="show-account-list-servlet">アカウント一覧</a></li>
			   	<li><a href="show-delete-user-account-servlet">アカウント削除</a></li>
			   	<li><a href="show-account-servlet">アカウント確認</a></li>
				<li><a href="logout-servlet">ログアウト</a></li>
			<%} else if (authority.equals("shop")) {%>
				<li><a href="show-insert-sweets-servlet">商品情報登録</a></li>
				<li><a href="show-update-sweets-servlet">商品情報編集</a></li>
				<li><a href="show-delete-sweets-servlet">商品情報削除</a></li>
				<li><a href="show-account-servlet">アカウント確認</a></li>
				<li><a href="logout-servlet">ログアウト</a></li>
			<%} else {%>
				<li><a href="show-shop-list-servlet">店舗一覧表示</a></li>
				<li><a href="show-account-servlet">アカウント確認</a></li>
				<li><a href="logout-servlet">ログアウト</a></li>
			<%}%>
		</ul>
		</div>
	</div>
	</div>
</body>
</html>