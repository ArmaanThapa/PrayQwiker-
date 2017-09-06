package com.qwikr.webapi.service;

import com.qwikr.webapi.domain.Product;
import com.qwikr.webapi.domain.ProductCategory;
import java.util.ArrayList;
import java.util.List;

public abstract interface ProductService
{
  public abstract void addProduct(Product paramProduct);
  
  public abstract Product getProduct(long paramLong);
  
  public abstract void deleteProduct(long paramLong);
  
  public abstract void updateProduct(Product paramProduct);
  
  public abstract List<Product> getAllProducts();
  
  public abstract List<Product> getbyName(String paramString);
  
  public abstract List<Product> getProductById(long paramLong);
  
  public abstract ArrayList<Product> getAllProductInCategory(ProductCategory paramProductCategory);
  
  public abstract ArrayList<Product> getProductForCategoryId(long paramLong);
}