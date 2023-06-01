<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集確認画面</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class="wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div class="contents">
			<%
			request.setCharacterEncoding("UTF-8");
			%>
			アカウント情報を以下の内容に変更します。よろしいですか？
			<br>
			<%
		    AdminBean bean = (AdminBean)request.getAttribute("bean");
		    %>
		    
			ログインID：<%=bean.getAdmin_id() %><br>
			パスワード：<%=(String) request.getAttribute("admin_password")%><br>
		
			<form action="update-admin-account-servlet" method="POST">
				<div class="textsize">
					<input type="hidden" name = "admin_id" value=<%=bean.getAdmin_id() %>>
					<input type="hidden" name = "admin_password" value=<%=(String) request.getAttribute("admin_password")%>>
				</div>
				<input type="submit" value="変更" class="send" id="yes">
			</form>
		
			<form action="UpdateAdminAccount.jsp" method="POST">
				<div class="textsize">
					<input type="hidden" name = "admin_id" value=<%=bean.getAdmin_id() %>>
					<input type="hidden" name = "admin_password" value=<%=(String) request.getAttribute("admin_password")%>>
				</div>
				<input type="submit" value="戻る" class="send" id="no">
			</form>
		</div>
	</div>
</body>
</html>