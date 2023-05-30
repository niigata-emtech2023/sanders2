<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者編集画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<form action="CheckAdminUpdateServlet" method="post">
		管理者ID：${admin.admin_id}<br>
		パスワード：<input type="password" name="admin_password" value="${admin.admin_password}"><br>
		<input type="submit" value="変更する">
	</form>
	<jsp:include page="footer.jsp" />
</body>
</html>