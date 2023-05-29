<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.UserBean,java.util.List"
						 import="model.entity.ShopBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集画面</title>
</head>
<body>
	<body>

	ユーザーID：${user.user_id}<br>
	氏名：${user.user_name}<br>
	パスワード：${user.password}<br>
	好きなジャンル：${user.genre}<br>
	住所：${user.user_adress}<br>
	<form action="" method="POST">
		<input type="submit" value="変更する">
	</form>

	店舗ID：${shop.shop_id}<br>
	店舗名：${shop.shop_name}<br>
	パスワード：${shop.shop_password}<br>
	住所：${shop.shop_adress}<br>
	電話番号：${shop.shop_tel}<br>
	<form action="" method="POST">
		<input type="submit" value="変更する">
	</form>
</body>
</html>