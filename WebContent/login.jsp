<%@page import="model.domain.User, model.domain.Product, model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<h3>Login successful!!!</h3>
	<h4>
		Hello,
		<%=session.getAttribute("userId")%></h4>

		<% ArrayList<Product> products = (ArrayList<Product>) Service.getProducts();%>
		<%User user = (User) request.getAttribute("user");%>
		<%session.setAttribute("user", user);%>
	<%--  <form action="Controller" method="post">
		<input type="hidden" name="userId"
			value="<%=((User) session.getAttribute("user")).getUserId()%>">
		<input type="submit" value="My Basket">
	</form>  --%>
	<!-- <form action="SearchProductServlet" method="post">
            Search the product you want :
            <input type="text" name="productname" size="24">
            <input type="submit" value="Submit">
        </form> -->
	<table border="2px">
		<tr>
			<th width="100">Product ID</th>
			<th width="150">Product Type</th>
			<th width="200">Product Name</th>
			<th width="400">Explanation</th>
			<th width="150">Price</th>
			<th width="100">Inventory</th>
			<th width="200">Take in Basket</th>
		</tr>
		<%
			for (int i = 0; i < products.size(); i++) {
				Product product = products.get(i);
		%>
		<tr>
			<td align="center"><%=product.getProductId()%></td>
			<td align="center"><%=product.getProductType()%></td>
			<td align="center"><%=product.getProductName()%></td>
			<td align="center"><%=product.getDescription()%></td>
			<td align="center">$<%=product.getPrice()%></td>
			<td align="center"><%=product.getInventory()%></td>
			 <td align="center">
				<form action="Controller" method="post">
					Enter the numbers you want : 
<%-- 					<input type="hidden" name="userId" value="<%=((User) session.getAttribute("user")).getUserId()%>">
 --%>				<input type="hidden" name="userId" value="userId">	
 					<input type="hidden" name="productId" value="<%=product.getProductId()%>">
					<input type="text" name="productCount">
					<input type="hidden" name="command" value="addBasket">
					<input type="submit" value="Take">  
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<form>&nbsp;&nbsp;&nbsp;
            <input type="button" value="Basket" Onclick="location.href='basket.jsp'">
</body>

</html>


