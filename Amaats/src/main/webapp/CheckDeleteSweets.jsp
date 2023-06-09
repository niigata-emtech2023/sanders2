<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.SweetsBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除：確認画面</title>
<link rel="stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div class="contents">
			<%
			request.setCharacterEncoding("UTF-8");
			%>
			<div class="alert">
			商品を削除します。
			<br> 本当によろしいですか？
			</div><br>
			<%
			String sweets_id =  request.getParameter("sweets_id");
			String sweets_name =  request.getParameter("sweets_name");
			String sweets_genre =  request.getParameter("sweets_genre");
			int sweets_value = Integer.parseInt(request.getParameter("sweets_value"));
			String sweets_info =  request.getParameter("sweets_info");
			%>
		
		<div class="textleft">
			商品ID：<%=sweets_id%><br> 
			商品名：<%=sweets_name%><br>
			値段：<%=sweets_value%><br> 
			ジャンル：<%=sweets_genre%><br>
			詳細情報：<%=sweets_info%><br> 
		</div>
		<div>
			<form action="delete-sweets-servlet" method="POST">
				<input type="hidden" name="sweets_id" value=<%=sweets_id%>>
				<input type="submit" value="はい" id="yes" class="send">
			</form>
			
				<form action="show-delete-sweets-servlet" method="POST">
					<input type="submit" value="いいえ" id="no" class="send">
				</form>
			</div>
		</div>
	</div>
</body>
</html>