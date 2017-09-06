<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set New Password</title>
</head>
<body>
<h3>Set New Password</h3>
<form:form modelAttribute="changePassword" action="<%=request.getContextPath()%>/setNewPassword">
	<table>
		<tr>
			<td>Enter Old Password</td>
			<td>:</td>
			<td><input type="password" name="password"
											placeholder="Enter Password" required="required"></td>
		</tr>
		<tr>
			<td>Enter New Password</td>
			<td>:</td>
			<td><input type="password" name="password"
											placeholder="Enter Password" required="required"></td>
		</tr>
		<tr>
			<td>Confirm New Password</td>
			<td>:</td>
			<td><input type="password" name="confirmpassword"
											placeholder="Enter Confirm Password" required="required"></td>
		</tr>
		<tr>
			<td colspan="3"><input type="Submit" value="Submit" /></td>
		</tr>
	</table>
	</form:form>
</body>
</html>