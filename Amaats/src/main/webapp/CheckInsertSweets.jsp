<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.SweetsBean"%>
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
		    <% SweetsBean sb = (SweetsBean) request.getAttribute("bean"); %>
		    
		    商品名：<%=sb.getSweets_name() %><br>
		    ジャンル：<%=sb.getSweets_genre() %><br>
		    価格：<%=sb.getSweets_value() %><br>
		    商品情報：<%=sb.getSweets_info() %><br>
		    商品画像：<% try {
		    				if (!sb.getPath().equals("")) {%>
		    					あり<br>
		    			 <% } 
		    			} catch (NullPointerException e) {%>
		    				なし<br>
		    		<%	} %>
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