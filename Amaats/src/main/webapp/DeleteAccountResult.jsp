<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除完了</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
<<<<<<< HEAD
	<div id="wrapper">
		<div class="header"><jsp:include page = "header.jsp"></div>
	 	<div id="contents">
		<form action="show-delete-user-account-servlet" method="POST">
		 
		 削除が完了しました。
		 
		 <input type ="submit" value="戻る">
		 </form>
	 </div>
	 <div class="footer"><jsp:include page = "footer.jsp"></div>
	 </div>
=======
 <div class="header"><jsp:include page = "header.jsp" />
	</div>
 <form action="show-delete-user-account-servlet" method="POST">
 
 削除が完了しました。<br>
 
 <input type ="submit" value="戻る">
 </form>
 <jsp:include page = "footer.jsp" />
>>>>>>> branch 'master' of https://github.com/niigata-emtech2023/sanders2
</body>
</html>