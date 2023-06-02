<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel = "stylesheet" href = "style.css"> -->
<!-- <link rel="stylesheet" href="css/style.base.css"> -->
<link rel="stylesheet" href="css/footer.css">
</head>
<!-- <body class = "footer"> -->
<body>
	<div class="position">
	<% String AuthoFoot = (String) session.getAttribute("authority");
			if (AuthoFoot.equals("user")) {%>
	<% String genre;
	try {  
			genre = (String) request.getAttribute("genre");
			if (genre.equals(null)) {
				genre = "ジャンル検索";
			}
		} catch (NullPointerException e) { genre = "ジャンル検索"; }%>
	<%  String minvalue; 
	try {  
			minvalue = (String) request.getAttribute("minvalue");
			if (minvalue.equals(null)) {
				minvalue = "値段下限";
			}
		} catch (NullPointerException e) { minvalue = "値段下限"; }%>
	<%  String maxvalue; 
	try {  
			maxvalue = (String) request.getAttribute("maxvalue");
			if (maxvalue.equals(null)) {
				maxvalue = "値段上限";
			}
		} catch (NullPointerException e) { maxvalue = "値段上限"; }%>
	<div style = "display:inline-flex">
	<form action = "search-genre-servlet" method = "POST">
		<select name = "genre" class="genre">
       		<option value="<%=genre%>"><%=genre%></option>
        	<option value="ケーキ">ケーキ</option>
        	<option value="チョコレート">チョコレート</option>
        	<option value="クッキー">クッキー</option>
        	<option value="カヌレ">カヌレ</option>
        	<option value="マカロン">マカロン</option>
			<option value="和菓子">和菓子</option>
			<option value="その他">その他</option>
		</select>
		<input type = "submit" value = "検索" class="searchbutton">
	</form>　　　　　
	<form action = "search-value-servlet" method = "POST">
			値段：<input type = "text" name = "minvalue" value = "<%=minvalue%>" class="price"> ～
			<input type = "text" name = "maxvalue" value = "<%=maxvalue%>" class="price">
			<input type = "submit" value = "検索" class="searchbutton">
	</form>
	</div>
	<% }%>
	</div>
</body>
</html>