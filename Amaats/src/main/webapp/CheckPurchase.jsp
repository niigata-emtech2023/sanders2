<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	<div id="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div id="contents">
			ご注文内容<br>
			<form action="CompletePurchaseServlet" method="post">
			<%
				List<SweetsBean> cartList = (List<SweetsBean>) request.getAttribute("cartList");
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
				</tr>
			<%
				}
			%>
				</table>
				<input type="submit" value="注文を確定する">
			</form>
		</div>
		<div class = "footer"><%@ include file="footer.jsp" %></div>
	</div>
</body>
</html>