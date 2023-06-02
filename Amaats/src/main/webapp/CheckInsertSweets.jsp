<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録確認</title>
<link rel="stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div class="contents">
	    	<div class="textleft">
			    この内容で商品を登録しますがよろしいですか？<br>
			    <% SweetsBean sb = (SweetsBean) request.getAttribute("bean"); %>
			    
			    商品名：<%=sb.getSweets_name() %><br>
			    ジャンル：<%=sb.getSweets_genre() %><br>
			    価格：<%=sb.getSweets_value() %><br>
			    商品情報：<%=sb.getSweets_info() %><br>
			</div>
		    <div style="display:inline-flex">
		    <form action="insert-sweets-servlet" method="POST">
		    <input type = "hidden" name = "sweets_name" value = "<%=sb.getSweets_name()%>" >
		    <input type = "hidden" name = "sweets_genre" value = "<%=sb.getSweets_genre()%>" >
		    <input type = "hidden" name = "sweets_value" value = "<%=sb.getSweets_value()%>" >
		    <input type = "hidden" name = "sweets_info" value = "<%=sb.getSweets_info()%>" >
		    <input type ="submit" value="はい" id="yes" class="send">
		    </form>
		    
		    <form action="show-insert-sweets-servlet" method="POST">
		    <input type ="submit" value="いいえ" id="no" class="send">
		    </form>
		    </div>
		</div>
	</div>
</body>
</html>