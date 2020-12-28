<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Product, domain.ProductService, domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@include file="productcatalog.jsp" %>
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
    <h3>Login successful!!!</h3>
    <h4>Hello, <%=session.getAttribute("name")%></h4>
    <%
    ArrayList<Product> products = (ArrayList<Product>) ProductService.getProdService().getAllProduct();
    %>
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
                    <form action="AddBasketServlet" method="post">
                        Enter the numbers you want :
                        <input type="hidden" name="userId" value="<%=((User) session.getAttribute("user")).getUserId()%>">
                        <input type="hidden" name="productId" value="<%=product.getProductId()%>">
                        <input type="text" name="productCount" size="5">
                        <input type="submit" value="Take">
                    </form>
                </td>
            </tr>
            <% }%>
        </table>    
   <!--  -->
    
        <%-- Hello,
        <%=session.getAttribute("name")%></h4>
        <% ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
        <form action="basket" method="post">
            <input type="hidden" name="userid" value="<%=user.getUserId()%>">
            <input type="submit" value="My Basket">
        </form>
        <form action="search" method="post">
            Search the product you want :
            <input type="text" name="productname" size="24">
            <input type="submit" value="Submit">
        </form>
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
                    <form action="take" method="post">
                        Enter the numbers you want :
                        <input type="hidden" name="userid" value="<%=user.getUserId()%>">
                        <input type="hidden" name="productid" value="<%=product.getProductId()%>">
                        <input type="text" name="numbers" size="5">
                        <input type="submit" value="Take">
                    </form>
                </td>
            </tr>
            <% }%>
        </table>  --%>
</body>

</html>