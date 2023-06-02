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
			<div class="alert">
				アカウント情報を以下の内容に変更します。<br>
				よろしいですか？
			</div>
			<br>
			<%
		    AdminBean bean = (AdminBean)request.getAttribute("bean");
		    %>
		    
		    <div class="textleft">
				ログインID：<%=bean.getAdmin_id() %><br>
				パスワード：<%=(String) request.getAttribute("admin_password")%><br>
			</div>
			<form action="update-admin-account-servlet" method="POST">
					<input type="hidden" name = "admin_id" value=<%=bean.getAdmin_id() %>>
					<input type="hidden" name = "admin_password" value=<%=(String) request.getAttribute("admin_password")%>>
				<input type="submit" value="変更" class="send2" id="yes">
			</form>
		
			<form action="UpdateAdminAccount.jsp" method="POST">
					<input type="hidden" name = "admin_id" value=<%=bean.getAdmin_id() %>>
					<input type="hidden" name = "admin_password" value=<%=(String) request.getAttribute("admin_password")%>>
				<input type="submit" value="戻る" class="send2" id="no">
			</form>
		</div>
	</div>
</body>
</html>