<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@page import="com.qwikr.webapi.domain.User"%>
<html>
<head>
<!-- <meta name="_csrf_parameter" content="_csrf" />
<meta name="_csrf_header" content="X-CSRF-TOKEN" />
<meta name="_csrf" content="e62835df-f1a0-49ea-bce7-bf96f998119c" />
 --><meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title></title>
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
</head><body>
	<%
		long size = (Long) session.getAttribute("cartsize");
		String email = (String)session.getAttribute("email");
		String password = (String)session.getAttribute("password");
	%>
	<header id="header">  <!--header-->
	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="<%=request.getContextPath()%>/userhome"><img
							src="<%=request.getContextPath()%>/resources/images/home/logo.png"
							alt="" width="200px"/></a>
					</div>
				</div>
				<div class="col-sm-6 col-xs-6">
					<div class="search_box">
						<input type="text" placeholder="Search"/>
					</div>
				</div>
				<div class="col-sm-2 col-xs-6">
					<div class="shop-menu pull-right">
						<%
							if (session.getAttribute("userobj") != null) {
								User uobj = (User) session.getAttribute("userobj");
						%>
						<%-- <h5 style="color: navy;"><b>Hi <%=uobj.getFirstname()%> !</b></h5> --%>
							
						<ul class="nav navbar-nav">
							<li><a href="<%=request.getContextPath()%>/cartdata/cart"><i
									class="fa fa-shopping-cart fa-2x"></i></a>&nbsp;<%=size%></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#"><i
									class="fa fa-user-circle-o fa-2x"></i></a>
								<ul class="dropdown-menu">
									<li><a href="<%=request.getContextPath()%>/userProfile">Profile</a></li>
									<!-- <li><a href="" data-toggle="modal" data-target="#changePassword">Change Password</a></li> -->
									<%-- <h6>
											<a href="<spring:url value=""/>" data-toggle="modal"
												data-target="#myModal"> Forgotten Password?</a>
										</h6> --%>
									<li><a href="#" data-toggle="modal" data-target="#changePasswordmodelinjspapge">Change Password</a></li>
									<li><a href="<%=request.getContextPath()%>/userlogout">Log
											Out</a></li>
								</ul></li><li><h5 style="color: navy;"><b>Hi <%=uobj.getFirstname()%> !</h5></li>
						</ul>
						<%
							}
						%>
					</div>
		<!-- ----------------------------------------------------***** -->
			   </div>
			</div>
		</div>
	</div>
<!-- --------------------Change Password------------------ -->



  <div id="changePasswordmodelinjspapge" class="modal fade" role="dialog">
		<div class="modal-dialog modal-sm">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body text-center">
					<form action="<%=request.getContextPath()%>/setNewPassword" method="post">
						<h3>Set New Password</h3>
						<input type="password" name="password" id="oldpassword"
							placeholder="Old Password" required="required"
							onchange="oldpasswordValidator()" maxlength="10"/><br>
						<div id="oldpass_div" style="color: red"></div>
						<input type="password" name="password" id="newpassword"
							placeholder="New Password" required="required"
							onchange="passwordValidator()" maxlength="10"/><br>
						<div id="newpass_div" style="color: red"></div>
						<input type="password" name="confirmpassword" id="cnewpassword"
							placeholder="Confirm New Password" required="required"
							onchange="cpasswordValidator()" maxlength="10"/><br>
						<div id="cnewpass_div" style="color: red"></div>
						<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<input type="submit" class="btn btn-default" value="Submit"/><br>
						<br>
					</form>
				</div>
			</div>
		</div>
	</div> 

 
<!--end change password  -->

<%-- <div id="myModal" class="modal fade" role="dialog">
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
 --%>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.scrollUp.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/price-range.js"></script>
	<script	src="<%=request.getContextPath()%>/resources/js/jquery.prettyPhoto.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</body>
</html>