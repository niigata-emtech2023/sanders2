<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録確認</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <form action="InsertSweetsServlet" method="POST">
    この内容で商品を登録しますがよろしいですか？
    <jsp:useBean id="bean" class="model.entity.SweetsBean" scope="request"/>
    
    商品ID：<jsp:getProperty name="bean" property="sweets_id" /><br>
    商品名：<jsp:getProperty name="bean" property="sweets_name" /><br>
    カテゴリ：<jsp:getProperty name="bean" property="sweets_category" /><br>
    価格：<jsp:getProperty name="bean" property="sweets_value" /><br>
    商品情報：<jsp:getProperty name="bean" property="sweets_info" /><br>
    
    <input type ="submit" value="いいえ">
    <input type ="submit" value="はい">
    
    </form>

</body>
</html>