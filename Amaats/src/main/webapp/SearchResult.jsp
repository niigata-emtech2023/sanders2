<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<div class="header"><%@ include file="header.jsp" %>
	    </div>
	    <div id = "contents">
			<%
				List<SweetsBean> sweetsList
					= (List<SweetsBean>) request.getAttribute("sweetsList");
			%>
			<table><caption>検索結果一覧</caption>
				<thead><tr>
					<th>商品名</th>
					<th>値段</th>
					<th>ジャンル</th>
					<th>店舗ID</th>
					<th></th>
				</tr></thead>
				<tbody>
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
				</tbody>
			</table>
		</div>
		<div class="footer"><%@ include file="footer.jsp" %></div>
	</div>
</body>
</html>