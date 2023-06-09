<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List, model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集商品選択</title>
<link rel = "stylesheet" href = "css/style_base.css">
<link rel = "stylesheet" href = "css/sweets.css">
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
			<% try { sweetsList.get(1); %>
			<table>
				<caption>検索結果一覧</caption>
				<thead>
					<tr>
						<th class="td1">商品名</th>
						<th class="td2">値段</th>
						<th class="td3">ジャンル</th>
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
						<td class="td5">
							<form action = "SelectImage.jsp" method = "POST">
								<input type="hidden" name="sweets_id" value="<%=sweets.getSweets_id()%>">
								<input type="hidden" name="sweets_name" value="<%=sweets.getSweets_name()%>">
								<input type="submit" value="画像変更">
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