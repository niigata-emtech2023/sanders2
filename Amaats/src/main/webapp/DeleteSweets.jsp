<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報削除画面</title>
<link rel = "stylesheet" href = "css/style_base.css">
<link rel = "stylesheet" href = "css/sweets_table.css">
</head>
<body>
	<div class="wrapper">
    	<div class = "header"><%@ include file="header.jsp" %></div>
    	<div class="contents">
	   	 <% 
	   	 List<SweetsBean> sweetsList = (List<SweetsBean>)request.getAttribute("beanList");
	   	 %>
	    
	    <table>
	    	<thead>
			<tr>
				<th class="td1">商品名</th>
				<th class="td2">値段</th>
				<th class="td3">ジャンル</th>
<!-- 				<th></th> -->
			</tr>
			</thead>
			<tbody>
			<%
				for (SweetsBean sweets : sweetsList) {
			%>
			<tr>
				
				<td class="td1"><%=sweets.getSweets_name()%></td>
				<td class="td2"><%=sweets.getSweets_value()%></td>
				<td class="td3"><%=sweets.getSweets_genre()%></td>
				<td class="td4">
				
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
			</tbody>
			</table>
		</div>
	</div>
</body>
</html>