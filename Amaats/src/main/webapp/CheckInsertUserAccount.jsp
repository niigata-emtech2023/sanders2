<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー新規登録確認</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	<div class="wrapper">
		<div class="contents">
			この内容で登録しますがよろしいですか？<br>
			<br>
			名前：<%=request.getParameter("user_name")%><br>
			ログインID：<%=request.getParameter("user_id")%><br>
			パスワード：
			<% for (int i = 1; i <= request.getParameter("password").length(); i++) { %>
			*
			<% } %><br>
			住所：<%=request.getParameter("user_address")%><br>
			<div style = "display:inline-flex">
			<form action = "InsertUserAccount.jsp" method = "POST">
				<div class="textsize">
					<input type = "hidden" name = "user_name" value = "<%=request.getParameter("user_name")%>">
					<input type = "hidden" name = "user_id" value = "<%=request.getParameter("user_id")%>">
					<input type = "hidden" name = "password" value = "<%=request.getParameter("password")%>">
					<input type = "hidden" name = "passcon" value = "<%=request.getParameter("passcon")%>">
					<input type = "hidden" name = "user_address" value = "<%=request.getParameter("user_address")%>">
					<input type = "submit" value = "いいえ" class="send">
				</div>
			</form>
			<form action = "insert-user-account-servlet" method = "POST">
				<div class="textsize">
					<input type = "hidden" name = "user_id" value = "<%=request.getParameter("user_id")%>">
					<input type = "hidden" name = "user_name" value = "<%=request.getParameter("user_name")%>">
					<input type = "hidden" name = "password" value = "<%=request.getParameter("password")%>">
					<input type = "hidden" name = "user_address" value = "<%=request.getParameter("user_address")%>">
					<input type = "submit" value = "はい" class="send">
				</div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>