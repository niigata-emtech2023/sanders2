<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント情報確認画面</title>
<link rel="stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class="wrapper">
	    <div class = "header"><%@ include file="header.jsp" %></div>
	    <div class="contents">
		     <%
		    AdminBean bean = (AdminBean)request.getAttribute("bean");
		    %>
		    <div class="textsize">ログインID：<%=bean.getAdmin_id() %><br></div>
		    
		    <form action="UpdateAdminAccount.jsp" method="POST">
		    	<input type = "hidden" name = "admin_id" value = "<%=bean.getAdmin_id() %>">
		        <input type="submit" value="編集する" class="send">
		    </form>
	    </div>
    </div>
</body>
</html>