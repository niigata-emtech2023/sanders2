<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.entity.UserBean,model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント一覧表示</title>
<link rel="stylesheet" href = "css/style_base.css">
<link rel="stylesheet" href = "css/account_table.css">
</head>
<body>
	<div class = "wrapper">
		<% List<UserBean> userList = (List<UserBean>) request.getAttribute("userList"); %>
		<div class = "header"><%@ include file="header.jsp" %></div>
			<div class = "contents">
			<table border = "1">
				<thead>
					<tr>
						<th class="td1">ユーザーID</th>
						<th class="td2">氏名</th>
					</tr>
				</thead>
				<tbody>
				<% for (UserBean user : userList) { %>
				
				<tr>
					<td class="td1"><%=user.getUser_id()%></td>
					<td class="td2"><%=user.getUser_name()%></td>
				</tr>
				
				<% } %>
				</tbody>
			</table>
			<% List<ShopBean> shopList = (List<ShopBean>) request.getAttribute("shopList"); %>
			<table border = "1">
				<thead>
					<tr>
						<th class="td1">店舗ID</th>
						<th class="td2">店舗名</th>
					</tr>
				</thead>
				<tbody>
				<% for (ShopBean shop : shopList) { %>
				
				<tr>
					<td class="td1"><%=shop.getShop_id()%></td>
					<td class="td2"><%=shop.getShop_name()%></td>
				</tr>
				
				<% } %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>