<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.dao.AccountDAO,model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗一覧</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<header>
		<div class="header"><%@ include file="header.jsp" %>
		</div>
		</header>
		<div id = "contents">
		
<<<<<<< HEAD
		<%	AccountDAO adao = new AccountDAO();
			List<ShopBean> shopList = adao.getShopList(); %>
			
			<table>
				<thead>
					<tr>
						<th>店舗名</th>
						<th>住所</th>
						<th></th>
					</tr>
				</thead>
				<% for (ShopBean shop: shopList) {%>
				<tbody>
				<tr>
					<td><%=shop.getShop_name()%></td>
					<td><%=shop.getShop_address()%></td>
					<td>
						<form action = "search-result-servlet" method = "POST">
							<input type = "hidden" name = "shop_id" value = "<%=shop.getShop_id()%>">
							<input type = "submit" value = "商品一覧">
						</form>
					</td>
				</tr>
				</tbody>
				<%}%>
			</table>
		</div>
		<footer>
		<div class="footer"><%@ include file="footer.jsp" %></div>
		</footer>
	</div>
=======
		<table border = "1">
			<tr>
				<th>店舗名</th>
				<th>住所</th>
				<th></th>
			</tr>
			<% for (ShopBean shop: shopList) {%>
			<tr>
				<td><%=shop.getShop_name()%></td>
				<td><%=shop.getShop_address()%></td>
				<td>
					<form action = "search-shop-servlet" method = "POST">
						<input type = "hidden" name = "shop_id" value = "<%=shop.getShop_id()%>">
						<input type = "submit" value = "商品一覧">
					</form>
				</td>
			</tr>
			<%}%>
		</table>
	
	<footer>
	<%@ include file="footer.jsp" %>
	</footer>
>>>>>>> branch 'master' of https://github.com/niigata-emtech2023/sanders2
</body>
</html>