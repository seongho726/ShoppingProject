<%@page import="model.domain.Basket, model.domain.User, model.domain.Calculate, model.domain.Payment, model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History</title>
<%String userId = (String) session.getAttribute("userId");%>
<%ArrayList<Payment> payments = (ArrayList<Payment>) session.getAttribute("payments");%>
</head>
<body>
	<h2>
		Hello,<%=userId%></h2>
	<h2>Here is your order history.</h2>
	<table border=1>
		<tr>
			<th width="200">Payment ID</th>
			<th width="200">User Id</th>
			<th width="200">Total Count</th>
			<th width="200">Total Price</th>
			<th width="200">Address</th>
			<th width="200">Contact</th>
		</tr>
		<%
			for (int i = 0; i < payments.size(); i++) {
				Payment payment = payments.get(i);
		%>
		<tr>
			<td align="center"><%=payment.getPaymentId()%></td>
			<td align="center"><%=userId%></td>
			<td align="center"><%=payment.getTotalCount()%></td>
			<td align="center"><%=payment.getTotalPrice()%></td>
			<td align="center"><%=payment.getAddress()%></td>
			<td align="center"><%=payment.getContact()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>

	<form>
		&nbsp;&nbsp;&nbsp; <input type="button"
			value="Go back to add more items" Onclick="location.href='login.jsp'">
</body>
</html>