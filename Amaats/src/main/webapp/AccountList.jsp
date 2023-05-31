<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.entity.UserBean,model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント一覧表示</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<% List<UserBean> userList = (List<UserBean>) request.getAttribute("userList"); %>
		<div class = "header"><%@ include file="header.jsp" %></div>
			<div id = "contents">
			<table border = "1">
				<thead>
					<tr>
						<th>ユーザーID</th>
						<th>氏名</th>
						<th></th>
					</tr>
				</thead>
				<% for (UserBean user : userList) { %>
				<tr>
					<td><%=user.getUser_id()%></td>
					<td><%=user.getUser_name()%></td>
					<td>
						<form action="account-user-detail-servlet" method="POST">
							<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
							<input type="submit" value="詳細表示">
						</form>
					</td>
				</tr>
				<% } %>
			</table>
			<% List<ShopBean> shopList = (List<ShopBean>) request.getAttribute("shopList"); %>
			<table border = "1">
				<tr>
					<th>店舗ID</th>
					<th>店舗名</th>
					<th></th>
				</tr>
				<% for (ShopBean shop : shopList) { %>
				<tr>
					<td><%=shop.getShop_id()%></td>
					<td><%=shop.getShop_name()%></td>
					<td>
						<form action="account-shop-detail-servlet" method="POST">
							<input type="hidden" name="shop_id" value="<%=shop.getShop_id()%>">
							<input type="submit" value="詳細表示">
						</form>
					</td>
				</tr>
				<% } %>
			</table>
		</div>
		<div class = "footer"><%@ include file="footer.jsp" %></div>
	</div>
</body>
</html>