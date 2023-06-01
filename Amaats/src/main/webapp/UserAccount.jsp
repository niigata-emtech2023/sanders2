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
	<% request.setCharacterEncoding("UTF-8"); %>
	<div id = "wrapper">
	    <div class="header"><jsp:include page = "header.jsp" />
	    </div>
	    <div id = "contents">
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
		    	<input type = "hidden" name = "user_id" value = "<%=bean.getUser_id() %>">
		    	<input type = "hidden" name = "user_name" value = "<%=bean.getUser_name() %>">
		    	<input type = "hidden" name = "user_genre" value = "<%=bean.getUser_genre() %>">
		    	<input type = "hidden" name = "user_address" value = "<%=bean.getUser_address() %>">
		    	<input type = "hidden" name = "password" value = "<%=bean.getPassword() %>">
		        <input type="submit" value="編集する">
		    </form>
	    </div>
	    <div class="footer"><jsp:include page="footer.jsp" /></div>
    </div>
</body>
</html>