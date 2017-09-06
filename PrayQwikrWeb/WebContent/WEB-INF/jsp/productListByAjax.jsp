<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="java.util.List" isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:forEach items="${productlist}" var="pobj">

<div class="col-sm-4">
			<div class="">

				 <a
					href="<%=request.getContextPath() %>/viewdetail/${pobj.productDetailid}"> <img
					src="<%=request.getContextPath() %>/${pobj.fileName}" alt="product" width="300" height="50; margin-top: 25px;"
					class="img-responsive" />
				
				</a>${pobj.productName}<%-- <a
						href="<%=request.getContextPath() %>/viewdetail/${pobj.productDetailid}" class="view">View
							Details</a> --%>
			</div>
			<div class="">
				<div class="Price">
					<span class="price-new">Price:</span> <span class="price-new">${pobj.unitPrice}
						/-</span>
				</div>



				<div align="" style="width: 100px; display: inline; float: right;">

					<a
						href="<%=request.getContextPath() %>/addtocart/${pobj.productDetailid}">
						<span class="like">
                                                        <button type="button" class="btn btn-success" style="width: 120px; margin-bottom: 10%;
                                                        ">Add to Cart</button>
                                                    </span>
					</a>
				</div>


			</div></div>
		</c:forEach></div>
</body>
</html>