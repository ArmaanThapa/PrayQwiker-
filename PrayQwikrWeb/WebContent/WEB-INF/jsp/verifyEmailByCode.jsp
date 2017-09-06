<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="_csrf_parameter" content="_csrf" />
<meta name="_csrf_header" content="X-CSRF-TOKEN" />
<meta name="_csrf" content="e62835df-f1a0-49ea-bce7-bf96f998119c" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verify Account | PrayQwikr</title>
</head>
<body>
<h3 style="color: navy;font-style: oblique;">You not yet Verified Your Email Id,Please Verify</h3>
<h3 style="color: green;font-style: oblique;">${verifycode }</h3>
<form action="<%=request.getContextPath()%>/verifyEmailByCode">

	<table>
		<tr>
			<td>Enter Your Verification Code</td>
			<td>:</td>
			<td><input id="verificationcode" type="text" name="verificationcode"
									placeholder="Verification Code" required="required"/></td>
									      <td>${codeError }</td>
									       <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
		</tr>
		<tr>
			<td colspan="3"><input type="Submit" value="Verify" /></td>
		</tr>
	</table>
	</form>
	<a href="/index2">Home Page</a>
</body>
</html>