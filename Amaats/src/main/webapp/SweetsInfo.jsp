<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.SweetsBean,model.entity.ReviewBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amaats 商品詳細ページ</title>
<link rel = "stylesheet" href = "css/style_base.css">
<link rel = "stylesheet" href = "css/style_table.css">
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
		    	
			<img src="/Amaats/upload/<%=bean.getPath() %>" id="pathimg">
			<div class="textleft">
				商品名：<%=bean.getSweets_name()%><br>
				カテゴリ：<%=bean.getSweets_genre()%><br>
				価格：<%=bean.getSweets_value()%>円<br>
				商品情報：<br><%=bean.getSweets_info()%><br>
			</div>
			<% String session_id = (String) session.getAttribute("session_id");
				String Authority = (String) session.getAttribute("authority");
				if (Authority.equals("shop") && session_id.equals(bean.getShop_id())) {%>
			<form action="update-sweets-from-servlet" method="POST">
			    <input type="submit" value="変更する" class="send">
			</form>
			<%}%>
			<form action="review-servlet" method="POST">
				<div class="textsize">口コミ登録</div><br>
				<textarea name="review_text" cols="40" rows="4" id="reviewarea">
				</textarea>
				<input type="hidden" name ="sweets_id" value="<%=bean.getSweets_id()%>">
				<input type="submit" value="登録" class="send">
			</form>
				
			<%
			List<ReviewBean> reviewList = (List<ReviewBean>)request.getAttribute("reviewList");
				
			if(reviewList.size() != 0){%>
			<h3>口コミ</h3>
				
			<%for(ReviewBean review : reviewList){%>
				<tr>
					<td class="td1"><%=review.getUser_id() %></td>
					<td class="td2"><%=review.getReview_text() %></td>
				</tr>
			<% } %>
				
			<%}else{
			%>
			
			<div id="reviewnull">口コミはまだありません</div>
			
			<%
			}
			%>
			
			<form action="show-sweets-list-servlet" method="POST">
				<br><input type="submit" value="一覧表示" id="allbutton">
			</form>
			
			</div>
		<div class="footer"><%@ include file="footer.jsp" %></div>
	</div>
</body>
</html>