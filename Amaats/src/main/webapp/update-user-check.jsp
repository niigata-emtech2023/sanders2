<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集確認画面</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<%
	request.setCharacterEncoding("UTF-8");
	%>
	アカウント編集情報を以下の内容に変更します。よろしいですか？
	<br>
	<jsp:useBean id="user" scope="session"class="model.entity.UserBean" />

	<jsp:setProperty name="user" property="user_name"param="user_name" />
	<jsp:setProperty name="user" property="user_id"param="user_id" />
	<jsp:setProperty name="user" property="password"param="password" />
	<jsp:setProperty name="user" property="user_genre"param="user_genre" />
	<jsp:setProperty name="user" property="user_address"param="user_address" />
		

	ユーザID：<jsp:getProperty name="user" property="user_id" /><br>
	氏名：<jsp:getProperty name="user" property="user_name" /><br>
	パスワード：<jsp:getProperty name="user" property="password" /><br>
	好きなジャンル：<jsp:getProperty name="user" property="user_genre" /><br>
	住所：<jsp:getProperty name="user" property="user_address" /><br>

	<form action="-servlet" method="POST">
		<input type="submit" value="はい">
	</form>

	<form action="-servlet" method="POST">
		<input type="submit" value="戻る">
	</form>

</body>
</html>