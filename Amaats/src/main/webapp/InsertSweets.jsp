<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <form action="InsertSweetsServlet" method="POST">
    商品名：<input type="text" name="sweets_name"><br>
    カテゴリ：<input type ="select" name="sweets_category"><br>
    価格：<input type = "text" name="sweets_value"><br>
    商品情報：<input type="text" name="sweets_info"><br>
    
    <input type="submit" value="登録">

</body>
</html>