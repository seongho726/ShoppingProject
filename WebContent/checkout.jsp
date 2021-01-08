<%@page import="model.domain.Basket, model.domain.User, model.domain.Calculate"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <% String userId=(String) session.getAttribute("userId");%>
        <% ArrayList<Basket> baskets = (ArrayList<Basket>) session.getAttribute("baskets");%>
        <% Calculate calculate = (Calculate) session.getAttribute("calculate");%>
<%--         <% session.setAttribute("user", user);%>
 --%>    </head>
    <body>
        <h2>Hello, <%=userId%></h2>
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
                <td align="center"><%=userId%></td>
                <td align="center"><%=basket.getProductId()%></td>
                <td align="center"><%=basket.getProductCount()%></td>
            </tr>
			
            <% }%>
        </table>
        <br>
        <div> <h4 align="center">Total Count = <%=calculate.getTotalProductCount()%></h4>
            <h4 align=center>Total Price = $<%=calculate.getTotalBasketPrice()%></h4> </div>
            
 
        <h2>Pay Form</h2>
        
        <form action="Controller" method="post">
            <table>
            
                <tr><td>Address:</td><td>
                        <input type="text" name="address" size="24" required="required"></td></tr>
                <tr><td>Contact:</td><td>
                        <input type="text" name="contact" size="24" required="required"></td></tr>
                <tr><td>Credit Card Number:</td><td>
                        <input type="text" name="ccNumber" size="24" required="required"></td></tr>
                <tr><td>Credit Card Expiration:</td><td>
                        <input type="text" name="ccExpiration" size="24" required="required"></td></tr>
                <tr><td>Credit Card Password:</td><td>
                        <input type="text" name="ccPassword" size="24" required="required"></td></tr></table>
                <br>
                
             <br>
            <input type="hidden" name="userId" value="<%=userId%>"> 
            <input type="hidden" name="command" value="payBasket">
            <input type="submit" value="Pay">&nbsp;&nbsp;
            <input type="reset" value="reset">&nbsp;&nbsp;
            <input type="button" value="Back to main"
            		Onclick="location.href='main.jsp'">
        </form>        
      	<form>&nbsp;&nbsp;&nbsp;
            <input type="button" value="Go back to add more items"
            Onclick="location.href='login.jsp'">
    </body>
</html>