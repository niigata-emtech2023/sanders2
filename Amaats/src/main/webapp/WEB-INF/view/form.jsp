<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>画像アップロード</title>
</head>
<body>
<form action="/Amaats/Main" method="post" enctype="multipart/form-data">
名前:<input type="text" name="name"><br>
好きな言葉:<input type="text" name="word"><br>
好きな写真:<input type="file" name="pict"><br>
<button type="submit">送信</button>
</form>
</body>
</html>