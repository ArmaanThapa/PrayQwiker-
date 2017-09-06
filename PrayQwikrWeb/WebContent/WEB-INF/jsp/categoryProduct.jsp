<%@ page import="java.util.List" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="categorylist">
	<c:forEach items="${childCategorylist}" var="childcategory">
		<ul>
			<li><a href="#" onclick=getChildCategory(${childcategory.id})>${childcategory.categoryName}</a>
				<div id="childCategory${childcategory.id}"></div></li>
		</ul>
	</c:forEach>
</div>

<div id="listofproduct">
	<c:forEach items="${productlist}" var="pobj">

		<div class="col-sm-4">
			<div class="">
				<a
					href="<%=request.getContextPath() %>/viewdetail/${pobj.productDetailid}">
					<img src="<%=request.getContextPath() %>/${pobj.fileName}"
					alt="product" width="300" height="50; margin-top: 25px;"
					class="img-responsive" />
				</a>${pobj.productName}
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
							<button type="button" class="btn btn-success"
								style="width: 120px; margin-bottom: 10%;">Add to Cart</button>
					</span>
					</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>