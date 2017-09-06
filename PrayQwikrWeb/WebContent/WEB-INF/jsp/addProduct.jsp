<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PrayQwik.com</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">
</head>

<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">

				<a class="navbar-brand" href="#">PrayQwik.com</a>
			</div>

			<!-- Collect  -->
			<ul class="nav navbar-nav">
				<li><a href="#">HOME</a></li>
				<li><a href="#">SEARCH PRODUCTS</a></li>
				<li><a href="add">ADD PRODUCTS</a></li>
				
			</ul>
 <ul class="nav navbar-nav navbar-right">
       
        <li><a href="./adminlogout" >SIGN OUT</a></li>        
      </ul>
			
		</div>
		<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>



	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>
</body>
</html>
<!-- 
<form class="form-horizontal" action="addProduct" enctype="multipart/form-data"  method="post">
	<fieldset>

		Form Name
		<legend>Add Products</legend>



		Text input
		<div class="form-group">
			<label class="col-md-4 control-label" for="product_name">Product
				Name</label>
			<div class="col-md-4">
				<input id="product_name" name="productName"
					placeholder="Product Name" class="form-control input-md"
					required="required" type="text">

			</div>
		</div>



		Text input
		<div class="form-group">
			<label class="col-md-4 control-label" for="available_quantity" >Unit
				Price</label>
			<div class="col-md-4">
				<input type="number" id="unitprice" name="unitPrice"
					placeholder=" Product Unit Price" class="form-control input-md"
					required="required">

			</div>
		</div>

		Text input
		<div class="form-group">
			<label class="col-md-4 control-label" for="product_weight" >
				Weight</label>
			<div class="col-md-4">
				<input id="product_weight" name="weight"
					placeholder="Product  Weight" class="form-control input-md"
					required="" type="number" required>

			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="product_description">DESCRIPTION</label>
			<div class="col-md-4">
				<textarea class="form-control" id="product_description"
					name="decription"></textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="product_weight"> </label>
			<div class="col-md-4">
				<div class="form-group">
					<label class="col-md-4 control-label" for="product_weight">
						Egg Less</label>
					<div class="col-md-4">
						<input type="radio" name="caketype" value="yes" checked>Yes<br>
						<input type="radio" name="caketype" value="no" checked>No
						<br>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="panel panel-default">


				Standar Form
				
		<div class="col-md-12">
			 <form action="/imageUpload" enctype="multipart/form-data"  method="POST" name="fileinfo">
         <label> Select images:</label>  
         <input type="file" name="file" multiple>
        
          <button type="submit" class="btn btn-success"> Upload</button>
          </form> 
								</div>	
					
				

				Drop Zone
				
				<div class="upload-drop-zone" id="drop-zone"></div>

				Progress Bar
				<div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="60"
						aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
						<span class="sr-only">60% Complete</span>
					</div>
				</div>

				Upload Finished
				<div class="js-upload-finished"></div>
			</div>
		</div>
		</div>
		/container
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-4">
				<button id="singlebutton" name="singlebutton"
					class="btn btn-primary">submit</button>
			</div>
		
	
	</div>
	
</form> -->

