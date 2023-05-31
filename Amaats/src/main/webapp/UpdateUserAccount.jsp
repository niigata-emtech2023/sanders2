<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.UserBean,java.util.List"
						 import="model.entity.ShopBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<div class="header"><%@ include file="header.jsp" %>
		</div>
		<div id = "contents">
			<form action="CheckUserUpdateServlet" method="post">
				ユーザーID：${user.user_id}<br>
				氏名：<input type="text" name="user_name" value="${user.user_name}"><br>
				パスワード：<input type="password" name="password" value="${user.password}"><br>
				好きなジャンル：<input type="text" name="user_genre"value="${user.user_genre}"><br>
				住所：<input type="text" name="user_adress"value="${user.user_adress}"><br>
				<input type="submit" value="変更する">
			</form>
		</div>
		<div class="footer"><jsp:include page="footer.jsp" /></div>
	</div>
</body>
</html>