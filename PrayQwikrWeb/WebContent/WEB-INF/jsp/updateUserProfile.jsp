<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Details</title>
</head>
<body>
<%@include file="header.jsp"%>
	<%-- <form method="post" action="<%=request.getContextPath()%>/updateUserProfileProcess"> --%>
	<form:form modelAttribute="updateUser" class="fm1" method="post" action="updateUserProfileProcess">
	<h5>Update Your Name</h5>
	<hr>
		<table>
			<tr>
				<td>First Name</td>
				<td>:</td>
				<td><form:input id="firstname" path="firstname" type="text" required="required"/></td>
						<td><div style="color: red;">${ufirstnameError}</div></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>:</td>
				<td><form:input id="lastname" path="lastname" type="text" required="required"/></td>
						<td><div style="color: red;">${ulastnameError}</div></td>
			</tr>
			<tr><td rowspan="3"><input type="Submit" value="Update" /></td></tr>
		</table>
	</form:form>
</body>
</html>