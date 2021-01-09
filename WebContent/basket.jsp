<%@page import="java.util.HashMap"%>
<%@page import="model.domain.Basket, model.domain.User, model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% String userId = (String)session.getAttribute("userId");%>
        <% ArrayList<Basket> baskets = (ArrayList<Basket>) session.getAttribute("baskets");%>
        <% HashMap prices = (HashMap) session.getAttribute("prices");%>

    </head>
    <body>
        <h2>Hello,<%=userId%></h2>
        <table border=1>
            <tr>
                <th width="200">Basket ID</th>
                <th width="200">User Id</th>
                <th width="200">Product ID</th>
                <th width="200">Product Count</th>
                <th width="200">Price</th>
                <th width="200">Delete</th>
            </tr>
            <%
            	int totalPrice = 0;
                for (int i = 0; i < baskets.size(); i++) {
                    Basket basket = baskets.get(i);
                   	int tempPrice = (int)prices.get(basket.getProductId()) * basket.getProductCount();
                   	totalPrice += tempPrice;
            %>
            <tr>
                <td align="center"><%=basket.getBasketId()%></td>
                <td align="center"><%=userId%></td>
                <td align="center"><%=basket.getProductId()%></td>
                <td align="center"><%=basket.getProductCount()%></td>
                <td align="center"><%=tempPrice%></td>
               <%--  <td align="center"><%=*basket.getProductCount()%></td> --%>
              	<td align="center">  
              		<form action="Controller" method="post">
                        <input type="hidden" name="basketId" value="<%=basket.getBasketId()%>">
                        <input type="hidden" name="userId" value="<%=userId%>">
                        <input type="hidden" name="command" value="deleteBasket">
                        <input type="submit" value="Delete" onclick="return confirm('Are you sure?')">
                    </form></td>
            </tr>
            <% }%>
        </table>
        <br>
        <div>
        <% out.print(totalPrice); %>
        </div>
        
        <form action="Controller" method="post">
                        <input type="hidden" name="userId" value="<%=userId%>">
                        <input type="hidden" name="command" value="buyBasket">
                        <input type="submit" value="Checkout">
                    </form>
        
      	<form>&nbsp;&nbsp;&nbsp;
            <input type="button" value="Go back to add more items"
            Onclick="location.href='login.jsp'">
    </body>
</html>