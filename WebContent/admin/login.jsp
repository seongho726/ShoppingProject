<%@page import="dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Product,model.ProductService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product List</title>
	<%
	ArrayList<Product> products = (ArrayList<Product>) ProductService.getProdService().getAllProduct();
	%>
	<%User user = (User) request.getAttribute("user");%>
	<%session.setAttribute("user", user);%>
</head>
<body>
	<h2>
		Hello,
		<%=session.getAttribute("name")%></h2>
	<!-- <form action="paymentlist" method="post">
		<input type="submit" value="All Payment">
	</form> -->
	<table border="2px">
		<tr>
			<th width="100">Product ID</th>
			<th width="150">Product Type</th>
			<th width="200">Product Name</th>
			<th width="400">Explanation</th>
			<th width="150">Price</th>
			<th width="100">Inventory</th>
		<!-- 	<th width="100">Update</th> -->
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
			<%-- <td align="center">
                    <form action="CreateProduct" method="post">
                        <input type="hidden" name="productid" value="<%=product.getProductId()%>">
                        <input type="submit" value="Update"> </form> --%>
		</tr>
		<%
			}
		%>
	</table>
	 <form action="CreateProduct" method="post">
            <input type="submit" value="Create">
            </form>
</body>
</html>