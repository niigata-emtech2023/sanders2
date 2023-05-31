<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗アカウント登録</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	<div class="header"><jsp:include page = "header.jsp" />
	</div>
	<div class = "header"><jsp:include page = "header.jsp" /></div>
	店舗アカウント登録<br>
	<span>${alert}</span><br>
	<form action = "check-insert-shop-account-servlet" method = "POST">
		店舗ID：<input type = "text" name = "shop_id" value = "${shop_id}"><br>
		店舗名：<input type = "text" name = "shop_name" value = "${shop_name}"><br>
		パスワード：<input type = "password" name = "password" value = "${password}"><br>
		パスワード確認：<input type = "password" name = "passcon" value = "${passcon}"><br>
		<input type = "submit" value = "登録">
	</form>
	<div class = "footer"><jsp:include page = "footer.jsp" /></div>
</body>
</html>