<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean,java.util.List""model.entity.ShopBean.java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
</head>
<body>
	<%
		List<UserBean> userList = (List<UserBean>) request.getAttribute("userList");
	%>
	<table>
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
				<form action="ShowDeleteAccountServlet" method="POST">
					<input type="hidden" name="code" value="<%=user.getUser_id()%>">
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
				<form action="ShowDeleteAccountServlet" method="POST">
					<input type="hidden" name="code" value="<%=shop.getShop_id()%>">
					<input type="submit" value="削除">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>