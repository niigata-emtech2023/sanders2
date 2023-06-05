<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報-変更登録結果</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class = "wrapper">
	<div class="header"><%@ include file="header.jsp" %>
	</div>
	<div class = "contents">
		<%
			int processingNumber = (Integer) request.getAttribute("processingNumber");
			if (processingNumber > 0) {
		%>
		<div class="textleft">商品情報を変更しました。<br></div>
		<%
			} else {
		%>
		商品情報を変更できませんでした。<br>
		<%
			}
		%>
		<form action="show-update-sweets-list-servlet" method="POST">
			<input type="submit" value="一覧画面に戻る">
		</form>
	</div>
	</div>
</body>
</html>