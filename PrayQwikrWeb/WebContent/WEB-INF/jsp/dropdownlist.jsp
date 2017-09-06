<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List" isELIgnored="false"%>
<c:forEach items="${pcategorylist}" var="pobj">
	<option value="${pobj.id}">${pobj.categoryName}</option>
</c:forEach>