<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BasketDAO, java.util.ArrayList, model.domain.Basket, model.domain.User, model.Service, java.util.HashMap, model.domain.Calculate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

	String userId=(String) session.getAttribute("userId");
	ArrayList<Basket> all = (ArrayList<Basket>) Service.getBasket(userId);
	request.setAttribute("all", all);
    Calculate calculate = (Calculate) Service.calculateBasket(userId);

%>
   <%--  <c:set var="total" value="${0}"/>
    
	<c:forEach items = "${sessionScope.all}" var="data">

	 <div class="shp__single__product">
                            <div class="shp__pro__thumb">
                                <a href="#">
                                    <img src="images/product/sm-img/1.jpg" alt="product images">
                                </a>
                            </div>
                            <div class="shp__pro__details">
                                <h2 id="ajaxid">${data.productId}</h2>
                                <span id="ajaxinventory" class="quantity">QTY:${data.productCount} </span>
                                <span id="ajaxprice" class="shp__price">$ 10 </span>
                            </div>
                            <div class="remove__btn">
                                <a href="#" title="Remove this item"><i class="zmdi zmdi-close"></i></a>
                            </div>
                        </div>
	</c:forEach> --%>
	                   
  			<%
                for (int i = 0; i < all.size(); i++) {
                    Basket basket = all.get(i);
                   	
            %>
             <div class="shp__cart__wrap">
            
             <div class="shp__single__product">
             
                            <div class="shp__pro__thumb">
                                <a href="#">
                                    <img src="images/product/sm-img/1.jpg" alt="product images">
                                </a>
                            </div>
                            <div class="shp__pro__details">
                            
                                <h2 id="ajaxid"><%= basket.getProductId() %></h2>
                                <span id="ajaxinventory" class="quantity">QTY: <%= basket.getProductCount() %> </span>
                                
<!--                                 <span id="ajaxprice" class="shp__price">$  </span>
 -->                            </div>
                            <div class="remove__btn">
                            
                                 <form id ="myForm" action="Controller" method="post">
                        		 <input type="hidden" name="basketId" value="<%=basket.getBasketId()%>">
                        		 <input type="hidden" name="userId" value="<%=userId%>">
                      		     <input type="hidden" name="command" value="deleteAjaxBasket">
                      			 <input type="submit" value="Delete">
                    			</form>
                                <a href="#" title="Remove this item"><i class="zmdi zmdi-close"></i></a>
                            </div>
                        </div>
                    
                      <% }%>                           
					<ul class="shoping__total">
                        <li class="subtotal"> Subtotal: </li>
                        <li class="total__price">$ <%= calculate.getTotalBasketPrice() %></li>
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
            