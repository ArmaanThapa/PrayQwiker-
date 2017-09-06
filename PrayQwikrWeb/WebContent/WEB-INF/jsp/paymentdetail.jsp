<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import="com.qwikr.webapi.domain.Delivery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@page import="com.qwikr.webapi.domain.Delivery"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping Address | PrayQwik</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<%
		Delivery dobj = (Delivery) request.getAttribute("deliveryobj");
		String fname = (String)	session.getAttribute("firstName");
		//out.println(fname);
		String lname = (String)		session.getAttribute("lastName");
		String mail = (String)	session.getAttribute("email");
		String mobile = (String)	session.getAttribute("mobilenumber");
		String street = (String)	session.getAttribute("street");
		String lmark = (String)	session.getAttribute("landmark");
		int zip = Integer.parseInt(""+	session.getAttribute("zipcode"));
		String city = (String)	session.getAttribute("city");
		String country = (String)	session.getAttribute("country");
		long subtotal = Long.parseLong("" + session.getAttribute("subtotal"));
	%>
	<form action="<%=request.getContextPath()%>/placeyourorder">
		<center>
		<h2>Shipping Address</h2>
		<hr>
		
		<h1>
			<b>SubTotal: <%=subtotal%></b>
		</h1>
		<table>
				<tr>
					<td>Customer Name</td>
					<td>:</td>
					<td><%=fname%>&nbsp;&nbsp;<%=lname%>
					</td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td>:<%=dobj.getEmail()%></td>
					<td><%-- <%=mail%> --%>
					</td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td>:</td>
					<td><%=mobile%>
					</td>
				</tr>
				<tr>
					<td>Street</td>
					<td>:</td>
					<td><%=street%>
					</td>
				</tr>
				<tr>
					<td>Landmark</td>
					<td>:</td>
					<td><%=lmark%>
					</td>
				</tr>
				<tr>
					<td>Zipcode</td>
					<td>:</td>
					<td><%=zip%>
					</td>
				</tr>
				<tr>
					<td>City</td>
					<td>:</td>
					<td><%=city%>
					</td>
				</tr>
				<tr>
					<td>Country</td>
					<td>:</td>
					<td><%=country%>
					</td>
				</tr>
		</table>   
		<%-- <table>
				<tr>
					<td>Customer Name</td>
					<td>:</td>
					<td><%=firstname%>&nbsp;&nbsp;<%=lastname%>
					</td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td>:</td>
					<td><%=dobj.getEmail()%>
					</td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td>:</td>
					<td><%=dobj.getMobilenumber()%>
					</td>
				</tr>
				<tr>
					<td>Street</td>
					<td>:</td>
					<td><%=dobj.getStreetaddress()%>
					</td>
				</tr>
				<tr>
					<td>Landmark</td>
					<td>:</td>
					<td><%=dobj.getLandmark()%>
					</td>
				</tr>
				<tr>
					<td>Zipcode</td>
					<td>:</td>
					<td><%=dobj.getZipcode()%>
					</td>
				</tr>
				<tr>
					<td>City</td>
					<td>:</td>
					<td><%=dobj.getCity()%>
					</td>
				</tr>
				<tr>
					<td>Country</td>
					<td>:</td>
					<td><%=dobj.getCountry()%>
					</td>
				</tr>
		</table>   --%>
		<table>
			<tr>
				<td>
				<td></td>
				<td><input type="submit" class="btn btn-success"
					style="margin-bottom: 50px; margin-left: 20px"
					value="Pay by PayQwik"></td>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>

			</tr>
		</table>
		</center>
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>