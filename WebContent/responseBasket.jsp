<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.BasketDAO, java.util.ArrayList, model.domain.Basket, model.domain.User, model.Service, java.util.HashMap, model.domain.Calculate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String userId = (String) session.getAttribute("userId");
	ArrayList<Basket> all = (ArrayList<Basket>) Service.getBasket(userId);
	session.setAttribute("all", all);
	Calculate calculate = (Calculate) Service.calculateBasket(userId);
	session.setAttribute("calculate", calculate);
%>
<div class="shp__cart__wrap">

	<c:forEach items="${sessionScope.all}" var="data">

		<div class="shp__single__product">
			<div class="shp__pro__details">
				<h2>${data.productId}</h2>
				<span class="quantity"> QTY:${data.productCount} </span>
				<!--                                 <span id="ajaxprice" class="shp__price">$ 10 </span>
 -->
			</div>
			<div class="remove__btn">
				<%--                                 <a href='Controller?command=deleteAjaxBasket?basketId=${data.basketId}?userId=${userId}' title="Remove this item"><i class="zmdi zmdi-close"></i></a>
 --%>
				<form id="myForm" action="Controller" method="post">
					<input type="hidden" name="basketId" value="${data.basketId}">
					<input type="hidden" name="userId" value="${userId}"> <input
						type="hidden" name="command" value="deleteAjaxBasket"> <input
						class="zmdi zmdi-close" type="submit" value="X">
				</form>

			</div>
		</div>
	</c:forEach>

	<ul class="shoping__total">
		<li class="subtotal">Subtotal:</li>
		<li class="total__price">$ ${calculate.totalBasketPrice}</li>
	</ul>
</div>


<!-- <script>
$('#myForm').click(function(){
	   $.ajax({
	        type: 'post',
	        url: 'Controller',
	        success: function(data){
	            alert(data);
	        }
	   });
	    return false; //<- 이 문장으로 새로고침(reload)이 방지됨
	});

</script>  -->
