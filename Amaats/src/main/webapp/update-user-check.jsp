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
	<jsp:useBean id="user" scope="request"class="model.entity.UserBean" />		

	ユーザID：<jsp:getProperty name="user" property="user_id" /><br>
	氏名：<jsp:getProperty name="user" property="user_name" /><br>
	パスワード：<jsp:getProperty name="user" property="password" /><br>
	好きなジャンル：<jsp:getProperty name="user" property="user_genre" /><br>
	住所：<jsp:getProperty name="user" property="user_address" /><br>

	<form action="update-user-account-servlet" method="POST">
		<input type="hidden" name = "user_id" value=>
		<input type="hidden" name = "user_name" value=>
		<input type="hidden" name = "password" value=>
		<input type="hidden" name = "user_genre" value=>
		<input type="hidden" name = "user_address" value=>
		<input type="submit" value="はい">
	</form>

	<form action="UpdateUserAccount.jsp" method="POST">
		<input type="submit" value="戻る">
	</form>

</body>
</html>