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
		    <span class="alert">${alert}</span>
		    <form action="check-insert-sweets-info-servlet" method="POST"  enctype="multipart/form-data">
		    <div class="textleft">
			    商品名：<input type="text" name="sweets_name"><br>
			    ジャンル：
			    <select name="sweets_genre" class="send">
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
			    <textarea name="sweets_info" cols="40" rows="5"></textarea>
			    <br>
			    写真：<input type="file" name="pict" class="send"><br>
			    <div class="img"><input type="submit" value="登録" class="send"></div>
		    </div>
		    </form>
	    </div>
    </div>
</body>
</html>