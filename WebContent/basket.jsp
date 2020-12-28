<%@page import="domain.Basket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<Basket> baskets = (ArrayList<Basket>) request.getAttribute("baskets");%>
        <% User user = (User) request.getAttribute("user");%>
        <% session.setAttribute("user", user);%>
    </head>
    <body>
        <h2>Hello, <%= user.getUserName()%></h2>
        <table border="2px">
            <tr>
                <th width="200">Basket ID</th>
                <th width="200">User Name</th>
                <th width="200">Product ID</th>
                <th width="200">Numbers</th>
                <th width="200">Delete</th>
            </tr>
            <%
                for (int i = 0; i < baskets.size(); i++) {
                    Basket basket = baskets.get(i);
            %>
            <tr>
                <td align="center"><%=basket.getBasketId()%></td>
                <td align="center"><%=user.getUserName()%></td>
                <td align="center"><%=basket.getProductId()%></td>
                <td align="center"><%=basket.getProductCount()%></td>
              	<td align="center">  
              		<form action="delete" method="post">
                        <input type="hidden" name="basketid" value="<%=basket.getBasketId()%>">
                        <input type="hidden" name="userid" value="<%=user.getUserId()%>">
                        <input type="submit" value="Delete">
                    </form></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>