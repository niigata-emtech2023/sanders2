<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class="wrapper">
		<div class="header"><jsp:include page = "header.jsp" /></div>
	 	<div class="contents">
		<form action="show-delete-user-account-servlet" method="POST">
		 <div class="textsize">
		 	削除が完了しました。
		 </div>
		 <br>
		 <input type ="submit" value="戻る" class="send">
		 </form>
	 </div>
	 </div>
</body>
</html>