<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗アカウント登録確認</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	    <div class = "header"><%@ include file="header.jsp" %></div>
	
	この内容で登録しますがよろしいですか？<br>
	<br>
	店舗ID：<%=request.getParameter("shop_id")%><br>
	店舗名：<%=request.getParameter("shop_name")%><br>
	パスワード：
	<% for (int i = 1; i <= request.getParameter("password").length(); i++) { %>
	*
	<% } %><br>
	<div style = "display:inline-flex">
	<form action = "InsertShopAccount.jsp" method = "POST">
		<input type = "submit" value = "いいえ">
	</form>
	<form action = "insert-shop-account-servlet" method = "POST">
		<input type = "hidden" name = "shop_id" value = "<%=request.getParameter("shop_id")%>">
		<input type = "hidden" name = "shop_name" value = "<%=request.getParameter("shop_name")%>">
		<input type = "hidden" name = "password" value = "<%=request.getParameter("password")%>">
		<input type = "submit" value = "はい">
	</form>
	</div>
	
	<div class = "footer"><%@ include file="footer.jsp" %></div>
</body>
</html>