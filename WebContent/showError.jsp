<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<% String url = application.getContextPath() + "/"; %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
<br><br><br>

	<center>
		<h3>${sessionScope.errorMsg}</h3>
			
		<br><br><br>
		<a href="${pageContext.request.contextPath}/main.jsp">메인 화면으로 이동하기</a>
	</center>
	
</body>
</html>