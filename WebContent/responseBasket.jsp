<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, model.domain.Basket, model.domain.User, model.Service, java.util.HashMap, model.domain.Product, model.domain.Calculate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String userId = (String) session.getAttribute("userId");
	session.setAttribute("all", Service.getBasket(userId));
	session.setAttribute("calculate", Service.calculateBasket(userId));
%>
<div class="shp__cart__wrap">

	<c:choose>
		
		<c:when test="${not empty all}">
			<c:forEach items="${sessionScope.all}" var="data">
				<div class="shp__single__product">
					<div class="shp__pro__details">
						<h2>${data.productId}</h2>
						<span class="quantity"> QTY:${data.productCount} </span>
					</div>
					<div class="remove__btn">
						<form id="myForm" action="Controller" method="post">
							<input type="hidden" name="basketId" value="${data.basketId}">
							<input type="hidden" name="userId" value="${userId}"> <input
								type="hidden" name="command" value="deleteBasket"> <input
								class="zmdi zmdi-close" type="submit" value="X">
						</form>
					</div>
				</div>
			</c:forEach>
		</c:when>
		
		<c:otherwise>
			<div class="shp__single__product">
				<div class="shp__pro__details">
					<h2>Your cart is empty.</h2>
					<span class="quantity"> Add products.</span>
				</div>
			</div>
		</c:otherwise>
	
	</c:choose>

	<ul class="shoping__total">
		<li class="subtotal">Subtotal:</li>
		<li class="total__price">$ ${calculate.totalBasketPrice}</li>
	</ul>

</div>

