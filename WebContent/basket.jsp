<%@page import="model.domain.Basket, model.domain.User"%>
<%@page import="java.util.ArrayList"%>
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
                <th width="200">Product Count</th>
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
              		<form action="DeleteBasketServlet" method="post">
                        <input type="hidden" name="basketId" value="<%=basket.getBasketId()%>">
                        <input type="hidden" name="userId" value="<%=user.getUserId()%>">
                        <input type="submit" value="Delete" onclick="return confirm('Are you sure?')">
                    </form></td>
            </tr>
			
            </form>
            <% }%>
        </table>
        <br>
        
        <form action="BuyBasketServlet" method="post">
                        <input type="hidden" name="userId" value="<%=user.getUserId()%>">
                        <input type="submit" value="Checkout">
                    </form>
        
      	<form>&nbsp;&nbsp;&nbsp;
            <input type="button" value="Go back to add more items"
            Onclick="location.href='login.jsp'">
    </body>
</html>