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
<meta charset="utf-8">

<meta name="description" content="">
<meta name="author" content="">
<title>Welcome to PrayQwik</title>
<%-- <link
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
    <![endif]-->
<!--  <link rel="shortcut icon"
	href="<%=request.getContextPath()%>/resources/images/ico/favicon.ico"> -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-57-precomposed.png"> --%>
	
<script type="text/javascript">
	function oldpasswordValidator() {
		var oldpassword = document.getElementById("oldpassword").value;
		console.log("old password ------> " +oldpassword);
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//console.log("in if ready state condition");
				document.getElementById("oldpass_div").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "<%=request.getContextPath()%>/ajaxOldPasswordValidator?password=" + oldpassword,
				true);
		xhttp.send();
	}

	function passwordValidator() {
		var newpassword = document.getElementById("newpassword").value;
		console.log("newpassword --- > "+newpassword);
		var passReg = "((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})";

		if (!newpassword.match(passReg)) {
			document.getElementById("newpass_div").innerHTML = "Password Should be 6 to 10 Characters";
			return false;
		} else {
			document.getElementById("newpass_div").innerHTML = "";
			return false;
		}
	}

	function cpasswordValidator() {
		var npassword = document.getElementById("newpassword").value;
		var cnpassword = document.getElementById("cnewpassword").value;
		console.log("npassword---- > " +npassword + "----        cnpassword--->"+cnpassword);
		if (cnpassword !== npassword) {
			document.getElementById("cnewpass_div").innerHTML = "Password and Confirm Password Not Match";
			return false;
		} else {
			document.getElementById("cnewpass_div").innerHTML = "";
			return false;
		}
	}
</script>
</head>
<body>
	
	<header id="header">  <!--header-->
	

 
<!--end change password  -->


<div align="center" style="background-color: orange;font-size: medium;color: green;">${cartSuccess}${updateProfileSuccess }</div>
	<%@include file="header.jsp"%>
	<!-- ------------CODE FROM HEADER FILE------- -->
	<header id="header"> 
	 <%
	 	String email2 = (String) session.getAttribute("email");
	 	String password2 = (String) session.getAttribute("password");
	 	session.setAttribute("mail", email2);session.setAttribute("password", password2);
	 %>
	<!--/header-middle-->
	 <div class="header-bottom">
		<!--header-bottom-->
		<div class="container">
			<div class="col-md-12 col-lg-offset-1">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="mainmenu pull-left">
					<ul class="nav navbar-nav collapse navbar-collapse">
						<li><a href="index.html" class="active">Prasadam</a></li>
						<li><a href="#">God Idols</a>
						<li><a href="#">Pooja Items</a></li>
						<li><a href="#">Zevotion</a></li>
						<li><a href="#">Rudraksha</a></li>
						<!-- <li><a href="#">HOME & FURNITURE</a></li> -->
						<li><a href="#">BOOKS & MORE</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--/header-bottom-->
	</header>
	<!--/header-->

	<section id="slider">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img
					src="<%=request.getContextPath()%>/resources/images/home/slider1.jpg"
					class="img-responsive">
			</div>

			<div class="item">
				<img
					src="<%=request.getContextPath()%>/resources/images/home/slider2.jpg"
					class="img-responsive">
			</div>

			<div class="item">
				<img
					src="<%=request.getContextPath()%>/resources/images/home/slider3.jpg"
					class="img-responsive">
			</div>

			<div class="item">
				<img
					src="<%=request.getContextPath()%>/resources/images/home/slider4.jpg"
					class="img-responsive">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	</section>
	<!---end slider-->
	<br>
	<br>

	<section>
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<!--left-sidebar-->
				<div class="left-sidebar">
					<h2>Category</h2>
					<c:forEach items="${categorylist}" var="category">
	    				<div class="panel-group category-products" id="accordian">
						<!-- ********************************---Displaying Category from database -->
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									
										<a data-toggle="collapse" data-parent="#accordian"
											href="#sportswear2"> <span class="badge pull-right"><i
												class="fa fa-plus"></i></span> ${category.categoryName}
										</a>
									
								</h4>
							<div id="sportswear2" class="panel-collapse collapse">
								<div class="panel-body">
									<c:forEach items="${productlist}" var="products">
										<ul>
											<li><a href="<%=request.getContextPath() %>/viewdetail/${products.productDetailid}">
											${products.productName}</a></li>
										</ul>
									</c:forEach>
								</div>
							</div>
						</div>
						<!-- ********************************---End Displaying Category from database -->
					</div>
					</div>
					</c:forEach>
				</div>
											
					<br>

					<div class="brands_products">
						<!--brands_products-->
						<h2>Brands</h2>
						<div class="brands-name">
						<c:forEach items="${brandList}" var="brands">
						<ul class="nav nav-pills nav-stacked">
								<li><a href="#"><span class="pull-right"></span>${brands.brandName}</a></li>
						</ul>
						</c:forEach>
						</div>
					</div>
					<!--/brands_products-->
					<div class="price-range">
						<!--price-range-->
						<h2>Price Range</h2>
						<div class="well text-center">
							<input type="text" class="span2" value="" data-slider-min="0"
								data-slider-max="2000" data-slider-step="5"
								data-slider-value="[250,850]" id="sl2"><br/> <b
								class="pull-left"><i class="fa fa-inr"></i> 0</b> <b
								class="pull-right"><i class="fa fa-inr"></i> 2000</b>
						</div>
					</div>
					<!--/price-range-->
					<div class="shipping text-center">
						<!--shipping-->
						<img
							src="${pageContext.request.contextPath}/resources/images/home/shipping.jpg"
							alt="" />
					</div>
					<!--/shipping-->
				</div>
			<!-- </div> -->
			<!------end left-sidebar------->
			<!-- -------------------------------Displaying Products From Database----START---------------------------------------------------- -->
			<div class="col-sm-9 padding-right">
				<div class="features_items">
					<!--features_items-->
					<h2 class="title text-center">Features Items</h2>
					<c:forEach items="${productlist}" var="pobj">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<!-- --------------products---------- -->
									<div class="productinfo text-center">
										<a
											href="${pageContext.request.contextPath}/viewdetail/${pobj.productDetailid}">
											<img
											src="${pageContext.request.contextPath}/resources/images/uploaded-images/${pobj.fileName}"
											alt="product" width="300" height="50; margin-top: 25px;"
											class="img-responsive" />
										</a>
										<h2>
											<i class="fa fa-inr"></i> ${pobj.unitPrice}
										</h2>
										<p>${pobj.productName}</p>
										<a
											href="${pageContext.request.contextPath}/addtocart/${pobj.productDetailid}"
											class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<a
												href="${pageContext.request.contextPath}/viewdetail/${pobj.productDetailid}"
												class="btn btn-default add-to-cart">Details</a>
											<h2>
												<i class="fa fa-inr"></i> ${pobj.unitPrice}<br>
											</h2>
											<p>${pobj.productName}</p>
											<a
												href="${pageContext.request.contextPath}/addtocart/${pobj.productDetailid}"
												class="btn btn-default add-to-cart"> <i
												class="fa fa-shopping-cart"></i>Add to cart
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<br>
	<br> 
<!---------------------------------------Footer------------------------------>
<!-- end foooter -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.scrollUp.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/price-range.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.prettyPhoto.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<%@include file="footer.jsp"%>
</body>
</html>