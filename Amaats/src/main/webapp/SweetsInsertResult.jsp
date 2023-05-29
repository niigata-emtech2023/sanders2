<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品情報登録確認画面</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <form action="show-insert-sweets-servlet" method="POST">
    以下の内容で商品の登録が完了しました
    <%
    SweetsBean bean = (SweetsBean) request.getAttribute("bean");
    %>
    
    商品ID：<%=bean.getSweets_id()%><br>
    商品名：<%=bean.getSweets_name()%><br>
    カテゴリ：<%=bean.getSweets_genre()%><br>
    価格：<%=bean.getSweets_value()%><br>
    商品情報：<%=bean.getSweets_info()%><br>
    
    <input type ="submit" value="戻る">
    </form>

</body>
</html>