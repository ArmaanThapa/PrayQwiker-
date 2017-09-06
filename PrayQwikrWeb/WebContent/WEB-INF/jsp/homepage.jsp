<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.List" isELIgnored="false"%>
<html>
<head>
<title>Welcome to PrayQwik</title>
</head>
<body>

<%@include file="header.jsp"%>
 <div class="container">
 
  <div class="headline text-center" style="margin-top: -20px;">
   <div class="row">
    <div class="col-md-12">
	<h2 class="section-title">Making Every Celebration Special For Over A Decade</h2>
	</div>
   </div>
  </div>
	<div class="col-sm-12">
		<ul class="nav navbar-nav">
			<ul>
				<c:forEach items="${categorylist}" var="category">
					<%-- <c:if test="${category.parentCategoryId == 0}"> --%>
					<li><a href="#" onclick="getChildCategory(${category.id})">${category.categoryName}</a>
						<ul>
							<div id="childCategory${category.id}"></div>
						</ul></li>
					<%-- </c:if> --%>
				</c:forEach>
			</ul>
		</ul>

		<div id="productList">
			<c:forEach items="${productlist}" var="pobj">
				<div class="col-sm-4">
					<div class="">
					
						<a href="<%=request.getContextPath() %>/viewdetail/${pobj.productDetailid}">					
							<img src="<%=request.getContextPath() %>/resources/${pobj.productDetailid}.jpg"
							alt="product" width="300" height="50; margin-top: 25px;"
							class="img-responsive" />
						</a>
						
					<!--  	${pobj.fileName}<br>  ///  -->
						${pobj.productName}
					</div>
					<div class="">
						<div class="Price">
							<span class="price-new">Price:</span> <span class="price-new">${pobj.unitPrice}
								/-</span>
						</div>
						<div align="" style="width: 200px; display: inline; float: right;">
							<a
								href="<%=request.getContextPath() %>/addtocart/${pobj.productDetailid}">
								<span class="like">
									<button type="button" class="btn btn-success"
										style="width: 120px; margin-bottom: 10%;">Add to Cart</button>
							</span>
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	</div>
	<%@include file="footer.jsp"%>
	<script type="text/javascript">
	var id;
	function getChildCategory(cid) {
		id=cid;
		url="/childCategory?Id="+id;
		getXmlHttpObjectResponse(url,"Post",null,"TEXT","handlecategoryeInfoResponse");
	}
	
	function handlecategoryeInfoResponse(response){
		console.log("Response - > " + response);
		var parser = new DOMParser();
		var doc = parser.parseFromString(response, "text/xml");
		var categories = doc.getElementById("categorylist");
		var products = doc.getElementById("listofproduct");
		console.log("Child Category :: " + categories);
		console.log("Child Product :: " + products);
		if(categories !=null) {
			document.getElementById("childCategory"+id).innerHTML = response;
		}
		if(products !=null) {
			document.getElementById("productList").innerHTML = response;
		}
	}
	</script>
</body>
</html>