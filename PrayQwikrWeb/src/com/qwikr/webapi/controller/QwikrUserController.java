package com.qwikr.webapi.controller;

import com.qwikr.webapi.domain.Brand;
import com.qwikr.webapi.domain.Product;
import com.qwikr.webapi.domain.ProductCategory;
import com.qwikr.webapi.domain.User;
import com.qwikr.webapi.service.BrandService;
import com.qwikr.webapi.service.CartService;
import com.qwikr.webapi.service.DeliveryService;
import com.qwikr.webapi.service.LoginService;
import com.qwikr.webapi.service.ProductCategoryService;
import com.qwikr.webapi.service.ProductService;
import com.qwikr.webapi.service.SubcategoryService;
import com.qwikr.webapi.service.UserService;
import com.qwikr.webapi.service.UseradminService;
import com.qwikr.webapi.service.orderDetailService;
import java.io.PrintStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.velocity.app.VelocityEngine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/user"})
public class QwikrUserController
{
  @Autowired
  UseradminService adminuserservice;
  @Autowired
  ProductService productService;
  @Autowired
  CartService cartService;
  @Autowired
  UserService userService;
  @Autowired
  DeliveryService deliveryService;
  @Autowired
  LoginService loginService;
  @Autowired
  orderDetailService orderdetailService;
  @Autowired
  ProductCategoryService categoryService;
  @Autowired
  VelocityEngine velocityEngine;
  @Autowired
  SubcategoryService subcategoryservice;
  @Autowired
  BrandService brandservice;
  @Autowired
  SessionFactory session4;
  
  @RequestMapping(value={"/usersignup"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String usersignup(@ModelAttribute("userbean") User userbean, HttpServletRequest req, HttpServletResponse res, Model model)
    throws Exception
  {
    System.out.println("i am from usersignup");
    HttpSession session = req.getSession();
    String fname = userbean.getFirstname();
    String lname = userbean.getLastname();
    String mobile = userbean.getMobilenumber();
    String email = userbean.getEmailid();
    String pass = userbean.getPassword();
    String cpass = userbean.getConfirmpassword();
    
    System.out.println("First Name : " + fname);
    System.out.println("Last Name : " + lname);
    System.out.println("Mobile NUmber : " + mobile);
    System.out.println("User Email Id  is : " + email);
    System.out.println("Password : " + pass);
    System.out.println("Confirm Password : " + cpass);
    session.setAttribute("email", email);
    
    String USER_REGISTRATION_PASSWORD_REGEX = "((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})";
    
    Pattern passwordPattern = Pattern.compile("((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})");
    Matcher passwordMatcher = passwordPattern.matcher(userbean.getPassword());
    boolean passwordValidator = passwordMatcher.matches();
    
    String USER_ERGISTRATION_EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Matcher emailMatcher = emailPattern.matcher(userbean.getEmailid());
    boolean emailValidator = emailMatcher.matches();
    if ((userbean.getFirstname().isEmpty()) && (userbean.getLastname().isEmpty()) && 
      (userbean.getEmailid().isEmpty()) && (userbean.getMobilenumber().isEmpty()) && 
      (userbean.getPassword().isEmpty()) && (userbean.getConfirmpassword().isEmpty()))
    {
      System.err.println("all empty fields from validator...");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      model.addAttribute("passwordError", "Please Enter Password");
      model.addAttribute("confirmpasswordError", "Please Enter Confirm Password");
      return "home";
    }
    if ((userbean.getFirstname().isEmpty()) && (userbean.getLastname().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your lsst Name");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      return "home";
    }
    if ((userbean.getFirstname().isEmpty()) && (userbean.getEmailid().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      return "home";
    }
    if ((userbean.getFirstname().isEmpty()) && (userbean.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "home";
    }
    if ((userbean.getFirstname().isEmpty()) && (userbean.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Passsword");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("passwordError", "Please Enter Password");
      return "home";
    }
    if ((userbean.getFirstname().isEmpty()) && (userbean.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your First Name");
      System.err.println("Please Enter Your Confirm Passsword");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      model.addAttribute("confirmpasswordError", "Please Enter Confirm Password");
      return "home";
    }
    if ((userbean.getLastname().isEmpty()) && (userbean.getEmailid().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      return "home";
    }
    if ((userbean.getLastname().isEmpty()) && (userbean.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "home";
    }
    if ((userbean.getLastname().isEmpty()) && (userbean.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Password");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("passwordError", "Please Enter Your Password");
      return "home";
    }
    if ((userbean.getLastname().isEmpty()) && (userbean.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Last Name");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      return "home";
    }
    if ((userbean.getEmailid().isEmpty()) && (userbean.getMobilenumber().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "home";
    }
    if ((userbean.getEmailid().isEmpty()) && (userbean.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Password");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("passwordError", "Please Enter Your Password");
      return "home";
    }
    if ((userbean.getEmailid().isEmpty()) && (userbean.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Email Id");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      return "home";
    }
    if ((userbean.getMobilenumber().isEmpty()) && (userbean.getPassword().isEmpty()))
    {
      System.err.println("Please Enter Your Password");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("passwordError", "Please Enter Your Password");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "home";
    }
    if ((userbean.getMobilenumber().isEmpty()) && (userbean.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Confirm Password");
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "home";
    }
    if ((userbean.getPassword().isEmpty()) && (userbean.getConfirmpassword().isEmpty()))
    {
      System.err.println("Please Enter Your Password");
      System.err.println("Please Enter Your Confirm Password");
      model.addAttribute("confirmpasswordError", "Please Enter Your Confirm Password");
      model.addAttribute("passwordError", "Please Enter Your Password");
      return "home";
    }
    if (userbean.getFirstname().isEmpty())
    {
      System.err.println("Please Enter Your First Name");
      model.addAttribute("firstnameError", "Please Enter Your First Name");
      return "home";
    }
    if (userbean.getFirstname().matches(".*\\d.*"))
    {
      System.err.println("Your First Name Should not Contains Digits");
      model.addAttribute("firstnameError", "Your First Name Should not Contains Digits");
      return "home";
    }
    if (userbean.getLastname().isEmpty())
    {
      System.err.println("Please Enter Your Last Name");
      model.addAttribute("lastnameError", "Please Enter Your Last Name");
      return "home";
    }
    if (userbean.getLastname().matches(".*\\d.*"))
    {
      System.err.println("Your Last Name Should not Contains Digits");
      model.addAttribute("lastnameError", "Your Last Name Should not Contains Digits");
      return "home";
    }
    if (userbean.getMobilenumber().isEmpty())
    {
      System.err.println("Please Enter Your Mobile Number");
      model.addAttribute("mobileError", "Please Enter Your Mobile Number");
      return "home";
    }
    if (!userbean.getMobilenumber().matches("\\d{10}"))
    {
      System.err.println("Please Enter 10 Digit Mobile Number");
      model.addAttribute("mobileError", "Please Enter 10 Digit Mobile Number");
      return "home";
    }
    if (userbean.getMobilenumber().matches("\\d{10}"))
    {
      String userMobileNumber = userbean.getMobilenumber();
      List<User> mlist = this.userService.getMobilenumber(userMobileNumber);
      int size = mlist.size();
      System.out.println("User Entered Mobile Number : " + userMobileNumber);
      if (size >= 1)
      {
        System.err.println("Mobile number already exist.");
        System.err.println("mobile number of mn:" + userMobileNumber);
        model.addAttribute("mobileError", "Mobile Number You Entered " + userMobileNumber + " already Exist");
        return "home";
      }
    }
    if (userbean.getEmailid().isEmpty())
    {
      System.err.println("Please Enter Your Email Id");
      model.addAttribute("emailError", "Please Enter Your Email Id");
      return "home";
    }
    if (!emailValidator)
    {
      System.err.println("Please Enter Valid Email Id");
      model.addAttribute("emailError", "Please Enter Valid Email Id");
      return "home";
    }
    if (emailValidator)
    {
      String userEmail = userbean.getEmailid();
      List<User> elist = this.userService.getEmail(userEmail);
      
      int size = elist.size();
      if (size >= 1)
      {
        System.out.println("Email of mn:" + userEmail);
        System.err.println("Email Id already Exist.");
        model.addAttribute("emailError", "Email Id You Entered " + userEmail + " already Exist");
        return "home";
      }
    }
    if (userbean.getPassword().isEmpty())
    {
      System.err.println("Please Enter Password");
      model.addAttribute("passwordError", "Please Enter Password");
      return "home";
    }
    if (!passwordValidator)
    {
      System.err.println("Password Should be 6 to 10 Characters");
      model.addAttribute("passwordError", "Password Should be 6 to 10 Characters");
      return "home";
    }
    if (userbean.getConfirmpassword().isEmpty())
    {
      System.err.println("Please enter Confirm Password");
      model.addAttribute("confirmpasswordError", "Confirm Password Should not be Empty");
      return "home";
    }
    if (!userbean.getPassword().equals(userbean.getConfirmpassword()))
    {
      System.err.println("Password and Confirm Password Not match");
      model.addAttribute("confirmpasswordError", "Password and Confirm Password not match");
      return "home";
    }
    userbean.setFirstname(fname);
    userbean.setLastname(lname);
    userbean.setEmailid(email);
    userbean.setPassword(pass);
    userbean.setMobilenumber(mobile);
    userbean.setConfirmpassword(cpass);
    
    this.userService.sendMail(userbean);
    System.out.println("Register Sucessfully");
    User uobj = (User)session.getAttribute("userobj");
    List<Product> plist = this.productService.getAllProducts();
    req.setAttribute("productlist", plist);
    List<Brand> brands = this.brandservice.getAllBrand();
    System.out.println("Size of Brand : " + brands.size());
    long size;
   // long size;
    if (uobj == null) {
      size = 0L;
    } else {
      size = ((Long)session.getAttribute("cartsize")).longValue();
    }
    session.setAttribute("cartsize", Long.valueOf(size));
    List<ProductCategory> pclist = this.categoryService.getCategory();
    req.setAttribute("categorylist", pclist);
    model.addAttribute("brandList", brands);
    model.addAttribute("categorylist", pclist);
    
    req.setAttribute("successMessage", "registered successfully");
    model.addAttribute("successMessage", "Registered Successfully!, Please Verify Your Account");
    return "verifyAccount";
  }
}
