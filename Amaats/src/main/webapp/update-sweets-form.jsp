<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats：商品情報-更新入力フォーム</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<jsp:useBean id="sweets" class="model.entity.SweetsBean"
		scope="session" />

	<form action="show-update-sweets-servlet" method="post">
		商品ID：<jsp:getProperty name="sweets" property="sweets_id" /><br>
		商品名：<input type="text" name="name"
			value="<jsp:getProperty name="sweets" property="sweets_name" />"><br>
		値段：<input type="text" name="age"
			value="<jsp:getProperty name="sweets" property="sweets_value" />"><br>
		カテゴリ：<select name="sweets_category">
			<option value="sweets1"></option>
			<option value="sweets2">ケーキ</option>
			<option value="sweets3">チョコレート</option>
			<option value="sweets4">クッキー</option>
			<option value="sweets5">カヌレ</option>
			<option value="sweets6">マカロン</option>
			<option value="sweets7">和菓子</option>
			<option value="sweets8">その他</option>

		</select><br> <input type="submit" value="更新する">
	</form>

	<form action="sweets-info-servlet" method="POST">
		<input type="hidden" name="sweetsId"
			value="<%=sweets.getSweets_id()%>"> <input type="submit"
			value="詳細表示画面に戻る">
	</form>

</body>
</html>