package com.qwikr.webapi.controller;

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
import org.apache.velocity.app.VelocityEngine;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QwikrAjaxController
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
}
