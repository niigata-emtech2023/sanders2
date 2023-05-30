<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗アカウント登録確認</title>
</head>
<body>
	<jsp:include page = "header.jsp">
	登録が完了しました。
	<form action="InsertAccountServlet" method="post">
		<input type="submit" value="メニュー画面に戻る">
	</form>
	<jsp:include page = "footer.jsp">
</body>
</html>