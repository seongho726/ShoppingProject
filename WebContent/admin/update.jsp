<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head><title>Update Form</title>
</head>
    <body>
        <form action="Controller" method="post">
            <table>
                <tr><td>Product Id: </td><td>
               			<input type="text" name="productId"  value="${sessionScope.product.productId}" readonly></td></tr>
                <tr><td>Product Type:</td><td>
                        <input type="text" name="producttype" size="20" value="${sessionScope.product.productType}" readonly></td></tr>
                <tr><td>Product Name:</td><td>
                        <input type="text" name="productname" size="20" value="${sessionScope.product.productName}" readonly></td></tr>
                <tr><td>Description:</td><td>
                        <input type="text" name="description" size="50" value="${sessionScope.product.productId}"></td></tr>
                <tr><td>Price:</td><td>
                        <input type="text" name="price" size="5" value= "${sessionScope.product.productId}"></td></tr>
                <tr><td>Inventory:</td><td>
                        <input type="text" name="inventory" size="5" value= "${sessionScope.product.productId}"></td></tr>
            </table>
            <input type="submit" value="Submit">
            <input type="hidden" name="command" value="updateProduct">
        </form>        
    </body>
</html>