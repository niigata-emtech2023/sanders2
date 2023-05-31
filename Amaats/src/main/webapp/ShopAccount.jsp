<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.ShopBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント情報確認画面</title>
<link rel = "stylesheet" href = "style.css">
</head>
<body>
    <div class="header"><%@ include file="header.jsp" %>
    </div>
    
    <%
    ShopBean bean = (ShopBean)request.getAttribute("bean");
    %>
    店舗名：<%=bean.getShop_name() %><br>
    ログインID：<%=bean.getShop_id() %><br>
    住所：<%=bean.getShop_address() %><br>
    電話番号：<%=bean.getShop_tel() %><br>
    
    <form action="UpdateShopAccount.jsp" method="POST">
        <input type="submit" value="編集する">
    </form>
    <jsp:include page="footer.jsp" />
    
    

</body>
</html>