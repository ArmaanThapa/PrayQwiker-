<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Admin Signup | QwikrPay</title>
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
			return false;
		} else if(fname.match(reg)){
			document.getElementById("fndiv").innerHTML = "Please Enter Valid First Name";
			return false;
		}else {
			document.getElementById("fndiv").innerHTML = "";
			return true;
		}
	}
	function lastnameValidator() {
		var lname = document.getElementById("lname").value;
		console.log("Lname------ > " +lname);
		var reg = ".*\\d.*";
		var regix = "[a-zA-Z]";
		if (!lname.match(regix)) {
			document.getElementById("lndiv").innerHTML = "Please Enter Valid Last Name";
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
		var xhttp = new XMLHttpRequest();

		if (isNaN(mobile)) {
			document.getElementById("mdiv").innerHTML = "Please Valid Mobile Number";
			return false;
		} else if (!mobile.match(mobileRegix)) {
			document.getElementById("mdiv").innerHTML = "Please Enter 10 Digit Mobile Number";
			return false;
		} else if (mobile.match(mobileRegix)) {
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("mdiv").innerHTML = this.responseText;
				}
			};
			xhttp.open("GET", "<%=request.getContextPath()%>/adminMobilenumberValidator?number=" + mobile, true);
			xhttp.send();

		} else {
			document.getElementById("mdiv").innerHTML = "";
			return false;
		}
	}
	function emailValidator() {
		var email = document.getElementById("emailid").value;
		console.log("email---- > " +email);
		var emailReg = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		var xhttp = new XMLHttpRequest();
		if (!email.match(emailReg)) {
			document.getElementById("ediv").innerHTML = "Please Enter Valid Email Id";
			return false;
		} else if (email.match(emailReg)) {
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("ediv").innerHTML = this.responseText;
				}
			};
			xhttp.open("GET", "<%=request.getContextPath()%>/adminEmailValidator?email=" + email, true);
			xhttp.send();
		} else {
			document.getElementById("ediv").innerHTML = "";
			return false;
		}
	}

	function organizationValidator() {
		var orgname = document.getElementById("orgname").value;
		console.log("orgname---- > " +orgname);
		var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("orgdiv").innerHTML = this.responseText;
				}
			};
			xhttp.open("GET", "<%=request.getContextPath()%>/adminOrganizationValidator?orgname=" + orgname, true);
			xhttp.send();
		} 
	
	function passwordValidator() {
		var password = document.getElementById("password").value;
		console.log("Password--------> " + password);
		var passReg = "((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})";

		if (!password.match(passReg)) {
			document.getElementById("pdiv").innerHTML = "Password Should be 6 to 10 Characters";
			return false;
		} else {
			document.getElementById("pdiv").innerHTML = "";
			return false;
		}
	}
	function confirmpasswordValidator() {
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
</script>
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
					<form action="<%=request.getContextPath()%>/adminsignin" method="post">
					<p class="title">Sign Up</p>
						<hr>
						<table><tr><td>
						<input type="text" name="firstname" id="fname"
							onchange="firstnameValidator(this.value)"
							placeholder="Enter First Name" required="required"/></td>
						<td><div id="fndiv" style="color: red">${firstnameError}</div></td></tr>
						<tr><td><input type="text" name="lastname" id="lname"
							onchange="lastnameValidator()" placeholder="Enter Last Name"
							required="required"/></td>
						<td><div id="lndiv" style="color: red">${lastnameError}</div></td></tr>
						<tr><td><input type="text" name="mobilenumber" id="mobilenumber"
							maxlength="10" placeholder="Enter Mobile Number"
							required="required" onchange="mobilenumberValidator()"/></td>
						<td><div id="mdiv" style="color: red">${mobileError}</div></td></tr>
						<tr><td><input type="text" name="email" id="emailid"
							placeholder="Enter Email Address"
							required="required" onchange="emailValidator()"/></td>
						<td><div id="ediv" style="color: red">${emailError}</div></td></tr>
						<!-- <tr><td><input type="text" name="emailid" id="emailid"
							placeholder="Enter Email Address" required="required"
							onchange="emailValidator()"/></td>
						<td><div id="ediv" style="color: red"></div></td></tr> -->
						
						<tr><td><input type="text" name="organization" id="orgname"
							placeholder="Enter Organization Name" required="required"
							onchange="organizationValidator()"/></td>
						<td><div id="orgdiv" style="color: red">${orgError}</div></td></tr>
						
						<tr><td><input type="password" name="password" id="password"
							placeholder="Enter Password" required="required"
							onchange="passwordValidator()" maxlength="10"/></td>
						<td><div id="pdiv" style="color: red">${passwordError}</div></td></tr>
						<tr><td><input type="password" name="confirmpassword" id="confirmpassword"
							placeholder="Enter Confirm Password" required="required"
							onchange="confirmpasswordValidator()" maxlength="10"/></td>
						<td><div id="cpdiv" style="color: red">${confirmpasswordError}</div></td></tr>
						<tr><td><input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <br> <input type="submit"
							class="btn" value="Sign Up" id="submitButton" /></td></tr>
					</table>
					</form>
				</div>
			</div>
			<!--end col-8-->
		</div>
		<!--end row-->
	</div>
	<!---end container----->
</body>
</html>