<%@page session="false" import="java.util.Iterator"%>
<html>
    <head><title>Join Form</title></head>
    <body>
        <h2>Join Form</h2>
        <form action="JoinServlet" method="post">
            <table>
                <tr><td>Username:</td><td>
                        <input type="text" name="username" size="24" required="required"></td></tr>
                <tr><td>Password:</td><td>
                        <input type="password" name="password" size="24" required="required"></td></tr>
                <tr><td>Email:</td><td>
                        <input type="email" name="email" size="24" required="required"></td></tr>
                <tr><td>Contact:</td><td>
                        <input type="text" name="contact" size="24" required="required"></td></tr>
                <tr><td>Address:</td><td>
                        <input type="text" name="address" size="50" required="required"></td></tr></table>
                <br>
                <br> <input type="hidden" name="command" value="insert">
            <input type="submit" value="Join">&nbsp;&nbsp;
            <input type="reset" value="reset">&nbsp;&nbsp;
            <input type="button" value="Back to main"
            		Onclick="location.href='main.jsp'">
        </form>        
    </body>
</html>