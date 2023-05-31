<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean,model.entity.ShopBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
    <div class = "header"><%@ include file="header.jsp" %></div>
    
	このアカウントを削除しますが,
	<br> 本当によろしいですか？
	<jsp:useBean id="shop" scope="request" class="model.entity.ShopBean" />
	
	ユーザID：<jsp:getProperty name="shop" property="shop_id" /><br>
	店舗名：<jsp:getProperty name="shop" property="shop_name" /><br>
	パスワード：<jsp:getProperty name="shop" property="shop_password" /><br>
	住所：<jsp:getProperty name="shop" property="shop_address" /><br>
	電話番号：<jsp:getProperty name="shop" property="shop_tel" /><br>

	<div style = "display:inline-flex">
		<form action="ShowDeleteAccountServlet" method="POST">
			<input type="submit" value="いいえ">
		</form>
		<form action="DeleteAccountServlet" method="POST">
			<input type="hidden" name="type" value="shop">
			<input type="hidden" name="shop_id" value="<jsp:getProperty name="shop" property="shop_id" />">
			<input type="submit" value="はい">
		</form>
	</div>
	
	<div class = "footer"><%@ include file="footer.jsp" %></div>
</body>
</html>