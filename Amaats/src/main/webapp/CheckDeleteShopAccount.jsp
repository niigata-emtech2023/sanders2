<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean,model.entity.ShopBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link rel="stylesheet" href = "css/style_base.css">
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<div class="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div class="contents">
	    <div class="text">
			このアカウントを削除しますが,
			<br> 本当によろしいですか？<br>
		</div>
		<br>
		<div class="textsize">
			ログインID：<%=request.getParameter("shop_id")%><br>
			店名：<%=request.getParameter("shop_name")%><br>
			パスワード：<%=request.getParameter("shop_password")%><br>
			住所：<%=request.getParameter("shop_address")%><br>
			電話番号：<%=request.getParameter("shop_tel")%><br>
		</div>
			<div style = "display:inline-flex">
				<form action="show-delete-user-account-servlet" method="POST">
					<input type="submit" value="いいえ" id="no" class="send">
				</form>
				<form action="delete-account-servlet" method="POST">
					<input type="hidden" name="type" value="shop">
					<input type="hidden" name="shop_id" value="<%=request.getParameter("shop_id")%>">
					<input type="submit" value="はい" id="yes" class="send">
				</form>
			</div>
		</div>
	</div>
</body>
</html>