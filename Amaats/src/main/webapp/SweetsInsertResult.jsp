<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録確認画面</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class = "wrapper">
	    <div class="header"><%@ include file="header.jsp" %>
	    </div>
	    <div class = "contents">
		    <form action="show-insert-sweets-servlet" method="POST">
		    <div class="textleft">
			    以下の内容で商品の登録が完了しました
			    <%
			    SweetsBean bean = (SweetsBean) request.getAttribute("bean");
			    %>
			    
			    商品ID：<%=bean.getSweets_id()%><br>
			    商品名：<%=bean.getSweets_name()%><br>
			    カテゴリ：<%=bean.getSweets_genre()%><br>
			    価格：<%=bean.getSweets_value()%><br>
			    商品情報：<%=bean.getSweets_info()%><br>
		    </div>
		    <input type ="submit" value="戻る" class="send">
		    </form>
	    </div>
	</div>
</body>
</html>