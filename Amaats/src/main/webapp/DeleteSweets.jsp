<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報削除画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
    <div class = "header"><%@ include file="header.jsp" %></div>
    <% 
    List<SweetsBean> sweetsList = (List<SweetsBean>)request.getAttribute("sweetsList");
    %>
    
    <table>
		<tr>
			<th>商品名</th>
			<th>値段</th>
			<th>ジャンル</th>
			<th>店舗ID</th>
			<th></th>
		</tr>
		<%
			for (SweetsBean sweets : sweetsList) {
		%>
		<tr>
			
			<td><%=sweets.getSweets_name()%></td>
			<td><%=sweets.getSweets_value()%></td>
			<td><%=sweets.getSweets_genre()%></td>
			<td><%=sweets.getShop_id()%></td>
			<td></td>
			<td>
			
				<form action="CheckDeleteSweets.jsp" method="POST">
					<input type="hidden" name="id" value="<%=sweets.getSweets_id()%>">
					<input type="submit" value="削除">
					
				</form>
			</td>
		</tr>
		<% }
		%>

</body>
</html>