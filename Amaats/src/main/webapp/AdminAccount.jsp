<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント情報確認画面</title>
<link rel="stylesheet" href = "style.css">
</head>
<body>
    <div class = "header"><%@ include file="header.jsp" %></div>
    
     <%
    AdminBean bean = (AdminBean)request.getAttribute("bean");
    %>
    ログインID：<%=bean.getAdmin_id() %><br>
    
    <form action="UpdateAdminAccount.jsp" method="POST">
        <input type="submit" value="編集する">
    </form>
    <div class = "footer"><%@ include file="footer.jsp" %></div>
</body>
</html>