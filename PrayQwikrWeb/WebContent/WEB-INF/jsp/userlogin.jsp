<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<style>
/* body, html {
    background-repeat: no-repeat;
    background-image: linear-gradient(rgb(255, 254, 254), rgb(227, 188, 190));
}

.center {
    max-width: 350px;
      margin: auto;
    width: 60%;
    border: 1px solid grey;
    padding: 10px;
    margin-top: 200px;
}

.btn {
    font-weight: 700;
    height: 36px;
     -moz-user-select: none;
    -webkit-user-select: none; 
    user-select: none;
    cursor: default;
}

#inputPassword{
margin-top: 20px;
height: 25px;
width:200px;
}
#inputEmail{
margin-top:30px;
height: 25px;
width:200px;

} */
.wrapper {
	margin-top: 15%;
	align-items: center;
	width: 50%;
	height: 50%;
	font-family: "Gill Sans", "Gill Sans MT", "Myriad Pro",
		"DejaVu Sans Condensed", Helvetica, Arial, sans-serif;
}

.wrapper p {
	padding-top: 20px;
	font-size: 30px;
}

.wrapper hr {
	width: 50%;
}

.wrapper input {
	margin-top: 1%;
	padding: 1.2%;
	width: 250px;
}
</style>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<div class="center">
			<%
				String str = "" + request.getAttribute("number");
				if (!str.equalsIgnoreCase("null")) {
					int number = Integer.parseInt(str);
					if (number == 1) {
			%>
			<h3><%=request.getAttribute("message")%><h3>
					<%
						}
						}
					%>
					<body style="background: url(resources/img/bg.jpg) fixed center"
						class="img-responsive">
						<center>
							<div class="wrapper"
								style="margin-top: 310px; margin-bottom: -45px;">
								<img
									src="<%=request.getContextPath()%>/resources/img/QWIKRPAYlogo.png"
									class="img-responsive" alt="">

								<form action="<%=request.getContextPath()%>/userlogin"
									class="form-signin" method="post">

									<p class="title"
										style="margin-top: -25px; margin-bottom: -10px;">Log in</p>
									<hr>
									<center>
										<input type="email" name="emailId" placeholder="Email Id" />
										<i class="fa fa-user"></i><br> 
										<input type="password"
											name="password" placeholder="Password" /> <i
											class="fa fa-key"></i><br> <input type="submit"
											class="btn btn-default"
											style="margin-top: 15px; width: 30%; background: #f1592a; color: white"
											value="Login">
								</form>
								<br>
								<br>
								<br>
								<div>
									<a href="#" data-toggle="modal" data-target="#mysignup">New
										Registration</a>
								</div>
							</div>
							<a href="#" class="forgot-password" data-toggle="modal"
								data-target="#forgotpass">Forgot password?</a>
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->

	<div class="modal fade" id="mysignup" role="dialog"
		style="margin-top: 15%;">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>

					<h4 class="modal-title">Registration page</h4>
				</div>
				<div class="modal-body">

					<form action="<%=request.getContextPath()%>/usersignup" method="post">
						<table>
							<tr>
								<td><input type="text" name="firstname"
									placeholder="Enter first name" style="margin-top: 10px"
									required="required"></td>
								<td>${firstnameError}</td>
							</tr>
							<tr>
								<td><input type="text" name="lastname"
									placeholder="Enter last name" style="margin-top: 10px"
									required="required"></td>
								<td>${lastnameError }</td>
							</tr>
							<tr>
								<td><input type="email" name="emailid"
									placeholder="Enter Email Id" style="margin-top: 10px"
									required="required"></td>
								<td>${emailError }</td>
							</tr>


							<tr>
								<td><input type="password" name="password"
									placeholder="password" style="margin-top: 10px"
									required="required"></td>
								<td>${passwordError }</td>
							</tr>

							<tr>
								<td><input type="password" name="confirmpassword"
									placeholder="confirmpassword" style="margin-top: 10px"
									required="required"></td>
								<td>${confirmpasswordError }</td>
							</tr>
							<tr>
								<td><input type="text" name="mobilenumber"
									placeholder="mobilenumber" style="margin-top: 10px"
									required="required"></td>
								<td>${mobileError }</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="signup"
									style="margin-top: 10px"></td>
							</tr>
						</table>


					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="forgotpass" role="dialog"
		style="margin-top: 20%;">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Forgot Password</h4>
				</div>
				<div class="modal-body">
					<form action="<%=request.getContextPath()%>/forgotpassword">
						<div id="sendemail"></div>
						<input type="email" id="emailforpass" name="emailId"
							placeholder="Registered Email Id"> <input type="submit"
							value="submit">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>