<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗アカウント登録</title>
<link rel = "stylesheet" href = "css/style_base.css">

</head>
<body>
	<div class="wrapper">
		<div class="header"><jsp:include page = "header.jsp" />
		</div>
		<div class="contents">
			<h2>店舗アカウント登録</h2><br>
			<span class="alert">${alert}</span><br>
			<form action = "check-insert-shop-account-servlet" method = "POST">
				<div class="textsize">
					店舗ID：<input type = "text" name = "shop_id" value = "${shop_id}" id="shopid"><br>
					店舗名：<input type = "text" name = "shop_name" value = "${shop_name}" id="shopid2"><br>
					<span id="pass">パスワード：<input type = "password" name = "shop_password" value = "${shop_password}"><br></span>
					パスワード確認：<input type = "password" name = "passcon" value = "${passcon}"><br>
				</div>
				<div class="register"><input type = "submit" value = "登録" class="send"></div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>