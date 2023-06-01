<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集確認画面</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
		<% request.setCharacterEncoding("UTF-8");
	   UserBean bean = (UserBean)request.getAttribute("bean");
	   String password = bean.getPassword();
	   String user_name = bean.getUser_name();
	   String user_genre; String user_address;
	   try {  user_genre = bean.getUser_genre(); } catch (NullPointerException e) { user_genre = ""; }
	   try {  user_address = bean.getUser_address(); } catch (NullPointerException e) { user_address = ""; }%>
	<div class = "wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div class = "contents">
			<%
			request.setCharacterEncoding("UTF-8");
			%>
			<div class="text">
				アカウント編集情報を以下の内容に変更します。<br>
				よろしいですか？
			</div>
			<br>
			<div class="textleft">
				ログインID：<%=bean.getUser_id() %><br>
				氏名：<%=user_name %><br>
				パスワード：<%=password %><br>
				好きなジャンル：<%=user_genre %><br>
				住所：<%=user_address %><br>
			</div>
			<form action="update-user-account-servlet" method="POST">
				<input type="hidden" name = "user_id" value=<%=bean.getUser_id() %>>
				<input type="hidden" name = "user_name" value=<%=user_name %>>
				<input type="hidden" name = "password" value=<%=password %>>
				<input type="hidden" name = "user_genre" value=<%=user_genre %>>
				<input type="hidden" name = "user_address" value=<%=user_address %>>
				<input type="submit" value="変更" class="send" id="yes">
			</form>
		
			<form action="UpdateUserAccount.jsp" method="POST">
				<input type="submit" value="戻る" class="send" id="no">
			</form>
		</div>
		<div class="footer"><jsp:include page = "footer.jsp" /></div>
	</div>
</body>
</html>