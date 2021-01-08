<%@page import="model.domain.User, model.domain.Product, model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login</title>
	<%
	ArrayList<Product> products = (ArrayList<Product>) Service.getProducts();
	%>
	<%User user = (User) request.getAttribute("user");%>
	<%session.setAttribute("user", user);%>
</head>
<body>
	<h4>
		Hello,
		<%=session.getAttribute("userId")%></h4>
	<!-- <form action="paymentlist" method="post">
		<input type="submit" value="All Payment">
	</form> -->
	<table border=1>
		<tr>
			<th width="100">Product ID</th>
			<th width="150">Product Type</th>
			<th width="200">Product Name</th>
			<th width="400">Explanation</th>
			<th width="150">Price</th>
			<th width="100">Inventory</th>
			<th width="100">Update</th>
			<th width="100">Delete</th>
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
                        <input type="hidden" name="productId" value="<%=product.getProductId()%>">
                        <input type="hidden" name="command" value="updateProductReq">
                        <input type="submit" value="Update"> </form> 
            <td align="center">
                    <form action="Controller" method="post">
                        <input type="hidden" name="productId" value="<%=product.getProductId()%>">
                        <input type="hidden" name="command" value="deleteProduct">
                        <input type="submit" value="Delete"> </form>             
		</tr>
		<%}%>
	</table>
	 <form action="admin/create.jsp" method="post">
            <input type="submit" value="Product Create">
            </form>
</body>
</html>