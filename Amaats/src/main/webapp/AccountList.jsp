<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント一覧表示</title>
</head>
<body>
	<table>
		<tr>
			<th>ユーザーID</th>
			<th>氏名</th>
			<th></th>
		</tr>

		<c:forEach var="user" items="${userList}">
			<tr>
				<td>${user.user_id}</td>
				<td>${user.user_name}</td>
				<td>
					<form action="" method="POST">
						<input type="hidden" name="user_id" value="${user.user_id}">
						<input type="submit" value="詳細表示">
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
	<table>
		<tr>
			<th>店舗ID</th>
			<th>店舗名</th>
			<th></th>
		</tr>

		<c:forEach var="shop" items="${shopList}">
			<tr>
				<td>${shop.shop_id}</td>
				<td>${shop.shop_name}</td>
				<td>
					<form action="" method="POST">
						<input type="hidden" name="shop_id" value="${shop.shop_id}">
						<input type="submit" value="詳細表示">
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>