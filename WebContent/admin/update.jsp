<%@page import="domain.User"%>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>Update Form</title>
        <%  User user = (User) request.getAttribute("user");
            int productid = (int) request.getAttribute("productid");
            session.setAttribute("productid", productid);
            session.setAttribute("user", user);%></head>
    <body>
        <form action="updateprocess" method="post">
            <table>
                <tr><td>Product ID:</td><td>
                    <%=productid%></tr>
                <tr><td>Product Type:</td><td>
                        <input type="text" name="producttype" size="20"></td></tr>
                <tr><td>Product Name:</td><td>
                        <input type="text" name="productname" size="20"></td></tr>
                <tr><td>Explanation:</td><td>
                        <input type="text" name="explanation" size="50"></td></tr>
                <tr><td>Price:</td><td>
                        <input type="text" name="price" size="5"></td></tr>
                <tr><td>Inventory:</td><td>
                        <input type="text" name="inventory" size="5"></td></tr>
            </table>
            <input type="submit" value="Submit">
            <input type="hidden" name="command" value="updateProduct">
        </form>        
    </body>
</html>