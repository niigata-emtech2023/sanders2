<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集完了</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class = "wrapper">
		<div class="header"><jsp:include page = "header.jsp" />
		</div>
		<div class="contents">
			<div class="textsize">アカウント情報の編集が完了しました。</div>
			<form action = "show-account-servlet" method = "POST">
				<input type = "submit" value = "アカウント確認画面へ" class="send">
			</form>
			<% String authority = (String) session.getAttribute("authority"); 
			   if (authority.equals("user")) {%>
			<div class="footer"><jsp:include page = "footer.jsp"/></div>
			<% } %>
		</div>
	</div>
</body>
</html>