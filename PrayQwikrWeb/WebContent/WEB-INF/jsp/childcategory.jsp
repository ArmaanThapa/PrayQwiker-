<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div  id="categorylist">
<c:forEach items="${childCategorylist}" var="childcategory">
	<ul>
		<li>
		
		<a href="#" onclick=getChildCategory(${childcategory.id})>${childcategory.categoryName}</a>
			<div id="childCategory${childcategory.id}"></div>
		
			</li>
	</ul>
</c:forEach></div>
<!-- 
		if(categories !=null) {
			document.getElementById("childCategory"+id).innerHTML = categories.innerHTML;
		}
		if(products !=null) {
			document.getElementById("productList").innerHTML = response.innerHTML;
		} -->