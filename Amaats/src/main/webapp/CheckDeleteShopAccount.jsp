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
	<br> 本当によろしいですか？<br>
	
	ユーザID：<%=request.getParameter("shop_id")%><br>
	名前：<%=request.getParameter("shop_name")%><br>
	パスワード：<%=request.getParameter("shop_password")%><br>
	住所：<%=request.getParameter("shop_address")%><br>
	電話番号：<%=request.getParameter("shop_tel")%><br>

	<div style = "display:inline-flex">
		<form action="show-delete-account-servlet" method="POST">
			<input type="submit" value="いいえ">
		</form>
		<form action="delete-account-servlet" method="POST">
			<input type="hidden" name="type" value="shop">
			<input type="hidden" name="shop_id" value="<%=request.getParameter("shop_id")%>">
			<input type="submit" value="はい">
		</form>
	</div>
	
	<div class = "footer"><%@ include file="footer.jsp" %></div>
</body>
</html>