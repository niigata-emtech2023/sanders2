<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー新規登録確認画面</title>
</head>
<body>
	<jsp:include page = "header.jsp">
	
	この内容で登録しますがよろしいですか？<br>
	<br>
	店舗ID：<%=request.getParameter("shop_id")%><br>
	店舗名：<%=request.getParameter("shop_name")%><br>
	パスワード：
	<% for (int i = 1; i <= request.getParameter("password").size(); i++) { %>
	*
	<% } %><br>
	<div style = "display:inline-flex">
	<form action = "InsertShopAccount.jsp" method = "POST">
		<input type = "submit" value = "いいえ">
	</form>
	<form action = "insert-shop-account-servlet" method = "POST">
		<input type = "hidden" name = "shop_id" value = "<%=request.getParameter("shop_id")%>">
		<input type = "hidden" name = "shop_id" value = "<%=request.getParameter("shop_name")%>">
		<input type = "hidden" name = "shop_id" value = "<%=request.getParameter("shop_id")%>">
		<input type = "submit" value = "はい">
	</form>
	</div>
	
	<jsp:include page = "footer.jsp">
</body>
</html>