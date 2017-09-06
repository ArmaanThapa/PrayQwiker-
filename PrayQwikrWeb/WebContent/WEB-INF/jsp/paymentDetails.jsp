<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import="com.qwikr.webapi.domain.Delivery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@page import="com.qwikr.webapi.domain.Delivery"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
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
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-57-precomposed.png">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57-precomposed.png">
<title>Shipping Address | PrayQwik</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<%
		Delivery dobj = (Delivery) request.getAttribute("deliveryobj");
		String firstname = (String) session.getAttribute("firstName");
		String lastname = (String) session.getAttribute("lastName");
		long subtotal = Long.parseLong("" + session.getAttribute("subtotal"));
	%>
	<form action="<%=request.getContextPath()%>/placeyourorder">
		<div align="center">
			<h2>Shipping Address</h2>
			<h1>
				<b>SubTotal: <%=subtotal%></b>
			</h1>
			<table>
				<c:forEach items="${address}" var="addres">
					<tr>
						<td>Customer Name</td>
						<td>:</td>
						<td>${addres.firstname}&nbsp;&nbsp;${addres.lastname }</td>
					</tr>
					<tr>
						<td>Email Id</td>
						<td>:</td>
						<td>${addres.email }</td>
					</tr>
					<tr>
						<td>Mobile Number</td>
						<td>:</td>
						<td>${addres.mobilenumber}</td>
					</tr>
					<tr>
						<td>Street</td>
						<td>:</td>
						<td>${addres.streetaddress }</td>
					</tr>
					<tr>
						<td>Landmark</td>
						<td>:</td>
						<td>${addres.landmark}</td>
					</tr>
					<tr>
						<td>Zipcode</td>
						<td>:</td>
						<td>${addres.zipcode}</td>
					</tr>
					<tr>
						<td>City</td>
						<td>:</td>
						<td>${addres.city}</td>
					</tr>
					<tr>
						<td>Country</td>
						<td>:</td>
						<td>${addres.country}</td>
					</tr>
				</c:forEach>
			</table>

			<table>
				<tr>
					<td>
					<td></td>
					<td><input type="submit" class="btn btn-success"
						style="margin-bottom: 50px; margin-left: 20px"
						value="Pay by PayQwik"></td>
					<td><input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /></td>

				</tr>
			</table>
		</div>
	</form>

	<%@include file="footer.jsp"%>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.scrollUp.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/price-range.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.prettyPhoto.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</body>
</html>