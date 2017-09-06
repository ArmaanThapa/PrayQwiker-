package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.dao.Productdao;
import com.qwikr.webapi.domain.Product;
import com.qwikr.webapi.domain.ProductCategory;
import com.qwikr.webapi.service.ProductService;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp
  implements ProductService
{
  @Autowired
  ProductCategoryServiceImpl pcservice;
  @Autowired
  Productdao dao;
  
  public void addProduct(Product product)
  {
    this.dao.add(product);
  }
  
  public void deleteProduct(long id)
  {
    this.dao.delete(id);
  }
  
  public void updateProduct(Product product)
  {
    this.dao.edit(product);
  }
  
  public Product getProduct(long id)
  {
    return this.dao.get(id);
  }
  
  public List<Product> getAllProducts()
  {
    return this.dao.viewAll();
  }
  
  public List<Product> getbyName(String name)
  {
    return this.dao.getbyName(name);
  }
  
  public List<Product> getProductById(long categoryId)
  {
    return this.dao.getProductById(categoryId);
  }
  
  public ArrayList<Product> getAllProductInCategory(ProductCategory category)
  {
    ArrayList<ProductCategory> ccs = this.pcservice.getChildCategory(category);
    ArrayList<Product> plist = new ArrayList();
    if (ccs.size() != 0) {
      for (ProductCategory c : ccs)
      {
        plist.addAll(getProductForCategoryId(c.getId()));
        System.out.println("=============cid========" + c.getId());
        getAllProductInCategory(c);
      }
    }
    System.out.println("=========plistplist==========" + plist.size());
    return plist;
  }
  
  public ArrayList<Product> getProductForCategoryId(long categoryId)
  {
    ArrayList<Product> prod = new ArrayList();
    for (Product product : getAllProducts()) {
      if (product.getCategoryId() == categoryId) {
        prod.add(product);
      }
    }
    return prod;
  }
}