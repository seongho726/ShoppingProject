<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Iterator"%> 
<jsp:useBean id="status" scope="request" class="util.Status"/>
<html>
    <head><title>Login Form</title></head>
    <body>
        <h2>Login Form</h2>
        <%if ((status != null) && !status.isSuccessful()) {%>
        <font color="red">There were problems processing your request:
        <ul><%Iterator errors = status.getExceptions();
            while (errors.hasNext()) {
                Exception ex = (Exception) errors.next();%>
            <li><%= ex.getMessage()%><%}%></ul></font><%}%>
        <form action="Login" method="post">
            <table>
                <tr><td>Login Select:</td>
                    <td><select name="usertype">
                            <option name="userType" value="unknown">Your Select
                            <option name="userType" value="A">Administrator
                            <option name="userType" value="C">Customer</select></td></tr>
                <tr><td>Username:</td><td>
                        <input type="text" name="userName" size="24"></td></tr>
                <tr><td>Password:</td><td>
                        <input type="password" name="password" size="24"></td></tr></table>
            <input type="submit" value="Submit">
        </form>
        if you have not your ID, you should join to my shopping site!
        <form action="join.jsp" method="post">
            <input type="submit" value="Join">
        </form>   
    </body>
</html>