package com.qwikr.webapi.validation;

import com.qwikr.webapi.dao.impl.AdminDaoImpl;
import com.qwikr.webapi.domain.Admin;
import com.qwikr.webapi.dto.AdminDto;
import com.qwikr.webapi.service.AdminService;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class AdminValidate
{
  @Autowired
  AdminService adminService;
  AdminDaoImpl adminDao = new AdminDaoImpl();
  
  public String adminRegistrationValidator(AdminDto adminDto, Model model)
  {
    System.out.println("I am from admin Validate Class");
    
    String ADMIN_REGISTRATION_PASSWORD_REGEX = "((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})";
    
    Pattern passwordPattern = Pattern.compile("((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})");
    Matcher passwordMatcher = passwordPattern.matcher(adminDto.getPassword());
    boolean passwordValidator = passwordMatcher.matches();
    
    String USER_ERGISTRATION_EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Matcher emailMatcher = emailPattern.matcher(adminDto.getEmail());
    boolean emailValidator = emailMatcher.matches();
    if ((adminDto.getFirstname().isEmpty()) && (adminDto.getLastname().isEmpty()) && 
      (adminDto.getEmail().isEmpty()) && (adminDto.getMobilenumber().isEmpty()) && 
      (adminDto.getPassword().isEmpty()) && (adminDto.getOrganization().isEmpty()) && (adminDto.getConfirmpassword().isEmpty()))
    {
      System.err.println("all empty fields from validator...");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      model.addAttribute("orgError", "Please Enter Your Organization Name");
      model.addAttribute("passwordError", "Please Enter Password");
      model.addAttribute("confirmpasswordError", "Please Enter Confirm Password");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getFirstname().isEmpty()) && (adminDto.getLastname().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your lsst Name");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getFirstname().isEmpty()) && (adminDto.getEmail().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getFirstname().isEmpty()) && (adminDto.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getFirstname().isEmpty()) && (adminDto.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Passsword");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("passwordError", "Please Enter Password");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getFirstname().isEmpty()) && (adminDto.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Confirm Passsword");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("confirmpasswordError", "Please Enter Confirm Password");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getLastname().isEmpty()) && (adminDto.getEmail().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getLastname().isEmpty()) && (adminDto.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getLastname().isEmpty()) && (adminDto.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Password");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("passwordError", "Please Enter Your Password");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getLastname().isEmpty()) && (adminDto.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getEmail().isEmpty()) && (adminDto.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getEmail().isEmpty()) && (adminDto.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Password");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("passwordError", "Please Enter Your Password");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getEmail().isEmpty()) && (adminDto.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getMobilenumber().isEmpty()) && (adminDto.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Password");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("passwordError", "Please Enter Your Password");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getMobilenumber().isEmpty()) && (adminDto.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Confirm Password");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "/Admin/adminRegister";
    }
    if ((adminDto.getPassword().isEmpty()) && (adminDto.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Password");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      model.addAttribute("passwordError", "Please Enter Your Password");
      return "/Admin/adminRegister";
    }
    if (adminDto.getFirstname().isEmpty())
    {
      System.err.println("Please Enter Your First Name");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      return "/Admin/adminRegister";
    }
    if (adminDto.getFirstname().matches(".*\\d.*"))
    {
      System.err.println("Your First Name Should not Contains Digits");
      model.addAttribute("firstnameError", "Your First Name Should not Contains Digits");
      return "/Admin/adminRegister";
    }
    if (adminDto.getLastname().isEmpty())
    {
      System.err.println("Please Enter Your Last Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      return "/Admin/adminRegister";
    }
    if (adminDto.getLastname().matches(".*\\d.*"))
    {
      System.err.println("Your Last Name Should not Contains Digits");
      model.addAttribute("lastnameError", "Your Last Name Should not Contains Digits");
      return "/Admin/adminRegister";
    }
    if (adminDto.getMobilenumber().isEmpty())
    {
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "/Admin/adminRegister";
    }
    if (!adminDto.getMobilenumber().matches("\\d{10}"))
    {
      System.err.println("Please Enter 10 Digit Mobile Number");
      model.addAttribute("mobileError", "Please Enter 10 Digit Mobile Number");
      return "/Admin/adminRegister";
    }
    if (adminDto.getMobilenumber().matches("\\d{10}"))
    {
      String adminMobile = adminDto.getMobilenumber();
      System.out.println("adminMobile -->  " + adminMobile);
      List<Admin> mlist = this.adminDao.checkAdminMobilenumber(adminMobile);
      
      int size = mlist.size();
      System.out.println("User Entered Mobile Number : " + adminMobile);
      if (size >= 1)
      {
        System.err.println("Mobile number already exist.");
        System.err.println("mobile number of mn:" + adminMobile);
        model.addAttribute("mobileError", "Mobile Number You Entered already Exist");
        return "/Admin/adminRegister";
      }
    }
    if (adminDto.getEmail().isEmpty())
    {
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      return "/Admin/adminRegister";
    }
    if (!emailValidator)
    {
      System.err.println("Please Enter Valid Email Id");
      model.addAttribute("emailError", "Please Enter Valid Email Id");
      return "/Admin/adminRegister";
    }
    if (emailValidator)
    {
      String userEmail = adminDto.getEmail();
      System.out.println("userEmail -----> " + userEmail);
      List<Admin> elist = this.adminService.getAdminEmail(userEmail);
      System.err.println("Admin MObile list : " + elist.size());
      int size = elist.size();
      if (size >= 1)
      {
        System.out.println("Email of mn:" + userEmail);
        System.err.println("Email Id already Exist.");
        model.addAttribute("emailError", "Email Id You Entered already Exist");
        return "/Admin/adminRegister";
      }
    }
    if (adminDto.getPassword().isEmpty())
    {
      System.err.println("Please Enter Password");
      model.addAttribute("passwordError", "Please Enter Password");
      return "/Admin/adminRegister";
    }
    if (!passwordValidator)
    {
      System.err.println("Password Should be 6 to 10 Characters");
      model.addAttribute("passwordError", "Password Should be 6 to 10 Characters");
      return "/Admin/adminRegister";
    }
    if (adminDto.getConfirmpassword().isEmpty())
    {
      System.err.println("Please enter Confirm Password");
      model.addAttribute("confirmpasswordError", "Confirm Password Should not be Empty");
      return "/Admin/adminRegister";
    }
    if (!adminDto.getPassword().equals(adminDto.getConfirmpassword()))
    {
      System.err.println("Password and Confirm Password Not match");
      model.addAttribute("confirmpasswordError", "Password and Confirm Password not match");
      return "/Admin/adminRegister";
    }
    return "";
  }
}