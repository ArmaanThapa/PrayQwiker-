  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
<%@include file="header.jsp" %>

            <!-- end navigation-->


            <!-- header begin -->
          
            
            <center><div class="container" id="success">
            <div class="row">
                	<div class="col-md-12">
                    	<i class="fa fa-check-circle-o fa-5x"></i>
                      	  <h1>Your Total Transaction Amount: ${amount}</h1>
                          <hr>
                          <h4>Please Click on Submit Button to Pay Through VPayQwik</h4>
						  <form action="http://fgmtest.firstglobalmoney.com:8035/ws/api/auth" method="post">
						  <div style="display: none;"><input type="text" name="amount" value="${amount}">
						  <input type="text" name="transactionID" value="${transactionId}">
						  <input type="number" name="id" value="1988">
						  <input type="text" name="hash" value="${hash}"></div>
						  <input type="submit" class="btn btn-success" value="Submit">
						</form> 
						  
                          
           	   </div><!--end row-->          	
            </div></center>
</body>
</html> 
 
<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="http://fgmtest.firstglobalmoney.com:8035/ws/api/auth" method="post">
  Amount:<br>
  <input type="text" name="amount" value="${amount}">
  <br>
  Order ID:<br>
  <input type="text" name="transactionID" value="${transactionId}">
  <br>
  Merchant Id:<br>
  <input type="number" name="id" value="1988">
  <br>
  Hash:<br>
  <input type="text" name="hash" value="${hash}">
  <input type="submit" value="Submit">
</form> 

	

</body>
</html>  --%>