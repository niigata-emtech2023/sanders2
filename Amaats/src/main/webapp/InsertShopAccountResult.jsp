<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗登録完了</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id="wrapper">
	 <div class="header"><jsp:include page = "header.jsp" /></div>
	 <div id="contents">
		 <form action="show-insert-shop-account-servlet" method="POST">
		 
		 登録が完了しました。<br>
		 
		 <input type ="submit" value="戻る">
		 </form>
	</div>
	<div class="footer"><jsp:include page = "footer.jsp" /></div>
	</div>
</body>
</html>