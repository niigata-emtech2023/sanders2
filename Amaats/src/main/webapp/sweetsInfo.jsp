<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats 商品詳細ページ</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    
    <%
    SweetsBean bean = (SweetsBean)request.getAttribute("bean");
    %>
    
    商品名：<%=bean.getSweets_name()%><br>
    カテゴリ：<%=bean.getSweets_genre()%><br>
    価格：<%=bean.getSweets_value()%><br>
    商品情報：<%=bean.getSweets_info()%><br>

	<form action="sweets-alter-form-servlet" method="POST">
	    <input type="submit" value="変更する">
	</form>

	<form action="show-sweets-list-servlet" method="POST">
		<input type="submit" value="一覧表示">
	</form>
	
	<form action="" method="POST">
	    数量：<select name="sum">
	        
	        <% for(int i = 1 ; i<=30 ; i++){ %>
	        <option value=<%=i%>>	
	        <% }
	        %>
	    </select>
	    <input type="submit" value="カートに入れる">
	</form>
	
	<form action="ReviewServlet" method="POST">
	    口コミ登録<br>
	    <textarea name="" cols="40" rows="4">
	    </textarea>
	    <input type="submit" value="登録">
	    
	</form>
	
	
	<%@ include file="footer.jsp" %>
</body>
</html>