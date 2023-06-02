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
	<div id="wrapper">
    	<div class = "header"><%@ include file="header.jsp" %></div>
    	<div id="contents">
	   	 <% 
	   	 List<SweetsBean> sweetsList = (List<SweetsBean>)request.getAttribute("beanList");
	   	 %>
	    <div align = "center">
	    <table border = 1>
			<tr>
				<th>商品名</th>
				<th>値段</th>
				<th>ジャンル</th>
				<th></th>
			</tr>
			<%
				for (SweetsBean sweets : sweetsList) {
			%>
			<tr>
				
				<td><%=sweets.getSweets_name()%></td>
				<td><%=sweets.getSweets_value()%></td>
				<td><%=sweets.getSweets_genre()%></td>
				<td>
				
					<form action="CheckDeleteSweets.jsp" method="POST">
						<input type="hidden" name="sweets_id" value="<%=sweets.getSweets_id()%>">
						<input type="hidden" name="sweets_name" value="<%=sweets.getSweets_name()%>">
						<input type="hidden" name="sweets_genre" value="<%=sweets.getSweets_genre()%>">
						<input type="hidden" name="sweets_value" value="<%=sweets.getSweets_value()%>">
						<input type="hidden" name="sweets_info" value="<%=sweets.getSweets_info()%>">
						<input type="submit" value="削除">
						
					</form>
				</td>
			</tr>
			<% 
			}
			%>
		</table>
		</div>
		</div>
	</div>
</body>
</html>