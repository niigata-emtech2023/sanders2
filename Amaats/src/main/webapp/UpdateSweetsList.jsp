<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List, model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集商品選択</title>
<link rel = "stylesheet" href = "css/style_base.css">
<link rel = "stylesheet" href = "css/style_table.css">
</head>
<body>
<div id="wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div id="contents">
			<%
				List<SweetsBean> sweetsList
					= (List<SweetsBean>) request.getAttribute("beanList");
			%>
			<% try { sweetsList.get(1); %>
			<table>
				<caption>検索結果一覧</caption>
				<thead>
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>ジャンル</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					for (SweetsBean sweets : sweetsList) {
					%>
					<tr>
						<td><%=sweets.getSweets_name()%></td>
						<td><%=sweets.getSweets_value()%></td>
						<td><%=sweets.getSweets_genre()%></td>
						<td>

							<form action="show-update-sweets-servlet" method="POST">
								<input type="hidden" name="sweets_id" value="<%=sweets.getSweets_id()%>">
								<input type="hidden" name="sweets_name" value="<%=sweets.getSweets_name()%>">
								<input type="hidden" name="sweets_value" value="<%=sweets.getSweets_value()%>">
								<input type="hidden" name="sweets_genre" value="<%=sweets.getSweets_genre()%>">
								<input type="hidden" name="sweets_info" value="<%=sweets.getSweets_info()%>">
								<input type="hidden" name="path" value="<%=sweets.getPath()%>">
								<input type="submit" value="編集">
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
	</div>
</body>
</html>