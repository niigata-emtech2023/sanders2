<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<link rel="stylesheet" href="css/style_base.css">
<link rel = "stylesheet" href = "css/style_table.css">
</head>
<body>
	<div class="wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div class="contents">
			<%
				List<SweetsBean> sweetsList
					= (List<SweetsBean>) request.getAttribute("beanList");
			%>
			<% try { sweetsList.get(1);%>
			<table>
				<caption>検索結果一覧</caption>
				<thead>
					<tr>
						<th class="td1">商品名</th>
						<th class="td2">値段</th>
						<th class="td3">ジャンル</th>
						<th class="td4">店舗ID</th>
						<th></th>
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
						<td class="td4"><%=sweets.getShop_id()%></td>
<!-- 						<td></td> -->
						<td class="td5">

							<form action="show-sweets-info-servlet" method="POST">
								<input type="hidden" name="id"
									value="<%=sweets.getSweets_id()%>"> <input
									type="submit" value="詳細表示">
							</form>
						</td>
					</tr>
					<%
					}
				%>
				</tbody>
			</table>
			<% } catch (NullPointerException e) { %>
			該当する商品はありませんでした。<br>
			<% } %>
		</div>
		<div class="footer"><%@ include file="footer.jsp"%></div>
	</div>
</body>
</html>