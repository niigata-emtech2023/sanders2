<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats 商品一覧ページ</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div class="header"><jsp:include page = "header.jsp" />
	</div>
	<%
		List<SweetsBean> sweetsList
			= (List<SweetsBean>) request.getAttribute("sweetsList");
	%>
	<table border = "1">
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
			
				<form action="show-sweets-info-servlet" method="POST">
					<input type="hidden" name="id" value="<%=sweets.getSweets_id()%>">
					<input type="submit" value="詳細表示">
					
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<jsp:include page = "footer.jsp" />
</body>
</html>