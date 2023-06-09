<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	<div id="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div id="contents">
			<form action="CheckPurchaseServlet" method="post">
				<%
					List<SweetsBean> cartList = (List<SweetsBean>) request.getAttribute("cartList");
		
					if (cartList.size() != 0) {
				%>
			<h3>カート商品一覧</h3>
		
			<table>
				<tr>
					<th>商品名</th>
					<th>値段</th>
					<th>数量</th>
				</tr>
			<%
					for (SweetsBean sweets : cartList) {
			%>
				<tr>
					<td><%=sweets.getSweets_name()%></td>
					<td><%=sweets.getSweets_value()%></td>
					<td><input type="button" name="quantity"></td>
				</tr>
			<%
					}
			%>
				</table>
			<%
				} else {
			%>
			カート内に商品が入っていません。<br>
			<%
				}
			%>
				<input type="submit" value="購入する">
			</form>
		</div>
		<div class = "footer"><%@ include file="footer.jsp" %></div>
	</div>
</body>
</html>