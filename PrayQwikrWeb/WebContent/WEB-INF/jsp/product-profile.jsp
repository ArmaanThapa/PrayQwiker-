<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="com.qwikr.webapi.domain.User"%>
<%@page import="com.qwikr.webapi.domain.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="_csrf_parameter" content="_csrf" />
<meta name="_csrf_header" content="X-CSRF-TOKEN" />
<meta name="_csrf" content="e62835df-f1a0-49ea-bce7-bf96f998119c" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<!--    <link href="css/font-awesome.min.css" rel="stylesheet">-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<%=request.getContextPath()%>/resources/css/prettyPhoto.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/price-range.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/animate.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/main.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/responsive.css"
	rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/images/ico/favicon.ico">-->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
<div style="color: green;background-color: orange;">${cartSecc}</div>
	<%@include file="header.jsp"%>  
	<%-- <%
		long size = (Long) session.getAttribute("cartsize");
	%>
	<header id="header"> <!--header-->
	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="<%=request.getContextPath()%>/"><img
							src="<%=request.getContextPath()%>/resources/images/home/logo.png"
							alt="" width="200px" /></a>
					</div>
				</div>
				<div class="col-sm-6 col-xs-6">
					<div class="search_box">
						<input type="text" placeholder="Search" />
					</div>
				</div>
				<div class="col-sm-2 col-xs-6">
					<div class="shop-menu pull-right">
						<%
							if (session.getAttribute("userobj") != null) {
								User uobj = (User) session.getAttribute("userobj");
						%>
						<ul class="nav navbar-nav">
							<li>Hi <%=uobj.getFirstname()%> !
							</li>
							<li><a href="<%=request.getContextPath()%>/cartdata/cart"><i
									class="fa fa-shopping-cart fa-2x"></i></a>&nbsp;<%=size%></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"><i
									class="fa fa-user-circle-o fa-2x"></i></a>
								<ul class="dropdown-menu">
									<li><a href="<%=request.getContextPath()%>/userProfile">Profile</a></li>
									<li><a href="" data-toggle="modal"
										data-target="#changePassword">Change Password</a></li>
									<li><a href="<%=request.getContextPath()%>/userlogout">Log
											Out</a></li>
								</ul></li>
						</ul>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
 --%>
	<div class="container" id="product" style="margin-top: 40px;">
		<div class="col-sm-5">
			<a href="#"> <img
				src="<%=request.getContextPath()%>/resources/images/uploaded-images/${productObj.fileName}"
				alt="product" width="350" height="200" class="img-responsive" />
			</a>
		</div>

		<div class="col-sm-6">
		
			<h1>${productObj.productName}</h1>
			<hr>
			<b><p>Description :</b> ${productObj.decription}
			</p>

			<b><h4>Price : ${productObj.unitPrice }</h4></b> <a
				href="<%=request.getContextPath()%>/addtocart/${productObj.productDetailid}">
				<span class="like">
					<button type="button" class="btn btn-success"
						style="margin-left: 0;">Add to Cart</button>
			</span>
			</a>
		</div>
	</div>
	</div>
	<br>
	<br>
	<br><br><br><br><br><br><br><br><br><br><br>
	<%@include file="footer.jsp"%>
	<!--Footer-->
<%-- 	<footer id="footer"> 
	<div class="footer-widget">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Service</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Online Help</a></li>
							<li><a href="#">Contact Us</a></li>
							<li><a href="#">Order Status</a></li>
							<li><a href="#">Change Location</a></li>
							<li><a href="#">FAQ’s</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Quock Shop</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">T-Shirt</a></li>
							<li><a href="#">Mens</a></li>
							<li><a href="#">Womens</a></li>
							<li><a href="#">Gift Cards</a></li>
							<li><a href="#">Shoes</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>Policies</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Terms of Use</a></li>
							<li><a href="#">Privecy Policy</a></li>
							<li><a href="#">Refund Policy</a></li>
							<li><a href="#">Billing System</a></li>
							<li><a href="#">Ticket System</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="single-widget">
						<h2>About Shopper</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Company Information</a></li>
							<li><a href="#">Careers</a></li>
							<li><a href="#">Store Location</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3 col-sm-offset-1">
					<div class="single-widget">
						<h2>About Shopper</h2>
						<form action="#" class="searchform">
							<input type="text" placeholder="Your email address" />
							<button type="submit" class="btn btn-default">
								<i class="fa fa-arrow-circle-o-right"></i>
							</button>
							<p>
								Get the most recent updates from <br />our site and be updated
								your self...
							</p>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<p class="pull-left">Copyright © 2016</p>
			</div>
		</div>
	</div>

	</footer>
 --%>	<!--/Footer-->
		<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.scrollUp.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/price-range.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.prettyPhoto.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
	
</body>
</html>