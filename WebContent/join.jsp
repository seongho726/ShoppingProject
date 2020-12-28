<%@page session="false" import="java.util.Iterator"%>
<html>
    <head><title>Join Form</title></head>
    <body>
        <h2>Join Form</h2>
        <form action="join" method="post">
            <table>
                <tr><td>username:</td><td>
                        <input type="text" name="username" size="24"></td></tr>
                <tr><td>Password:</td><td>
                        <input type="password" name="password" size="24"></td></tr>
                <tr><td>Email:</td><td>
                        <input type="text" name="email" size="24"></td></tr>
                <tr><td>Contact:</td><td>
                        <input type="text" name="contact" size="24"></td></tr>
                <tr><td>Address:</td><td>
                        <input type="text" name="address" size="50"></td></tr></table>
            <input type="submit" value="Submit">
        </form>        
    </body>
</html>