<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats：商品情報-更新入力フォーム</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div id = "contents">
			<% SweetsBean sb = (SweetsBean) request.getAttribute("bean"); %>
		
			<form action="check-update-sweets-servlet" method="post">
				商品ID：<%=sb.getSweets_id() %><br>
				商品名：<input type="text" name="sweets_name" value="<%=sb.getSweets_name() %>"><br>
				値段：<input type="text" name="sweets_value" value="<%=sb.getSweets_value() %>"><br>
				ジャンル：<select name="sweets_genre">
					<option value="default"><%=sb.getSweets_genre() %></option>
					<option value="sweets2">ケーキ</option>
					<option value="sweets3">チョコレート</option>
					<option value="sweets4">クッキー</option>
					<option value="sweets5">カヌレ</option>
					<option value="sweets6">マカロン</option>
					<option value="sweets7">和菓子</option>
					<option value="sweets8">その他</option>
				</select><br> <input type="submit" value="更新する">
				価格：<input type = "text" name="sweets_value" value = "<%=sb.getSweets_value()%>"><br>
			    商品情報：<br>
			    <textarea name="sweets_info" cols="40" rows="5"><%=sb.getSweets_info() %></textarea>
			    写真：<input type="file" name="pict"><br>
			    <input type = "hidden" name = "sweets_id" value = "<%=sb.getSweets_id() %>">
			    <input type = "submit" value = "更新">
			</form>
		
			<form action="sweets-info-servlet" method="POST">
				<input type="hidden" name="sweetsId" value="<%=sb.getSweets_id()%>"> 
				<input type="submit" value="詳細表示画面に戻る">
			</form>
		</div>
	</div>
</body>
</html>