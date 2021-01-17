<%@page import="model.domain.Basket, model.domain.User, model.Service"%>
<%@page import="java.util.ArrayList, java.util.HashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
             <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <form action="#">               
                            <div class="table-content table-responsive">
                                <table>
                                    <thead>
                                        <tr>
                                            <th class="product-name">Basket ID</th>
                                            <th class="product-name">User Name</th>
                                            <th class="product-name">Product ID</th>
                                            <th class="product-quantity">Product Count</th>
                                            <th class="product-subtotal">Price</th>
                                            <th class="product-name">Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
            						<c:forEach items="${sessionScope.baskets}" var="data">
                                        <tr>
                                            <th class="product-name">${data.basketId}</th>
                                            <th class="product-name">${data.userId}</th>
                                            <th class="product-name">${data.productId}</th>
                                            <th class="product-quantity">${data.productCount}</th>
                                            <th class="product-subtotal">${sessionScope.prices.get(data.productId)*data.productCount}</th> 
                                            <td class="product-remove">
                                            	<form>
                        						<input type="hidden" name="basketId" value="${data.basketId}">
                        						<input type="hidden" name="userId" value="${data.userId}">
                      						    <input type="hidden" name="command" value="deleteBasket">
                      						    <input type="submit" value="Delete">
                    						</form></td>
                                        </tr>
                         <%--  <% }%> --%>
                         </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-8 col-sm-7 col-xs-12">
                                    <div class="buttons-cart">
                                    <br>
                                      <a href="shop.jsp">Continue Shopping</a>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-5 col-xs-12">
                                    <div class="cart_totals">
                                        <div class="wc-proceed-to-checkout">
                                       <%--      <h3> Your Total Price is <%=totalPrice %>.</h3> --%>
                                            <br>
                                            <form action="Controller" method="post">
                        					<input type="hidden" name="userId" value="${sessionScope.userId}">
                        					<input type="hidden" name="command" value="buyBasket">
                       						<input type="submit" value="Proceed to Checkout">
                    						</form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form> 
                    </div>
                </div>
</body>
</html>