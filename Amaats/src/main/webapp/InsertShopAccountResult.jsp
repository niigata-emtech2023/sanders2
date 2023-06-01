<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>店舗登録完了</title>
<!-- <link rel = "stylesheet" href = "style.css"> -->
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class="wrapper">
	 <div class="header"><jsp:include page = "header.jsp" /></div>
	 <div class="contents">
		 <form action="show-insert-shop-account-servlet" method="POST">
		 
		 登録が完了しました。<br>
		 
		 <input type ="submit" value="戻る">
		 </form>
	</div>
	</div>
</body>
</html>