<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録</title>
<link rel="stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div class="contents">
	    <h3>商品情報登録</h3>
		    <span class="alert">${alert}</span>
		    <form action="check-insert-sweets-info-servlet" method="POST">
		    <div class="textright2">
			    商品名：<input type="text" name="sweets_name" id="textcenter"><br>
			    ジャンル：
			    <select name="sweets_genre" id="textcenter3">
			        <option value="default">選択してください</option>
					<option value="sweets2">ケーキ</option>
					<option value="sweets3">チョコレート</option>
					<option value="sweets4">クッキー</option>
					<option value="sweets5">カヌレ</option>
					<option value="sweets6">マカロン</option>
					<option value="sweets7">和菓子</option>
					<option value="sweets8">その他</option>
			    </select><br>
			    価格：<input type = "text" name="sweets_value" id="textcenter2"><br>
			    商品情報：
			    <textarea name="sweets_info" cols="25" rows="5"></textarea><br>
		    </div>
		    <br>
		    <input type="submit" value="登録" class="send">
		    </form>
	    </div>
    </div>
</body>
</html>