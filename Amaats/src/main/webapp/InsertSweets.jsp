<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	<div id="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div id="contents">
		    <span>${alert}</span>
		    <form action="check-insert-sweets-info-servlet" method="POST">
		    商品名：<input type="text" name="sweets_name"><br>
		    カテゴリ：
		    <select name="sweets_genre">
		        <option value="default">選択してください</option>
				<option value="sweets2">ケーキ</option>
				<option value="sweets3">チョコレート</option>
				<option value="sweets4">クッキー</option>
				<option value="sweets5">カヌレ</option>
				<option value="sweets6">マカロン</option>
				<option value="sweets7">和菓子</option>
				<option value="sweets8">その他</option>
		    </select><br>
		    
		    価格：<input type = "text" name="sweets_value"><br>
		    商品情報：<br>
		    <textarea name="sweets_info" cols="40" rows="5">
		    </textarea>
		    
		    <input type="submit" value="登録">
		    </form>
	    </div>
    </div>
</body>
</html>