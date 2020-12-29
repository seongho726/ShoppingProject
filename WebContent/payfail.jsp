<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Failed</title>
</head>
<body>
	Payment did not go through. 
	<%=request.getAttribute("error")%>
</body>
</html>