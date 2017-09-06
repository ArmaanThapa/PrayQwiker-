<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="_csrf_parameter" content="_csrf" />
<meta name="_csrf_header" content="X-CSRF-TOKEN" />
<meta name="_csrf" content="e62835df-f1a0-49ea-bce7-bf96f998119c" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Update Delivery Address | PrayQwik</title>
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css"
	rel="stylesheet">
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
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-57-precomposed.png">
<script type="text/javascript">
	function fnameValiadator(val) {
		var fname = document.getElementById("firstname").value;
		console.log("firstname------ > " + fname);
		var reg = ".*\\d.*";
		var regix = "[a-zA-Z]";
		if (!fname.match(regix)) {
			document.getElementById("fn_div").innerHTML = "Please Enter Valid Last Name";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else if (fname.match(reg)) {
			document.getElementById("fn_div").innerHTML = "Please Enter Valid Last Name";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("fn_div").innerHTML = "";
			return true;
		}
	}

	function lnameValiadator(val) {
		var lname = document.getElementById("lastname").value;
		console.log("lastname------ > " + lname);
		var reg = ".*\\d.*";
		var regix = "[a-zA-Z]";
		if (!lname.match(regix)) {
			document.getElementById("ln_div").innerHTML = "Please Enter Valid Last Name";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else if (lname.match(reg)) {
			document.getElementById("ln_div").innerHTML = "Please Enter Valid Last Name";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("ln_div").innerHTML = "";
			return true;
		}
	}

	function emailValiadator(val) {
		var mail = document.getElementById("email").value;
		console.log("mail------ > " + mail);
		var emailReg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (!mail.match(emailReg)) {
			document.getElementById("mail_div").innerHTML = "Please Enter Valid Email Id";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("mail_div").innerHTML = "";
			return true;
		}
	}

	function mobileValiadator(val) {
		var mobileRegix = "\\d{10}";
		var mobile = document.getElementById("mobile").value;
		console.log("mobile------ > " + mobile);
		if (isNaN(mobile)) {
			document.getElementById("mobile_div").innerHTML = "Please Valid Mobile Number";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else if (!mobile.match(mobileRegix)) {
			document.getElementById("mobile_div").innerHTML = "Please Enter 10 Digit Mobile Number";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("mobile_div").innerHTML = "";
			return true;
		}
	}

	function zipValiadator(val) {
		var zipRegix = "\\d{6}";
		var zip = document.getElementById("zipcode").value;
		console.log("zipcode------ > " + zip);
		if (isNaN(zip)) {
			document.getElementById("zip_div").innerHTML = "Please Valid Mobile Number";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else if (!zip.match(zipRegix)) {
			document.getElementById("zip_div").innerHTML = "Please Enter 6 Digit Zipcode";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("zip_div").innerHTML = "";
			return true;
		}
	}

	function cityValiadator(val) {
		var reg = ".*\\d.*";
		var regix = "[a-zA-Z]";
		var city = document.getElementById("city").value;
		console.log("city------ > " + city);
		if (!city.match(regix)) {
			document.getElementById("city_div").innerHTML = "Please Enter Valid City Name";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else if (city.match(reg)) {
			document.getElementById("city_div").innerHTML = "Please Enter Valid City Name";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("city_div").innerHTML = "";
			return true;
		}
	}

	function countryValiadator(val) {
		var reg = ".*\\d.*";
		var regix = "[a-zA-Z]";
		var country = document.getElementById("country").value;
		console.log("country------ > " + country);
		if (!country.match(regix)) {
			document.getElementById("country_div").innerHTML = "Please Enter Valid Country Name";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else if (country.match(reg)) {
			document.getElementById("country_div").innerHTML = "Please Enter Valid Country Name";
			document.getElementById("submitButton").disabled = true;
			return false;
		} else {
			document.getElementById("country_div").innerHTML = "";
			return true;
		}
	}
</script>

</head>
<!--/head-->

<body>
	<%@include file="header.jsp"%>
	<center>
		<h3>Update Delivery Address</h3>
		<form id="frm" method="post" class="fm1"
			action="<%=request.getContextPath()%>/updateDeliveryAddress">
			<table>
				<tr>
					<td>Enter First Name</td>
					<td>:</td>
					<td><input id="firstname" type="text" name="firstname"
						placeholder="Enter First Name" required="required"
						onchange="fnameValiadator()" /></td>
					<td><div id="fn_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>Enter Last Name</td>
					<td>:</td>
					<td><input id="lastname" type="text" name="lastname"
						placeholder="Enter Last Name" required="required"
						onchange="lnameValiadator()" /></td>
					<td><div id="ln_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>Enter Email</td>
					<td>:</td>
					<td><input id="email" name="email" type="text"
						placeholder="Enter Email" required="required"
						onchange="emailValiadator()" /></td>
					<td><div id="mail_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>Enter Mobile Number</td>
					<td>:</td>
					<td><input type="text" id="mobile" name="mobilenumber"
						maxlength="10" placeholder="Enter Mobile Number"
						required="required"
						onchange="mobileValiadator()" /></td>
					<td><div id="mobile_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>Enter Street Address</td>
					<td>:</td>
					<td><input id="streetaddress" name="streetaddress" type="text"
						placeholder="Enter Street" required="required" /></td>
					<td><div id="street_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>Enter Landmark</td>
					<td>:</td>
					<td><input id="landmark" name="landmark" type="text"
						placeholder="Enter Landmark" required="required" /></td>
					<td><div id="lmark_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>Enter Zipcode</td>
					<td>:</td>
					<td><input id="zipcode" name="zipcode" type="text"
						placeholder="Enter Zipcode" maxlength="6" required="required"
						onchange="zipValiadator()" /></td>
					<td><div id="zip_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>Enter City</td>
					<td>:</td>
					<td><input id="city" name="city" type="text"
						placeholder="Enter City" required="required"
						onchange="cityValiadator()" /></td>
					<td><div id="city_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>Enter Country</td>
					<td>:</td>
					<td><input id="country" name="country" type="text"
						placeholder="Enter Country Name" required="required"
						onchange="countryValiadator()" /></td>
					<td><div id="country_div" style="color: red"></div></td>
				</tr>
				<tr>
					<td>
					<td></td>
					<td><input value="Update" type="submit"
						class="btn btn-default" /></td>
					<td><input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /></td>

				</tr>
			</table>
		</form>
	</center>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@include file="footer.jsp"%>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.scrollUp.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.prettyPhoto.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</body>
</html>