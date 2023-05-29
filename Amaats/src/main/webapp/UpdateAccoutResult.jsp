<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集完了</title>
</head>
<body>
	<jsp:include page = "header.jsp" />
	アカウント情報の編集が完了しました。
	<form action = "show-account-servlet" method = "POST">
		<input type = "submit" value = "アカウント確認画面へ">
	</form>
	<jsp:include page = "footer.jsp" />
</body>
</html>