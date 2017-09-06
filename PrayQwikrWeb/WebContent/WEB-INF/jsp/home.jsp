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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Welcome to PrayQwikr</title>
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
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-57-precomposed.png">
<script type="text/javascript">
$(document).ready(function() {
	<%-- xhttp.open("GET", "<%=request.getContextPath()%>/mobilenumberValidator?number=" + mobile, true); --%>
    $(function() {
            $("#search").autocomplete({
            source : function(request, response) {
            $.ajax({
                    url : "<%=request.getContextPath()%>/getAllItemsList",
                    type : "GET",
                    data : {
                            term : request.term
                    },
                    dataType : "json",
                    success : function(data) {
                            response(data);
                    }
            });
    }
});
});
});
</script>
<script type="text/javascript">
	function firstnameValidator(val) {
		//alert("The new value is: ");
		var fname = document.getElementById("fname").value=val;
		console.log("fname---- > " +fname);
		var reg = ".*\\d.*";
		var regix = "[a-zA-Z]";
		var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";
		if (!fname.match(regix)) {
			document.getElementById("fndiv").innerHTML = "Please Enter Valid First Name";
			//document.getElementById("submitButton").disabled = true;
			return false;
		} else if(fname.match(reg)){
			document.getElementById("fndiv").innerHTML = "Please Enter Valid First Name";
			//document.getElementById("submitButton").disabled = true;
			return false;
		}else {
			document.getElementById("fndiv").innerHTML = "";
			return true;
		}
		/* for (var i = 0; i < fname.value.length; i++) {
		    if (iChars.indexOf(fname.value.charAt(i)) != -1){
		    	document.getElementById("fndiv").innerHTML = "Please Enter Valid First Name";
				document.getElementById("submitButton").disabled = true;
				return false;
		} */
	}
	function lastnameValidator() {
		var lname = document.getElementById("lname").value;
		console.log("Lname------ > " +lname);
		var reg = ".*\\d.*";
		var regix = "[a-zA-Z]";
		if (!lname.match(regix)) {
			document.getElementById("lndiv").innerHTML = "Please Enter Valid Last Name";
			//document.getElementById("submitButton").disabled = true;
			return false;
		}else if(lname.match(reg)){
			document.getElementById("lndiv").innerHTML = "Please Enter Valid Last Name";
			//document.getElementById("submitButton").disabled = true;
			return false;
		}else {
			document.getElementById("lndiv").innerHTML = "";
			return true;
		}
	}
	function mobilenumberValidator() {

		var mobile = document.getElementById("mobilenumber").value;
		console.log("mobile---- > " +mobile);
		var mobileRegix = "\\d{10}";
		//var url="mobileChecker.jsp?val="+mobile;
		var xhttp = new XMLHttpRequest();

		if (isNaN(mobile)) {
			document.getElementById("mdiv").innerHTML = "Please Valid Mobile Number";
			//document.getElementById("submitButton").disabled = true;
			return false;
		} else if (!mobile.match(mobileRegix)) {
			document.getElementById("mdiv").innerHTML = "Please Enter 10 Digit Mobile Number";
			//document.getElementById("submitButton").disabled = true;
			return false;
		} else if (mobile.match(mobileRegix)) {
			//**************Added for AJAX Call********
			//console.log("in if else");
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					//console.log("in if condition............");
					document.getElementById("mdiv").innerHTML = this.responseText;
					//document.getElementById("submitButton").disabled = true;
				}
			};
			xhttp.open("GET", "<%=request.getContextPath()%>/mobilenumberValidator?number=" + mobile, true);
			//document.getElementById("submitButton").disabled = true;
			xhttp.send();

		} else {
			document.getElementById("mdiv").innerHTML = "";
			return false;
		}
	}

	//**********************************END********************
	function emailValidator() {
		var email = document.getElementById("emailid").value;
		console.log("email---- > " +email);
		var emailReg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		var xhttp = new XMLHttpRequest();
		if (!email.match(emailReg)) {
			document.getElementById("ediv").innerHTML = "Please Enter Valid Email Id";
			//document.getElementById("submitButton").disabled = true;
			return false;
		} else if (email.match(emailReg)) {
			//**************Added for AJAX Call********
			//console.log("in if else");
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					//console.log("in if condition............");
					document.getElementById("ediv").innerHTML = this.responseText;
					//document.getElementById("submitButton").disabled = true;
				}
			};
			xhttp.open("GET", "<%=request.getContextPath()%>/ajaxEmailValidator?email=" + email, true);
			xhttp.send();
		} else {
			document.getElementById("ediv").innerHTML = "";
			return false;
		}
	}

	function passwordValidator() {
		var password = document.getElementById("password").value;
		console.log("Password--------> " + password);
		var passReg = "((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})";

		if (!password.match(passReg)) {
			document.getElementById("pdiv").innerHTML = "Password Should be 6 to 10 Characters";
			//document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("pdiv").innerHTML = "";
			return false;
		}
	}
	
	function changepasswordValidator() {
		var password = document.getElementById("password").value;
		var cpassword = document.getElementById("confirmpassword").value;
		console.log("password---- > " +password+ "-----           cpassword----> "+cpassword );
		if (cpassword !== password) {
			document.getElementById("cpdiv").innerHTML = "Password and Confirm Password Not Match";
			//document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("cpdiv").innerHTML = "";
			//document.getElementById("submitButton").disabled = false;
			return false;
		}
	}
	//---------------------------------------------------------
	function loginemailValidator() {
		var emailid = document.getElementById("loginemailid").value;
		console.log("Email is :" +emailid);
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//console.log("in if ready state condition");
				document.getElementById("login_email_div").innerHTML = this.responseText;
			}
			else {
				document.getElementById("login_email_div").innerHTML = "";
				//document.getElementById("loginButton").disabled = true;
			}
		};
		xhttp.open("GET", "<%=request.getContextPath()%>/ajaxLoginEmailValidator?email=" + emailid, true);
		xhttp.send();
	}

	function loginpasswordValidator() {
		var emailid2 = document.getElementById("loginemailid").value;
		var password2 = document.getElementById("loginpassword").value;
		console.log("Email is :" +emailid2);
		console.log("Password is  :" +password2);
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//console.log("in if ready state condition");
				document.getElementById("login_fail_div").innerHTML = this.responseText;
				//document.getElementById("loginButton").disabled = true;
			} else {
				document.getElementById("login_fail_div").innerHTML = "";
				//document.getElementById("loginButton").disabled = false;
			}
		};
		xhttp.open("GET", "<%=request.getContextPath()%>/ajaxLoginPasswordValidator?email=" + emailid2
				+ "&password=" + password2, true);
		xhttp.send();
	}

	function forgottenPassword() {
		var femailid = document.getElementById("femailid").value;
		console.log("Femail :" + femailid);
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200) {
				console.log("in if ready state condition");
				document.getElementById("forgot_div").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "<%=request.getContextPath()%>/ajaxforgotPasswordValidator?email=" + femailid,true);
		xhttp.send();
	}

	function verifyCode(val) {
		var vcode = document.getElementById("vcode").value=val;
		//alert("code is  -- >  "  +vcode)
		console.log("vcode ---> " + vcode);
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				console.log("in if ready state condition");
				document.getElementById("verify_div").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "<%=request.getContextPath()%>/ajaxVerificationCodeValidator?code=" + vcode, true);
		xhttp.send();
	}
</script>
<script>
	function openPopup() {
		//alert("register..");
		console.log("in register ");
		var fn = document.getElementById("fname").value;
		var ln = document.getElementById("lname").value;
		var pwd = document.getElementById("password").value;
		var cpwd = document.getElementById("confirmpassword").value;
		var email = document.getElementById("emailid").value;
		var mobile = document.getElementById("mobilenumber").value;
		console.log(fn +","+ln +","+pwd+","+cpwd+","+email+","+mobile);
		//form.submit();
		//myPopup = window.open(url,'popupWindow','width=640,height=480');
		//if (!myPopup.opener)
		//   myPopup.opener = self;
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				console.log("in if ready state condition");
				document.getElementById("reg_fail_div").innerHTML = this.responseText;
			} else {
				document.getElementById("reg_fail_div").innerHTML = "";
			}
		};<%-- <%=request.getContextPath()%> --%>
		xhttp.open("GET", "<%=request.getContextPath()%>/ajaxUserRegister?fname=" + fn + "&lname=" + ln
				+ "&mail=" + email + "&mobile=" + mobile + "&pass=" + pwd
				+ "&cpass=" + cpwd, true);
		xhttp.send();
	}
	
	function userForgottenPassword() {
		var mail = document.getElementById("femailid").value;
		console.log("Email is  -- >"  + mail);
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200) {
				//console.log("in if ready state condition");
				document.getElementById("reg_fail_div").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET", "<%=request.getContextPath()%>/ajaxforgottenPassword?mail="+ mail, true);
		xhttp.send();
	}
</script>
</head>
<!--/head-->

<body>
<div align="center" style="color: red;background-color: orange; font-size: medium; border-width: thin;">
	<b>${loginError}</b></div>
<div align="center" style="color: red;background-color: orange; font-size: medium; border-width: thin;">
	<b>${firstnameError}${lastnameError}${emailError}${mobileError}${passwordError}${confirmpasswordError}</b>
	<b>${forgotError}</b>
	</div>
<div align="center" style="color: green;background-color: orange;font-size: medium;">
	<b>${verifySuccess}</b>
</div>
<div align="center" style="color: green;background-color: orange;font-size: medium;">
	<b>${forgotPasswordSuccess}</b>
</div>
<div align="center" style="color: green;background-color: orange;font-size: medium;">
<b>${newPassSeccess}</b>
</div>
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
						<input type="text" placeholder="Search" id="search"/>
					</div>
				</div>
				<div class="col-sm-2 col-xs-6">
					<div class="shop-menu pull-right">
						<ul class="nav navbar-nav">
							<li><a href="#"><i class="fa fa-shopping-cart fa-2x"></i></a></li>
							<li><a href="#" id="loginform"><i
									class="fa fa-user-circle-o fa-2x"></i></a></li>
						</ul>
						<div id="login">
							<ul class="nav nav-tabs">
								<li class="active"><a data-toggle="tab" href="#Login1">Login</a></li>
								<li><a data-toggle="tab" href="#signup">Signup</a></li>
							</ul>

							<div class="tab-content">
								<div id="Login1" class="tab-pane fade in active text-center">
									<br>
									<!-- userlogin onsubmit="return loginValidate(this.value)" -->
									<form method="post" name="fm"
										action="<%=request.getContextPath()%>/userlogin">
										<div id="login_fail_div" style="color: red"></div>

										<input type="text" name="emailid" id="loginemailid"
											placeholder="Enter Email Id" required="required"
											onchange="loginemailValidator()"/>
										<div id="login_email_div" style="color: red"></div>

										<input type="password" name="password" id="loginpassword"
											placeholder="Enter Password" required="required"
											onchange="loginpasswordValidator()" maxlength="10"
											minlength="6"/><br>
										<h6>
											<a href="<spring:url value=""/>" data-toggle="modal"
												data-target="#myModal"> Forgotten Password?</a>
										</h6>
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" /> <input type="submit" class="btn"
											value="Login" id="loginButton" />
									</form>
								</div>
								<div id="signup" class="tab-pane fade text-center">
									<br>
									<form action="<%=request.getContextPath()%>/user/usersignup" method="post" name="form">
										<div id="reg_fail_div" style="color: red"></div>
										<input type="text" name="firstname" id="fname"
											onchange="firstnameValidator(this.value)"
											placeholder="Enter First Name" required="required"/>
										<div id="fndiv" style="color: red"></div>
										<input type="text" name="lastname" id="lname"
											onchange="lastnameValidator()" placeholder="Enter Last Name"
											required="required"/>
										<div id="lndiv" style="color: red"></div>
										<input type="text" name="mobilenumber" id="mobilenumber"
											maxlength="10" minlength="10"
											placeholder="Enter Mobile Number" required="required"
											onchange="mobilenumberValidator()"/>
										<div id="mdiv" style="color: red"></div>
										<input type="text" name="emailid" id="emailid"
											placeholder="Enter Email Id" required="required"
											onchange="emailValidator()"/>
										<div id="ediv" style="color: red"></div>
										<input type="password" name="password" id="password"
											placeholder="Enter Password" required="required"
											onchange="passwordValidator()" maxlength="10"/>
										<div id="pdiv" style="color: red"></div>
										<input type="password" name="confirmpassword"
											id="confirmpassword" placeholder="Enter Confirm Password"
											required="required" onchange="changepasswordValidator()"
											maxlength="10"/><br>
										<div id="cpdiv" style="color: red"></div>
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" /> <br> <input type="submit"
											class="btn" value="Submit" id="submitButton"/>
											 <!-- onClick="openPopup()" data-toggle="modal"
											data-target="#verifycodeModal" -->
									</form>
								</div>
							</div>
							<!-----end tab-content -->
							<!-- -<input type="button" name="btn" value="Submit" id="submitBtn" data-toggle="modal" 
							data-target="#confirm-submit" class="btn btn-default" data-toggle="modal" data-target="#verifycodeModal"/>
							 -->
						</div>
						<!---end login--->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ------------------------------- --> <!--/header-middle-->
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
						<li><a href="#" class="active">Prasadam</a></li>
						<li><a href="#">God Idols</a>
						<li><a href="#">Pooja Items</a></li>
						<li><a href="#">Zevotion</a></li>
						<li><a href="#">Rudraksha</a></li>
						<!-- <li><a href="#">HOME & FURNITURE</a></li> -->
						<li><a href="#">Books & More</a></li>
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
							<%-- <div id="sportswear2" class="panel-collapse collapse">
								<div class="panel-body">
									<c:forEach items="${productlist}" var="products">
										<ul>
											<li><a href="<%=request.getContextPath() %>/viewdetail/${products.productDetailid}">
											${products.productName}</a></li>
										</ul>
									</c:forEach>
								</div>
							</div> --%>
						</div>
						
						<!-- ********************************---End Displaying Category from database -->
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
							data-slider-value="[250,850]" id="sl2"><br /> <b
							class="pull-left"><i class="fa fa-inr"></i> 0</b> <b
							class="pull-right"><i class="fa fa-inr"></i> 2000</b>
					</div>
				</div>
				<!--/price-range-->

				<div class="shipping text-center">
					<!--shipping-->
					<img
						src="<%=request.getContextPath()%>/resources/images/home/shipping.jpg"
						alt="" />
				</div>
				<!--/shipping-->
			</div>
			<!-- below is row div end-->
		<!-- </div> -->
		<!------end left-sidebar------->
		<!-- --------------------------------Displaying Product from Database--------------------------------- -->
		<div class="col-sm-9 padding-right">
			<div class="features_items"><!--features_items-->
				<h2 class="title text-center">Features Items</h2>
				<c:forEach items="${productlist}" var="pobj">
					<div class="col-sm-4">

						<div class="product-image-wrapper">

							<div class="single-products">

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
											class="btn btn-default add-to-cart"><i class=""></i>Details</a>
										<h2>
											<i class="fa fa-inr"></i> ${pobj.unitPrice}
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
				<!--features_items-->
				<!-- --------------------------END FEATURED ITEMS-------------------------------------------- -->
				</div>
	</div>
	</div>
	</section>

	<br>
	<br>

	<footer id="footer"> <!--Footer-->
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
							<li><a href="#">Pudraksha</a></li>
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
							<input type="text" placeholder="Your email address" /> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
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
	<!-- ----forgotten Password- -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body text-center">
					<form action="<%=request.getContextPath()%>/forgottenPassword" method="post">
						<h3>Forgotten Password</h3>
						<input type="text" name="emailid" id="femailid"
							onchange="forgottenPassword()" placeholder="Enter Email Id"
							required="required" />
						<div id="forgot_div" style="color: red"></div>
						<h6 style="color: red">${forgotErrors}</h6>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <br> <input type="submit"
							class="btn btn-default" value="Submit"/><br>
						<br><!-- data-toggle="modal"
							data-target="#messageModal"   onClick="userForgottenPassword()" -->
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- -----------------------------------/forgotten Password----------->
	<!-- *************************************-***************************** -->
	<div id="messageModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body text-center">
					<div id="message_div" style="color: green">Temporary Password
						has been sent to your Email,Please check your Email for New
						Password</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ---*************************************************************** -->
	<!-- ---------------------------------------verifycodeModal------- -->
	<div id="verifycodeModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body text-center">
					<form action="<%=request.getContextPath()%>/verifyCode">
						<h5>${message}</h5>
						<h3>Verify Your Account</h3>
						<input type="text" name="verificationcode" id="vcode"
							onchange="verifyCode(this.value)"
							placeholder="Enter Verification Code" required="required" />
						<div id="verify_div" style="color: red"></div>
						<h4 style="color: red;">${verifyFail}</h4>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <br> 
							<input type="submit"
							class="btn btn-default" value="Submit" /><br> <br>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- ----/verifycodeModal--------------------------------------------- -->

	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.scrollUp.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/price-range.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/jquery.prettyPhoto.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</body>
</html>