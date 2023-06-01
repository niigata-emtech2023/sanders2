<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.UserBean,java.util.List"
						 import="model.entity.ShopBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集画面</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); 
	   String password = request.getParameter("password");
	   String user_name = request.getParameter("user_name");
	   String user_genre; String user_address;
	   try {  user_genre = request.getParameter("user_genre"); } catch (NullPointerException e) { user_genre = ""; }
	   try {  user_address = request.getParameter("user_address"); } catch (NullPointerException e) { user_address = ""; }%>
	<div class = "wrapper">
		<div class="header"><%@ include file="header.jsp" %>
		</div>
		<div class = "contents">
			<form action="check-user-update-servlet" method="post">
				<div class="textleft">
					ログインID：<%=request.getParameter("user_id")%><br>
					氏名：<input type="text" name="user_name" value="<%=user_name%>"><br>
					パスワード：<input type="password" name="password" value="<%=password%>"><br>
					好きなジャンル：<input type="text" name="user_genre"value="<%=user_genre%>"><br>
					住所：<input type="text" name="user_address"value="<%=user_address%>"><br>
				</div>
				<input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>">
				<br>
				<input type="submit" value="変更する" class="send">
			</form>
		</div>
		<div class="footer"><jsp:include page="footer.jsp" /></div>
	</div>
</body>
</html>