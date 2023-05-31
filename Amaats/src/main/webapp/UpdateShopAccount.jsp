<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗編集画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div class="header"><%@ include file="header.jsp" %>
	</div>
	<form action="check-shop-update-servlet" method="post">
		店舗ID：${shop.shop_id}<br>
		店舗名：<input type="text" name="shop_name" value="${shop.shop_name}"><br>
		パスワード：<input type="password" name="shop_password" value="${shop.shop_password}"><br>
		住所：<input type="text" name="shop_address"value="${shop.shop_address}"><br>
		電話番号：<input type="text" name="shop_tel"value="${shop.shop_tel}"><br>
		<input type="submit" value="変更する">
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>