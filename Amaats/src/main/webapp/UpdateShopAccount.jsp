<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗編集画面</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>

	<div class = "wrapper">
		<div class="header"><%@ include file="header.jsp" %>
		</div>
		<div class = "contents">
		<h3>店舗編集画面</h3>
			<form action="check-shop-update-servlet" method="post">
				<div class="textright2">
					<span id="textcenter5"> 店舗ID：<%=request.getParameter("shop_id")%></span><br>
					店舗名：<input type="text" name="shop_name" value="<%=request.getParameter("shop_name")%>" id="textcenter"><br>
					パスワード：<input type="password" name="shop_password" value="<%=request.getParameter("shop_password")%>" id="textcenter2"><br>
					住所：<input type="text" name="shop_address"value="<%=request.getParameter("shop_address")%>" id="textcenter3"><br>
					電話番号：<input type="text" name="shop_tel"value="<%=request.getParameter("shop_tel")%>" id="textcenter4"><br>
				</div>
				<input type = "hidden" name = "shop_id" value = "<%=request.getParameter("shop_id")%>">
				<br>
				<input type="submit" value="変更する" class="send">
			</form>
		</div>
		<div class="footer"><jsp:include page="footer.jsp" /></div>
	</div>

</body>
</html>