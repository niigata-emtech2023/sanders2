<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー詳細画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	ユーザーID：${user.user_id}<br>
	氏名：${user.user_name}<br>
	パスワード：${user.password}<br>
	好きなジャンル：${user.user_genre}<br>
	住所：${user.user_adress}<br>

	<form action="ShowUserAccountServlet" method="POST">
		<input type="submit" value="一覧表示">
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>