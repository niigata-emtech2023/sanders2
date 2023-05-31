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
	<jsp:useBean id="user" scope="request" class="model.entity.UserBean" />
	
	ユーザID：<jsp:getProperty name="user" property="user_id" /><br>
	氏名：<jsp:getProperty name="user" property="user_name" /><br>
	パスワード：<jsp:getProperty name="user" property="password" /><br>
	好きなジャンル：<jsp:getProperty name="user" property="user_genre" /><br>
	住所：<jsp:getProperty name="user" property="user_address" /><br>
	
	<div style = "display:inline-flex">
		<form action="ShowDeleteAccountServlet" method="POST">
			<input type="submit" value="いいえ">
		</form>
		<form action="DeleteAccountServlet" method="POST">
			<input type="hidden" name="type" value="shop">
			<input type="hidden" name="user_id" value="<jsp:getProperty name="user" property="user_id" />">
			<input type="submit" value="はい">
		</form>
	</div>

	<jsp:useBean id="shop" scope="request" class="model.entity.ShopBean" />
	
	<div class = "footer"><%@ include file="footer.jsp" %></div>
</body>
</html>