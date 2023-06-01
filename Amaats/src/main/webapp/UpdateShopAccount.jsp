<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗編集画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>

	<div id = "wrapper">
		<div class="header"><%@ include file="header.jsp" %>
		</div>
		<div id = "contents">
			<form action="check-shop-update-servlet" method="post">
				店舗ID：<%=request.getParameter("shop_id")%><br>
				店舗名：<input type="text" name="shop_name" value="<%=request.getParameter("shop_name")%>"><br>
				パスワード：<input type="password" name="shop_password" value="<%=request.getParameter("shop_password")%>"><br>
				住所：<input type="text" name="shop_address"value="<%=request.getParameter("shop_address")%>"><br>
				電話番号：<input type="text" name="shop_tel"value="<%=request.getParameter("shop_tel")%>"><br>
				
				<input type = "hidden" name = "shop_id" value = "<%=request.getParameter("shop_id")%>">
				<input type="submit" value="変更する">
			</form>
		</div>
		<div class="footer"><jsp:include page="footer.jsp" /></div>
	</div>

</body>
</html>