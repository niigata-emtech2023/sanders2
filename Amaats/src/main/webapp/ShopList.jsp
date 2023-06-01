<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.dao.AccountDAO,model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗一覧</title>
<link rel = "stylesheet" href = "css/style_base.css">
<link rel = "stylesheet" href = "css/list_table.css">
</head>
<body>
	<div class = "wrapper">
		<header>
		<div class="header"><%@ include file="header.jsp" %>
		</div>
		</header>
		<div class = "contents">
		<%	AccountDAO adao = new AccountDAO();
			List<ShopBean> shopList = adao.getShopList(); %>
			
			<table>
				<thead>
					<tr>
						<th class="td1">店舗名</th>
						<th class="td2">住所</th>
<!-- 						<th></th> -->
					</tr>
				</thead>
				<tbody>
				<% for (ShopBean shop: shopList) {%>
				<tr>
					<td class="td1"><%=shop.getShop_name()%></td>
					<td class="td2"><%=shop.getShop_address()%></td>
					<td class="td3">
						<form action = "search-shop-servlet" method = "POST">
							<input type = "hidden" name = "shop_id" value = "<%=shop.getShop_id()%>">
							<input type = "submit" value = "商品一覧">
						</form>
					</td>
				</tr>
				<%}%>
				</tbody>
			</table>
		</div>
		<footer>
		<div class="footer"><%@ include file="footer.jsp" %></div>
		</footer>
	</div>
</body>
</html>