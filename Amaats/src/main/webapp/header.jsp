<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/hamburger.css">
<!-- <link rel="stylesheet" href="css/style.base.css"> -->
<link rel="stylesheet" href="css/header.css">
</head>
<body>
	<% String name; 
	try {  
			name = (String) request.getAttribute("sweets_name");
			if (name.equals(null)) {
				name = "名前検索";
			}
		} catch (NullPointerException e) { name = "名前検索"; }%>
	<div style = "text-align:center">
		<a href = "show-sweets-list-servlet"><img src = "image/amaats_logo.png" alt = "Amaats" id="logobutton"></a>
		<% String Autho = (String) session.getAttribute("authority");
			if (Autho.equals("user")) {%>
		<form action = "search-name-servlet" method = "POST">
			<input type = "text" name = "sweets_name" id="searchtext" value= "<%=name%>">
			<input type = "submit" value = "検索" class="searchbutton">
		</form>
		<%} %>
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
				<li><a href="show-update-sweets-list-servlet">商品情報編集</a></li>
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