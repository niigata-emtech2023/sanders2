<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean,model.entity.ReviewBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats 商品詳細ページ</title>
<link rel = "stylesheet" href = "css/style_base.css">
</head>
<body>
	<div class = "wrapper">
    <div class="header"><%@ include file="header.jsp" %>
    </div>
    <div class = "contents">
	    <%
	    SweetsBean bean = (SweetsBean)request.getAttribute("bean");
	    
	    try {
	    
	    	bean.getSweets_name();
	    
	    } catch (NullPointerException e) {
	    	
	    	bean.setSweets_name("");
	    	bean.setSweets_genre("");
	    	bean.setSweets_value(0);
	    	bean.setSweets_info("");
	    	
	    }
	    %>
	    
	    <div class="flex">
	    	
		    <img src="/Amaats/upload/<%=bean.getPath() %>" id="pathimg">
		    <div class="textleft">
			    商品名：<%=bean.getSweets_name()%><br>
			    カテゴリ：<%=bean.getSweets_genre()%><br>
			    価格：<%=bean.getSweets_value()%><br>
			    商品情報：<%=bean.getSweets_info()%><br>
		    </div>
		</div>
		<% String session_id = (String) session.getAttribute("session_id");
			String Authority = (String) session.getAttribute("authority");
			if (Authority.equals("shop") && session_id.equals(bean.getShop_id())) {%>
		<form action="update-sweets-from-servlet" method="POST">
		    <input type="submit" value="変更する" class="send">
		</form>
		<%}%>
		
		<form action="ReviewServlet" method="POST">
			<div class="flex">
			    <div class="textsize">口コミ登録</div><br>
			    <textarea name="review_text" cols="40" rows="4" id="reviewarea">
			    </textarea>
			    <input type="submit" value="登録" class="send">
			</div>
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
		
		<form action="show-sweets-list-servlet" method="POST">
			<input type="submit" value="一覧表示" id="allbutton">
		</form>
	
		
		</div>
	<div class="footer"><%@ include file="footer.jsp" %></div>
	</div>
</body>
</html>