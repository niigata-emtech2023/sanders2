<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者編集画面</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class = "wrapper">
		<div class="header"><%@ include file="header.jsp" %>
		</div>
		<div class = "contents">
			<form action="check-admin-update-servlet" method="post">
				<div class="textsize2">
					ログインID：<%=request.getParameter("admin_id")%><br>
					パスワード：<input type="password" name="admin_password" value="${admin_password}"><br></div>
				<br><input type="submit" value="変更する" class="send">
			</form>
		</div>
	</div>
</body>
</html>