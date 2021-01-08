<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Iterator"%> 
<html>
    <head><title>Login Form</title></head>
    <body>
        <h2>Login Form</h2>
        <form action="Controller" method="post">
            <table>
              <tr><td>Login Select:</td>
                    <td><select name="userType">
                            <option value="unknown">Your Select
                            <option value="A">Administrator
                            <option value="C">Customer</select></td></tr> 
                <tr><td>UserId:</td><td>
                        <input type="text" name="userId" size="24"></td></tr>
                <tr><td>Password:</td><td>
                        <input type="password" name="password" size="24"></td></tr>
                 </table>
      		<input type="hidden" name="command" value="validate">
            <input type="submit" value="Submit">
        </form>
        if you have not your ID, you should join to my shopping site!
        <form action="join.jsp" method="post">
            <input type="submit" value="Join">
        </form>   
    </body>
</html>