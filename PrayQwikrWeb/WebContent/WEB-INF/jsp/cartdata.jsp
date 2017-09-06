<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.qwikr.webapi.domain.User"%>
<%@page import="com.qwikr.webapi.domain.Product"%>
<%@page import="com.qwikr.webapi.domain.datatransferbean"%>

<%@page import="java.util.List" isELIgnored="false"%>
<html>
<head>

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
<title>Cart | QwikrPay</title>
</head>
<body>
	<!-- --------------------------------------------- -->
	<%@include file="header.jsp"%>
	<section id="cart_items">
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td class="status">Status</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.cartlist}" var="cobj">
							<tr>
								<td class="cart_product"><a href=""><img
										src="<%=request.getContextPath()%>/resources/images/uploaded-images/${cobj.fileName}"
										alt="product" width="200" height="300" class="img-responsive"></a>
								</td>
								<td class="cart_price">
									<p>${cobj.price}</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<a class="cart_quantity_up" 
											href="<%=request.getContextPath()%>/addItemToCart/${cobj.userId}/${cobj.productId}">
											+ </a> <input class="cart_quantity_input" type="text" style="margin-top: -10px;"
											name="quantity" value="${cobj.quantity}" autocomplete="off"
											size="2"> <a class="cart_quantity_down"
											href="<%=request.getContextPath()%>/remove/${cobj.userId}/${cobj.productId}">
											- </a>
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">${cobj.totalprice}</p>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">${cobj.status}</p>
								</td>
								<td class="cart_delete"><a class="cart_quantity_delete"
									href="<%=request.getContextPath()%>/removeAllItems/${cobj.userId}/${cobj.productId}"><i
										class="fa fa-times"></i></a></td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td class="sub_total"><b>SubTotal</td>
							<td class="sub_total_price"><%=session.getAttribute("subtotal")%></b></td>
						</tr>
					</tbody>
				</table>
				<%
					List<datatransferbean> cartlist = (List<datatransferbean>) request.getAttribute("cartlist");

					if (cartlist != null && cartlist.size() > 0) {
				%>
				<button type="button" class="btn btn-success"
					style="margin-left: 77%; color: black; margin-bottom: 50px;">
					<a href="${pageContext.request.contextPath}/checkout"
						style="color: wheat;">proceed to checkout</a>
				</button>
				<%
					}
				%>
			</div>
		</div>
	</section>
	<!--/#cart_items-->


	<!-- ----------------------------------- -->
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