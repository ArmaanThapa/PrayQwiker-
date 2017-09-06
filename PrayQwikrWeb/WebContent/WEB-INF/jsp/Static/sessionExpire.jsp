<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<link rel="icon" href='<c:url value="/resources/images/favicon.png"/>'
	type="image/png" />
<title>Session Expired | QwikrPay</title>
</head>
<body>
	<div class="logo pull-left">
		<a href="<%=request.getContextPath()%>/"><img
			src="<%=request.getContextPath()%>/resources/images/home/logo.png"
			alt="" width="200px" /></a>
	</div>
	<div class="jumbotron" align="center">
		<h1 class="text text-warning">
			Sorry <span class="glyphicon glyphicon-exclamation-sign"></span>
		</h1>
		<h2></h2>
		<h2></h2>
		<p  class="text text-warning">Your Session Expired, Please Login</p>
	</div>
</body>
</html>