<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean,model.entity.ReviewBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats 商品詳細ページ</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
    <div class="header"><%@ include file="header.jsp" %>
    </div>
    
    <%
    SweetsBean bean = (SweetsBean)request.getAttribute("bean");
    %>
    
    商品名：<%=bean.getSweets_name()%><br>
    カテゴリ：<%=bean.getSweets_genre()%><br>
    価格：<%=bean.getSweets_value()%><br>
    商品情報：<%=bean.getSweets_info()%><br>

	<form action="update-sweets-from-servlet" method="POST">
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
	    <textarea name="review_text" cols="40" rows="4">
	    </textarea>
	    <input type="submit" value="登録">
	</form>
	
	<%
	List<ReviewBean> reviewList = (List<ReviewBean>)request.getAttribute("reviewList");
	
	if(reviewList.size() != 0){%>
	<h3>口コミ</h3>
	
	<%for(ReviewBean review : reviewList){%>
		<tr>
		<td><%=review.getUser_id() %></td>
		<td><%=review.getReview_text() %></td>
		</tr>
	<% } %>
	
	<%}else{
	%>口コミはまだありません<%
	}
	%>
	

	
	
	<%@ include file="footer.jsp" %>
</body>
</html>