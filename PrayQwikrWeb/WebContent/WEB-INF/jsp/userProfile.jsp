<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.qwikr.webapi.domain.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="_csrf_parameter" content="_csrf" />
<meta name="_csrf_header" content="X-CSRF-TOKEN" />
<meta name="_csrf" content="e62835df-f1a0-49ea-bce7-bf96f998119c" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>

<body>
<div align="center" style="font-size: medium;background-color: maroon;color: green;">${updateProfileSuccess }</div>
	<%@include file="header.jsp"%>
	<%
		User uobj = (User) session.getAttribute("userobj");
		session.setAttribute("userid", uobj.getUserid());
		long ui = (Long) session.getAttribute("userid");
		//String id = String.valueOf(ui);
		//int uid = Integer.parseInt(id);
		//out.println("User id in Update Profile : " + ui);
	%>
	<h3 style="color: navy;">${updateProfile}</h3>
	<%-- <a href="<spring:url value="<%=request.getContextPath()%>/updateUserProfile"/>">Update Profile Name</a> --%>
	<a href="<%=request.getContextPath()%>/updateUserProfile">Update Profile Name</a>
	<h3>Personal info</h3>

	<table border="1" cellspacing="2" cellpadding="2">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Mobile Number</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.firstname}</td>
				<td>${user.lastname}</td>
				<td>${user.emailid}</td>
				<td>${user.mobilenumber}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br><br><br><br><br><br>
	<br><br><br>
<%@include file="footer.jsp"%>
</body>
</html>