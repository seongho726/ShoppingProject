<%@page import="domain.Basket, domain.User, domain.Calculate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% ArrayList<Basket> baskets = (ArrayList<Basket>) request.getAttribute("baskets");%>
        <% User user = (User) request.getAttribute("user");%>
        <% Calculate calculate = (Calculate) request.getAttribute("calculate");%>
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
            </tr>
			
            <% }%>
        </table>
        <br>
        <div> <h4 align="center">Total Count = <%=calculate.getTotalProductCount()%></h4>
            <h4 align=center>Total Price = <%=calculate.getTotalBasketPrice()%></h4> </div>
            
        <form action="PayBasketServlet" method="post">
                        <input type="hidden" name="userId" value="<%=user.getUserId()%>">
                        <input type="submit" value="Pay">
                    </form>
        
      	<form>&nbsp;&nbsp;&nbsp;
            <input type="button" value="Go back to add more items"
            Onclick="location.href='login.jsp'">
    </body>
</html>