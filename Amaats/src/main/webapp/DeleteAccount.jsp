<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean,java.util.List,model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
<link rel="stylesheet" href = "css/style_base.css">
<link rel="stylesheet" href = "css/delete_table.css">
</head>
<body>
	<div class="wrapper">
		<div class="header"><jsp:include page = "header.jsp" />
		</div>
		<div class="contents">
			<%
				List<UserBean> userList = (List<UserBean>) request.getAttribute("userList");
			%>
	<table border = "1">
		<thead>
				<tr>
					<th class="td1">ユーザーID</th>
					<th class="td2">氏名</th>
				</tr>
		</thead>
		<tbody>
				<%
					for (UserBean user : userList) {
					%>
			
				<tr>
					<td class="td1"><%=user.getUser_id()%></td>
					<td class="td2"><%=user.getUser_name()%></td>
					<td class="td3">
						<form action="CheckDeleteUserAccount.jsp" method="POST">
							<input type="hidden" name="type" value="user">
							<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
							<input type="hidden" name="user_name" value="<%=user.getUser_name()%>">
							<input type="hidden" name="password" value="<%=user.getPassword()%>">
							<input type="hidden" name="user_address" value="<%=user.getUser_address()%>">
							<input type="hidden" name="user_genre" value="<%=user.getUser_genre()%>">
							<input type="submit" value="削除">
						</form>
					</td>
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
			<%
				List<ShopBean> shopList = (List<ShopBean>) request.getAttribute("shopList");
			%>
			<table border = "1">
				<thead>
				<tr>
					<th class="td1">店舗ID</th>
					<th class="td2">店舗名</th>
				</tr>
				</thead>
				<tbody>
				<%
					for (ShopBean shop : shopList) {
				%>
				
				<tr>
					<td class="td1"><%=shop.getShop_id()%></td>
					<td class="td2"><%=shop.getShop_name()%></td>
					<td class="td3">
						<form action="CheckDeleteShopAccount.jsp" method="POST">
							<input type="hidden" name="type" value="shop">
							<input type="hidden" name="shop_id" value="<%=shop.getShop_id()%>">
							<input type="hidden" name="shop_name" value="<%=shop.getShop_name()%>">
							<input type="hidden" name="shop_password" value="<%=shop.getShop_password()%>">
							<input type="hidden" name="shop_address" value="<%=shop.getShop_address()%>">
							<input type="hidden" name="shop_tel" value="<%=shop.getShop_tel()%>">
							<input type="submit" value="削除">
						</form>
					</td>
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>