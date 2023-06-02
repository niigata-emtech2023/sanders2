<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>画像選択画面</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<div class="wrapper">
		<div class="header"><jsp:include page = "header.jsp" />
		</div>
		<div class="contents">
			<h3>画像選択</h3><br>
			商品ID：<%=request.getParameter("sweets_id") %><br>
			商品名：<%=request.getParameter("sweets_name") %><br>
			<form action="insert-image-servlet" method="post" enctype="multipart/form-data">
				好きな写真:<input type="file" name="pict"><br>
				<input type="hidden" name = "sweets_id" value = "<%=request.getParameter("sweets_id") %>">
				<input type="submit" value = "変更">
			</form>
		</div>
	</div>
</body>
</html>