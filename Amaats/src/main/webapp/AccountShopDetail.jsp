<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗詳細画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	店舗ID：${shop.shop_id}<br>
	店舗名：${shop.shop_name}<br>
	パスワード：${shop.shop_password}<br>
	住所：${shop.shop_adress}<br>
	電話番号：${shop.shop_tel}<br>

	<form action="ShowUserAccountServlet" method="POST">
		<input type="submit" value="一覧表示">
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>