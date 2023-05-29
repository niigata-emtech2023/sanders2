<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats：商品情報-編集確認</title>
</head>
<body>

	
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	商品情報を以下の内容に変更します。よろしいですか？<br>
	<jsp:useBean id="sweets" scope="session" class="model.entity.SweetsBean" />
	
	<jsp:setProperty name="sweets" property="sweets_name" param="sweets_name" />
	<jsp:setProperty name="sweets" property="sweetsValue" param="sweets_value" />
	<jsp:setProperty name="sweets" property="sweets_grene" param="sweets_grene" />
	
	商品ID：<jsp:getProperty name="sweets" property="sweets_id" /><br>
	商品名：<jsp:getProperty name="sweets" property="sweets_name" /><br>
	値段：<jsp:getProperty name="sweets" property="sweets_value" /><br>
	カテゴリ：<jsp:getProperty name="sweets" property="sweets_genre" /><br>

	<form action="update-sweets-servlet" method="POST">
		<input type="submit" value="はい">
	</form>

	<form action="update-sweets-form-servlet" method="POST">
		<input type="submit" value="戻る">
	</form>

</body>
</html>