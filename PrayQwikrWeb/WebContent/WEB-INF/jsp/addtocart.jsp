<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="com.qwikr.webapi.domain.Product"%>
<%@page import="com.qwikr.webapi.domain.Cart"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add To Cart</title>

</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<c:forEach items="${cartlist}" var="cart">
			<div class="col-sm-12">
				<h1>${cart.productName}</h1>
				<div class="col-sm-5">

					<a href="#"> <img src="" alt="product" width="200"
						height="100" class="img-responsive" />
					</a>
				</div>

				<b><p>Price :${cart.Price}</p></b> <b><p>Price
						:${cart.Price*cart.quantity}</p></b> <a
					href="{request.getContextPath()}/${cart.productid}">
					<button type="button" class="btn btn-cart">
						Buy <i class="fa fa-shopping-cart"></i>
					</button>
				</a>
			</div>
		</c:forEach>
	</div>
 </body>
</html>