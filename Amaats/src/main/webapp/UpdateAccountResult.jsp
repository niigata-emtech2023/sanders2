<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集完了</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<div class="header"><jsp:include page = "header.jsp" />
		</div>
		アカウント情報の編集が完了しました。
		<form action = "show-account-servlet" method = "POST">
			<input type = "submit" value = "アカウント確認画面へ">
		</form>
		<% String authority = (String) session.getAttribute("authority"); 
		   if (authority.equals("user")) {%>
		<div class="footer"><jsp:include page = "footer.jsp"/></div>
		<% } %>
	</div>
</body>
</html>