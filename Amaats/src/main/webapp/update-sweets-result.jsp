<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報-変更登録結果</title>
</head>
<body>

	<%
		int processingNumber = (Integer) request.getAttribute("processingNumber");
		if (processingNumber > 0) {
	%>
	次のデータを変更登録しました。<br>
	<%
		} else {
	%>
	次のデータを変更登録できませんでした。<br>
	<%
		}
	%>
	<jsp:useBean id="sweets" scope="session" class="model.entity.SweetsBean" />
	：<jsp:getProperty name="sweets" property="sweets_id" /><br>
	：<jsp:getProperty name="sweets" property="sweets_name" /><br>
	：<jsp:getProperty name="sweets" property="sweets_value" /><br>
	：<jsp:getProperty name="sweets" property="shop_id" /><br>
//
	<form action="sweetsList.jsp" method="POST">
		<input type="submit" value="一覧画面に戻る">
	</form>
//
	<% session.invalidate(); %>
	


</body>
</html>