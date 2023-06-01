<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント情報確認画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
	    <div class="header"><%@ include file="header.jsp" %></div>
	    <div id = "contents">
		    
		    <%
		    ShopBean bean = (ShopBean)request.getAttribute("bean");
		    %>
		    店舗名：<%=bean.getShop_name() %><br>
		    ログインID：<%=bean.getShop_id() %><br>
		    パスワード：<%=bean.getShop_password() %><br>
		    住所：<%=bean.getShop_address() %><br>
		    電話番号：<%=bean.getShop_tel() %><br>
		    
		    <form action="UpdateShopAccount.jsp" method="POST">
		    	<input type = "hidden" name = "shop_name" value = "<%=bean.getShop_name() %>">
				<input type = "hidden" name = "shop_id" value = "<%=bean.getShop_id() %>">
				<input type = "hidden" name = "shop_password" value = "<%=bean.getShop_password() %>">
				<input type = "hidden" name = "shop_address" value = "<%=bean.getShop_address() %>">
				<input type = "hidden" name = "shop_tel" value = "<%=bean.getShop_tel() %>">
		        <input type="submit" value="編集する">
		    </form>
	    </div>
	    <div class="footer"><jsp:include page="footer.jsp" /></div>
    </div>
</body>
</html>