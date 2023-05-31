<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者編集画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<div class="header"><%@ include file="header.jsp" %>
		</div>
		<div id = "contents">
			<form action="CheckAdminUpdateServlet" method="post">
				管理者ID：${admin.admin_id}<br>
				パスワード：<input type="password" name="admin_password" value="${admin.admin_password}"><br>
				<input type="submit" value="変更する">
			</form>
		</div>
		<div class="footer"><jsp:include page="footer.jsp" /></div>
	</div>
<<<<<<< HEAD
=======
	<form action="check-admin-update-servlet" method="post">
		管理者ID：${admin.admin_id}<br>
		パスワード：<input type="password" name="admin_password" value="${admin.admin_password}"><br>
		<input type="submit" value="変更する">
	</form>
	<jsp:include page="footer.jsp" />
>>>>>>> branch 'master' of https://github.com/niigata-emtech2023/sanders2
</body>
</html>