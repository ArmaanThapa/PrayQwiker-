















<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>PrayQwik.com</title>
       <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <link rel="stylesheet" type="text/css"
         href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
      <link rel="stylesheet"
         href="<%=request.getContextPath()%>/resources/css/bootstrap-combobox.css">
      <script
         src="<%=request.getContextPath()%>/resources/comboboxJs/bootstrap-combobox.js"></script>
      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
         integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
         crossorigin="anonymous">
      <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
         integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
         crossorigin="anonymous">
          <script>
  $( function() {
    var availableTags = [
      "ELECTRONICS",
      "APPLIANCES",
      "MEN",
      "WOMEN",
      "BABY AND KIDS",
      "BOOKS",
      "HOME AND FURNITURE",
      "FITTNESS",
      "PERSONALISATION",
    ];
    $( "#product_name" ).autocomplete({
      source: availableTags
    });
  } );
  </script>
 <script type="text/javascript">
 var status=""
         
      <script type="text/javascript">
         var status = "subcategory"
         $(document).on(
         		'change',
         		'#categoryId',
         		function() {
         			var cat_id = $(this).val();
         			$.ajax({
         				type : 'POST',
         				url : "/getSubCategoryList?subCategoryId=" + cat_id
         						+ "&ajax=" + status,
         				success : function(data) {
         					$('#subcategoryId').html(data);
         				}
         			});
         		});
      </script>
      <script type="text/javascript">
         $(document).on('change', '#subcategoryId', function() {
         	var brandId = $(this).val();
         	$.ajax({
         		type : 'POST',
         		url : "/getSubCategoryList?brandId=" + brandId,
         		success : function(data) {
         			$('#brandId').html(data);
         		}
         	});
         });
      </script>
      <script type="text/javascript">
      function doAjaxCall(){
    	  //var category = $('#categoryName').val();
    	  alert(category);
    	  $.ajax({
    		 // alert("lllllllll");
    	  
     		  type:'GET',
    		  url:"/getSubcategoriesrelatedtospecificcategory?category="+category,
     		  success:function(data){
     			  alert(data);
     			  $('#op1').html(data);
     			  $('#subcategoryNamee').val();
     		  }
     	  });
      }
      </script>
   </head>
   <body>
      <ul class="nav nav-tabs navbar-default"
         style="height: 65px; background: white;">
         <div class="container-fluid">
            <div class="navbar-header">
               <a class="navbar-brand" href="#"><img alt=""
                  src="<%=request.getContextPath()%>/resources/img/QWIKRPAY.png""></a>
            </div>
          
            <ul class="nav navbar-nav navbar-right"
               style="margin-right: 20px; margin-top: 9px;">
               <li><a href="./adminlogout">LOG OUT</a></li>
            </ul>
         </div>
         <!-- -----------------------------------Panel Starts*----------------------------------------------------------- -->
      </ul>
      <div class="box" style="height: 5px; width: 100%; background: #f1592a;"></div>
      <ul class="nav nav-tabs" style="background: white;">
         <li class="active"><a data-toggle="tab" href="#orderlist">
            Order List <span class="badge">${orderedlist}</span>
            </a>
         </li>
         <li><a data-toggle="tab" href="#userlist">User List <span
            class="badge">${userlist}</span></a></li>
         <li><a data-toggle="tab" href="#addproduct">ADD PRODUCT <span
            class="badge"></span></a></li>
         <li><a data-toggle="tab" href="#addcategory">ADD PRODUCT
            CATEGORY<span class="badge">${productCategorylist}</span>
            </a>
         </li>
          <li><a data-toggle="tab" href="#addsubcategory">ADD PRODUCT
            SUB-CATEGORY<span class="badge">${productCategorylist}</span>
            </a>
         </li>
         <li><a data-toggle="tab" href="#totalproduct">TOTAL PRODUCT <span
            class="badge">${productlist}</span>
            </a>
             <li><a data-toggle="tab" href="#addbrand">ADD PRODUCT
            BRAND<span class="badge">${productCategorylist}</span>
            </a>
         </li>
         </li>
         <li><a data-toggle="tab" href="#activeuser">ACTIVE USER <span
            class="badge">${activeuserlist}</span></a></li>
         <li><a data-toggle="tab" href="#sessionlog">SESSION LOG <span
            class="badge">${sessionloglist}</span></a></li>
      </ul>
      <!-- -----------------------------------------Panel Ends-------------------------------------------- -->
      <div class="tab-content">
         <!-- order detail-->
         <div id="orderlist" class="tab-pane fade in active">
            <legend>
               <h2>Order List</h2>
            </legend>
            <table id="olist">
               <thead>
                  <tr>
                     <th>S.NO</th>
                     <th>Order ID</th>
                     <th>Transaction ID</th>
                     <th>User Name</th>
                     <th>Email ID</th>
                     <th>Mobile Number</th>
                     <th>Total Payment</th>
                     <th>Transaction Status</th>
                  </tr>
               </thead>
               <tbody>
                 
                     <c:forEach items="${orderedlist}" var="oobj">
                  <tr>
                     <td>${oobj}</td>
                     <td>${oobj}</td>
                     <td>${oobj}</td>
                     <td>${oobj}</td>
                     <td>${oobj}</td>
                     <td>${oobj}</td>
                     <td>${oobj}</td>
                     <td>${oobj}</td>
                  </tr>
                </c:forEach>
               </tbody>
            </table>
         </div>
         <!--order detail close  -->
         <div id="userlist" class="tab-pane fade">
            <legend>
               <h2>User List</h2>
            </legend>
            <table id="ulist">
               <thead>
                  <tr>
                     <th>First Name</th>
                     <th>Last Name</th>
                     <th>Email</th>
                     <th>Mobile Number</th>
                  </tr>
               </thead>
               <tbody>
                 <c:forEach items="${userlist}" var="uobj">
                  <tr>
                     <input type="hidden" name="userId" value="${uobj}"/>
                     <td>${uobj}</td>
                     <td>${uobj}</td>
                     <td>${uobj}</td>
                     <td>${uobj}</td>
                  </tr>
                     </c:forEach>
               </tbody>
            </table>
         </div>
         <!---------------------------------------- for add product  -------------------------------------->
         <div id="addproduct" class="tab-pane fade">
            <form class="form-horizontal" action="addProduct"
               enctype="multipart/form-data" method="post">
               <legend>
                  <h2>Add Products</h2>
               </legend>
             
               <div class="form-group">
                  <label class="col-md-4 control-label" for="categoryName">Select Category </label>
                  <div class="col-md-4">
                     <select name="categoryId" id="categoryId">
                      <option value="0">-----------select value-------</option>
                     <c:forEach items="${allcategorylist}" var="pobj">
                        <option value="${pobj}">${pobj}</option>
                      </c:forEach>
                     </select>
                  </div>
               </div>
               
              
               <div class="form-group">
                  <label class="col-md-4 control-label" for="subcategoryName">Select SubCategory </label>
                  <div class="col-md-4">
                     <select name="categoryId" id="categoryId">
                      <option value="0">-----------select value-------</option>
                     <c:forEach items="${allsubcategory}" var="qobj">
                        <option value="${qobj}">${qobj}</option>
                      </c:forEach>
                     </select>
                  </div>
               </div>
 
               <div class="form-group">
                  <label class="col-md-4 control-label" for="brandName">Select
                  brand</label>
                  <div class="col-md-4">
                     <select name="brandid" id="brandId">
                        <option value=0>-----------select value-------</option>
                        <c:forEach items="${allbrands}" var="bobj">
                        <option value="${bobj}">${bobj}</option>
                        </c:forEach>
                     </select>
                  </div>
               </div>
               <div class="form-group">
                  <label class="col-md-4 control-label" for="product_name">Product Name</label>
                  <div class="col-md-4">
                     <input id="product_name" name="productName"
                        placeholder="Product Name" class="form-control input-md"
                        required="required" type="text">
                  </div>
               </div>
               <!-- Text input-->
               <div class="form-group">
                  <label class="col-md-4 control-label" for="available_quantity">Unit
                  Price</label>
                  <div class="col-md-4">
                     <input type="number" id="unitprice" name="unitPrice"
                        placeholder=" Product Unit Price" class="form-control input-md"
                        required="required">
                  </div>
               </div>
               
               <!-- Text input-->
               <div class="form-group">
                  <label class="col-md-4 control-label" for="product_weight">
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
 
               <div class="container">
                  <div class="panel panel-default">
                      <div class="col-md-12">
                     <label> Select images:</label> <input type="file" name="file"
                        multiple>
                  </div>
               </div>
               </div>
               <h5 style="color: red;">${imageError}</h5>
               <div class="form-group">
                  <label class="col-md-4 control-label" for="singlebutton"></label>
                  <div class="col-md-4">
                     <button id="singlebutton" name="singlebutton" class="btn btn-primary">submit</button>
                  </div>
               </div>
               
            </form>
         </div>
         <!-- --------------------------------------------End Add Product------------------------------------- -->
         <!-- Add category=============  -->
         <div id="addcategory" class="tab-pane fade">
            <form class="form-horizontal" action="addcategory"
               enctype="multipart/form-data" method="post">
               <legend>
                  <h2>Add Category</h2>
               </legend>
               <!-- for attribute shud b same as id not name -->
               <div class="form-group">
                  <label class="col-md-4 control-label" for="product_name">Category Name</label>
                  <div class="col-md-4">
                     <input id="product_name" name="categoryName"
                        placeholder="Category Name" class="form-control input-md"
                        required="required" type="text">
                  </div>
               </div>
               <section> <input type="submit" value="submit"></section>
            </form>
         </div>
         <!-- add category closed -->
         <!-- add subcategory -->
          <div id="addsubcategory" class="tab-pane fade">
            <form class="form-horizontal" action="addsubcategory"
               enctype="multipart/form-data" method="post">
               <legend>
                  <h2>Add sub Category</h2>
               </legend>
               <!-- for attribute shud b same as id not name -->
               <div class="form-group">
                   <label class="col-md-4 control-label" for="categoryName">Select Category </label>
                  <div class="col-md-4">
                     <select name="category" id="categoryId">
                      <option value="0">-----------select value-------</option>
                     <c:forEach items="${allcategorylist}" var="pobj">
                       
                        <option value="${pobj}">${pobj}</option>
                      </c:forEach>
                     </select>
                  </div>
               </div>
               <div class="form-group">
                  <label class="col-md-4 control-label" for="subcategoryName">Select SubCategory </label>
                  <div class="col-md-4">
                   <input id="subcategoryName" name="subcategory"
                        placeholder="sub Category Name" class="form-control input-md"
                        required="required" type="text">
                                     </div>
               </div>
                  <section> <input type="submit" value="submit"></section>
            </form>
         </div>
         <!-- subcategory ends -->
         <!------------------------------- add product brand ----------------->
        <div id="addbrand" class="tab-pane fade">
            <form class="form-horizontal" action="addbrand"
               enctype="multipart/form-data" method="post">
               <legend>
                  <h2>Add brand</h2>
               </legend>
               <!-- for attribute shud b same as id not name -->
               <div class="form-group">
                   <label class="col-md-4 control-label" for="categoryName">Select Category </label>
                  <div class="col-md-4">
                     <select name="category" id="categoryName" onchange="doAjaxCall()">
                      <option>-----------select value-------</option>
                     <c:forEach items="${allcategorylist}" var="pobj">
                        <option value="${poj}" >${pobj}</option>
                      </c:forEach>
                     </select>
                  </div>
               </div>
               
               <div class="form-group">
                  <label class="col-md-4 control-label" for="subcategoryName">Select SubCategory </label>
                  <div class="col-md-4">
                   <select name="subcategory" id="subcategoryName">
                   <option>-----------select value-------</option>
                   <c:forEach items="${subcategories}" var="cobj">
                        <option value="${cobj}">${cobj}</option>
                      </c:forEach>
                     </select>
                                     </div>
               </div>
                
                <div class="form-group">
                  <label class="col-md-4 control-label" for="brandName">Select brand Name </label>
                  <div class="col-md-4">
                   <input id="subcategoryName" name="brandName"
                        placeholder="brand Name" class="form-control input-md"
                        required="required" type="text">
                                     </div>
               </div>
                  <section> <input type="submit" value="submit"></section>
            </form>
         </div>
         <!-- brand ends.. -->
         <div id="totalproduct" class="tab-pane fade">
            <legend>
               <h2>Product List</h2>
            </legend>
            <table id="plist">
               <thead>
                  <tr>
                     <th>Product Name</th>
                     <th>Price</th>
                     <th>Weight</th>
                     <th>Description</th>
                  </tr>
               </thead>
               <tbody>
               <c:forEach items="${productlist}" var="pobj">
                 
                  <tr>
                     <td>${pobj}</td>
                     <td>${pobj}</td>
                     <td>${pobj}</td>
                     <td>${pobj}</td>
                  </tr>
                 </c:forEach>
               </tbody>
            </table>
         </div>
         <div id="activeuser" class="tab-pane fade">
            <legend>
               <h2>Active User List</h2>
            </legend>
            <table id="alist">
               <thead>
                  <tr>
                     <th>UserId</th>
                     <th>Mobile Number</th>
                     <th>sessionId</th>
                     <th>Status</th>
                  </tr>
               </thead>
               <tbody>
               <c:forEach items="${activeuserlist}" var="lobj">
                  <tr>
                     <td>${lobj}</td>
                     <td>${lobj}</td>
                     <td>${lobj}</td>
                     <td>${lobj}</td>
                  </tr>
                 </c:forEach>
               </tbody>
            </table>
         </div>
         <div id="sessionlog" class="tab-pane fade">
            <legend>
               <h2>Session Log</h2>
            </legend>
            <table id="slist">
               <thead>
                  <tr>
                     <th>UserId</th>
                     <th>Mobile Number</th>
                     <th>sessionId</th>
                     <th>Status</th>
                  </tr>
               </thead>
               <tbody>
               <c:forEach items="${sessionloglist}" var="sobj">
                  <tr>
                     <td>${sobj}</td>
                     <td>${sobj}</td>
                     <td>${sobj}</td>
                     <td>${sobj}</td>
                  </tr>
                 </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
      <script type="text/javascript" charset="utf8"
         src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
      <script type="text/javascript" charset="utf8"
         src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
      <script type="text/javascript">
         $(function() {
         	$("#olist").dataTable();
         })
      </script>
      <script type="text/javascript">
         $(function() {
         	$("#ulist").dataTable();
         })
      </script>
      <script type="text/javascript">
         $(function() {
         	$("#plist").dataTable();
         })
      </script>
      <script type="text/javascript">
         $(function() {
         	$("#alist").dataTable();
         })
      </script>
      <script type="text/javascript">
         $(function() {
         	$("#slist").dataTable();
         })
      </script>
   </body>
</html>
 --%>














<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Admin | Qwikrpay</title>
       <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <link rel="stylesheet" type="text/css"
         href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
      <link rel="stylesheet"
         href="<%=request.getContextPath()%>/resources/css/bootstrap-combobox.css">
      <script
         src="<%=request.getContextPath()%>/resources/comboboxJs/bootstrap-combobox.js"></script>
      <!-- Latest compiled and minified CSS -->
      <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
         integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
         crossorigin="anonymous">
      <link rel="stylesheet"
         href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
         integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
         crossorigin="anonymous">
          <script>
  $( function() {
    var availableTags = [
      "ELECTRONICS",
      "APPLIANCES",
      "MEN",
      "WOMEN",
      "BABY AND KIDS",
      "BOOKS",
      "HOME AND FURNITURE",
      "FITTNESS",
      "PERSONALISATION",
    ];
    $( "#product_name" ).autocomplete({
      source: availableTags
    });
  } );
  </script>
 <script type="text/javascript">
 var status=""
         
      <script type="text/javascript">
         var status = "subcategory"
         $(document).on(
         		'change',
         		'#categoryId',
         		function() {
         			var cat_id = $(this).val();
         			$.ajax({
         				type : 'POST',
         				url : "/getSubCategoryList?subCategoryId=" + cat_id
         						+ "&ajax=" + status,
         				success : function(data) {
         					$('#subcategoryId').html(data);
         				}
         			});
         		});
      </script>
      <script type="text/javascript">
         $(document).on('change', '#subcategoryId', function() {
         	var brandId = $(this).val();
         	$.ajax({
         		type : 'POST',
         		url : "/getSubCategoryList?brandId=" + brandId,
         		success : function(data) {
         			$('#brandId').html(data);
         		}
         	});
         });
      </script>
      <script type="text/javascript">
      function doAjaxCall(){
    	  //var category = $('#categoryName').val();
    	  alert(category);
    	  $.ajax({
    		 alert("lllllllll");
    	  
     		  type:'GET',
    		  url:"/getSubcategoriesrelatedtospecificcategory?category="+category,
     		  success:function(data){
     			  alert(data);
     			  $('#op1').html(data);
     			  $('#subcategoryNamee').val();
     		  }
     	  });
      }
      </script>
   </head>
   <body>
      <ul class="nav nav-tabs navbar-default"
         style="height: 65px; background: white;">
         <div class="container-fluid">
            <div class="navbar-header">
               <a class="navbar-brand" href="#"><img alt=""
                  src="<%=request.getContextPath()%>/resources/img/QWIKRPAY.png"" width="200px"></a>
            </div>
          
            <ul class="nav navbar-nav navbar-right"
               style="margin-right: 20px; margin-top: 9px;">
               <li><a href="./adminlogout">LOG OUT</a></li>
            </ul>
         </div>
         <!-- -----------------------------------Panel Starts*----------------------------------------------------------- -->
      </ul>
      <div class="box" style="height: 5px; width: 100%; background: #f1592a;"></div>
      <ul class="nav nav-tabs" style="background: white;">
         <li class="active"><a data-toggle="tab" href="#orderlist">
            Order List <span class="badge">${orderedlist.size()}</span>
            </a>
         </li>
         <li><a data-toggle="tab" href="#userlist">User List <span
            class="badge">${userlist.size()}</span></a></li>
         <li><a data-toggle="tab" href="#addproduct">ADD PRODUCT <span
            class="badge"></span></a></li>
         <li><a data-toggle="tab" href="#addcategory">ADD PRODUCT
            CATEGORY<span class="badge">${productCategorylist.size()}</span>
            </a>
         </li>
          <li><a data-toggle="tab" href="#addsubcategory">ADD PRODUCT
            SUB-CATEGORY<span class="badge">${productCategorylist.size()}</span>
            </a>
         </li>
         <li><a data-toggle="tab" href="#totalproduct">TOTAL PRODUCT <span
            class="badge">${productlist.size()}</span>
            </a>
             <li><a data-toggle="tab" href="#addbrand">ADD PRODUCT
            BRAND<span class="badge">${productCategorylist.size()}</span>
            </a>
         </li>
         </li>
         <li><a data-toggle="tab" href="#activeuser">ACTIVE USER <span
            class="badge">${activeuserlist.size()}</span></a></li>
         <li><a data-toggle="tab" href="#sessionlog">SESSION LOG <span
            class="badge">${sessionloglist.size()}</span></a></li>
      </ul>
      <!-- -----------------------------------------Panel Ends-------------------------------------------- -->
      <div class="tab-content">
         <!-- order detail-->
         <div id="orderlist" class="tab-pane fade in active">
            <legend>
               <h2>Order List</h2>
            </legend>
            <table id="olist">
               <thead>
                  <tr>
                     <th>S.NO</th>
                     <th>Order ID</th>
                     <th>Transaction ID</th>
                     <th>User Name</th>
                     <th>Email ID</th>
                     <th>Mobile Number</th>
                     <th>Total Payment</th>
                     <th>Transaction Status</th>
                  </tr>
               </thead>
               <tbody>
                 
                     <c:forEach items="${orderedlist}" var="oobj">
                  <tr>
                     <td>${oobj.getO_id()}</td>
                     <td>${oobj.getOrderId()}</td>
                     <td>${oobj.getTransactionId()}</td>
                     <td>${oobj.getUserName()}</td>
                     <td>${oobj.getEmailId()}</td>
                     <td>${oobj.getMobileno()}</td>
                     <td>${oobj.getTotalpayment()}</td>
                     <td>${oobj.getTransactionStatus()}</td>
                  </tr>
                </c:forEach>
               </tbody>
            </table>
         </div>
         <!--order detail close  -->
         <div id="userlist" class="tab-pane fade">
            <legend>
               <h2>User List</h2>
            </legend>
            <table id="ulist">
               <thead>
                  <tr>
                     <th>First Name</th>
                     <th>Last Name</th>
                     <th>Email</th>
                     <th>Mobile Number</th>
                  </tr>
               </thead>
               <tbody>
                 <c:forEach items="${userlist}" var="uobj">
                  <tr>
                     <input type="hidden" name="userId" value="${uobj.getUserid()}"/>
                     <td>${uobj.getFirstname()}</td>
                     <td>${uobj.getLastname()}</td>
                     <td>${uobj.getEmailid()}</td>
                     <td>${uobj.getMobilenumber()}</td>
                  </tr>
                     </c:forEach>
               </tbody>
            </table>
         </div>
         <!---------------------------------------- for add product  -------------------------------------->
         <div id="addproduct" class="tab-pane fade">
            <form class="form-horizontal" action="addProduct"
               enctype="multipart/form-data" method="post">
               <legend>
                  <h2>Add Products</h2>
               </legend>
             
               <div class="form-group">
                  <label class="col-md-4 control-label" for="categoryName">Select Category </label>
                  <div class="col-md-4">
                     <select name="categoryId" id="categoryId">
                      <option value="0">-----------select value-------</option>
                     <c:forEach items="${allcategorylist}" var="pobj">
                        <option value="${pobj.getId()}">${pobj.getCategoryName()}</option>
                      </c:forEach>
                     </select>
                  </div>
               </div>
               
              
               <div class="form-group">
                  <label class="col-md-4 control-label" for="subcategoryName">Select SubCategory </label>
                  <div class="col-md-4">
                     <select name="categoryId" id="categoryId">
                      <option value="0">-----------select value-------</option>
                     <c:forEach items="${allsubcategory}" var="qobj">
                        <option value="${qobj.getSubcategoryId()}">${qobj.getSubcategory()}</option>
                      </c:forEach>
                     </select>
                  </div>
               </div>
 
               <div class="form-group">
                  <label class="col-md-4 control-label" for="brandName">Select
                  brand</label>
                  <div class="col-md-4">
                     <select name="brandid" id="brandId">
                        <option value=0>-----------select value-------</option>
                        <c:forEach items="${allbrands}" var="bobj">
                        <option value="${bobj.getBrandId()}">${bobj.getBrandName()}</option>
                        </c:forEach>
                     </select>
                  </div>
               </div>
               <div class="form-group">
                  <label class="col-md-4 control-label" for="product_name">Product Name</label>
                  <div class="col-md-4">
                     <input id="product_name" name="productName"
                        placeholder="Product Name" class="form-control input-md"
                        required="required" type="text">
                  </div>
               </div>
               <!-- Text input-->
               <div class="form-group">
                  <label class="col-md-4 control-label" for="available_quantity">Unit
                  Price</label>
                  <div class="col-md-4">
                     <input type="number" id="unitprice" name="unitPrice"
                        placeholder=" Product Unit Price" class="form-control input-md"
                        required="required">
                  </div>
               </div>
               
               <!-- Text input-->
               <div class="form-group">
                  <label class="col-md-4 control-label" for="product_weight">
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
 
               <div class="container">
                  <div class="panel panel-default">
                      <div class="col-md-12">
                     <label> Select images:</label> <input type="file" name="file"
                        multiple>
                  </div>
               </div>
               </div>
               <h5 style="color: red;">${imageError}</h5>
               <div class="form-group">
                  <label class="col-md-4 control-label" for="singlebutton"></label>
                  <div class="col-md-4">
                     <button id="singlebutton" name="singlebutton" class="btn btn-primary">submit</button>
                  </div>
               </div>
               
            </form>
         </div>
         <!-- --------------------------------------------End Add Product------------------------------------- -->
         <!-- Add category=============  --><!-- enctype="multipart/form-data"  -->
         <div id="addcategory" class="tab-pane fade">
            <form class="form-horizontal" action="<%=request.getContextPath()%>/addcategory" method="post">
               <legend>
                  <h2>Add Category</h2>
               </legend>
               <!-- for attribute shud b same as id not name -->
               <div class="form-group">
                  <label class="col-md-4 control-label" for="product_name">Category Name</label>
                  <div class="col-md-4">
                     <input id="product_name" name="categoryName"
                        placeholder="Category Name" class="form-control input-md"
                        required="required" type="text">
                  </div>
               </div>
               <section> <input type="submit" value="submit"></section>
            </form>
         </div>
         <!-- add category closed -->
         <!-- add subcategory -->
          <div id="addsubcategory" class="tab-pane fade">
            <form class="form-horizontal" action="addsubcategory"
               enctype="multipart/form-data" method="post">
               <legend>
                  <h2>Add sub Category</h2>
               </legend>
               <!-- for attribute shud b same as id not name -->
               <div class="form-group">
                   <label class="col-md-4 control-label" for="categoryName">Select Category </label>
                  <div class="col-md-4">
                     <select name="category" id="categoryId">
                      <option value="0">-----------select value-------</option>
                     <c:forEach items="${allcategorylist}" var="pobj">
                       
                        <option value="${pobj.getCategoryName()}">${pobj.getCategoryName()}</option>
                      </c:forEach>
                     </select>
                  </div>
               </div>
               <div class="form-group">
                  <label class="col-md-4 control-label" for="subcategoryName">Select SubCategory </label>
                  <div class="col-md-4">
                   <input id="subcategoryName" name="subcategory"
                        placeholder="sub Category Name" class="form-control input-md"
                        required="required" type="text">
                                     </div>
               </div>
                  <section> <input type="submit" value="submit"></section>
            </form>
         </div>
         <!-- subcategory ends -->
         <!------------------------------- add product brand ----------------->
        <div id="addbrand" class="tab-pane fade">
            <form class="form-horizontal" action="addbrand"
               enctype="multipart/form-data" method="post">
               <legend>
                  <h2>Add brand</h2>
               </legend>
               <!-- for attribute shud b same as id not name -->
               <div class="form-group">
                   <label class="col-md-4 control-label" for="categoryName">Select Category </label>
                  <div class="col-md-4">
                     <select name="category" id="categoryName" onchange="doAjaxCall()">
                      <option>-----------select value-------</option>
                     <c:forEach items="${allcategorylist}" var="pobj">
                        <option value="${pobj.getCategoryName()}" >${pobj.getCategoryName()}</option>
                      </c:forEach>
                     </select>
                  </div>
               </div>
               
               <div class="form-group">
                  <label class="col-md-4 control-label" for="subcategoryName">Select SubCategory </label>
                  <div class="col-md-4">
                   <select name="subcategory" id="subcategoryName">
                   <option>-----------select value-------</option>
                   <c:forEach items="${subcategories}" var="cobj">
                        <option value="${cobj.getSubcategory()}">${cobj.getSubcategory()}</option>
                      </c:forEach>
                     </select>
                                     </div>
               </div>
                
                <div class="form-group">
                  <label class="col-md-4 control-label" for="brandName">Select brand Name </label>
                  <div class="col-md-4">
                   <input id="subcategoryName" name="brandName"
                        placeholder="brand Name" class="form-control input-md"
                        required="required" type="text">
                                     </div>
               </div>
                  <section> <input type="submit" value="submit"></section>
            </form>
         </div>
         <!-- brand ends.. -->
         <div id="totalproduct" class="tab-pane fade">
            <legend>
               <h2>Product List</h2>
            </legend>
            <table id="plist">
               <thead>
                  <tr>
                     <th>Product Name</th>
                     <th>Price</th>
                     <th>Weight</th>
                     <th>Description</th>
                  </tr>
               </thead>
               <tbody>
               <c:forEach items="${productlist}" var="pobj">
                 
                  <tr>
                     <td>${pobj.getProductName()}</td>
                     <td>${pobj.getUnitPrice()}</td>
                     <td>${pobj.getWeight()}</td>
                     <td>${pobj.getDecription()}</td>
                  </tr>
                 </c:forEach>
               </tbody>
            </table>
         </div>
         <div id="activeuser" class="tab-pane fade">
            <legend>
               <h2>Active User List</h2>
            </legend>
            <table id="alist">
               <thead>
                  <tr>
                     <th>UserId</th>
                     <th>Mobile Number</th>
                     <th>sessionId</th>
                     <th>Status</th>
                  </tr>
               </thead>
               <tbody>
               <c:forEach items="${activeuserlist}" var="lobj">
                  <tr>
                     <td>${lobj.getUserId()}</td>
                     <td>${lobj.getEmailId()}</td>
                     <td>${lobj.getSessionID()}</td>
                     <td>${lobj.getStatus()}</td>
                  </tr>
                 </c:forEach>
               </tbody>
            </table>
         </div>
         <div id="sessionlog" class="tab-pane fade">
            <legend>
               <h2>Session Log</h2>
            </legend>
            <table id="slist">
               <thead>
                  <tr>
                     <th>UserId</th>
                     <th>Mobile Number</th>
                     <th>sessionId</th>
                     <th>Status</th>
                  </tr>
               </thead>
               <tbody>
               <c:forEach items="${sessionloglist}" var="sobj">
                  <tr>
                     <td>${sobj.getUserId()}</td>
                     <td>${sobj.getEmailId()}</td>
                     <td>${sobj.getSessionID()}</td>
                     <td>${sobj.getStatus()}</td>
                  </tr>
                 </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
      <script type="text/javascript" charset="utf8"
         src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
      <script type="text/javascript" charset="utf8"
         src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
      <script type="text/javascript">
         $(function() {
         	$("#olist").dataTable();
         })
      </script>
      <script type="text/javascript">
         $(function() {
         	$("#ulist").dataTable();
         })
      </script>
      <script type="text/javascript">
         $(function() {
         	$("#plist").dataTable();
         })
      </script>
      <script type="text/javascript">
         $(function() {
         	$("#alist").dataTable();
         })
      </script>
      <script type="text/javascript">
         $(function() {
         	$("#slist").dataTable();
         })
      </script>
   </body>
</html>
 