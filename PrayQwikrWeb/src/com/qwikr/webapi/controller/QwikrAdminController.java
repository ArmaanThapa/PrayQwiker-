package com.qwikr.webapi.controller;


import com.qwikr.webapi.domain.Admin;
import com.qwikr.webapi.domain.Product;
import com.qwikr.webapi.domain.ProductCategory;
import com.qwikr.webapi.domain.ProductSubcategory;
import com.qwikr.webapi.dto.AdminDto;
import com.qwikr.webapi.service.AdminService;
import com.qwikr.webapi.service.BrandService;
import com.qwikr.webapi.service.CartService;
import com.qwikr.webapi.service.DeliveryService;
import com.qwikr.webapi.service.LoginService;
import com.qwikr.webapi.service.ProductCategoryService;
import com.qwikr.webapi.service.ProductService;
import com.qwikr.webapi.service.SubcategoryService;
import com.qwikr.webapi.service.UserService;
import com.qwikr.webapi.service.orderDetailService;
import java.io.PrintStream;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QwikrAdminController
{
  @Autowired
  AdminService adminService;
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
  
  @RequestMapping({"/AdminRegister"})
  public ModelAndView adminRegister()
  {
    return new ModelAndView("/Admin/adminRegister");
  }
  
  @RequestMapping({"/adminsignin"})
  public String adminsignin(@ModelAttribute("adminReg") AdminDto adminDto, HttpServletRequest request, HttpServletResponse res, Model model)
  {
    System.out.println("I am from admin signup");
    
    HttpSession session = request.getSession();
    String fname = adminDto.getFirstname();
    String lname = adminDto.getLastname();
    String mobile = adminDto.getMobilenumber();
    String email = adminDto.getEmail();
    String orgname = adminDto.getOrganization();
    String pass = adminDto.getPassword();
    String cpass = adminDto.getConfirmpassword();
    session.setAttribute("email", adminDto.getEmail());
    Admin adminDomain = new Admin();
    String ADMIN_REGISTRATION_PASSWORD_REGEX = "((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})";
    
    Pattern passwordPattern = Pattern.compile("((?=.*[a-zA-Z\\d~!@#$%^&*()]).{6,10})");
    Matcher passwordMatcher = passwordPattern.matcher(adminDto.getPassword());
    boolean passwordValidator = passwordMatcher.matches();
    
    String ADMIN_ERGISTRATION_EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Matcher emailMatcher = emailPattern.matcher(adminDto.getEmail());
    boolean emailValidator = emailMatcher.matches();
    
    System.out.println("Fname  : " + fname);
    System.out.println("lname  : " + lname);
    System.out.println("mobile : " + mobile);
    System.out.println("email  : " + email);
    System.out.println("orgname  : " + orgname);
    System.out.println("pass   : " + pass);
    System.out.println("cpass  : " + cpass);
    if (adminDto.getFirstname().matches(".*\\d.*"))
    {
      System.err.println("Your First Name Should not Contains Digits");
      model.addAttribute("firstnameError", "Your First Name Should not Contains Digits");
      return "/Admin/adminRegister";
    }
    if (adminDto.getLastname().matches(".*\\d.*"))
    {
      System.err.println("Your Last Name Should not Contains Digits");
      model.addAttribute("lastnameError", "Your Last Name Should not Contains Digits");
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
      
      List<Admin> mlist = this.adminService.checkAdminMobilenumber(adminMobile);
      int size = mlist.size();
      System.out.println("Admin Entered Mobile Number : " + adminMobile);
      if (size >= 1)
      {
        System.err.println("Mobile number already exist.");
        System.err.println("mobile number of mn:" + adminMobile);
        model.addAttribute("mobileError", "Mobile Number You Entered already Exist");
        return "/Admin/adminRegister";
      }
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
    if (!passwordValidator)
    {
      System.err.println("Password Should be 6 to 10 Characters");
      model.addAttribute("passwordError", "Password Should be 6 to 10 Characters");
      return "/Admin/adminRegister";
    }
    if (!adminDto.getPassword().equals(adminDto.getConfirmpassword()))
    {
      System.err.println("Password and Confirm Password Not match");
      model.addAttribute("confirmpasswordError", "Password and Confirm Password not match");
      return "/Admin/adminRegister";
    }
    adminDomain.setFirstname(fname);
    adminDomain.setLastname(lname);
    adminDomain.setMobilenumber(mobile);
    adminDomain.setEmail(email);
    adminDomain.setOrganization(orgname);
    adminDomain.setPassword(pass);
    this.adminService.addAdmin(adminDomain, request, res);
    System.out.println("Registered Successfully!");
    model.addAttribute("regSuccess", "Registered Successfully, Please Verify Your Account");
    return "/Admin/adminVerifyAccount";
  }
  
  @RequestMapping({"/adminVerifyAccount"})
  public String vefiryCode(@ModelAttribute("verifyCode") Admin admin, HttpServletRequest request, Model model)
  {
    System.out.println("i am form admin verify code");
    String vcode = admin.getVerificationcode();
    HttpSession session2 = request.getSession();
    String mail = (String)session2.getAttribute("email");
    System.out.println("Emaill in verify code : " + mail);
    
    System.out.println("verification code is --  " + vcode);
    if (!vcode.isEmpty())
    {
      List<Admin> vcodelist = this.adminService.getbyVerificationcode(vcode);
      int size = vcodelist.size();
      if ((size == 0) || (size <= 0))
      {
        System.err.println("Please Enter Correct Verfication Code");
        model.addAttribute("vcodeError", "Please Enter Correct Verfication Code");
        return "/Admin/adminVerifyAccount";
      }
    }
    this.adminService.verifyAdminAccount(vcode, mail);
    
    model.addAttribute("verifySuccess", "Your Account Verified Successfully");
    return "/Admin/adminlogin";
  }
  
  @RequestMapping({"/adminlogout"})
  public String adminlogout(HttpServletRequest request)
  {
    HttpSession session = request.getSession();
    session.removeAttribute("adminuser");
    session.invalidate();
    return "/Admin/adminlogin";
  }
  
  @RequestMapping(value={"/childCategory"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView getchildcategorylist(HttpServletRequest request, Model model)
  {
    long categoryId = Long.parseLong(request.getParameter("Id"));
    List<Product> productList = new ArrayList();
    ProductCategory productCategory = this.categoryService.getProductCategory(categoryId);
    
    ArrayList<ProductCategory> subCategorylist = (ArrayList)this.categoryService
      .getSubCategoryById(categoryId);
    if ((subCategorylist != null) && (subCategorylist.size() > 0))
    {
      request.setAttribute("childCategorylist", subCategorylist);
    }
    else
    {
      productList = this.productService.getProductById(categoryId);
      request.setAttribute("productlist", productList);
      return new ModelAndView("/Admin/producthome");
    }
    return new ModelAndView("/Admin/childcategory");
  }
  
  @RequestMapping(value={"/getSubCategoryList"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView getSubCategoryList(HttpServletRequest request)
  {
    List<ProductCategory> pcategorylist = null;
    if ((request.getParameter("ajax") != null) && (request.getParameter("ajax").equals("subcategory")))
    {
      long subcategoryId = Long.parseLong(request.getParameter("subCategoryId"));
      
      pcategorylist = this.categoryService.getSubCategoryById(subcategoryId);
    }
    else
    {
      long brandId = Long.parseLong(request.getParameter("brandId"));
      pcategorylist = this.categoryService.getSubCategoryById(brandId);
    }
    request.setAttribute("pcategorylist", pcategorylist);
    return new ModelAndView("/Admin/dropdownlist");
  }
  
  @RequestMapping(value={"/getSubcategoriesrelatedtospecificcategory"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public List<ProductSubcategory> getSubcategoriesrelatedtospecificcategory(@RequestParam("category") String category, Model model, HttpServletRequest req)
  {
    System.out.println("i am from getSubcategoriesrelatedtospecificcategory()");
    String cat = req.getParameter("categoryName");
    List<ProductSubcategory> sblist = this.subcategoryservice.getSubcategoryByCategory(cat);
    model.addAttribute("addsubcategories", sblist);
    for (ProductSubcategory productSubcategory : sblist) {
      System.out.println(productSubcategory);
    }
    return sblist;
  }
}