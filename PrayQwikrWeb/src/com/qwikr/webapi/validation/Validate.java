package com.qwikr.webapi.validation;

import com.qwikr.webapi.domain.User;
import com.qwikr.webapi.service.UserService;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class Validate
{
  @Autowired
  UserService userService;
  
  public boolean userRegistrationValidator(User userDomain, Model model)
  {
    System.out.println("I am from Validate Class");
    
    String USER_REGISTRATION_PASSWORD_REGEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10})";
    Pattern passwordPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10})");
    Matcher passwordMatcher = passwordPattern.matcher(userDomain.getPassword());
    boolean passwordValidator = passwordMatcher.matches();
    
    String USER_ERGISTRATION_EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Matcher emailMatcher = emailPattern.matcher(userDomain.getEmailid());
    boolean emailValidator = emailMatcher.matches();
    if ((userDomain.getFirstname().isEmpty()) && (userDomain.getLastname().isEmpty()) && 
      (userDomain.getEmailid().isEmpty()) && (userDomain.getMobilenumber().isEmpty()) && 
      (userDomain.getPassword().isEmpty()) && (userDomain.getConfirmpassword().isEmpty()))
    {
      System.err.println("all empty fields from validator...");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      model.addAttribute("passwordError", "Please Enter Password");
      model.addAttribute("confirmpasswordError", "Please Enter Confirm Password");
      
      return false;
    }
    if ((userDomain.getFirstname().isEmpty()) && (userDomain.getLastname().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your lsst Name");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      
      return false;
    }
    if ((userDomain.getFirstname().isEmpty()) && (userDomain.getEmailid().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      
      return false;
    }
    if ((userDomain.getFirstname().isEmpty()) && (userDomain.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      
      return false;
    }
    if ((userDomain.getFirstname().isEmpty()) && (userDomain.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Passsword");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("passwordError", "Please Enter Password");
      
      return false;
    }
    if ((userDomain.getFirstname().isEmpty()) && (userDomain.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Confirm Passsword");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("confirmpasswordError", "Please Enter Confirm Password");
      
      return false;
    }
    if ((userDomain.getLastname().isEmpty()) && (userDomain.getEmailid().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      
      return false;
    }
    if ((userDomain.getLastname().isEmpty()) && (userDomain.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      
      return false;
    }
    if ((userDomain.getLastname().isEmpty()) && (userDomain.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Password");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("passwordError", "Please Enter Your Password");
      
      return false;
    }
    if ((userDomain.getLastname().isEmpty()) && (userDomain.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      
      return false;
    }
    if ((userDomain.getEmailid().isEmpty()) && (userDomain.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      
      return false;
    }
    if ((userDomain.getEmailid().isEmpty()) && (userDomain.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Password");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("passwordError", "Please Enter Your Password");
      
      return false;
    }
    if ((userDomain.getEmailid().isEmpty()) && (userDomain.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      
      return false;
    }
    if ((userDomain.getMobilenumber().isEmpty()) && (userDomain.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Password");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("passwordError", "Please Enter Your Password");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      
      return false;
    }
    if ((userDomain.getMobilenumber().isEmpty()) && (userDomain.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Confirm Password");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      
      return false;
    }
    if ((userDomain.getPassword().isEmpty()) && (userDomain.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Password");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      model.addAttribute("passwordError", "Please Enter Your Password");
      
      return false;
    }
    if (userDomain.getFirstname().isEmpty())
    {
      System.err.println("Please Enter Your First Name");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      
      return false;
    }
    if (userDomain.getFirstname().matches(".*\\d.*"))
    {
      System.err.println("Your First Name Should not Contains Digits");
      model.addAttribute("firstnameError", "Your First Name Should not Contains Digits");
      
      return false;
    }
    if (userDomain.getLastname().isEmpty())
    {
      System.err.println("Please Enter Your Last Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      
      return false;
    }
    if (userDomain.getLastname().matches(".*\\d.*"))
    {
      System.err.println("Your Last Name Should not Contains Digits");
      model.addAttribute("lastnameError", "Your Last Name Should not Contains Digits");
      
      return false;
    }
    if (userDomain.getEmailid().isEmpty())
    {
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      
      return false;
    }
    if (!emailValidator)
    {
      System.err.println("Please Enter Valid Email Id");
      model.addAttribute("emailError", "Please Enter Valid Email Id");
      
      return false;
    }
    if (emailValidator)
    {
      String userEmail = userDomain.getEmailid();
      List<User> elist = this.userService.getEmail(userEmail);
      
      int size = elist.size();
      if (size >= 1)
      {
        System.out.println("Email of mn:" + userEmail);
        System.err.println("Email Id already Exist.");
        model.addAttribute("emailError", "Email Id You Entered already Exist");
        
        return false;
      }
    }
    if (userDomain.getMobilenumber().isEmpty())
    {
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      
      return false;
    }
    if (!userDomain.getMobilenumber().matches("\\d{10}"))
    {
      System.err.println("Please Enter 10 Digit Mobile Number");
      model.addAttribute("mobileError", "Please Enter 10 Digit Mobile Number");
      
      return false;
    }
    if (userDomain.getMobilenumber().matches("\\d{10}"))
    {
      String userMobileNumber = userDomain.getMobilenumber();
      List<User> mlist = this.userService.getMobilenumber(userMobileNumber);
      int size = mlist.size();
      System.out.println("User Entered Mobile Number : " + userMobileNumber);
      if (size >= 1)
      {
        System.err.println("Mobile number already exist.");
        System.err.println("mobile number of mn:" + userMobileNumber);
        model.addAttribute("mobileError", "Mobile Number You Entered already Exist");
        return false;
      }
    }
    if (userDomain.getPassword().isEmpty())
    {
      System.err.println("Please Enter Password");
      model.addAttribute("passwordError", "Please Enter Password");
      
      return false;
    }
    if (!passwordValidator)
    {
      System.err.println("Password Should be 6 to 10 Characters");
      model.addAttribute("passwordError", 
        "Password Should be 6 to 10 Characters and Atleast contain One Uppercase and Lowercase letter with special characters like @#$%");
      
      return false;
    }
    if (userDomain.getConfirmpassword().isEmpty())
    {
      System.err.println("Please enter Confirm Password");
      model.addAttribute("confirmpasswordError", "Confirm Password Should not be Empty");
      
      return false;
    }
    if (!userDomain.getPassword().equals(userDomain.getConfirmpassword()))
    {
      System.err.println("Password and Confirm Password Not match");
      model.addAttribute("confirmpasswordError", "Password and Confirm Password not match");
      
      return false;
    }
    return true;
  }
}