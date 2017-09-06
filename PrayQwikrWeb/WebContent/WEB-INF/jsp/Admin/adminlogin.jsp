<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Admin Login | QwikrPay</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
         href="/resources/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
</head>

<body>
	<div class="container-fluid">
		<div class="row">

			<div class="col-md-3"
				style="background: rgb(230, 64, 12); height: 100vh; background-image: url(resources/img/bg3.png)">
				<img src="resources/img/QWIKRPAY.png" class="img-responsive logo">
			</div>
			<!--end col-4-->
		
			<div class="col-md-9 wrapbg">
				<div class="wrapper">
				<h5 style="color: green">${verifySuccess}</h5>
				
					<form action="<%=request.getContextPath()%>/adminsignup"
						method="post" class="login">
						<p class="title">Log in</p>
						<h5 style="color: red">${loginError}</h5>
						<hr>
						<h4 style="color: red;">${adminFail}</h4>
						<input type="text" name="email" placeholder="User name" /> <br>
						<input type="password" name="password" placeholder="Password" /> <br>
						<button type="submit" class="btn btn-default"
							style="margin-top: 15px; width: 32%; background: #f1592a; color: white">Login</button>
					</form>
				<%-- <a href="<%=request.getContextPath()%>/AdminRegister">Sign Up</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="">Forgotten Password?</a> --%>
				</div>
			</div>
			<!--end col-8-->
		</div>
		<!--end row-->
	</div>
	<!---end container----->
</body>
</html>