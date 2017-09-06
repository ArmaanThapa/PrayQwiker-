<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<%@ page session="true"%>
<%@page import="com.qwikr.webapi.domain.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="_csrf_parameter" content="_csrf" />
<meta name="_csrf_header" content="X-CSRF-TOKEN" />
<meta name="_csrf" content="e62835df-f1a0-49ea-bce7-bf96f998119c" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delivery Address</title>
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
<!-- ---------------------------- -->
	<%
		long size = (Long) session.getAttribute("cartsize");
	%>
	<header id="header"> <!--header-->
	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="index.html"><img
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
									<li><a href="/QwikerApplication_New/userProfile">Profile</a></li>
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

<!-- --------------------------- -->
	<div class="container">
		<div class="col-md-7">
			<form:form modelAttribute="delivery" id="form" class="fm1"
				method="post" action="<%=request.getContextPath()%>/continueforpayment">
			
			${message}
			<table border="2">
					<tr>
						<th colspan="3">Address</th>
					</tr>
					<c:forEach items="${address}" var="add">
						<tr>
							<td>${add.firstname}${add.lastname}, ${add.email},
								${add.mobilenumber},${add.streetaddress},${add.landmark},${add.city},
								${add.country},${add.zipcode}
							</td>
							<td><a
								href="<spring:url value="/update?orderid=${add.orderid}"/>">Edit</a>
							</td>
							<td><a
								href="<spring:url value="/delete?orderid=${add.orderid}"/>">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<h3>Delivery Address</h3>
				<div>
					<label for="firstname">First Name:</label>
					<form:input path="firstname" id="firstname" type="text"
						class="form-control" placeholder="Enter first name" />
				</div>

				<div>
					<label for="lastname">Last Name:</label>
					<form:input path="lastname" id="lastname" type="text"
						class="form-control" placeholder="Enter last name" />
				</div>

				<div>
					<label for="email">Email:</label>

					<form:input path="email" id="email" name="email" type="text"
						class="form-control" placeholder="Enter email" />

				</div>
				<div>
					<label for="mobile">Contact Number:</label>
					<form:input path="mobilenumber" id="mobile" name="mobilenumber"
						type="text" class="form-control" placeholder="Enter Mobile Number" />
				</div>
				<div>
					<label for="streetaddress">Street :</label>

					<form:input path="streetaddress" id="streetaddress"
						name="streetaddress" type="text" class="form-control"
						placeholder="Enter Street" />

				</div>
				<div>
					<label for="landmark">Landmark :</label>

					<form:input path="landmark" id="landmark" name="landmark"
						type="text" class="form-control" placeholder="Enter landmark" />


				</div>
				<div>
					<label for="zipcode">Zip Code:</label>

					<form:input path="zipcode" id="zipcode" name="zipcode" type="text"
						class="form-control" placeholder="Enter Zipcode" />

				</div>
				<div>
					<label for="city">City:</label>

					<form:input path="city" id="city" name="city" type="text"
						class="form-control" placeholder="Enter City" />

				</div>
				<div>
					<label for="country">Country:</label>
					<form:input path="country" id="country" name="country" type="text"
						class="form-control" placeholder="Enter country name" />
<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
					<input type="submit" value="continue" class="btn btn-success"
						style="margin-left: 0px; margin-top: 20px; margin-bottom: 50px;">
				</div>

				<div class="col-md-5"></div>
			</form:form>
		</div>

	</div>
<!---------------------------------------Footer------------------------------>
	<footer id="footer"> 
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
						<h2>Quick Shop</h2>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">Pooja Items</a></li>
							<li><a href="#">Rudraksha</a></li>
							<li><a href="#">God Idols</a></li>
							<!-- <li><a href="#">Gift Cards</a></li>
							<li><a href="#">Shoes</a></li> -->
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
						<form action="<%=request.getContextPath()%>/#" class="searchform">
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
	<!--/Footer-->

	<!-- --------------------Change Password------------------ -->

	<div id="changePassword" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body text-center">
					<form action="<%=request.getContextPath()%>/setNewPassword">
						<h3>Set New Password</h3>

						<input type="password" name="password" id="oldpassword"
							placeholder="Old Password" required="required"
							onchange="oldpasswordValidator(this.value)" /><br>
						<div id="oldpass_div" style="color: red"></div>
						<input type="password" name="password" id="newpassword"
							placeholder="New Password" required="required"
							onchange="passwordValidator(this.value)" /><br>
						<div id="newpass_div" style="color: red"></div>
						<input type="password" name="confirmpassword" id="cnewpassword"
							placeholder="Confirm New Password" required="required"
							onchange="cpasswordValidator(this.value)" /><br>
						<div id="cnewpass_div" style="color: red"></div>
						<input type="submit" class="btn btn-default" value="Submit" /><br>
						<br>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- ------------------------/Change Password-------------------- -->


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