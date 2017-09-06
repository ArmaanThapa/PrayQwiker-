<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<%@page import="com.qwikr.webapi.domain.User"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PrayQwik.com</title>

<link id="callCss" rel="stylesheet"
	href="<%=request.getContextPath()%>resources/css/bootstrap.min.css"
	media="screen" />

<!-- Bootstrap style responsive -->
<link
	href="<%=request.getContextPath()%>resources/css/bootstrap-responsive.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>resources/css/font-awesome.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>resources/css/base.css"
	rel="stylesheet" />
<!-- <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> -->
<!-- <script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/animate.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<script src="<%=request.getContextPath()%>/resources/ajax/ajaxcall.js"></script>

<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/js/prettify.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery.lightbox-0.5.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootshop.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"
	type="text/javascript"></script>
</head>
<body>
	<div id="header">
	
		<!--
		<div class="container">
			<div id="welcomeLine" class="row">
				<div class="span6">
					Welcome!<strong> User</strong>
				</div>
				<div class="span6">
					  
					<div class="pull-right">

						<a href="product_summary.html"><span
							class="btn btn-mini btn-primary"><i
								class="icon-shopping-cart icon-white"></i> [ 3 ] Items in your
								cart </span> </a>
					</div>
					
				</div>
			</div>
			-->
			<!-- Navbar ================================================== -->

			<div id="logoArea" class="navbar">
				<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<!--  
				<div class="navbar-inner">
					<a class="brand" href="index.html"><img
						src="<%=request.getContextPath()%>/resources/img/QWIKRPAY.png"
						style="width: 190px;" alt="Bootsshop" /></a>
					<form class="form-inline navbar-search" method="post"
						action="/products">
						<input id="srchFld" class="srchTxt" type="text" /> &nbsp; <select
							class="srchTxt">
							<option>All</option>
							<option>CLOTHES</option>
							<option>FOOD AND BEVERAGES</option>
							<option>HEALTH & BEAUTY</option>
							<option>SPORTS & LEISURE</option>
							<option>BOOKS & ENTERTAINMENTS</option>
						</select>
						<button type="submit" id="submitButton" class="btn btn-primary">Go</button>
						&nbsp;
					</form>
				</div>
				-->
			</div>

			<ul id="topMenu" class="nav pull-right">
				<!--  <li class=""><a href="special_offer.html"><font
						color="black"><h>Specials Offer</h> </font></a></li>
				<li class="">
				<a href="normal.html"><font color="black"><h>Delivery</h>
					</font></a></li>
				<li class=""><a href="contact.html"><font color="black"><h>Contact</h>
					</font></a></li>
				<li class=""><a href="#login" role="button" data-toggle="modal"
					style="padding-right: 8"background:" black";><span
						class="btn btn-large btn-success">Login</span></a>
					<div id="login" class="modal hide fade in" tabindex="-1"
						role="dialog" aria-labelledby="login" aria-hidden="false">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h5>Login Block</h5>
						</div>
						<div class="modal-body">
							<form class="form-horizontal loginFrm">
								<div class="control-group">
									<input type="text" id="inputEmail" placeholder="Email">
								</div>
								<div class="control-group">
									<input type="password" id="inputPassword"
										placeholder="Password">
								</div>
								<div class="control-group">
									<label class="checkbox"> <input type="checkbox">
										Remember me
									</label>
								</div>
							</form>
							<button type="submit" class="btn btn-success">Sign in</button>
							<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
						</div>
					</div></li>
					-->
			</ul>
		</div>
	</div>
	</div>
	</div>
	<!-- nav links -->
	<nav id="mainNavigation" class="navbar navbar-dafault main-navigation"
		role="navigation">
		<div class="container">
			<div class="navbar-header col-md-4 col-xs-8">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/"><img
					src="<%=request.getContextPath()%>/resources/img/QWIKRPAY.png"
					alt="logo"></a>
			</div>
			<ul class="nav navbar-nav navbar-right" style="float: left;">

				<%
					long size = ((Long) session.getAttribute("cartsize"));
				%>

				<%
					if (session.getAttribute("userobj") == null) {
				%>
				<li><a href="<%=request.getContextPath()%>/login"
					style="margin-top: 30px; margin-bottom: 10px;">Login</a></li>
				<li><a href="#" data-toggle="modal" data-target="#mysignup"
					style="margin-top: 30px;">Sign Up</a></li>
				<%
					} else {
				%>
				<%
					User uobj = (User) session.getAttribute("userobj");
				%>
				<h4 class="page-header">

					<div class="btn-group">
						Hi 
						<%=uobj.getFirstname()%>  !
						<i class="fa fa-sort-desc" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"></i>

						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/userprofile ">User
									Profile</a></li>
							<li><a href="#" data-toggle="modal"
								data-target="#changepass">change password</a></li>
							<li><a href="<%=request.getContextPath()%>/userlogout">LOG
									OUT</a></li>
						</ul>
					</div>

					<%=size%><a href="<%=request.getContextPath()%>/cartdata/cart">
						<i class="fa fa-shopping-basket fa-lg" style="color: #6d6e71;"></i>
						Cart
					</a>
					<%
						}
					%>
				</h4>
			</ul>
		</div>
		<!-- nav links -->
	</nav>
	<!-- header begin -->
	<%
		if (request.getAttribute("chkout") == null) {
	%>
	<%
		}
	%>

	<!--end jumbotron-->

	<!-- Latest compiled and minified JavaScript -->
	<div class="modal fade" id="mysignup" role="dialog">
		<div class="modal-dialog">


			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>

					<h4 class="modal-title">Registration page</h4>
				</div>
				<div class="modal-body">
					<form action="<%=request.getContextPath()%>/usersignup" method="post">
						<input type="text" name="firstName" placeholder="Enter first name"
							style="margin-top: 10px" required="required"><br> <input
							type="text" name="lastName" placeholder="Enter last name"
							style="margin-top: 10px" required="required"><br> <input
							type="email" name="emailId" placeholder="Enter Email Id"
							style="margin-top: 10px" required="required"><br> <input
							type="password" name="password" placeholder="password"
							style="margin-top: 10px" required="required"><br> <input
							type="text" name="mobileno" Placeholder="mobile number"
							style="margin-top: 10px" required="required"><br> <input
							type="submit" value="signup" style="margin-top: 10px">
					</form>
				</div>
			</div>

		</div>
	</div>
	<div class="modal fade" id="changepass" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>

					<b class="modal-title">new password</b>
				</div>
				<div class="modal-body">
					<form action="<%=request.getContextPath()%>/changepassword">

						<input type="password" id="oldpassword" name="password"
							placeholder="old password" style="margin-top: 10px"><br>
						<input type="password" id="newpassword" name="newpassword"
							placeholder="new password" style="margin-top: 10px"><br>
						<input type="password" name="confirmpassword" id="cnfpassword"
							placeholder="confirm password" style="margin-top: 10px"><br>
						<input type="submit" value="submit" style="margin-top: 10px">
						<div id="msg"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
</body>
</html>