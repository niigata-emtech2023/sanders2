<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント編集確認画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
	<div id = "wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div id = "contents">
			<%
			request.setCharacterEncoding("UTF-8");
			%>
			アカウント編集情報を以下の内容に変更します。よろしいですか？
			<br>
			<%
		    UserBean bean = (UserBean)request.getAttribute("bean");
		    %>
		
			<%= %>
			ユーザID：<%=bean.getUser_id() %><br>
			氏名：<%=bean.getUser_name() %><br>
			パスワード：<%=bean.getPassword() %><br>
			好きなジャンル：<%=bean.getUser_genre() %><br>
			住所：<%=bean.getUser_address() %><br>
		
			<form action="update-user-account-servlet" method="POST">
				<input type="hidden" name = "user_id" value=<%=bean.getUser_id() %>>
				<input type="hidden" name = "user_name" value=<%=bean.getUser_name() %>>
				<input type="hidden" name = "password" value=<%=bean.getPassword() %>>
				<input type="hidden" name = "user_genre" value=<%=bean.getUser_genre() %>>
				<input type="hidden" name = "user_address" value=<%=bean.getUser_address() %>>
				<input type="submit" value="はい">
			</form>
		
			<form action="UpdateUserAccount.jsp" method="POST">
				<input type="submit" value="戻る">
			</form>
		</div>
		<div class="footer"><jsp:include page = "footer.jsp"></div>
	</div>

</body>
</html>