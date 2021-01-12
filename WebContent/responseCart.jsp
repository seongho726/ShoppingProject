<%@page
	import="model.domain.Basket, model.domain.User, model.Service, model.domain.Product, model.domain.Calculate"%>
<%@page import="java.util.ArrayList, java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Product List</title>
<%
	String userId = (String) session.getAttribute("userId");
	ArrayList<Basket> baskets = (ArrayList<Basket>) session.getAttribute("baskets");
	//HashMap prices = (HashMap) session.getAttribute("prices");
	session.setAttribute("calculate", Service.calculateBasket(userId));
%>
</head>
<body>
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
<!-- 								<th class="product-subtotal">Price</th>
 -->								<th class="product-name">Delete</th>
							</tr>
						</thead>
						<tbody>
							<%
								/* 	int totalPrice = 0; */
								for (int i = 0; i < baskets.size(); i++) {
									Basket basket = baskets.get(i);
									/* 
								    int tempPrice = (int)prices.get(basket.getProductId()) * basket.getProductCount();
								    totalPrice += tempPrice; */
							%>
							<tr>
								<th class="product-name"><%=basket.getBasketId()%></th>
								<th class="product-name"><%=userId%></th>
								<th class="product-name"><%=basket.getProductId()%></th>
								<th class="product-quantity"><%=basket.getProductCount()%></th>
								<%-- <th class="product-subtotal">
									<%=tempPrice%>
								</th> --%>
								<td class="product-remove">
									<form action="Controller" method="post">
										<input type="hidden" name="basketId"
											value="<%=basket.getBasketId()%>"> <input
											type="hidden" name="userId" value="<%=userId%>"> <input
											type="hidden" name="command" value="deleteBasket"> <input
											type="submit" value="Delete">
									</form>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-md-8 col-sm-7 col-xs-12">
						<div class="buttons-cart">
							<br> <a href="shop.jsp">Continue Shopping</a>
						</div>
					</div>
					<div class="col-md-4 col-sm-5 col-xs-12">
						<div class="cart_totals">
							<div class="wc-proceed-to-checkout">
								<h3>
									Your Total Price is $ ${calculate.totalBasketPrice}
								</h3>
								<br>
								<form action="Controller" method="post">
									<input type="hidden" name="userId" value="<%=userId%>">
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