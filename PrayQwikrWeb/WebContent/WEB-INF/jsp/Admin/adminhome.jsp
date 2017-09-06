<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Login | QwikrPay</title>
<!-- Latest compiled and minified CSS -->
<%-- <link rel="icon" href='<c:url value="/resources/img/QWIKRPAY.png"/>' type="image/jpg" /> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.2/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

<%-- <link href="<c:url value="/resources/css/style_main.css"/>"
	rel='stylesheet' type='text/css'> --%>
<!-- ------------------------------------------------- -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- ------------------------------------------- -->
<link href="<c:url value="/resources/css/css_style.css"/>"
	rel='stylesheet' type='text/css'>
<link href="<c:url value="/resources/css/admin.css"/>" rel='stylesheet'
	type='text/css'>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<%-- ${pageContext.request.contextPath} --%>
<script src="<%=request.getContextPath()%>/resources/js/wow.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/header.js"></script>
<style>
.logo {
	background: white;
	padding: 10px 20px;
	border-radius: 10px;
	margin-left: 43%;
	margin-top: 80%;
}

.wrapper {
	margin-top: 15%;
	margin-left: 20%;
	height: 50%;
	font-family: "Gill Sans", "Gill Sans MT", "Myriad Pro",
		"DejaVu Sans Condensed", Helvetica, Arial, sans-serif;
}

.wrapper p {
	padding-top: 20px;
	font-size: 30px;
}

.wrapper input {
	margin-top: 1%;
	padding: 1.2%;
	width: 250px;
}
</style>
<body>
	<div class="container" style="margin-top: 8px;">
		<ul class="nav navbar-nav navbar-right">
			<form id="login" action="" method="post">
				<div class="group">
					<input type="text" name="username" autocomplete="off" required>
					<span class="highlight"></span> <span class="bar"></span> <label>Username
					</label>
				</div>

				<div class="group">
					<input type="password" name="password" autocomplete="off"
						maxlength="50" required> <span class="highlight"></span> <span
						class="bar"></span> <label>Password</label> <a href="#"
						data-toggle="modal" style="color: white;"
						data-target="#forgotPassword">Forgot Password? </a>
				</div>
				<button type="submit" class="btn"
					style="margin-top: 12px; margin-left: 20px; background: #ec2029; color: #FFFFFF; border-radius: 0">Submit</button>
			</form>
		</ul>
	</div>
<div class="col-xs-12 col-sm-6  col-md-4 "
			style="background: #FFFFFF; height: 518px;" id="signup">

			<h3 style="color: #7e7e7e;">Sign Up</h3>
			<hr style="border: solid .1px #949494;">

			<form id="signup"
				action="${pageContext.request.contextPath}/User/Register"
				method="post">
					<p class="align-center">${msg}</p>
					<div class="group">
						<input type="text" name="firstName" value="${user.firstName}"
							required>
						<p class="error">${error.firstName}</p>
						<span class="highlight"></span> <label>First Name</label>
					</div>

					<div class="group">
						<input type="text" name="lastName" value="${user.lastName}"
							required>
						<p class="error">${error.lastName}</p>
						<span class="highlight"></span> <label>Last Name</label>
					</div>

					<div class="group">

						<input type=password name="password" required>
						<p class="error">${error.password}</p>
						<span class="highlight"></span> <label>Password</label>
					</div>

					<div class="group">
						<input type="password" name="confirmPassword" required>
						<p class="error">${error.confirmPassword}</p>
						<span class="highlight"></span> <label>Confirm Password</label>
					</div>

					<div class="group">
						<input type="text" name="contactNo" value="${user.contactNo}"
							required> <span class="highlight"></span>
						<p class="error">${error.contactNo}</p>
						<label>Mobile Number</label>
					</div>

					<div class="group">
						<input type="email" name="email" value="${user.email}" required>
						<span class="highlight"></span>
						<p class="error">${error.email}</p>
						<label>Email Address</label>
					</div>

					<input type="checkbox" class="check" value="termsConditions"
						id="termsConditions" onclick="enableButton('registerButton');"
						style="width: 10%; text-align: left; margin-top: 20px; float: left; margin-right:;">
					<p style="font-size: 12px; margin-top: 12px; margin-bottom: -22px;">
						By clicking submit i hereby agree all the <a
							href="<c:url  value='/Terms&Conditions'/>">terms and
							conditions</a>.
					</p>
					<br>

					<button type="submit" class="btn disabled" id="registerButton"
						style="margin-top: 12px; margin-bottom: 2%; margin-left: 8%; background: #ec2029; color: #FFFFFF; width: 80%;">Submit</button>

				</form>
				</ul>
		</div> 	
</body>
</html>
