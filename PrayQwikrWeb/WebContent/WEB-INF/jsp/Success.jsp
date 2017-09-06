<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html class="no-js">







    <head>
    
    
    

        <title>Shipping address</title>

        <!-- meta -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        
        <!-- stylesheets -->
         <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/style.css"> 
<style>
#success{
	margin-top: 50px;
}
	#success .fa{
		color: red;
		margin-bottom: 20px;
	}
	#success hr{
		width: 50%;
	}
</style>

<%-- <c:redirect url="/home.jsp"/> --%>
    </head>

    <body>


            <!-- site-navigation start -->  
           <!--  <nav id="mainNavigation" class="navbar navbar-dafault main-navigation" role="navigation">
                <div class="container">
                      <div class="navbar-header col-md-4 col-xs-8">
                          <a class="navbar-brand" href="#"><img src="img/QWIKRPAY.png" alt="logo"></a>
                      </div>                 
                       <ul class="nav navbar-nav navbar-right" style="float:left;">
                          <li><a href="#">Login</a></li>
                          <li><a href="#">Signup</a></li>

                      </ul>
                 </div>
            </nav> -->
            <!-- end navigation-->


            <!-- header begin -->
            <div class="jumbotron">
            </div><!--end jumbotron-->
            
            <div class="container" id="success">
            	<div class="row">
                	<div class="col-md-12">
                    	<i class="fa fa-check-circle-o fa-5x"></i>
                      	  <h1>Thank you!</h1>
                          <hr>
                          <h4>Your Transaction is Successful!</h4>
                         <!-- <h4>Order ID :  </h4>
                          <h4>Transaction ID : </h4>   -->             
				   </div>
                </div><!--end row-->          	
            </div>
           
            
          
</form>

<!-- <form id="main" method="post" name="main" action="" onsubmit="redirect(this);">
    <input type="submit" name="submit"/> 
</form> -->





     

        

    </body>
</html>