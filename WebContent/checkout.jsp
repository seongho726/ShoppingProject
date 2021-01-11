<%@page import="model.domain.Basket, model.domain.User, model.domain.Calculate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Product List</title>
        <% String userId=(String) session.getAttribute("userId");%>
        <% ArrayList<Basket> baskets = (ArrayList<Basket>) session.getAttribute("baskets");%>
        <% Calculate calculate = (Calculate) session.getAttribute("calculate");%>
        <% HashMap prices = (HashMap) session.getAttribute("prices");%>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Place favicon.ico in the root directory -->
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    

    <!-- All css files are included here. -->
    <!-- Bootstrap fremwork main css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Owl Carousel main css -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <!-- This core.css file contents all plugings css file. -->
    <link rel="stylesheet" href="css/core.css">
    <!-- Theme shortcodes/elements style -->
    <link rel="stylesheet" href="css/shortcode/shortcodes.css">
    <!-- Theme main style -->
    <link rel="stylesheet" href="style.css">
    <!-- Responsive css -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- User style -->
    <link rel="stylesheet" href="css/custom.css">

	<!--  Axios -->
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <!-- Modernizr JS -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
    <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->  

    <!-- Body main wrapper start -->
    <div class="wrapper fixed__footer">
           <!-- Start Header Style -->
        <header id="header" class="htc-header header--3 bg__white">
            <!-- Start Mainmenu Area -->
            <div id="sticky-header-with-topbar" class="mainmenu__area sticky__header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3">
                            <div class="logo">
                                <a href="index.html">
                                    <img src="images/logo/logo.png" alt="logo">
                                </a>
                            </div>
                        </div>
                        <!-- Start MAinmenu Ares -->
                        <div class="col-md-8 col-lg-8 col-sm-6 col-xs-6">
                            <nav class="mainmenu__nav hidden-xs hidden-sm">
                                <ul class="main__menu">
                                    <li class="drop"><a href="index.html">Home</a></li>
                                    <li class="drop"><a href="shop.jsp">Shop</a>
                                    </li>
                                    <li class="drop"><a href="about.html">About</a>
                                    </li>
                                    <li><a href="contact.html">Contact</a></li>
                                </ul>
                            </nav>
                            <div class="mobile-menu clearfix visible-xs visible-sm">
                                <nav id="mobile_dropdown" style="display: block;">
                                    <ul>
                                        <li><a href="index.html">Home</a></li>
                                        <li class="drop"><a href="shop.jsp">Shop</a>
                                    </li>
                                    <li class="drop"><a href="about.html">About</a>
                                    </li>
                                        <li><a href="contact.html">Contact</a></li>
                                    </ul>
                                </nav>
                            </div>                          
                        </div>
                        <!-- End MAinmenu Ares -->
                        <div class="col-md-2 col-sm-4 col-xs-3">  
                            <ul class="menu-extra">
                                <li class="search search__open hidden-xs"><span class="ti-search"></span></li>
                                <li><a href="login-register.jsp"><span class="ti-user"></span></a></li>
                                <li class="cart__menu" onclick="ajaxCart()"><span class="ti-shopping-cart"></span></li>
                                <li class="toggle__menu hidden-xs hidden-sm"><span class="ti-menu" style="display: none;"></span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="mobile-menu-area"></div>
                </div>
            </div>
            <!-- End Mainmenu Area -->
        </header>
        <!-- End Header Style -->
        
        <div class="body__overlay"></div>
        <!-- Start Offset Wrapper -->
        <div class="offset__wrapper">
            <!-- Start Search Popap -->
            <div class="search__area">
                <div class="container" >
                    <div class="row" >
                        <div class="col-md-12" >
                            <div class="search__inner">
                                <form action="#" method="get">
                                    <input placeholder="Search here... " type="text">
                                    <button type="submit"></button>
                                </form>
                                <div class="search__close__btn">
                                    <span class="search__close__btn_icon"><i class="zmdi zmdi-close"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Search Popap -->
           
         <!-- Start Cart Panel -->
            <div class="shopping__cart">
                <div class="shopping__cart__inner">
                    <div class="offsetmenu__close__btn">
                        <a href="#"><i class="zmdi zmdi-close"></i></a>
                    </div>
                    <div id="ajaxcart">
                       
                    </div>
                    
                    <ul class="shopping__btn">
                        <li><a Onclick="location.href='Controller?command=getBasket'">View Cart</a></li>
                        <li class="shp__checkout"><a Onclick="location.href='Controller?command=buyBasket'">Checkout</a></li>
                    </ul>
                </div>
            </div>
            <!-- End Cart Panel -->
        </div>
        
<script>               
	function ajaxCart(){
	   axios.post('responseBasket.jsp')
	  .then(function (response) { 
		console.log("성공");
		document.getElementById("ajaxcart").innerHTML = response.data;
	  })
	  .catch(function (error) { 
	    console.log(error);
	  })
	  .then(function () {
	    // always executed
	  });
	} 
   </script>
        <!-- End Offset Wrapper -->
        <!-- Start Bradcaump area -->
        <div class="ht__bradcaump__area" style="background: rgba(0, 0, 0, 0) url(images/bg/2.jpg) no-repeat scroll center center / cover ;">
            <div class="ht__bradcaump__wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">Hello, <%= userId%></h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.html">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Checkout</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area -->
     <!-- cart-main-area start -->
        <div class="cart-main-area ptb--120 bg__white">
            <div class="container">
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
                                        </tr>
                                    </thead>
                                    <tbody>
                                   <%
            	int totalPrice = 0;
                for (int i = 0; i < baskets.size(); i++) {
                    Basket basket = baskets.get(i);
                   	int tempPrice = (int)prices.get(basket.getProductId()) * basket.getProductCount();
                   	totalPrice += tempPrice;
            %>
                                        <tr>
                                            <th class="product-name"><%=basket.getBasketId()%></th>
                                            <th class="product-name"><%=userId%></th>
                                            <th class="product-name"><%=basket.getProductId()%></th>
                                            <th class="product-quantity"><%=basket.getProductCount()%></th>
                                            <th class="product-subtotal"><%=tempPrice%></th>
                                        </tr>
                          <% }%>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-8 col-sm-7 col-xs-12">
                                    <div class="buttons-cart">
                                        <a href="location.href='login.jsp'">Continue Shopping</a>
                                    </div>
                                </div>
                                <div class="col-md-4 col-sm-5 col-xs-12">
                                    <div class="cart_totals">
                                        <h2>Cart Totals</h2>
                                        <table>
                                            <tbody>
                                            	<tr class="order-total">
                                                    <th>Total Count</th>
                                                    <td>
                                                        <strong><span class="amount"><%=calculate.getTotalProductCount()%></span></strong>
                                                    </td>
                                                </tr>     
                                                <tr class="order-total">
                                                    <th>Total</th>
                                                    <td>
                                                        <strong><span class="amount"><%=totalPrice%></span></strong>
                                                    </td>
                                                </tr>                                           
                                            </tbody>
                                        </table>
                                      
                                    </div>
                                </div>
                            </div>
                        </form> 
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 col-lg-8">
                        <div class="ckeckout-left-sidebar">
                            <!-- Start Checkbox Area -->
                            <div class="checkout-form">
                                <h2 class="section-title-3">Pay Form</h2>
                                <div class="checkout-form-inner">
                                <form action = "Controller" method="post">
                                    <div class="single-checkout-box">
                                        <input type="text" name="address" size="24" required="required" placeholder="Address">
                                    </div>
                                    <div class="single-checkout-box">
                                       <input type="text" name="contact" size="24" required="required" placeholder="Contact">
                                    </div>
                                    <div class="single-checkout-box">
                                       <input type="text" name="ccNumber" size="24" required="required" placeholder="Credit Card Number">
                                    </div>
                                    <div class="single-checkout-box">
                                       <input type="text" name="ccExpiration" size="24" required="required" placeholder="Credit Card Expiration">
                                    </div>
                                     <div class="single-checkout-box">
                                       <input type="text" name="ccPassword" size="24" required="required" placeholder="Credit Card Password">
                                    </div>
                                    <input type="hidden" name="userId" value="<%=userId%>"> 
           							<input type="hidden" name="command" value="payBasket">
           							<input type="submit" value="Confirm & Buy Now">&nbsp;&nbsp;
            						<input type="reset" value="reset">&nbsp;&nbsp;
                                </form>
                                </div>
                            </div>
                            <!-- End Checkbox Area -->
                            <!-- Start Payment Way -->
                            <div class="our-payment-sestem">
                            	<br>
                                <h2 class="section-title-3">We  Accept :</h2>
                                <ul class="payment-menu">
                                    <li><a href="#"><img src="images/payment/1.jpg" alt="payment-img"></a></li>
                                    <li><a href="#"><img src="images/payment/2.jpg" alt="payment-img"></a></li>
                                    <li><a href="#"><img src="images/payment/3.jpg" alt="payment-img"></a></li>
                                    <li><a href="#"><img src="images/payment/4.jpg" alt="payment-img"></a></li>
                                    <li><a href="#"><img src="images/payment/5.jpg" alt="payment-img"></a></li>
                                </ul>
                            </div>
                            <!-- End Payment Way -->
                        </div>
                    </div>
                    <div class="col-md-4 col-lg-4">
                        <div class="checkout-right-sidebar">
                            <div class="our-important-note">
                                <h2 class="section-title-3">Note :</h2>
                                <p class="note-desc">Lorem ipsum dolor sit amet, consectetur adipisici elit, sed do eiusmod tempor incididunt ut laborekf et dolore magna aliqua.</p>
                                <ul class="important-note">
                                    <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Lorem ipsum dolor sit amet, consectetur nipabali</a></li>
                                    <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Lorem ipsum dolor sit amet</a></li>
                                    <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Lorem ipsum dolor sit amet, consectetur nipabali</a></li>
                                    <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Lorem ipsum dolor sit amet, consectetur nipabali</a></li>
                                    <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Lorem ipsum dolor sit amet</a></li>
                                </ul>
                            </div>
                             <div class="puick-contact-area mt--60">
                                <h2 class="section-title-3">Contact Us</h2>
                                <p> 02-123-4567</p>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        <!-- cart-main-area end -->
             <!-- Start Footer Area -->
        <footer class="htc__foooter__area gray-bg">
            <div class="container">
                <div class="row">
                    <div class="footer__container clearfix">
                         <!-- Start Single Footer Widget -->
                        <div class="col-md-3 col-lg-3 col-sm-6">
                            <div class="ft__widget">
                                <div class="ft__logo">
                                    <a href="index.html">
                                        <img src="images/logo/logo.png" alt="footer logo" style="max-width: 80%;">
                                    </a>
                                </div>
                                <div class="footer-address">
                                    <ul>
                                        <li>
                                            <div class="address-icon">
                                                <i class="zmdi zmdi-pin"></i>
                                            </div>
                                            <div class="address-text">
                                                <p>Seoul, South Korea</p>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="address-icon">
                                                <i class="zmdi zmdi-email"></i>
                                            </div>
                                            <div class="address-text">
                                                <a href="#"> info@example.com</a>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="address-icon">
                                                <i class="zmdi zmdi-phone-in-talk"></i>
                                            </div>
                                            <div class="address-text">
                                                <p>02-123-4567</p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- End Single Footer Widget -->
                        
                        
                        
                        <div class="col-md-3 col-lg-2 col-sm-6 smt-30 xmt-30">
                            <div class="ft__widget">
                                <h2 class="ft__title">Infomation</h2>
                                <ul class="footer-categories">
                                    <li><a href="about.html">About Us</a></li>
                                    <li><a href="contact.html">Contact Us</a></li>
                                </ul>
                            </div>
                        </div>
                        
                        
                        
                    </div>
                </div>
                <!-- Start Copyright Area -->
                <div class="htc__copyright__area">
                    <div class="row">
                        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                            <div class="copyright__inner">
                                <div class="copyright">
                                    <p>© 2020 TECHNOLOGI 
                                    All Rights Reserved.</p>
                                </div>
                                <ul class="footer__menu">
                                    <li><a href="index.html">Home</a></li>
                                    <li><a href="shop.jsp">Product</a></li>
                                    <li><a href="contact.html">Contact Us</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Copyright Area -->
            </div>
        </footer>
        <!-- End Footer Area -->
    </div>
    <!-- Body main wrapper end -->
    <!-- Placed js at the end of the document so the pages load faster -->

    <!-- jquery latest version -->
    <script src="js/vendor/jquery-1.12.0.min.js"></script>
    <!-- Bootstrap framework js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- All js plugins included in this file. -->
    <script src="js/plugins.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <!-- Waypoints.min.js. -->
    <script src="js/waypoints.min.js"></script>
    <!-- Main js file that contents all jQuery plugins activation. -->
    <script src="js/main.js"></script>

</body>

</html>