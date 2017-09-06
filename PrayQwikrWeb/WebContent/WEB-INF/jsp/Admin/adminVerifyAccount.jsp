<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Verify Account | QwikrPay</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<%-- <link rel="stylesheet"
         href="<%=request.getContextPath()%>/resources/css/style.css"> --%>
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
function verificationcodeValidator() {
	var vcode = document.getElementById("verificationcode").value;
	//alert("code is  -- >  "  +vcode)
	console.log("vcode ---> " + vcode);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("in if ready state condition");
			document.getElementById("verify_div").innerHTML = this.responseText;
			return false;
		}
	};
	xhttp.open("GET", "<%=request.getContextPath()%>/adminVerificationCodeValidator?code=" + vcode, true);
	xhttp.send();
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
				<h5 align="center" style="color: green;">
						<b>${regSuccess}</b>
				</h5>
					<form action="<%=request.getContextPath()%>/adminVerifyAccount"
						method="post">
						<p class="title">Verify Your Account</p>
						<hr>
						<table>
					<tr><td><input type="text" name="verificationcode" id="verificationcode"
							placeholder="Enter Verification Code"
							required="required" onchange="verificationcodeValidator()"/></td>
						<td><div id="mdiv" style="color: red">${vcodeError}</div></td></tr>
							<%-- <tr>
								<td><input type="text" name="verificationcode" id="verificationcode"
									placeholder="Enter Verification Code" required="required"
									onchange="verificationcodeValidator()"/></td>
								<td><div id="verify_div" style="color: red">${vcodeError}</div></td>
							</tr>
 --%>							<tr>
								<td><input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}"/> <br> <input type="submit"
									class="btn" value="Verify" id="submitButton"/></td>
							</tr>
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


