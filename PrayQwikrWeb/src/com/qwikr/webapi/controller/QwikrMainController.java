package com.qwikr.webapi.controller;


import com.qwikr.webapi.dao.orderDetail;
import com.qwikr.webapi.dao.impl.BranddaoImpl;

import com.qwikr.webapi.domain.Admin;
import com.qwikr.webapi.domain.Brand;
import com.qwikr.webapi.domain.Cart;
import com.qwikr.webapi.domain.CartStatus;
import com.qwikr.webapi.domain.Delivery;
import com.qwikr.webapi.domain.LoginDomain;
import com.qwikr.webapi.domain.Orderdetail;
import com.qwikr.webapi.domain.Product;
import com.qwikr.webapi.domain.ProductCategory;
import com.qwikr.webapi.domain.ProductSubcategory;
import com.qwikr.webapi.domain.Status;
import com.qwikr.webapi.domain.Statuss;
import com.qwikr.webapi.domain.User;
import com.qwikr.webapi.domain.datatransferbean;
import com.qwikr.webapi.service.AdminService;
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
import com.qwikr.webapi.utils.PQ;
import com.qwikr.webapi.validation.doValidation;

import javafx.beans.value.ObservableObjectValue;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.app.VelocityEngine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class QwikrMainController
{



	@Autowired
	orderDetail orderDetail;
	
  @Autowired
  AdminService adminService;
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
  private static HashMap<Integer, ProductCategory> categoryMap;
  private static HashMap<Integer, Product> productMap;
  
  @RequestMapping({"/"})
  public String welcome(@ModelAttribute("pbean") Product pbean, HttpServletRequest request, Model model)
    throws Exception
  {
    System.out.println("i am from home page");
    
    HttpSession session = request.getSession();
    Status sess = (Status)session.getAttribute("session");
    System.err.println("Session is : " + sess);
    
    User uobj = (User)session.getAttribute("userobj");
    List<Product> plist = this.productService.getAllProducts();
    request.setAttribute("productlist", plist);
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
    request.setAttribute("categorylist", pclist);
    model.addAttribute("brandList", brands);
    model.addAttribute("categorylist", pclist);
    
    return "home";
  }
  
  @RequestMapping({"/viewdetail/{ProductDetailid}"})
  public String viewdetail(@ModelAttribute("pbean") Product pbean, @PathVariable("ProductDetailid") long ProductDetailid, HttpServletRequest request, Model model)
    throws Exception
  {
    System.out.println("i am form view details method");
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null)))
    {
      System.err.println("Session Expired");
      return welcome(pbean, request, model);
    }
    System.out.println("product id == " + ProductDetailid);
    Product pobj = this.productService.getProduct(ProductDetailid);
    model.addAttribute("productObj", pobj);
    request.setAttribute("image", pobj.getFileName());
    
    return "product-profile";
  }
  
  @RequestMapping({"/addtocart/{ProductDetailid}"})
  public ModelAndView addtocart(@ModelAttribute("pbean") Product pbean, @PathVariable("ProductDetailid") long productDetailid, HttpServletRequest request, Model model)
  {
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if (uobj != null)
    {
      Product pobj = this.productService.getProduct(productDetailid);
      String processingStatus = CartStatus.Processing.getValue();
      List<Cart> cartlist = this.cartService.getCartByUIdAndPIdAndStatus(uobj.getUserid(), pobj.getProductDetailid(), 
        CartStatus.Processing);
      
      Cart cart = null;
      if ((cartlist != null) && (cartlist.size() > 0)) {
        cart = (Cart)cartlist.get(0);
      }
      if (cart == null)
      {
        cart = new Cart();
        
        cart.setProductid(pobj.getProductDetailid());
        cart.setUserId(uobj.getUserid());
        cart.setQuantity(1L);
        cart.setStatus(CartStatus.Processing.getValue());
        this.cartService.addCart(cart);
      }
      else
      {
        cart.setQuantity(cart.getQuantity() + 1L);
        cart.setStatus(CartStatus.Processing.getValue());
        this.cartService.updateCart(cart);
      }
      List<Product> productlist = this.productService.getAllProducts();
      model.addAttribute("productlist", productlist);
      List<Cart> cartsize = this.cartService.getAllCartProduct(uobj.getUserid());
      long size = 0L;
      for (int i = 0; i < cartsize.size(); i++)
      {
        Cart crt = (Cart)cartsize.get(i);
        size += crt.getQuantity();
      }
      session.setAttribute("cartsize", Long.valueOf(size));
      request.setAttribute("categorylist", this.categoryService.getCategory());
      model.addAttribute("cartSuccess", "Product Added to Cart");
      return new ModelAndView("home2");
    }
    return new ModelAndView("home");
  }
  
  @RequestMapping({"/cartdata/{cart}"})
  public String getcartdata(@PathVariable("cart") String cart, HttpServletRequest request, Model model)
    throws Exception
  {
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, model);
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    System.out.println("User id in Cart Data   :  " + uid);
    
    Product pobj = null;
    Cart crt = null;
    datatransferbean bobj = null;
    long subtotal = 0L;
    long pid = 0L;
    String pname = null;
    String fname = null;
    long price = 0L;
    if ((uobj != null) && (cart != null) && (cart.equalsIgnoreCase("cart")))
    {
      List<Cart> cartlst = this.cartService.getAllCartProduct(uobj.getUserid());
      List<Product> plist = this.productService.getAllProducts();
      List<datatransferbean> cartlist = new ArrayList();
      Iterator itr = cartlst.iterator();
      Iterator<Product> pitr = plist.iterator();
      while (pitr.hasNext())
      {
        pobj = (Product)pitr.next();
        pid = pobj.getProductDetailid();
        fname = pobj.getFileName();
        price = pobj.getUnitPrice();
        pname = pobj.getProductName();
      }
      while (itr.hasNext())
      {
        crt = (Cart)itr.next();
        pobj = this.productService.getProduct(crt.getProductid());
        
        bobj = new datatransferbean();
        bobj.setUserId(crt.getUserId());
        
        bobj.setProductId(pobj.getProductDetailid());
        bobj.setProductId(crt.getProductid());
        
        bobj.setPrice(pobj.getUnitPrice());
        
        bobj.setFileName(pobj.getFileName());
        bobj.setQuantity(crt.getQuantity());
        bobj.setTotalprice(pobj.getUnitPrice() * crt.getQuantity());
        bobj.setStatus(crt.getStatus());
        bobj.setProductName(pobj.getProductName());
        
        subtotal += bobj.getTotalprice();
        cartlist.add(bobj);
      }
      request.setAttribute("cartlist", cartlist);
      session.setAttribute("subtotal", Long.valueOf(subtotal));
      
      return "cartdata";
    }
    if ((uobj != null) && (cart == null))
    {
      List<datatransferbean> cartlist = new ArrayList();
      
      List<Cart> cartlst = this.cartService.getAllCartProduct(uobj.getUserid());
      Iterator itr = cartlst.iterator();
      while (itr.hasNext())
      {
        crt = (Cart)itr.next();
        pobj = this.productService.getProduct(crt.getProductid());
        
        bobj = new datatransferbean();
        
        bobj.setUserId(crt.getUserId());
        
        bobj.setProductId(pobj.getProductDetailid());
        bobj.setPrice(pobj.getUnitPrice());
        bobj.setFileName(pobj.getFileName());
        bobj.setQuantity(crt.getQuantity());
        bobj.setTotalprice(pobj.getUnitPrice() * crt.getQuantity());
        subtotal += bobj.getTotalprice();
        bobj.setStatus(crt.getStatus());
        bobj.setProductName(pobj.getProductName());
        cartlist.add(bobj);
      }
      long size = 0L;
      for (int i = 0; i < cartlst.size(); i++)
      {
        Cart crts = (Cart)cartlst.get(i);
        size += crts.getQuantity();
      }
      session.setAttribute("cartsize", Long.valueOf(size));
      request.setAttribute("cartlist", cartlist);
      session.setAttribute("subtotal", Long.valueOf(subtotal));
      
      return "cartdata";
    }
    model.addAttribute("cartError", "No Items in Cart ");
    return "cartdata";
  }
  
  @RequestMapping({"/addItemToCart/{userId}/{productId}"})
  public String addtoCart(@PathVariable("userId") long userId, @PathVariable("productId") long productId, HttpServletRequest request, Model model)
    throws Exception
  {
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return "/Static/sessionExpire";
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    
    long quantity = 0L;
    List<Cart> cartlist1 = this.cartService.getCartByUIdAndPIdAndStatus(userId, productId, CartStatus.Processing);
    if (cartlist1 != null)
    {
      Cart cart = (Cart)cartlist1.get(0);
      
      quantity = cart.getQuantity();
      if (cart.getQuantity() >= 1L)
      {
        this.productService.getProduct(productId);
        cart.setQuantity(cart.getQuantity() + 1L);
        this.cartService.updateCart(cart);
      }
    }
    session.setAttribute("cartsize", Long.valueOf(quantity));
    request.setAttribute("cartlist", cartlist1);
    
    return getcartdata(null, request, model);
  }
  
  @RequestMapping({"/remove/{userId}/{productId}"})
  public String removefromCart(@PathVariable("userId") long userId, @PathVariable("productId") long productId, HttpServletRequest request, Model model)
    throws Exception
  {
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, model);
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    
    long quantity = 0L;
    List<Cart> cartlist1 = this.cartService.getCartByUIdAndPIdAndStatus(userId, productId, CartStatus.Processing);
    if (cartlist1 != null)
    {
      Cart cart = (Cart)cartlist1.get(0);
      
      quantity = cart.getQuantity();
      if (cart.getQuantity() > 1L)
      {
        this.productService.getProduct(productId);
        cart.setQuantity(quantity - 1L);
        this.cartService.updateCart(cart);
      }
      else
      {
        this.cartService.deleteCart(cart);
      }
    }
    session.setAttribute("cartsize", Long.valueOf(quantity));
    request.setAttribute("cartlist", cartlist1);
    
    return getcartdata(null, request, model);
  }
  
  @RequestMapping({"/removeAllItems/{userId}/{productId}"})
  public String removeAllCartItems(@PathVariable("userId") long userId, @PathVariable("productId") long productId, HttpServletRequest request, Model model)
    throws Exception
  {
    this.cartService.deleteAllCartItems(userId, productId);
    
    return getcartdata(null, request, model);
  }
  
  @RequestMapping({"/verifyCode"})
  public String vefiryCode(@ModelAttribute("verifyCode") User user, @RequestParam("vcode") String vcode, HttpServletRequest request, Model model)
    throws Exception
  {
    System.out.println("in verify code method.........");
    
    HttpSession session = request.getSession();
    
    String mail = (String)session.getAttribute("email");
    System.out.println("Emaill in verify code : " + mail);
    
    System.out.println("verification code is --  " + vcode);
    if (vcode.isEmpty())
    {
      System.err.println("Code is empty.");
      model.addAttribute("vcodeError", "Please Enter Verification Code");
      return "verifyAccount";
    }
    if (!vcode.isEmpty())
    {
      List<User> vcodelist = this.userService.getbyVerificationcode(vcode);
      int size = vcodelist.size();
      if ((size == 0) || (size <= 0))
      {
        System.err.println("Please Enter Correct Verfication Code");
        model.addAttribute("vcodeError", "Please Enter Correct Verfication Code");
        return "verifyAccount";
      }
    }
    this.userService.verifyAccount(vcode, mail);
    
    User uobj = (User)session.getAttribute("userobj");
    List<Product> plist = this.productService.getAllProducts();
    request.setAttribute("productlist", plist);
    List<Brand> brands = this.brandservice.getAllBrand();
    System.out.println("Size of Brand : " + brands.size());
    //long size;
    long size;
    if (uobj == null) {
      size = 0L;
    } else {
      size = ((Long)session.getAttribute("cartsize")).longValue();
    }
    session.setAttribute("cartsize", Long.valueOf(size));
    List<ProductCategory> pclist = this.categoryService.getCategory();
    request.setAttribute("categorylist", pclist);
    model.addAttribute("brandList", brands);
    model.addAttribute("categorylist", pclist);
    model.addAttribute("verifySuccess", "Your Account Verified Successfully");
    return welcome(null, request, model);
  }
  
  @RequestMapping({"/userhome"})
  public String getloginpage(Model model, HttpServletRequest request)
    throws Exception
  {
    System.out.println("i am from user home");
    HttpSession session = request.getSession();
    System.out.println("HttpSession is : " + session);
    boolean status = true;
    if ((session.getAttribute("email") == null) && (session.getAttribute("password") == null))
    {
      System.err.println("Session Expired !");
      return welcome(null, request, model);
    }
    System.out.println("Email id  from session : " + (String)session.getAttribute("email"));
    System.out.println("Password from session  : " + (String)session.getAttribute("password"));
    String mail = (String)session.getAttribute("email");
    String pwd = (String)session.getAttribute("password");
    
    Status sts = (Status)session.getAttribute("session");
    System.err.println("User Session is : " + sts);
    List<LoginDomain> sessionlist = this.loginService.getSessionStatusByEmailAndStatus((String)session.getAttribute("email"), sts);
    System.out.println("sessionlist.size() ----- > " + sessionlist.size());
    if (sessionlist.size() > 0)
    {
      LoginDomain lduid = (LoginDomain)sessionlist.get(0);
      System.out.println("I am from if condition");
      List<User> ulist = this.userService.getLoginVerification((String)session.getAttribute("email"), (String)session.getAttribute("password"), status);
      if (ulist.size() > 0)
      {
        User uobj1 = (User)ulist.get(0);
        session.setAttribute("userobj", uobj1);
      }
      List<Cart> cartsize = this.cartService.getAllCartProduct(lduid.getUserId());
      long size = 0L;
      for (int i = 0; i < cartsize.size(); i++)
      {
        Cart crt = (Cart)cartsize.get(i);
        size += crt.getQuantity();
      }
      System.out.println("cart size is : " + size);
      session.setAttribute("cartsize", Long.valueOf(size));
      List<Brand> brands = this.brandservice.getAllBrand();
      System.out.println("Brand Size : " + brands.size());
      model.addAttribute("brandList", brands);
      model.addAttribute("productlist", this.productService.getAllProducts());
      request.setAttribute("productlist", this.productService.getAllProducts());
      request.setAttribute("categorylist", this.categoryService.getCategory());
      return "home2";
    }
    model.addAttribute("login", "login page");
    return "home2";
  }
  
  @Scope("session")
  @RequestMapping({"/userlogin"})
  public String getUserlogin(@ModelAttribute("ubean") User ubean, HttpServletRequest request, HttpServletResponse response, Model model)
    throws Exception
  {
    System.out.println("i am from user login");
    HttpSession session = request.getSession();
    String email1 = ubean.getEmailid();
    String pass = ubean.getPassword();
    boolean status = true;
    String sessionid = null;
    System.out.println("Email id  : " + email1);
    System.out.println("Password  : " + pass);
    
    System.out.println("Email id  from session : " + (String)session.getAttribute("email"));
    System.out.println("Password from session  : " + (String)session.getAttribute("password"));
    Status sts = (Status)session.getAttribute("session");
    System.err.println("User Session is : " + sts);
    List<LoginDomain> sessionlist = this.loginService.getSessionStatusByEmailAndStatus((String)session.getAttribute("email"), sts);
    System.out.println("sessionlist.size() ----- > " + sessionlist.size());
    if (sessionlist.size() > 0)
    {
      LoginDomain lduid = (LoginDomain)sessionlist.get(0);
      
      System.out.println("I am from if condition");
      List<User> ulist = this.userService.getLoginVerification(email1, pass, status);
      if (ulist.size() > 0)
      {
        User uobj1 = (User)ulist.get(0);
        session.setAttribute("userobj", uobj1);
      }
      List<Cart> cartsize = this.cartService.getAllCartProduct(lduid.getUserId());
      long size = 0L;
      for (int i = 0; i < cartsize.size(); i++)
      {
        Cart crt = (Cart)cartsize.get(i);
        size += crt.getQuantity();
      }
      System.out.println("cart size is : " + size);
      
      session.setAttribute("cartsize", Long.valueOf(size));
      model.addAttribute("brandList", this.brandservice.getAllBrand());
      model.addAttribute("productlist", this.productService.getAllProducts());
      request.setAttribute("productlist", this.productService.getAllProducts());
      request.setAttribute("categorylist", this.categoryService.getCategory());
      
      return "home2";
    }
    User uobj1 = null;
    List<User> userlist = this.userService.getEmailAndPassword(email1, pass);
    session.setAttribute("userlist", userlist);
    if (userlist.size() > 0)
    {
      User userObj = (User)userlist.get(0);
      session.setAttribute("userObj", userObj);
      session.setAttribute("email", userObj.getEmailid());
      session.setAttribute("password", userObj.getPassword());
    }
    else
    {
      if ((email1 == null) && (pass == null)) {
        return welcome(null, request, model);
      }
      System.err.println("Invalid Email Id or Password");
      model.addAttribute("loginError", "Invalid Email Id or Password");
      return "home";
    }
    List<User> ulist = this.userService.getLoginVerification(email1, pass, status);
    session.setAttribute("ulist", ulist);
    if (ulist.size() > 0)
    {
      uobj1 = (User)ulist.get(0);
      
      double ramdom1 = Math.random() * 23000.0D;
      double random2 = Math.random() * 43500.0D;
      session.setAttribute("userobj", uobj1);
      sessionid = "AZuBy" + (int)ramdom1 + "hOSH" + (int)random2;
      List<LoginDomain> ldlist = this.loginService.getbyUserId(uobj1.getUserid());
      if (ldlist.size() == 0)
      {
        LoginDomain login = new LoginDomain(Status.ACTIVE, sessionid, uobj1.getUserid());
        System.out.println("Current User Id : " + uobj1.getUserid());
        
        login.setEmailId(uobj1.getEmailid());
        
        this.loginService.add(login);
        session.setAttribute("session", Status.ACTIVE);
      }
      else
      {
        LoginDomain lobj = (LoginDomain)ldlist.get(0);
        lobj.setStatus(Status.ACTIVE);
        lobj.setSessionID(sessionid);
        this.loginService.update(lobj);
        session.setAttribute("session", Status.ACTIVE);
        session.setAttribute("email", email1);
        session.setAttribute("password", pass);
      }
      if (uobj1 != null)
      {
        List<Cart> cartsize = this.cartService.getAllCartProduct(uobj1.getUserid());
        long size = 0L;
        for (int i = 0; i < cartsize.size(); i++)
        {
          Cart crt = (Cart)cartsize.get(i);
          size += crt.getQuantity();
        }
        session.setAttribute("email", uobj1.getEmailid());
        session.setAttribute("password", uobj1.getPassword());
        session.setAttribute("cartsize", Long.valueOf(size));
        model.addAttribute("brandList", this.brandservice.getAllBrand());
        model.addAttribute("productlist", this.productService.getAllProducts());
        request.setAttribute("productlist", this.productService.getAllProducts());
        request.setAttribute("categorylist", this.categoryService.getCategory());
        
        return "home2";
      }
    }
    else
    {
      model.addAttribute("verifyAccountError", "You Did not Verified Your Email Id,Please Verify ");
      return "verifyCode";
    }
    return "home2";
  }
  
  @RequestMapping({"/userlogout"})
  public String userlogout(HttpServletRequest request, Model model)
    throws Exception
  {
    System.out.println("i am from user logout");
    HttpSession session = request.getSession();
    System.out.println("Session is :" + session);
    User uobj = (User)session.getAttribute("userobj");
    System.out.println("User obj : " + uobj);
    if (uobj == null)
    {
      System.err.println("Your Session Expired");
      model.addAttribute("sessionExpire", "Your Session Expired");
      return "/Static/sessionExpire";
    }
    List<Product> plist = this.productService.getAllProducts();
    request.setAttribute("productlist", plist);
    List<Brand> brands = this.brandservice.getAllBrand();
    System.out.println("Size of Brand : " + brands.size());
    long size;
   // long size;
    if (uobj == null) {
      size = 0L;
    } else {
      size = ((Long)session.getAttribute("cartsize")).longValue();
    }
    long uid = uobj.getUserid();
    System.out.println("User id in logout : " + uid);
    
    List<LoginDomain> llist = this.loginService.getbyUserId(uid);
    LoginDomain lobj = (LoginDomain)llist.get(0);
    lobj.setStatus(Status.INACTIVE);
    this.loginService.update(lobj);
    session.removeAttribute("userobj");
    session.setAttribute("cartsize", Long.valueOf(size));
    List<ProductCategory> pclist = this.categoryService.getCategory();
    request.setAttribute("categorylist", pclist);
    model.addAttribute("brandList", brands);
    model.addAttribute("categorylist", pclist);
    
    return "home";
  }
  
  @RequestMapping({"/setNewPassword"})
  public String changepassword(@ModelAttribute("changePassword") User user, HttpServletRequest request, Model model)
    throws Exception
  {
    System.out.println("in change password process mehtod.....");
    
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, model);
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long ui = ((Long)session.getAttribute("userid")).longValue();
    String id = String.valueOf(ui);
    int uid = Integer.parseInt(id);
    System.out.println("User id in change Password Process  : " + uid);
    
    String oldPassword = user.getPassword();
    String pass = user.getPassword();
    String cpass = user.getConfirmpassword();
    
    System.out.println("Old Password : " + oldPassword);
    System.out.println("New Password  : " + pass);
    System.out.println("Confirm Password :  " + cpass);
    
    this.userService.setPassword(ui, cpass);
    model.addAttribute("newPassSeccess", "Your Password Changed Successfully!, Please Login with new Password");
    return userlogout(request, model);
  }
  
  @RequestMapping({"/verifyEmailByCode"})
  public String verifyEmailByCode(@ModelAttribute("verifyCode") User user, HttpServletRequest request, Model model)
  {
    System.out.println("in verifyEmailByCode method.........");
    HttpSession session2 = request.getSession();
    String mail = (String)session2.getAttribute("email");
    System.out.println("Emaill in verify code : " + mail);
    
    String vcode = user.getVerificationcode();
    System.out.println("verification code is --  " + vcode);
    if (vcode.isEmpty())
    {
      System.err.println("Code is empty.");
      model.addAttribute("codeError", "Please Enter Verification Code");
      return "verifyEmailByCode";
    }
    if (!vcode.isEmpty())
    {
      List<User> vlist = this.userService.getbyVerificationcode(vcode);
      int size = vlist.size();
      if ((size == 0) || (size <= 0))
      {
        System.err.println("Please Enter Correct Verfication Code");
        model.addAttribute("codeError", "Please Enter Correct Verfication Code");
        return "verifyEmailByCode";
      }
    }
    this.userService.verifyEmailByCode(vcode);
    model.addAttribute("verifycode", "Account Verified Successfully");
    return "verifyEmailByCode";
  }
  
  @RequestMapping({"/verifyCodeResult"})
  public String verifyCodeResult(Model model)
  {
    System.out.println("i am form verifyCodeResult");
    return "verifyCodeResult";
  }
  
  @RequestMapping({"/userProfile"})
  public String getuserprofile(@ModelAttribute("viewProfile") User viewProfile, ModelMap model, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    System.out.println("in profile page.");
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, null);
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    System.out.println("User id in User Profile :  " + uid);
    List<User> ulist = this.userService.getUserid(uid);
    int size = ulist.size();
    System.out.println("List Size User Profile : " + size);
    
    model.put("userList", ulist);
    
    return "userProfile";
  }
  
  @RequestMapping({"/updateUserProfile"})
  public String updateUser(Model model, @ModelAttribute("updateUser") User user)
  {
    System.out.println("in update user profile ");
    return "updateUserProfile";
  }
  
  @RequestMapping({"/updateUserProfileProcess"})
  public String updateUserProfileProcess(Model model, @ModelAttribute("updateUser") User user, HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    System.out.println("in update user profile process");
    HttpSession session = request.getSession();
    
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, model);
    }
    String fname = user.getFirstname();
    String lname = user.getLastname();
    if ((fname == null) || (lname == null) || (fname.equals(null)) || (lname.equals(null))) {
      return "updateUserProfile";
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long ui = ((Long)session.getAttribute("userid")).longValue();
    String id = String.valueOf(ui);
    int uid = Integer.parseInt(id);
    System.out.println("User id in User Profile Update Process  : " + uid);
    if ((fname.isEmpty()) && (lname.isEmpty()))
    {
      System.err.println("all empty fields from validator...");
      model.addAttribute("ufirstnameError", "Please Enter Your First Name");
      model.addAttribute("ulastnameError", "Please Enter Your Last Name");
      return "updateUserProfile";
    }
    if (fname.isEmpty())
    {
      System.err.println("Please Enter Your First Name");
      model.addAttribute("ufirstnameError", "Please Enter Your First Name");
      
      return "updateUserProfile";
    }
    if (fname.matches(".*\\d.*"))
    {
      System.err.println("Your First Name Should not Contains Digits");
      model.addAttribute("ufirstnameError", "Your First Name Should not Contains Digits");
      
      return "updateUserProfile";
    }
    if (lname.isEmpty())
    {
      System.err.println("Please Enter Your Last Name");
      model.addAttribute("ulastnameError", "Please Enter Your Last Name");
      
      return "updateUserProfile";
    }
    if (lname.matches(".*\\d.*"))
    {
      System.err.println("Your Last Name Should not Contains Digits");
      model.addAttribute("ulastnameError", "Your Last Name Should not Contains Digits");
      
      return "updateUserProfile";
    }
    System.out.println("Fname : " + fname);
    System.out.println("Lname : " + lname);
    this.userService.updateUserProfile(uid, fname, lname);
    
    List<Product> plist = this.productService.getAllProducts();
    request.setAttribute("productlist", plist);
    List<Brand> brands = this.brandservice.getAllBrand();
    System.out.println("Size of Brand : " + brands.size());
    long size;
    //long size;
    if (uobj == null) {
      size = 0L;
    } else {
      size = ((Long)session.getAttribute("cartsize")).longValue();
    }
    session.setAttribute("cartsize", Long.valueOf(size));
    List<ProductCategory> pclist = this.categoryService.getCategory();
    request.setAttribute("categorylist", pclist);
    model.addAttribute("brandList", brands);
    model.addAttribute("categorylist", pclist);
    
    model.addAttribute("updateProfileSuccess", "Your Profile Name Updated Successfully !");
    System.out.println("User Profile Updated Successfully!");
    
    return getUserlogin(uobj, request, response, model);
  }
  
  @RequestMapping({"/forgottenPassword"})
  public String getforgotpassword(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response, Model model)
    throws Exception
  {
    System.out.println("in forgot password..");
    
    String emailto = user.getEmailid();
    if ((emailto == null) || (emailto.equals(null))) {
      return welcome(null, request, model);
    }
    System.out.println("Email to is :" + emailto);
    
    List<User> ulist = this.userService.getEmail(emailto);
    if ((ulist != null) && (ulist.size() > 0))
    {
      User uobj = (User)ulist.get(0);
      if (uobj != null)
      {
        this.userService.forgotPasswordMail(emailto, user);
        model.addAttribute("forgotError", "Please Check your Email for new Password");
        return "home";
      }
    }
    else
    {
      model.addAttribute("forgotError", "Email Id Does Not Exists");
      
      return "home";
    }
    return "home";
  }
  
  @RequestMapping({"/checkout"})
  public String checkout(@ModelAttribute("delivery") Delivery delivery, HttpServletRequest request, Model modelmap)
    throws Exception
  {
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, modelmap);
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    System.out.println("User id in check out: " + uid);
    List<Delivery> list = this.deliveryService.viewAddressById(uid);
    
    
    
    modelmap.addAttribute("message", "Saved Delivery Address");
    session.setAttribute("deliveryAddress", list);
    modelmap.addAttribute("address", list);
    request.setAttribute("chkout", "chkout");
    return "checkout";
  }
  
  @RequestMapping({"/delete"})
  public String deleteDeliveryAddress(HttpServletRequest request, Model model, Delivery del)
    throws Exception
  {
    System.out.println("in delete address...");
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, model);
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    System.out.println("User id in delete : " + uid);
    
    session.setAttribute("oid", Long.valueOf(del.getOrderid()));
    long oid = ((Long)session.getAttribute("oid")).longValue();
    System.out.println("order id in delete : " + oid);
    
    this.deliveryService.deleteAddressById(uid, oid);
    System.out.println("after calling delete.............. ");
    return checkout(null, request, model);
  }
  
  @RequestMapping({"/update"})
  public String updateDeliveryAddress(@ModelAttribute("updateDeliveryAddress") Delivery delivery, HttpServletRequest request, Model model)
    throws Exception
  {
    HttpSession session2 = request.getSession();
    System.out.println("in update address method.........");
    System.out.println("Order Id in update Address : " + delivery.getOrderid());
    session2.setAttribute("orderId", Long.valueOf(delivery.getOrderid()));
    long oid = ((Long)session2.getAttribute("orderId")).longValue();
    System.out.println("order id in update : " + oid);
    User uobj = (User)session2.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, model);
    }
    session2.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session2.getAttribute("userid")).longValue();
    System.out.println("User id in update Address: " + uid);
    
    model.addAttribute("update", "Update Delivery Address");
    return "updateDeliveryAddress";
  }
  
  @RequestMapping({"/updateDeliveryAddress"})
  public String updateDeliveryAddressProcess(@ModelAttribute("updateDeliveryAddress") Delivery delivery, BindingResult bResult, HttpServletRequest request, Model model)
    throws Exception
  {
    HttpSession session = request.getSession();
    System.out.println("in update address process......");
    String cityName = delivery.getCity();
    if ((cityName == null) || (cityName.equals(null))) {
      return checkout(delivery, request, model);
    }
    System.out.println("City name  : " + cityName);
    
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null))) {
      return welcome(null, request, model);
    }
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    System.out.println("User id in update Address process  : " + uid);
    
    long oid = ((Long)session.getAttribute("orderId")).longValue();
    System.out.println("order id in update process: " + oid);
    
    String fname = delivery.getFirstname();
    String lname = delivery.getLastname();
    String landmark = delivery.getLandmark();
    String city = delivery.getCity();
    String country = delivery.getCountry();
    String email = delivery.getEmail();
    String mobile = delivery.getMobilenumber();
    String street = delivery.getStreetaddress();
    int zip = delivery.getZipcode();
    
    this.deliveryService.updateAddressByOrderId(email, zip, city, country, landmark, fname, lname, mobile, street, uid, 
      oid);
    
    System.out.println("after calling update method..");
    model.addAttribute("updated", "Your Address has been updated successfully");
    return checkout(delivery, request, model);
  }
  
  @RequestMapping({"/addDeliveryAddress"})
  public String addDeliveryAddress(@ModelAttribute("delivery") Delivery delivery, HttpServletRequest request, HttpServletResponse response, Model model)
    throws Exception
  {
    HttpSession session = request.getSession();
    User uobj = (User)session.getAttribute("userobj");
    int zipcode = delivery.getZipcode();
    String zcode = String.valueOf(zipcode);
    String fn = delivery.getFirstname();
    String ln = delivery.getLastname();
    String mail = delivery.getEmail();
    String mnum = delivery.getMobilenumber();
    String city = delivery.getCity();
    String country = delivery.getCountry();
    String str = delivery.getStreetaddress();
    String lm = delivery.getLandmark();
    System.out.println("Fname \t:" + fn);
    System.out.println("Lname \t:" + ln);
    System.out.println("Email \t:" + mail);
    System.out.println("Mobile  :" + mnum);
    System.out.println("City     :" + city);
    System.out.println("Country  :" + country);
    System.out.println("Street   :" + str);
    System.out.println("Zip      :" + zipcode);
    System.out.println("Landmark :" + lm);
    if (mail == null)
    {
      System.out.println("email is empty");
      return checkout(delivery, request, model);
    }
    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    Matcher emailMatcher = emailPattern.matcher(mail);
    boolean emailValidator = emailMatcher.matches();
    if (delivery.getFirstname().matches(".*\\d.*"))
    {
      System.err.println("Your First Name Should not Contains Digits");
      model.addAttribute("firstnameError", "Your First Name Should not Contains Digits");
      return "checkout";
    }
    if (delivery.getLastname().matches(".*\\d.*"))
    {
      System.err.println("Your Last Name Should not Contains Digits");
      model.addAttribute("lastnameError", "Your Last Name Should not Contains Digits");
      return "checkout";
    }
    if (!delivery.getMobilenumber().matches("\\d{10}"))
    {
      System.err.println("Please Enter 10 Digit Mobile Number");
      model.addAttribute("mobileError", "Please Enter 10 Digit Mobile Number");
      return "checkout";
    }
    if (!emailValidator)
    {
      System.err.println("Please Enter Valid Email Id");
      model.addAttribute("emailError", "Please Enter Valid Email Id");
      return "checkout";
    }
    if (delivery.getCity().matches(".*\\d.*"))
    {
      System.err.println("Your City Name Should not Contains Digits");
      model.addAttribute("cityError", "Your City Name Should not Contains Digits");
      return "checkout";
    }
    if (delivery.getCountry().matches(".*\\d.*"))
    {
      System.err.println("Your Country Name Should not Contains Digits");
      model.addAttribute("countryError", "Your Country Name Should not Contains Digits");
      return "checkout";
    }
    if (!zcode.matches("\\d{6}"))
    {
      System.err.println("Please Enter 6 Digit Zipcode");
      model.addAttribute("zipError", "Please Enter 6 Digit Zipcode");
      return "checkout";
    }
    List<Delivery> ldlist = this.deliveryService.getbyUserId(uobj.getUserid());
    Delivery del = new Delivery(uobj.getUserid());
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    System.out.println("Current User Id is : " + uobj.getUserid());
    
    session.setAttribute("firstName", delivery.getFirstname());
    session.setAttribute("lastName", delivery.getLastname());
    session.setAttribute("email", delivery.getEmail());
    session.setAttribute("mobilenumber", delivery.getMobilenumber());
    session.setAttribute("street", delivery.getStreetaddress());
    session.setAttribute("landmark", delivery.getLandmark());
    session.setAttribute("zipcode", Integer.valueOf(delivery.getZipcode()));
    session.setAttribute("city", delivery.getCity());
    session.setAttribute("country", delivery.getCountry());
    delivery.setUserid(uid);
    this.deliveryService.add(delivery);
    request.setAttribute("deliveryobj", delivery);
    model.addAttribute("deliveryAddress", "THis is delivvery Address");
    return checkout(del, request, model);
  }
  
  @RequestMapping({"/goforpayment"})
  public String goforpayment(@ModelAttribute("delivery") Delivery delivery, HttpServletRequest request, HttpServletResponse response, Model model)
    throws Exception
  {
    HttpSession session = request.getSession();
    long orderid = delivery.getOrderid();
    System.out.println();
    System.out.println("Order Id in goforpayment : " + delivery.getOrderid());
    User uobj = (User)session.getAttribute("userobj");
    if ((uobj == null) || (uobj.equals(null)))
    {
      System.err.println("your session expired");
      return welcome(null, request, model);
    }
    Delivery del = new Delivery(uobj.getUserid());
    session.setAttribute("userid", Long.valueOf(uobj.getUserid()));
    long uid = ((Long)session.getAttribute("userid")).longValue();
    System.out.println("Current User Id is : " + uobj.getUserid());
    List<Delivery> list = this.deliveryService.getAddressByOrderId(orderid);
    
   /* int transactionID=orderdetailService.addrandom();
    String strI  = "" + transactionID;
    String amount = ""+session.getAttribute("subtotal");
    String hash=orderdetailService.generateHash( strI,  amount);*/
    
    System.out.println("List Size : " + list.size());
    model.addAttribute("address", list);
    return "paymentDetails";
  }
  
  @RequestMapping({"/placeyourorder"})
  public String getorderdetail(@ModelAttribute("dbean") Delivery dbean, HttpServletRequest request, HttpServletResponse response,
		  HttpSession session,Model model)
    throws Exception
  {
    
    String userName = session.getAttribute("firstName") + " " + session.getAttribute("lastName");
    System.out.println(userName);
    
   long l = System.currentTimeMillis();
   System.out.println(l);
   String transNumber = ""+l;
   System.out.println( "transactionId::"+transNumber);
   String amount = ""+session.getAttribute("subtotal");
  // int transactionId=doValidation.addrandom();
   //String strI  = "" + transactionId;
   String hash=doValidation.generateHash(transNumber,amount);
  
   String date=doValidation.checkDate();
   System.out.println(date);
   String orderId = doValidation.checkdigit();
   
   
    Orderdetail odobj = new Orderdetail();
    String successURL = "http://fgmtest.firstglobalmoney.com:8034/pqshop/response";
    String failureURL = "http://fgmtest.firstglobalmoney.com:8034/pqshop/response";
  // odobj.setDate(date);
   // odobj.setTransactionId(strI);
    odobj.setDate(System.nanoTime()+"");
    odobj.setOrderId(orderId);
    odobj.setTotalpayment(Long.parseLong(amount));
    odobj.setUserName(userName);
    odobj.setTransactionId(transNumber);
    odobj.setEmailId((String)session.getAttribute("email"));
    odobj.setMobileno((String)session.getAttribute("mobilenumber"));
    
    odobj.setTransactionStatus(Statuss.INITIATED);
    System.out.println("Status::::"  +odobj.setTransactionStatus(Statuss.INITIATED));
    
    
    
    
  // this.orderdetailService.addorderDetail(odobj);
    orderDetail.addorderDetail(odobj);
    
  String ecrypt = "amount=" + amount + "&orderId=" + orderId + "&transNumber=" + "QP" + transNumber + 
      "&successURL=" + successURL + "&failureURL=" + failureURL + "&merchantId=2011";
    System.out.println("Before" + ecrypt);
    String fcn = PQ.encrypt(ecrypt);
  model.addAttribute("amount", amount);
    model.addAttribute("transactionId", transNumber);
    model.addAttribute("hash", hash);
    
   String url = "http://fgmtest.firstglobalmoney.com:8035/ws/api/auth";
    return "send";
  }
  
 


/*@RequestMapping(value="/placeyourorder")
  public String getOrderDetails(HttpServletRequest request,
		  HttpServletResponse response,Model model,HttpSession session  )
  {
	  String amount = ""+session.getAttribute("subtotal");
	  System.out.println(amount);
	  
	  Orderdetail orderdetail=new Orderdetail();
	  model.addAttribute("orderdetail",orderdetail.getTotalpayment());
	  
	  
	  return "New";
	  
  }*/
  
  @RequestMapping({"/adminlogin"})
  public ModelAndView adminlogin()
  {
    return new ModelAndView("/Admin/adminlogin");
  }
  
  @Scope("session")
  @RequestMapping({"/adminsignup"})
  public String getAdminlogin(@ModelAttribute("ubean") Admin ubean, HttpServletRequest request, HttpServletResponse response, Model model)
    throws Exception
  {
    System.out.println("i am from admin login");
    HttpSession session = request.getSession();
    String email1 = ubean.getEmail();
    String pass = ubean.getPassword();
    boolean status = true;
    String sessionid = null;
    System.out.println("Email id  : " + email1);
    System.out.println("Password  : " + pass);
    if ((email1.equalsIgnoreCase("prayqwik@gmail.com")) && (pass.equalsIgnoreCase("prayqwik@123")))
    {
      List<User> ulist = this.userService.viewAll();
      request.setAttribute("userlist", ulist);
      List<Product> plist = this.productService.getAllProducts();
      request.setAttribute("productlist", plist);
      List<LoginDomain> alist = this.loginService.getActiveUser();
      request.setAttribute("activeuserlist", alist);
      List<LoginDomain> slist = this.loginService.viewAll();
      request.setAttribute("sessionloglist", slist);
      
      List<Orderdetail> olist = this.orderdetailService.viewAll();
      System.out.println(olist);
      request.setAttribute("orderedlist", olist);
      List<Brand> brlist = this.brandservice.getAllBrand();
      request.setAttribute("allbrands", brlist);
      List<ProductSubcategory> pslist = this.subcategoryservice.getSubcategory();
      request.setAttribute("allsubcategory", pslist);
      List<ProductCategory> pclist = this.categoryService.getCategory();
      request.setAttribute("productCategorylist", pclist);
      List<ProductCategory> allcategorylist = this.categoryService.getAllCategory();
      request.setAttribute("allcategorylist", allcategorylist);
      session.setAttribute("adminemail", email1);
      session.setAttribute("adminpassword", pass);
      model.addAttribute("adminLogin", "Welcome to Admin Panel");
      return "/Admin/adminPanel";
    }
    System.err.println("Invalid Email Id or Password");
    model.addAttribute("loginError", "Invalid Email Id or Password");
    return "/Admin/adminlogin";
  }
  
  @RequestMapping(value={"/addProduct"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String getAddNewProductForm(@ModelAttribute Product pbean, @RequestParam("file") MultipartFile file, HttpServletRequest request, Model model)
    throws IllegalStateException, IOException
  {
    System.out.println("i am from admin login");
    if (file != null)
    {
      String parts = file.getOriginalFilename();
      if ((parts.contains(".png")) || (parts.contains(".PNG")) || (parts.contains(".JPG")) || (parts.contains(".jpg")) || (parts.contains(".jpeg")))
      {
        String rootDirectoryPath = "http://66.207.206.54:8034//QwikrWeb//WebContent//resources//images//uploaded-images";
        System.out.println("rootDirectoryPath   --->   " + rootDirectoryPath);
        System.out.println("Parts -- >   " + parts);
        System.out.println(file.getName() + " " + file.getOriginalFilename() + " " + file.getSize());
        
        File newObj = new File(rootDirectoryPath + "\\" + parts);
        
        newObj.mkdirs();
        System.out.println("Complete Path : --- > " + rootDirectoryPath + "\\" + parts);
        file.transferTo(newObj);
        System.out.println("file Saved Successfully");
        pbean.setFileName(parts);
      }
    }
    this.productService.addProduct(pbean);
    
    List<User> ulist = this.userService.viewAll();
    request.setAttribute("userlist", ulist);
    List<Product> plist = this.productService.getAllProducts();
    request.setAttribute("productlist", plist);
    List<LoginDomain> alist = this.loginService.getActiveUser();
    request.setAttribute("activeuserlist", alist);
    List<LoginDomain> slist = this.loginService.viewAll();
    request.setAttribute("sessionloglist", slist);
    List<Orderdetail> olist = this.orderdetailService.viewAll();
    request.setAttribute("orderedlist", olist);
    List<Brand> brlist = this.brandservice.getAllBrand();
    request.setAttribute("allbrands", brlist);
    List<ProductSubcategory> pslist = this.subcategoryservice.getSubcategory();
    request.setAttribute("allsubcategory", pslist);
    List<ProductCategory> pclist = this.categoryService.getCategory();
    request.setAttribute("productCategorylist", pclist);
    List<ProductCategory> allcategorylist = this.categoryService.getAllCategory();
    request.setAttribute("allcategorylist", allcategorylist);
    
    model.addAttribute("adminLogin", "Welcome to Admin Panel");
    
    return "/Admin/adminPanel";
  }
  
  @RequestMapping(value={"/addcategory"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView addcategory(@ModelAttribute("category") ProductCategory category, HttpServletRequest request, Model model)
  {
    System.out.println("i am from add Category");
    this.categoryService.addCategory(category);
    
    List<User> ulist = this.userService.viewAll();
    request.setAttribute("userlist", ulist);
    List<Product> plist = this.productService.getAllProducts();
    
    request.setAttribute("productlist", plist);
    List<LoginDomain> alist = this.loginService.getActiveUser();
    request.setAttribute("activeuserlist", alist);
    List<LoginDomain> slist = this.loginService.viewAll();
    request.setAttribute("sessionloglist", slist);
    List<Orderdetail> olist = this.orderdetailService.viewAll();
    request.setAttribute("orderedlist", olist);
    List<ProductCategory> pclist = this.categoryService.getCategory();
    request.setAttribute("productCategorylist", pclist);
    
    List<ProductCategory> allcategorylist = this.categoryService.getAllCategory();
    request.setAttribute("allcategorylist", allcategorylist);
    
    List<Brand> brlist = this.brandservice.getAllBrand();
    request.setAttribute("allbrands", brlist);
    
    List<ProductSubcategory> pslist = this.subcategoryservice.getSubcategory();
    request.setAttribute("allsubcategory", pslist);
    return new ModelAndView("/Admin/adminPanel");
  }
  
  @RequestMapping(value={"/addsubcategory"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView addSubCategory(@ModelAttribute ProductSubcategory subcategory, HttpServletRequest request, Model model)
  {
    System.out.println("I am from add subcategory");
    
    this.subcategoryservice.addSubcategory(subcategory);
    
    List<ProductCategory> allcategorylist = this.categoryService.getAllCategory();
    request.setAttribute("allcategorylist", allcategorylist);
    List<ProductSubcategory> pslist = this.subcategoryservice.getSubcategory();
    request.setAttribute("subcategories", pslist);
    System.out.println("after setting attribute.......");
    return new ModelAndView("/Admin/adminPanel");
  }
  
  @RequestMapping(value={"/addbrand"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView addBrand(@ModelAttribute Brand brand, HttpServletRequest request, Model model)
  {
    System.out.println("i am form add brand");
    this.brandservice.addbrand(brand);
    
    List<ProductCategory> allcategorylist = this.categoryService.getAllCategory();
    request.setAttribute("allcategorylist", allcategorylist);
    List<ProductSubcategory> pslist = this.subcategoryservice.getSubcategory();
    request.setAttribute("subcategories", pslist);
    List<Brand> brlist = this.brandservice.getAllBrand();
    request.setAttribute("allbrands", brlist);
    model.addAttribute("allcategorylist", allcategorylist);
    model.addAttribute("allsubcategory", pslist);
    model.addAttribute("allbrands", brlist);
    
    return new ModelAndView("/Admin/adminPanel");
  }
  
  @RequestMapping(value={"/getAllItemsList"}, headers={"Accept=*/*"})
  @ResponseBody
  public List<String> getSearchItemList(@RequestParam("term") String query)
  {
    System.out.println("I am from get Search Item List");
    List<String> matchItem = this.userService.getSearchItem(query);
    System.out.println("Size of List : " + matchItem.size());
    return matchItem;
  }
  
  @RequestMapping(value={"/ajaxOldPasswordValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String ajaxOldPasswordValidator(@ModelAttribute("userbean") User userbean, @RequestParam("password") String opassword, HttpServletRequest request, HttpServletResponse response, Model model)
    throws IOException
  {
    System.out.println("in side old password validator............");
    System.out.println("Old Password : " + opassword);
    List<User> oplist = this.userService.getOldPassword(opassword);
    int size = oplist.size();
    if (size <= 0)
    {
      System.err.println("Old Password doesnot match ");
      
      model.addAttribute("mobileExists", "Mobile Already Exist");
      return "Old Password Doesnot Match";
    }
    return "";
  }
  
  @RequestMapping(value={"/mobilenumberValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String mobilenumberValidator(@ModelAttribute("userbean") User userbean, @RequestParam("number") String mobilenumber, HttpServletRequest request, HttpServletResponse response, Model model)
    throws IOException
  {
    System.out.println("in side mobile validator............");
    System.out.println("Mobile : " + mobilenumber);
    
    List<User> mlist = this.userService.getMobilenumber(mobilenumber);
    int size = mlist.size();
    if (size >= 1)
    {
      System.err.println("Mobile Number already Exist.");
      
      model.addAttribute("mobileExists", "Mobile Already Exist");
      return "Mobile Number already Exist.";
    }
    return "";
  }
  
  @RequestMapping(value={"/ajaxEmailValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String ajaxEmailValidator(@ModelAttribute("userbean") User userbean, @RequestParam("email") String email, HttpServletRequest request, HttpServletResponse response, Model model)
    throws IOException
  {
    System.out.println("in side email validator............");
    System.out.println("email id is  : " + email);
    
    List<User> elist = this.userService.getEmail(email);
    int size = elist.size();
    if (size >= 1)
    {
      System.err.println("Email Id already Exist.");
      
      model.addAttribute("emailExists", "Email Id Already Exist");
      return "Email Id already Exist.";
    }
    return "";
  }
  
  @RequestMapping(value={"/ajaxLoginEmailValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String ajaxLoginEmailValidator(@ModelAttribute("userbean") User userbean, @RequestParam("email") String emailid, HttpServletRequest request, HttpServletResponse response, Model model)
  {
    List<User> loginEmailList = this.userService.getEmail(emailid);
    int size = loginEmailList.size();
    if (size <= 0)
    {
      System.err.println("Email id Does Not Exist");
      
      model.addAttribute("loginFail", "Invalid Email and Password");
      return "Email Id Does Not Exist";
    }
    return "";
  }
  
  @RequestMapping(value={"/ajaxforgotPasswordValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String ajaxforgotPasswordValidator(@ModelAttribute("userbean") User userbean, @RequestParam("email") String emailid, HttpServletRequest request, HttpServletResponse response, Model model)
  {
    List<User> forgotPasswordEmailList = this.userService.getEmail(emailid);
    int size = forgotPasswordEmailList.size();
    if (size <= 0)
    {
      System.err.println("Email id Does Not Exist");
      
      model.addAttribute("loginFail", "Invalid Email and Password");
      return "Email Id Does Not Exist";
    }
    return "";
  }
  
  @RequestMapping(value={"/ajaxVerificationCodeValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String ajaxVerificationCodeValidator(@ModelAttribute("userbean") User userbean, @RequestParam("code") String vcode, HttpServletRequest request, HttpServletResponse response, Model model)
  {
    System.out.println("in side ajaxVerificationCodeValidator............");
    System.out.println("Code id is  : " + vcode);
    List<User> vcodeList = this.userService.getbyVerificationcode(vcode);
    int size = vcodeList.size();
    if (size <= 0)
    {
      System.err.println("Invalid Verification Code");
      model.addAttribute("verifyFail", "Invalid Verification Code");
      return "Invalid Verification Code";
    }
    return "";
  }
  
  @RequestMapping(value={"/ajaxLoginPasswordValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String ajaxLoginPasswordValidator(@ModelAttribute("userbean") User userbean, @RequestParam("email") String emailid, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response, Model model)
  {
    System.out.println("i am form login Password validator");
    System.out.println("email id is  : " + emailid);
    System.out.println("Password is  : " + password);
    
    List<User> eplist = this.userService.getEmailAndPassword(emailid, password);
    int size = eplist.size();
    if (size <= 0)
    {
      System.err.println("Invalid Email Id or Password ");
      model.addAttribute("loginFail", "Invalid Email or Password");
      return "Invalid Email Id or Password ";
    }
    return "";
  }
  
  @RequestMapping(value={"/ajaxUserRegister"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String ajaxUserRegister(@RequestParam("fname") String fname, @RequestParam("lname") String lname, @RequestParam("mobile") String mobile, @RequestParam("mail") String emailid, @RequestParam("pass") String password, @RequestParam("cpass") String cpassword, @ModelAttribute("userbean") User userbean, HttpServletRequest request, Model model, HttpServletRequest req, HttpServletResponse res)
    throws Exception, Exception
  {
    System.out.println("in user sign up mehotd....");
    
    HttpSession session = request.getSession();
    
    System.out.println("First Name : " + fname);
    System.out.println("Last Name : " + lname);
    System.out.println("Mobile NUmber : " + mobile);
    System.out.println("User Email Id  is : " + emailid);
    System.out.println("Password : " + password);
    System.out.println("Confirm Password : " + cpassword);
    session.setAttribute("email", emailid);
    
    userbean.setFirstname(fname);
    userbean.setLastname(lname);
    userbean.setEmailid(emailid);
    userbean.setMobilenumber(mobile);
    userbean.setPassword(password);
    userbean.setConfirmpassword(cpassword);
    this.userService.sendMail(userbean);
    
    System.out.println("Register Sucessfully");
    request.setAttribute("message", "registered successfully");
    model.addAttribute("message", "Registered Successfully!");
    
    return "home";
  }
  
  @RequestMapping({"/ajaxResendVerificationCode"})
  public String ajaxResendVerificationCode(@RequestParam("remailid") String email, @ModelAttribute("verifyCode") User userbean, Model model, HttpServletRequest request)
  {
    System.out.println("i am form resendVerificationCode");
    
    long code = System.currentTimeMillis();
    String vcode = "VQ" + code + "MS";
    System.out.println("Verification Code from resendVerificationCode :  " + vcode);
    System.out.println("Email Id from resendVerificationCode :  " + email);
    this.userService.resendVerificationCode(email, vcode);
    System.out.println("Code sent Successfully");
    model.addAttribute("resendSuccess", "Verification Code has been Sent to your Email");
    
    return "verifyCodeResult";
  }
  
  @RequestMapping(value={"/adminMobilenumberValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String adminMobilenumberValidator(@ModelAttribute("adminbean") Admin admin, @RequestParam("number") String mobilenumber, HttpServletRequest request, HttpServletResponse response, Model model)
    throws IOException
  {
    System.out.println("i am from admin mobile validator");
    System.out.println("Mobile : " + mobilenumber);
    List<Admin> list = this.adminService.getAdminMobilenumber(mobilenumber);
    
    int size = list.size();
    if (size >= 1)
    {
      System.err.println("Mobile Number already Exist.");
      model.addAttribute("mobileExists", "Mobile Already Exist");
      return "Mobile Number already Exist";
    }
    return "";
  }
  
  @RequestMapping(value={"/adminEmailValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String adminEmailValidator(@ModelAttribute("adminbean") Admin admin, @RequestParam("email") String email, HttpServletRequest request, HttpServletResponse response, Model model)
    throws IOException
  {
    System.out.println("i am from admin email validator");
    System.out.println("Email : " + email);
    List<Admin> list = this.adminService.getAdminEmail(email);
    
    int size = list.size();
    if (size >= 1)
    {
      System.err.println("Email Address already Exist.");
      model.addAttribute("emailExists", "Email Id Already Exist");
      return "Email Id already Exist";
    }
    return "";
  }
  
  @RequestMapping(value={"/adminOrganizationValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String adminOrganizationValidator(@ModelAttribute("adminbean") Admin admin, @RequestParam("orgname") String orgname, HttpServletRequest request, HttpServletResponse response, Model model)
    throws IOException
  {
    System.out.println("i am from admin oraganization validator");
    System.out.println("Company Name : " + orgname);
    List<Admin> list = this.adminService.getAdminOrganization(orgname);
    
    int size = list.size();
    if (size >= 1)
    {
      System.err.println("Organization already Exist.");
      model.addAttribute("orgExists", "Organization already Exist");
      return "Organization already Exist";
    }
    return "";
  }
  
  @RequestMapping(value={"/adminVerificationCodeValidator"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String adminVerificationCodeValidator(@ModelAttribute("userbean") Admin admin, @RequestParam("code") String vcode, HttpServletRequest request, HttpServletResponse response, Model model)
  {
    System.out.println("i am from admin VerificationCodeValidator");
    System.out.println("Code id is  : " + vcode);
    List<Admin> vcodeList = this.adminService.getbyVerificationcode(vcode);
    int size = vcodeList.size();
    if (size <= 0)
    {
      System.err.println("Invalid Admin Verification Code");
      model.addAttribute("verifyFail", "Invalid Admin Verification Code");
      return "Invalid Verification Code";
    }
    return "";
  }
  
  @RequestMapping(method=RequestMethod.POST,value=("/success"))
  public String integrating(@ModelAttribute ("dean")Delivery delivery, HttpServletRequest request, HttpServletResponse response,
		  HttpSession session)
  {
	  String  session1=session.getAttribute("firstName") +"" +session.getAttribute("lastName");
	  Orderdetail orderdetail=new Orderdetail();
	//  List<Orderdetail>   statusses= this.orderdetailService.getByStatus(orderdetail.getTransactionId());
	 
	  
	
	 
	  

	  return "ordersuccess";
	  
  }
  @RequestMapping(method=RequestMethod.POST,value=("/failure"))
  public String failure(@ModelAttribute Orderdetail orderdetail,
		  HttpServletRequest request,HttpServletResponse response,Model model)
  {
	  
	  return "fail";
  }
}