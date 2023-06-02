<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>画像変更完了</title>
</head>
<body>
	<div class = "wrapper">
	    <div class="header"><%@ include file="header.jsp" %>
	    </div>
	    <div class = "contents">
		    <form action="show-update-sweets-list-servlet" method="POST">
		    <div class="textleft">
			    画像の変更が完了しました
			    
		    </div>
		    <input type ="submit" value="戻る" class="send">
		    </form>
	    </div>
	</div>
</body>
</html>