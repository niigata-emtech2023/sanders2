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
		
		<%	AccountDAO adao = new AccountDAO();
			List<ShopBean> shopList = adao.getShopList(); %>
			
			<table>
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
						<form action = "search-result-servlet" method = "POST">
							<input type = "hidden" name = "shop_id" value = "<%=shop.getShop_id()%>">
							<input type = "submit" value = "商品一覧">
						</form>
					</td>
				</tr>
				<%}%>
			</table>
		</div>
		<footer>
		<div class="footer"><%@ include file="footer.jsp" %></div>
		</footer>
	</div>
</body>
</html>