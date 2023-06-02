<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報-変更登録結果</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
	<div class="header"><%@ include file="header.jsp" %>
	</div>
	<div id = "contents">
		<%
			int processingNumber = (Integer) request.getAttribute("processingNumber");
			if (processingNumber > 0) {
		%>
		商品情報を変更しました。<br>
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