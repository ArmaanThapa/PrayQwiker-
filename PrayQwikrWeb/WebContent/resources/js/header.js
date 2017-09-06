var page = 1;
var perPage = 3;


function ActiveHeader(id) {
	$('#' + id).addClass("active");
}

function ActiveMenu(id) {
	$('#' + id).addClass("active");
}

function ActiveSubmenu(id) {
	console.log("SubMenu");
	console.log('#' + id + "SubMenu");
	if (id.length == 0) {
		console.log("menu is null");
		$('#PrepaidSubMenu').addClass("active");
		$('#DTHSubMenu').addClass("active");
		$('#MobileSubMenu').addClass("active");
		$('#IEmailSubMenu').addClass("active");
	} else {
		console.log("Menu is not null");
		$('#' + id + "SubMenu").addClass("active");
	}
}

function processMessage(message) {
	console.log("process Message called")
}

function ActiveFadeIn(id) {
	console.log("FadeIn")
	console.log('#' + id + "FadeIn");
	if (id.length == 0) {
		$('#PrepaidFadeIn').addClass("active in");
		$('#DTHFadeIn').addClass("active in");
		$('#MobileFadeIn').addClass("active in");
		$('#IEmailFadeIn').addClass("active in");

	} else {
		$('#' + id + "FadeIn").addClass("active in");
	}
}

function ActiveClick(id) {
	$("#" + id).click();
}

// Show popup
function showPopup(id) {
	if ($('#' + id).length) {
		$('#' + id).fadeIn();
	}
}

// Hide popup
function hidePopup(id) {
	if ($('#' + id).length) {
		$('#' + id).fadeOut();
	}
}

// Load Pagination Menu
function loadPagination(total) {
	console.log("PAGE :: " + total);
	var totalPage = Math.round(total / perPage);
	console.log("PAGE TOTAL :: " + totalPage);
	if (totalPage > 0) {
		$('#pagination').twbsPagination({
			totalPages : totalPage,
			startPage : page,
			visiblePages : 15,
			onPageClick : function(event, pg) {
				console.log("PAGE CLICK :: " + pg);
				checkPage(pg);
			}
		});
	}
}


// Load Page
function checkPage(pg) {
	console.log("CHECK PAGE :: " + pg);
	if (page != pg) {
		page = pg;
		console.log("CHECK PAGE SUBTRACT :: " + page);
		$('#loading').show();
		getUserList();
	}
}

function getUserList() {
	var requestData = 'page=' + (page - 1) + '&perPage=' + perPage;
	console.log("request Data " + requestData);
	$.ajax({

		type : "GET",
		url : "/PayQwik/Admin/Ajax/GetUser",
		contentType : "application/json",
		data : requestData,
		datatype : 'json',

		success : function(response) {
			console.log("Response " + JSON.stringify(response));
			$('#userList').html("");
			var size = response.length
			console.log("SIZE :: " + size);
			console.log("Head Created");

			for (i = 0; i < size; i++) {
				console.log("Body Created " + i);
				var u = response[i];
				$('#userList').append(
						'' + '<tr>' + '<td><b>User Name : </b>'
								+ u.userDetail.firstName + ''
								+ u.userDetail.middleName
								+ u.userDetail.lastName + '<br />'
								+ '<b>Mobile Number :</b> '
								+ u.userDetail.contactNo + '<br /> <b>Email'
								+ 'ID :</b>' + u.userDetail.email + '</td>'
								+ '<td>' + u.emailStatus + '</td>' + '<td>'
								+ u.userDetail.address + '</td>'
								+ '<td>Balance : 1833 -/ Rs.<br />Status :'
								+ u.mobileStatus
								+ '<td>Daily : <br />Monthly : <br /> Yearly :'
								+ '</td>' + '</tr>' + '');
			}
			console.log("Table Closes");
			$("#loading").hide();
		},
		error : function(response) {
			console.log("HERE INSIDE ERROR " + response.responseText);
			location.reload();
		}
	});
}

/* Here Pagination for All Users Ends */
/* Here Pagination for Verified Users Starts */
// Load Pagination Menu for verified Users
function loadPaginationVerifiedUsers(total) {
	console.log(" Verified Users PAGE :: " + total);
	var totalPage = Math.round(total / perPage);
	console.log(" Verified Users PAGE TOTAL :: " + totalPage);
	if (totalPage > 0) {
		$('#pagination').twbsPagination({
			totalPages : totalPage,
			startPage : page,
			visiblePages : 15,
			onPageClick : function(event, pg) {
				console.log(" Verified Users PAGE CLICK :: " + pg);
				checkPageVerifiedUsers(pg);
			}
		});
	}
}

// Load Page for verified Users
function checkPageVerifiedUsers(pg) {
	console.log(" Verified Users CHECK PAGE :: " + pg);
	if (page != pg) {
		page = pg;
		console.log("Verified Users CHECK PAGE SUBTRACT :: " + page);
		$('#loading').show();
		getUserListVerifiedUsers();
	}
}

function getUserListVerifiedUsers() {
	var requestData = 'page=' + (page - 1) + '&perPage=' + perPage;
	console.log("request Data " + requestData);
	$
			.ajax({

				type : "GET",
				url : "/PayQwik/Admin/Ajax/VerifiedUser",
				contentType : "application/json",
				data : requestData,
				datatype : 'json',

				success : function(response) {
					console.log("Verified Users Response "
							+ JSON.stringify(response));
					$('#userList').html("");
					var size = response.length
					console.log("SIZE :: " + size);
					console.log("Head Created");

					for (i = 0; i < size; i++) {
						console.log("Body Created " + i);
						var u = response[i];
						$('#userList')
								.append(
										'' + '<tr>' + '<td><b>User Name : </b>'
												+ u.userDetail.firstName
												+ ''
												+ u.userDetail.middleName
												+ u.userDetail.lastName
												+ '<br />'
												+ '<b>Mobile Number :</b> '
												+ u.userDetail.contactNo
												+ '<br /> <b>Email'
												+ 'ID :</b>'
												+ u.userDetail.email
												+ '</td>'
												+ '<td>'
												+ u.emailStatus
												+ '</td>'
												+ '<td>'
												+ u.userDetail.address
												+ '</td>'
												+ '<td>Balance : 1833 -/ Rs.<br />Status :'
												+ u.mobileStatus + '' + '</td>'
												+ '</tr>' + '');
					}
					console.log("Table Closes");
					$("#loading").hide();
				},
				error : function(response) {
					console.log("HERE INSIDE ERROR " + response.responseText);
					location.reload();
				}
			});
}

/* Here Pagination for Unverified Users Starts */
// Load Pagination Menu for Unverified Users
function loadPaginationUnverifiedUsers(total) {
	console.log(" Verified Users PAGE :: " + total);
	var totalPage = Math.round(total / perPage);
	console.log(" Verified Users PAGE TOTAL :: " + totalPage);
	if (totalPage > 0) {
		$('#pagination').twbsPagination({
			totalPages : totalPage,
			startPage : page,
			visiblePages : 15,
			onPageClick : function(event, pg) {
				console.log(" Verified Users PAGE CLICK :: " + pg);
				checkPageUnverifiedUsers(pg);
			}
		});
	}
}

// Load Page for verified Users
function checkPageUnverifiedUsers(pg) {
	console.log(" Verified Users CHECK PAGE :: " + pg);
	if (page != pg) {
		page = pg;
		console.log("Verified Users CHECK PAGE SUBTRACT :: " + page);
		$('#loading').show();
		getUserListUnverifiedUsers();
	}
}

function SelectOperator() {
	var i = 0;
	$("#mobile")
			.keypress(
					function(event) {
						if (event.which >= 48 && event.which <= 57) {
							i = i + 1;
							console.log(event.which);
							console.log(i);
							console.log($("#mobile").val());
							var mobilePart = $("#mobile").val();
							if (mobilePart >= 7000) {
								$
										.ajax({

											type : "GET",
											url : "/Guest/Ajax/GetTelco?number="
													+ mobilePart,
											contentType : "application/json",
											datatype : 'json',
											success : function(response) {
												console
														.log("Response "
																+ JSON
																		.stringify(response));
												var u = response;
												console.log(response);
												$("#operator").val(
														u.operator.serviceCode);
												$("#circle").val(u.circle.code);
												var link = "<a href='#' id='planzz'>Browse Plans</a>"
												$("#plan_link").html(link);
												$("#planzz")
														.click(
																function() {
																	console
																			.log("clicked");
																	$
																			.ajax({
																				type : "GET",
																				url : "/Guest/Ajax/GetPlans?operatorCode="
																						+ u.operator.code
																						+ "&circleCode="
																						+ u.circle.code,
																				contentType : "application/json",
																				datatype : 'json',
																				success : function(
																						response) {
																					console
																							.log("Response "
																									+ JSON
																											.stringify(response));
																					console
																							.log(response);
																					var plans = response.plans;
																					generateTable(plans);

																				}

																			});

																});
											},

										});
							}
						}
					});
}

function generateTable(plans,id) {
	$("#"+id).html("");
	console.log("inside generation of table");
	$("#"+id).append("<thead><tr><th class='col-xs-6'>Description</th><th class='col-xs-3'>Validity</th><th class='col-xs-2'>Amount</th></tr></thead>");
    $("#"+id).append("<tbody id='tbody"+id+"'>");
	for ( var i in plans) {
		console.log(plans[i].description)
			$("#tbody"+id).append("<tr id='bplanrow" +i+id+ "'>");
			$("#bplanrow" + i+id).append(
					"<td class='col-xs-6'>" + plans[i].description + "</td>");
			$("#bplanrow" +i+id).append(
					"<td class='col-xs-3'>" + plans[i].validity + "</td>");
			$("#bplanrow" +i+id).append(
					"<td class='col-xs-2'><a class='btn btn-primary btn-sm' onclick=enterAmount("
							+ plans[i].amount + ") href='#';>"
							+ plans[i].amount + "</a></td>");
			$("#tbodyOne").append("</tr>");
	}
	$("#"+id).append("</tbody>");
}


function generateDCTable(plans,id) {
	$("#"+id).html("");
	console.log("inside generation of table");
	$("#"+id).append("<thead><tr><th class='col-xs-6'>Description</th><th class='col-xs-3'>Validity</th><th class='col-xs-2'>Amount</th></tr></thead>");
	$("#"+id).append("<tbody id='tbody"+id+"'>");
	for ( var i in plans) {
		console.log(plans[i].description)
		$("#tbody"+id).append("<tr id='bplanrow" +i+id+ "'>");
		$("#bplanrow" + i+id).append(
			"<td class='col-xs-6'>" + plans[i].description + "</td>");
		$("#bplanrow" +i+id).append(
			"<td class='col-xs-3'>" + plans[i].validity + "</td>");
		$("#bplanrow" +i+id).append(
			"<td class='col-xs-2'><a class='btn btn-primary btn-sm' onclick=enterDCAmount("
			+ plans[i].amount + ") href='#';>"
			+ plans[i].amount + "</a></td>");
		$("#tbodyOne").append("</tr>");
	}
	$("#"+id).append("</tbody>");
}



function browsePic() {
	$("#profilePic").append("<h1>Change Image</h1>")

}

function removePic() {

	$("#picz").hide();
}

function enterAmount(amount) {
	console.log("inside enter amount");
	$("#pre_amount").val(amount);

}
function enterDCAmount(amount) {
	console.log("inside enter amount");
	$("#dc_amount").val(amount);

}
function hideID(id) {
	$("#" + id).hide();
}





































/*function ActiveHeader(id) {
	$('#' + id).addClass("active");
}

function ActiveMenu(id) {
	$('#' + id).addClass("active");
}

function ActiveSubmenu(id) {
	console.log("SubMenu");
	console.log('#' + id + "SubMenu");
	if (id.length == 0) {
		console.log("menu is null");
		$('#PrepaidSubMenu').addClass("active");
		$('#DTHSubMenu').addClass("active");
		$('#MobileSubMenu').addClass("active");
		$('#IEmailSubMenu').addClass("active");
	} else {
		console.log("Menu is not null");
		$('#' + id + "SubMenu").addClass("active");
	}
}
function enableButton(id) {
	var isChecked = $("#termsConditions").is(":checked");
	console.log(isChecked);
	if (isChecked) {
		console.log(isChecked);
		console.log("disable button with id " + id);
		$("#" + id).removeClass("disabled");
	} else {
		$("#" + id).addClass("disabled")
	}

}

function processMessage(message) {
	console.log("process Message called")
	if (message.includes('Registration Successful')
			|| message.includes("New OTP") || message.includes("Invalid OTP")) {
		$("#regMessage").modal("show");
	}
	if (message.includes(" Your mobile is  successfully verified")
			|| message.includes("Already Verified")) {
		$("#regMessage").modal("hide");
		$("#verifiedMessage").modal("show");
	}
	if (message.includes("Check your SMS for OTP Code to change your password")) {
		$("#forgotPassword").modal("show");
	}
}

function ActiveFadeIn(id) {
	console.log("FadeIn")
	console.log('#' + id + "FadeIn");
	if (id.length == 0) {
		$('#PrepaidFadeIn').addClass("active in");
		$('#DTHFadeIn').addClass("active in");
		$('#MobileFadeIn').addClass("active in");
		$('#IEmailFadeIn').addClass("active in");

	} else {
		$('#' + id + "FadeIn").addClass("active in");
	}

}

function ActiveClick(id) {
	$("#" + id).click();
}

// Show popup
function showPopup(id) {
	if ($('#' + id).length) {
		$('#' + id).fadeIn();
	}
}

// Hide popup
function hidePopup(id) {
	if ($('#' + id).length) {
		$('#' + id).fadeOut();
	}
}

$("#first_name").keydown(function(){
	console.log("key pressed");
	if(firstName == "" || firstName == null){
		console.log("firstName is entered")
		$("#error_first_name").html("Enter Your First Name");
	}
		
});

function processRegistration() {
	console.log("process registration");
	var firstName = $('#first_name').val();
	var lastName = $('#last_name').val() ;
	var password  = $('#password').val();
	var email = $('#email').val() ;
	var confirmPassword = $('#confirm_password').val();
	var dob = $('#dob').val();
	var contactNo = $('#contact_no').val() ;
	var gender = $("#gender").val() ;

	if(!(password === confirmPassword)) {
		$("#error_confirm_password").html("Passwords Mis Match");
	}
	else {
	$.ajax({
		type : "POST",
		headers : {
			"hash" : "123456"
		},
		contentType : "application/json",
		url : "/PayQwikWeb/Api/v1/User/Android/en/Registration/Process",
		dataType : 'json',
		data : JSON.stringify({
			"firstName" : "" + $('#first_name').val() + "",
			"lastName" : "" + $('#last_name').val() + "",
			"password" : "" + $('#password').val() + "",
			"confirmPassword" : "" + $('#confirm_password').val() + "",
			"contactNo" : "" + $('#contact_no').val() + "",
			"email" : "" + $('#email').val() + "",
			"gender" : "" + $("#gender").val() + "",
			"dateOfBirth" : "" + $('#dob').val() + ""
		}),
		success : function(response) {
			console.log(response);
			if (response.code.includes("S00")) {
				console.log("success");
				
				$("#regMessage").modal("show");
				$("#reg_otp_username").val($('#contact_no').val());
				$("#regMessage_success").html("Registration Successful OTP sent to "+ $('#contact_no').val()+" and verification mail sent to "+ $('#email').val());
			} 
		}
	});
	}

}

function processResendOTP() {
	console.log("inside resend mobile OTP");
	$.ajax({
		type : "POST",
		headers : {
			"hash" : "123456"
		},
		contentType : "application/json",
		url : "/PayQwikWeb/Api/v1/User/Android/en/Registration/ResendMobileOTP",
		dataType : 'json',
		data : JSON.stringify({
			"mobileNumber" : "" + $('#reg_otp_username').val() + ""
		}),
		success : function(response) {
			console.log(response);
			if (response.code.includes("S00")) {
				console.log("success");
				console.log(response.details);
				$("#regMessage_success").html(response.details);
				$("#fpOTP_message").html(response.details);
			} 
		}
	});
	
}


function processVerifyMobile() {
	console.log("inside verify mobile OTP");
	$.ajax({
		type : "POST",
		headers : {
			"hash" : "123456"
		},
		contentType : "application/json",
		url : "/PayQwikWeb/Api/v1/User/Android/en/Registration/MobileOTP",
		dataType : 'json',
		data : JSON.stringify({
			"mobileNumber" : "" + $('#reg_otp_username').val() + "",
			"key" : "" + $('#verify_reg_otp_key').val() + ""
		}),
		success : function(response) {
			console.log(response);
			if (response.code.includes("S00")) {
				console.log("success");
				$("#regMessage").modal('hide');
				$("#verifiedMessage").modal('show');
				$("#success_verification_message").html(response.details+" Please login to continue");
				console.log(response.details);
			} else {
				$("#regMessage_success").html(response.details);				
			}
		}
	});
	
}
//
// $.ajax({
// type : "POST",
// headers:{"hash":"123456"},
// contentType : "application/json",
// url : "/Api/v1/User/Android/en/Login/ChangePasswordWithOTP",
// dataType:'json',
// data: JSON.stringify({"username":""+
// $('#fp_username').val()+"","newPassword":""+
// $('#fpnewPassword_key').val()+"","confirmPassword":""+
// $('#fpconfirmPassword_key').val()+"","key":""+ $('#fpOTP_key').val()+""}),
// success : function(response) {
// console.log(response);
// if (response.code.includes("S00")) {
// console.log("success");
//				
// $("#successNotification").modal("show");
// $("#success_alert").html("Password Changed Successfully");
// } else {
// $("#fp_username").val(response.details.username);
// $("#fpOTP_message").html(response.details.key);
// }
// }
// });

 Here Pagination for All Users Starts 

// Load Pagination Menu
function loadPagination(total) {
	console.log("PAGE :: " + total);
	var totalPage = Math.round(total / perPage);
	console.log("PAGE TOTAL :: " + totalPage);
	if (totalPage > 0) {
		$('#pagination').twbsPagination({
			totalPages : totalPage,
			startPage : page,
			visiblePages : 15,
			onPageClick : function(event, pg) {
				console.log("PAGE CLICK :: " + pg);
				checkPage(pg);
			}
		});
	}
}

$("#resend_form_button").click(function() {
	
var mobileNumber = $("#resend_mobile_number").val();

$.ajax({
	type : "POST",
	headers : {
		"hash" : "123456"
	},
	contentType : "application/json",
	url : "/PayQwikWeb/Api/v1/User/Android/en/Login/ChangePasswordWithOTP",
	dataType : 'json',
	data : JSON.stringify({
		"username" : "" + $('#fp_username').val() + "",
		"newPassword" : "" + $('#fpnewPassword_key').val() + "",
		"confirmPassword" : "" + $('#fpconfirmPassword_key').val() + "",
		"key" : "" + $('#fpOTP_key').val() + ""
	}),
	success : function(response) {
		console.log(response);
		if (response.code.includes("S00")) {
			console.log("success");

			$("#successNotification").modal("show");
			$("#success_alert").html("Password Changed Successfully");
		} else {
			$("#fp_username").val(response.details.username);
			$("#fpOTP_message").html(response.details.key);
		}
	}
});


});

// Load Page
function checkPage(pg) {
	console.log("CHECK PAGE :: " + pg);
	if (page != pg) {
		page = pg;
		console.log("CHECK PAGE SUBTRACT :: " + page);
		$('#loading').show();
		getUserList();
	}
}

function getUserList() {
	var requestData = 'page=' + (page - 1) + '&perPage=' + perPage;
	console.log("request Data " + requestData);
	$.ajax({

		type : "GET",
		url : "/PayQwik/Admin/Ajax/GetUser",
		contentType : "application/json",
		data : requestData,
		datatype : 'json',

		success : function(response) {
			console.log("Response " + JSON.stringify(response));
			$('#userList').html("");
			var size = response.length
			console.log("SIZE :: " + size);
			console.log("Head Created");

			for (i = 0; i < size; i++) {
				console.log("Body Created " + i);
				var u = response[i];
				$('#userList').append(
						'' + '<tr>' + '<td><b>User Name : </b>'
								+ u.userDetail.firstName + ''
								+ u.userDetail.middleName
								+ u.userDetail.lastName + '<br />'
								+ '<b>Mobile Number :</b> '
								+ u.userDetail.contactNo + '<br /> <b>Email'
								+ 'ID :</b>' + u.userDetail.email + '</td>'
								+ '<td>' + u.emailStatus + '</td>' + '<td>'
								+ u.userDetail.address + '</td>'
								+ '<td>Balance : 1833 -/ Rs.<br />Status :'
								+ u.mobileStatus
								+ '<td>Daily : <br />Monthly : <br /> Yearly :'
								+ '</td>' + '</tr>' + '');
			}
			console.log("Table Closes");
			$("#loading").hide();
		},
		error : function(response) {
			console.log("HERE INSIDE ERROR " + response.responseText);
			location.reload();
		}
	});
}

 Here Pagination for All Users Ends 

 Here Pagination for Verified Users Starts 

// Load Pagination Menu for verified Users
function loadPaginationVerifiedUsers(total) {
	console.log(" Verified Users PAGE :: " + total);
	var totalPage = Math.round(total / perPage);
	console.log(" Verified Users PAGE TOTAL :: " + totalPage);
	if (totalPage > 0) {
		$('#pagination').twbsPagination({
			totalPages : totalPage,
			startPage : page,
			visiblePages : 15,
			onPageClick : function(event, pg) {
				console.log(" Verified Users PAGE CLICK :: " + pg);
				checkPageVerifiedUsers(pg);
			}
		});
	}
}

// Load Page for verified Users
function checkPageVerifiedUsers(pg) {
	console.log(" Verified Users CHECK PAGE :: " + pg);
	if (page != pg) {
		page = pg;
		console.log("Verified Users CHECK PAGE SUBTRACT :: " + page);
		$('#loading').show();
		getUserListVerifiedUsers();
	}
}

function getUserListVerifiedUsers() {
	var requestData = 'page=' + (page - 1) + '&perPage=' + perPage;
	console.log("request Data " + requestData);
	$
			.ajax({

				type : "GET",
				url : "/PayQwik/Admin/Ajax/VerifiedUser",
				contentType : "application/json",
				data : requestData,
				datatype : 'json',

				success : function(response) {
					console.log("Verified Users Response "
							+ JSON.stringify(response));
					$('#userList').html("");
					var size = response.length
					console.log("SIZE :: " + size);
					console.log("Head Created");

					for (i = 0; i < size; i++) {
						console.log("Body Created " + i);
						var u = response[i];
						$('#userList')
								.append(
										'' + '<tr>' + '<td><b>User Name : </b>'
												+ u.userDetail.firstName
												+ ''
												+ u.userDetail.middleName
												+ u.userDetail.lastName
												+ '<br />'
												+ '<b>Mobile Number :</b> '
												+ u.userDetail.contactNo
												+ '<br /> <b>Email'
												+ 'ID :</b>'
												+ u.userDetail.email
												+ '</td>'
												+ '<td>'
												+ u.emailStatus
												+ '</td>'
												+ '<td>'
												+ u.userDetail.address
												+ '</td>'
												+ '<td>Balance : 1833 -/ Rs.<br />Status :'
												+ u.mobileStatus + '' + '</td>'
												+ '</tr>' + '');
					}
					console.log("Table Closes");
					$("#loading").hide();
				},
				error : function(response) {
					console.log("HERE INSIDE ERROR " + response.responseText);
					location.reload();
				}
			});
}

 Here Pagination for Unverified Users Starts 

// Load Pagination Menu for Unverified Users
function loadPaginationUnverifiedUsers(total) {
	console.log(" Verified Users PAGE :: " + total);
	var totalPage = Math.round(total / perPage);
	console.log(" Verified Users PAGE TOTAL :: " + totalPage);
	if (totalPage > 0) {
		$('#pagination').twbsPagination({
			totalPages : totalPage,
			startPage : page,
			visiblePages : 15,
			onPageClick : function(event, pg) {
				console.log(" Verified Users PAGE CLICK :: " + pg);
				checkPageUnverifiedUsers(pg);
			}
		});
	}
}

// Load Page for verified Users
function checkPageUnverifiedUsers(pg) {
	console.log(" Verified Users CHECK PAGE :: " + pg);
	if (page != pg) {
		page = pg;
		console.log("Verified Users CHECK PAGE SUBTRACT :: " + page);
		$('#loading').show();
		getUserListUnverifiedUsers();
	}
}

function SelectOperator() {
	var i = 0;
	$("#mobile")
			.keypress(
					function(event) {
						if (event.which >= 48 && event.which <= 57) {
							i = i + 1;
							console.log(event.which);
							console.log(i);
							console.log($("#mobile").val());
							var mobilePart = $("#mobile").val();
							if (mobilePart >= 7000) {
								$
										.ajax({

											type : "GET",
											url : "/Guest/Ajax/GetTelco?number="
													+ mobilePart,
											contentType : "application/json",
											datatype : 'json',
											success : function(response) {
												console
														.log("Response "
																+ JSON
																		.stringify(response));
												var u = response;
												console.log(response);
												$("#operator").val(
														u.operator.serviceCode);
												$("#circle").val(u.circle.code);
												var link = "<a href='#' id='planzz'>Browse Plans</a>"
												$("#plan_link").html(link);
												$("#planzz")
														.click(
																function() {
																	console
																			.log("clicked");
																	$
																			.ajax({
																				type : "GET",
																				url : "/Guest/Ajax/GetPlans?operatorCode="
																						+ u.operator.code
																						+ "&circleCode="
																						+ u.circle.code,
																				contentType : "application/json",
																				datatype : 'json',
																				success : function(
																						response) {
																					console
																							.log("Response "
																									+ JSON
																											.stringify(response));
																					console
																							.log(response);
																					var plans = response.plans;
																					generateTable(plans);

																				}

																			});

																});
											},

										});
							}
						}
					});
}
function processForgotPassword() {
	console.log("Inside Process Forgot Password");
	var oldVal = $("#fp_submit").val();
	$("#fp_submit").addClass("disabled");
	$("#fp_submit").val("Please wait ....");
	$.ajax({
		type : "POST",
		headers : {
			"hash" : "123456"
		},
		contentType : "application/json",
		url : "/PayQwikWeb/Api/v1/User/Android/en/Login/ForgotPassword",
		data : JSON.stringify({
			"username" : "" + $('#fp_username').val() + ""
		}),
		dataType : 'json',
		success : function(response) {
			console.log("Response " + JSON.stringify(response));
			$("#fp_submit").val(oldVal)
			$("#fp_submit").removeClass("disabled");
			console.log("Reponse Is ::");

			if (response.code.includes("S00")) {
				$("#forgotPassword").modal("hide");
				$("#fpOTP").modal("show");
				$("#fpusername_forgot").val($('#fp_username').val());
				$("#fpOTP_message").html(response.details);

			} else {
				console.log(response.details);
				$("#fp_message").append(response.details);
			}
		}
	});
}



function processResendOTPForgotPassword() {
	console.log("inside resend mobile OTP forgot Password");
	console.log($('#fpusername_forgot').val());
	$.ajax({
		type : "POST",
		headers : {
			"hash" : "123456"
		},
		contentType : "application/json",
		url : "/PayQwikWeb/Api/v1/User/Android/en/Login/ForgotPassword",
		dataType : 'json',
		data : JSON.stringify({
			"username":""+$('#fpusername_forgot').val()+""
		}),
		success : function(response) {
			console.log(response);
			if (response.code.includes("S00")) {
				console.log("success");
				console.log(response.details);
				$("#fpOTP_message").html(response.details);
			} 
		}
	});
	
}


function processForgotPasswordOTP() {
	console.log("inside forgot password OTP");
	var key = $("#fpOTP_key").val();
	var newPassword = $('#fpnewPassword_key').val();
	var confirmPassword =  + $('#fpconfirmPassword_key').val() ;
	if(newPassword === confirmPassword) {
	$.ajax({
		type : "POST",
		headers : {
			"hash" : "123456"
		},
		contentType : "application/json",
		url : "/PayQwikWeb/Api/v1/User/Android/en/Login/ChangePasswordWithOTP",
		dataType : 'json',
		data : JSON.stringify({
			"username" : "" + $('#fpusername_forgot').val() + "",
			"newPassword" : "" + $('#fpnewPassword_key').val() + "",
			"confirmPassword" : "" + $('#fpconfirmPassword_key').val() + "",
			"key" : "" + $('#fpOTP_key').val() + ""
		}),
		success : function(response) {
			console.log(response);
			if (response.code.includes("S00")) {
				console.log("success");

				$("#successNotification").modal("show");
				$("#success_alert").html("Password Changed Successfully");
			} else {
				$("#fpusername_forgot").val(response.details.username);
				$("#fpOTP_message").html(response.details.key);
			}
		}
	});
	}else {
		$('#fpnewPassword_key').val("Please enter same password in both fields") 
	}
}


function generateTable(plans) {
	console.log("inside generation of table");
	$("#mycarousel").hide();
	$("#plan_table")
			.append(
					"<thead><tr><th class='col-xs-8'>Description</th><th class='col-xs-3'>Validity</th><th class='col-xs-1'>Amount</th></tr></thead>");
	$("#plan_table").append("<tbody id='tbodyOne'>");
	for ( var i in plans) {
		if (plans[i].planName.includes("Talktime")
				|| plans[i].planName.includes("Topup")) {
			$("#tbodyOne").append("<tr id='bplanrow" + i + "'>");
			$("#bplanrow" + i).append(
					"<td class='col-xs-9'>" + plans[i].description + "</td>");
			$("#bplanrow" + i).append(
					"<td class='col-xs-3'>" + plans[i].validity + "</td>");
			$("#bplanrow" + i).append(
					"<td class='col-xs-2'><a class='btn btn-primary' onclick=enterAmount("
							+ plans[i].amount + ") href='#';>"
							+ plans[i].amount + "</a></td>");
			$("#tbodyOne").append("</tr>");
		}
	}
	$("#plan_table").append("</tbody>");

}


function generateTableDataPlans(plans) {
	console.log("inside generation of data plans table");
	$("#mycarousel").hide();
	$("#plan_table")
			.append(
					"<thead><tr><th class='col-xs-8'>Description</th><th class='col-xs-3'>Validity</th><th class='col-xs-1'>Amount</th></tr></thead>");
	$("#plan_table").append("<tbody id='tbodyOne'>");
	for ( var i in plans) {
		if (!(plans[i].planName.includes("Talktime")
				|| plans[i].planName.includes("Topup"))) {
			$("#tbodyOne").append("<tr id='bplanrow" + i + "'>");
			$("#bplanrow" + i).append(
					"<td class='col-xs-9'>" + plans[i].description + "</td>");
			$("#bplanrow" + i).append(
					"<td class='col-xs-3'>" + plans[i].validity + "</td>");
			$("#bplanrow" + i).append(
					"<td class='col-xs-2'><a class='btn btn-primary' onclick=enterDCAmount("
							+ plans[i].amount + ") href='#';>"
							+ plans[i].amount + "</a></td>");
			$("#tbodyOne").append("</tr>");
		}
	}
	$("#plan_table").append("</tbody>");

}


function browsePic() {
	$("#profilePic").append("<h1>Change Image</h1>")

}

function removePic() {

	$("#picz").hide();
}

function enterAmount(amount) {
	console.log("inside enter amount");
	$("#pre_amount").val(amount);

}

function enterDCAmount(amount) {
	console.log("inside enter amount");
	$("#dc_amount").val(amount);

}


function hideID(id) {
	$("#" + id).hide();
}
*/