<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録</title>
</head>
<body>
    <div class="header"><%@ include file="header.jsp" %>
    </div>
    <span>${alert}</span>
    <form action="check-insert-sweets-info-servlet" method="POST">
    商品名：<input type="text" name="sweets_name"><br>
    カテゴリ：
    <select name="sweets_genre">
        <option value="default">選択してください</option>
        <option value="cake">ケーキ</option>
        <option value="cokkie">クッキー</option>
        <option value="chocolate">チョコレート</option>
    </select><br>
    
    価格：<input type = "text" name="sweets_value"><br>
    商品情報：<br>
    <textarea name="sweets_info" cols="40" rows="5">
    </textarea>
    
    <input type="submit" value="登録">
    </form>
</body>
</html>