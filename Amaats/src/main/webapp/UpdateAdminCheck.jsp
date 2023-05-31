<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"import="model.entity.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集確認画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div class="header"><%@ include file="header.jsp"%>
	</div>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	アカウント編集情報を以下の内容に変更します。よろしいですか？
	<br>
	<%
    AdminBean bean = (AdminBean)request.getAttribute("bean");
    %>
    
	ログインID：<%=bean.getAdmin_id() %><br>
	パスワード：<%=bean.getAdmin_password() %><br>

	<form action="update-admin-account-servlet" method="POST">
		<input type="hidden" name = "admin_id" value=<%=bean.getAdmin_id() %>>
		<input type="hidden" name = "admin_password" value=<%=bean.getAdmin_password() %>>
		<input type="submit" value="はい">
	</form>

	<form action="UpdateUserAccount.jsp" method="POST">
		<input type="submit" value="戻る">
	</form>
	
	<jsp:include page = "footer.jsp">

</body>
</html>