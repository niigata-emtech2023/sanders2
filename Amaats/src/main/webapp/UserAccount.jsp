<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント情報確認画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
    <div class="header"><jsp:include page = "header.jsp">
    </div>
    <%
    UserBean bean = (UserBean)request.getAttribute("bean");
    %>
    名前：<%=bean.getUser_name() %><br>
    ログインID：<%=bean.getUser_id() %><br>
    住所：<%=bean.getUser_address() %><br>
    好きなジャンル：
    <%String user_genre;
    try{
    	user_genre=bean.getUser_genre();
    }catch(NullPointerException e){
    	user_genre="";
    }
    %>
    <%=user_genre %>
    
    
    <form action="UpdateUserAccount.jsp" method="POST">
        <input type="submit" value="編集する">
    </form>
    
    <jsp:include page="footer.jsp" />
    

</body>
</html>