<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean,java.util.List,model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id="wrapper">
		<div class="header"><jsp:include page = "header.jsp" />
		</div>
		<div id="contents">
			<%
				List<UserBean> userList = (List<UserBean>) request.getAttribute("userList");
	%>
	<table border = "1">
				<tr>
					<th>ユーザーID</th>
					<th>氏名</th>
					<th></th>
				</tr>
				<%
					for (UserBean user : userList) {
					%>
				<tr>
					<td><%=user.getUser_id()%></td>
					<td><%=user.getUser_name()%></td>
					<td>
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
			</table>
			<%
				List<ShopBean> shopList = (List<ShopBean>) request.getAttribute("shopList");
			%>
			<table>
				<tr>
					<th>店舗ID</th>
					<th>店舗名</th>
					<th></th>
				</tr>
				<%
					for (ShopBean shop : shopList) {
				%>
				<tr>
					<td><%=shop.getShop_id()%></td>
					<td><%=shop.getShop_name()%></td>
					<td>
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
			</table>
		</div>
		<div class="footer"><jsp:include page = "footer.jsp" />
		</div>
	</div>
</body>
</html>