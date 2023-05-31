<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
</head>
<body>
	このアカウントを削除しますが,
	<br> 本当によろしいですか？
	<jsp:useBean id="user" scope="request" class="model.entity.UserBean" />

	ユーザID：<jsp:getProperty name="user" property="user_id" /><br>
	氏名：<jsp:getProperty name="user" property="user_name" /><br>
	パスワード：<jsp:getProperty name="user" property="password" /><br>
	好きなジャンル：<jsp:getProperty name="user" property="user_genre" /><br>
	住所：<jsp:getProperty name="user" property="user_adress" /><br>

	<jsp:useBean id="shop" scope="request" class="model.entity.ShopBean" />

	ユーザID：<jsp:getProperty name="shop" property="shop_id" /><br>
	店舗名：<jsp:getProperty name="shop" property="shop_name" /><br>
	パスワード：<jsp:getProperty name="shop" property="shop_password" /><br>
	住所：<jsp:getProperty name="shop" property="shop_adress" /><br>
	電話番号：<jsp:getProperty name="shop" property="shop_tel" /><br>

	<div class="yesno">
		<form action="ShowDeleteAccountServlet" method="POST">
			<input type="submit" value="いいえ">
		</form>
		<form action="DeleteAccountServlet" method="POST">
			<input type="submit" value="はい">
		</form>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>