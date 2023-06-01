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
			<div class="textsize">
			<br>
				ログインID：<%=request.getParameter("user_id")%><br>
				氏名：<%=request.getParameter("user_name")%><br>
				パスワード：<%=request.getParameter("password")%><br>
				好きなジャンル：<%=request.getParameter("user_genre")%><br>
				住所：<%=request.getParameter("user_address")%><br>
			</div>
			<div style = "display:inline-flex">
				<form action="show-delete-user-account-servlet" method="POST">
					<input type="submit" value="いいえ" id="no" class="send">
				</form>
				<form action="delete-account-servlet" method="POST">
					<input type="hidden" name="type" value="user">
					<input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>">
					<input type="submit" value="はい" id="yes" class="send">
				</form>
			</div>
		
			<jsp:useBean id="shop" scope="request" class="model.entity.ShopBean" />
		</div>
	</div>
</body>
</html>