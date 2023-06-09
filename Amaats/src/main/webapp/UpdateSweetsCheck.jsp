<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.SweetsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats：商品情報-編集確認</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class = "wrapper">
		<div class="header"><%@ include file="header.jsp"%>
		</div>
		<div class = "contents">
			<%
				request.setCharacterEncoding("UTF-8");
			%>
			商品情報を以下の内容に変更します。よろしいですか？<br>
			<%
			SweetsBean bean = (SweetsBean)request.getAttribute("bean");
		    %>
		    
			<div class="textleft">
			商品ID：<%=bean.getSweets_id() %><br>
			商品名：<%=bean.getSweets_name() %><br>
			値段：<%=bean.getSweets_value() %><br>
			ジャンル：<%=bean.getSweets_genre() %><br>
			商品情報：<%=bean.getSweets_info() %><br>
		</div>
			<form action="update-sweets-servlet" method="POST">
			<input type="hidden" name = "sweets_id" value=<%=bean.getSweets_id() %>>
			<input type="hidden" name = "sweets_name" value=<%=bean.getSweets_name() %>>
			<input type="hidden" name = "sweets_value" value=<%=bean.getSweets_value() %>>
			<input type="hidden" name = "sweets_genre" value=<%=bean.getSweets_genre() %>>
			<input type="hidden" name = "sweets_info" value=<%=bean.getSweets_info() %>>
			<input type="hidden" name = "pict" value=<%=(Part) request.getAttribute("pict") %>>
			
				<input type="submit" value="はい" id="yes" class="send">
			</form>
		
			<form action="update-sweets-form-servlet" method="POST">
				<input type="submit" value="戻る" id="no" class="send">
			</form>
		</div>
		<div class="footer"><jsp:include page="footer.jsp" /></div>
	</div>

</body>
</html>