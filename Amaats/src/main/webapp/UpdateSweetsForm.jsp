<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats：商品情報-更新入力フォーム</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class = "wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div class = "contents">
			<% SweetsBean sb = (SweetsBean) request.getAttribute("bean");
				String sweets_info = sb.getSweets_info();
				try {
					if (sweets_info.equals(null)) {
						sweets_info = "";
					}
				} catch (NullPointerException e) {
					sweets_info = "";
				}%>
		
			<form action="check-update-sweets-servlet" method="post">
			<div class="textleft">
				商品ID：<%=sb.getSweets_id() %><br>
				商品名：<input type="text" name="sweets_name" value="<%=sb.getSweets_name() %>"><br>
				値段：<input type="text" name="sweets_value" value="<%=sb.getSweets_value() %>"><br>
				ジャンル：<select name="sweets_genre">
					<option value="<%=sb.getSweets_genre() %>"><%=sb.getSweets_genre() %></option>
					<option value="sweets2">ケーキ</option>
					<option value="sweets3">チョコレート</option>
					<option value="sweets4">クッキー</option>
					<option value="sweets5">カヌレ</option>
					<option value="sweets6">マカロン</option>
					<option value="sweets7">和菓子</option>
					<option value="sweets8">その他</option>
				</select><br>
			    商品情報：
			    </div><br>
			    <textarea name="sweets_info" cols="40" rows="5"><%=sweets_info %></textarea><br>
			    <input type = "hidden" name = "id" value = "<%=sb.getSweets_id()%>">
			    <input type = "submit" value = "更新" class="send">
			</form>
		
			<form action="sweets-info-servlet" method="POST">
				<input type="hidden" name="sweetsId" value="<%=sb.getSweets_id()%>"> 
				<input type="submit" value="詳細表示画面に戻る" class="send3">
			</form>
		</div>
	</div>
</body>
</html>