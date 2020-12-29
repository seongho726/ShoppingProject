<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
 <form action="createprocess" method="post">
            <table>
                <tr><td>Product Type:</td><td>
                        <input type="text" name="producttype" size="20"></td></tr>
                <tr><td>Product Name:</td><td>
                        <input type="text" name="productname" size="20"></td></tr>
                <tr><td>Explanation:</td><td>
                        <input type="text" name="description" size="50"></td></tr>
                <tr><td>Price:</td><td>
                        <input type="text" name="price" size="5"></td></tr>
                <tr><td>Inventory:</td><td>
                        <input type="text" name="inventory" size="5"></td></tr>
            </table>
            <input type="submit" value="Submit">
           <br> <input type="hidden" name="command" value="insertProduct">
        </form>        
    </body>
</html>
</body>
</html>