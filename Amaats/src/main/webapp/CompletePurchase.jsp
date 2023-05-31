<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確定画面</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
	<div id="wrapper">
		<div class = "header"><%@ include file="header.jsp" %></div>
			<div id="contents">
			ご注文ありがとうございました。
			<form action="MenuServlet" method="post">
				<inout type="submit" value="メニュー画面に戻る">
			</form>
		</div>
		<div class = "footer"><%@ include file="footer.jsp" %></div>
	</div>
</body>
</html>