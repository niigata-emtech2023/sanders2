<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗編集確認画面</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class = "wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div class = "contents">
		<%
		request.setCharacterEncoding("UTF-8");
		%>
		<div class="alert">
			店舗アカウント編集情報を以下の内容に変更します。<br>
			よろしいですか？
		</div>
		<br>
		<%
	    ShopBean bean = (ShopBean)request.getAttribute("bean");
	    %>
	    <div class="textleft">
			店舗ID：<%=bean.getShop_id() %><br>
			店舗名：<%=bean.getShop_name() %><br>
			パスワード：<%=bean.getShop_password() %><br>
			住所：<%=bean.getShop_address() %><br>
			電話番号：<%=bean.getShop_tel() %><br>
		</div>
		<form action="update-shop-account-servlet" method="POST">
			<input type="hidden" name = "shop_id" value=<%=bean.getShop_id() %>>
			<input type="hidden" name = "shop_name" value=<%=bean.getShop_name() %>>
			<input type="hidden" name = "shop_password" value=<%=bean.getShop_password() %>>
			<input type="hidden" name = "shop_address" value=<%=bean.getShop_address() %>>
			<input type="hidden" name = "shop_tel" value=<%=bean.getShop_tel() %>>
			<input type="submit" value="はい" id="yes" class="send">
		</form>
	
		<form action="UpdateShopAccount.jsp" method="POST">
			<input type="submit" value="戻る" id="no" class="send">
		</form>
		</div>
		<div class="footer"><jsp:include page="footer.jsp" /></div>
	</div>

</body>
</html>