<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.SweetsBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除：確認画面</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	商品を削除します。
	<br> 本当によろしいですか？
	<%
	SweetsBean bean = (SweetsBean) request.getAttribute("bean");
	%>


	商品ID：<%=bean.getSweets_id()%><br> 
	商品名：<%=bean.getSweets_name()%><br>
	値段：<%=bean.getSweets_value()%><br> 
	カテゴリ：<%=bean.getSweets_genre()%><br>
	詳細情報：<%=bean.getSweets_info()%><br> 
	店舗ID：<%=bean.getShop_id()%><br>




	<form action="delete-sweets-servlet" method="POST">
		<input type="hidden" name="sweets_id" value=<%=bean.getSweets_id()%>>
		<input type="hidden" name="sweets_name"value=<%=bean.getSweets_name()%>> 
		<input type="hidden"name="sweets_value" value=<%=bean.getSweets_value()%>> 
		<input type="hidden" name="sweets_genre" value=<%=bean.getSweets_genre()%>>
		<input type="hidden" name="sweets_info"value=<%=bean.getSweets_info()%>>
		<input type="hidden"name="shop_id" value=<%=bean.getShop_id()%>> 
		<input type="submit" value="はい">
	</form>





	<div>
		<form action="show-delete-sweets-servlet" method="POST">
			<input type="submit" value="いいえ">
		</form>


	</div>
</body>
</html>