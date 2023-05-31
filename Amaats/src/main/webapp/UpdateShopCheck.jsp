<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗編集確認画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div id = "contents">
		<%
		request.setCharacterEncoding("UTF-8");
		%>
		店舗アカウント編集情報を以下の内容に変更します。よろしいですか？
		<br>
		<%
	    ShopBean bean = (ShopBean)request.getAttribute("bean");
	    %>
		店舗ID：<%=bean.getShop_id() %><br>
		店舗名：<%=bean.getShop_name() %><br>
		パスワード：<%=bean.getShop_password() %><br>
		住所：<%=bean.getShop_address() %><br>
		電話番号：<%=bean.getShop_tel() %><br>
		
		
		<form action="update-shop-account-servlet" method="POST">
			<input type="hidden" name = "user_id" value=<%=bean.getShop_id() %>>
			<input type="hidden" name = "user_name" value=<%=bean.getShop_name() %>>
			<input type="hidden" name = "password" value=<%=bean.getShop_password() %>>
			<input type="hidden" name = "user_genre" value=<%=bean.getShop_address() %>>
			<input type="hidden" name = "user_address" value=<%=bean.getShop_tel() %>>
			<input type="submit" value="はい">
		</form>
	
		<form action="UpdateShopAccount.jsp" method="POST">
			<input type="submit" value="戻る">
		</form>
		</div>
		<div class="footer"><jsp:include page="footer.jsp" /></div>
	</div>
</body>
</html>