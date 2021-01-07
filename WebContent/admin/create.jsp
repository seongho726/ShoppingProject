<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="Controller" method="post">
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
            <input type="submit" value="제품 생성">
           <br> <input type="hidden" name="command" value="addProduct">
        </form>        
    </body>
</html>
