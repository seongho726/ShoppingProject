<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Confirmed</title>
<%String userId = (String) session.getAttribute("userId");%>
</head>
<body>
	<h2>
		Hello,<%=userId%></h2>
	<h2>Thank you for your order!</h2>
	<form action="Controller" method="post">
	  <input type="hidden" name="userId" value="<%=userId%>"> 
            <input type="hidden" name="command" value="getPayment">
            <input type="submit" value="View Order History">&nbsp;&nbsp;
	</form>
	<form>
		&nbsp;&nbsp;&nbsp; <input type="button"
			value="Go back to add more items" Onclick="location.href='login.jsp'"></form>
</body>
</html>