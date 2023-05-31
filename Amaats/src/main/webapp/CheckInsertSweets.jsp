<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録確認</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	<div id="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div id="contents">
		    この内容で商品を登録しますがよろしいですか？
		    <jsp:useBean id="bean" class="model.entity.SweetsBean" scope="session"/>
		    
		    商品ID：<jsp:getProperty name="bean" property="sweets_id" /><br>
		    商品名：<jsp:getProperty name="bean" property="sweets_name" /><br>
		    カテゴリ：<jsp:getProperty name="bean" property="sweets_category" /><br>
		    価格：<jsp:getProperty name="bean" property="sweets_value" /><br>
		    商品情報：<jsp:getProperty name="bean" property="sweets_info" /><br>
		    
		    <div style="display:inline-flex">
		    <form action="insert-sweets-servlet" method="POST">
		    <input type ="submit" value="はい">
		    </form>
		    
		    <form action="show-insert-sweets-servlet" method="POST">
		    <input type ="submit" value="いいえ">
		    </form>
		    </div>
		</div>
		<div class = "footer"><%@ include file="footer.jsp" %></div>
	</div>
</body>
</html>