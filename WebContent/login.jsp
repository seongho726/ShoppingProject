<%@page import="domain.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
    </head>
    <body>
        <h2>Hello, <%= user.getUserName()%></h2>
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
        </table>
    </body>
</html>