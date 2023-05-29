<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント情報確認画面</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    
     <%
    AdminBean bean = (AdminBean)request.getAttribute("bean");
    %>
    名前：<%=bean.getAdmin_name() %><br>
    ログインID：<%=bean.getAdmin_id() %><br>
    
    <form action="UpdateAdminAccount.jsp" method="POST">
        <input type="submit" value="編集する">
    </form>
    <jsp:include page="footer.jsp" />
    

</body>
</html>