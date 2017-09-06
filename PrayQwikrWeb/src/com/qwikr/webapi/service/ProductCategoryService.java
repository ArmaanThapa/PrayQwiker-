package com.qwikr.webapi.service;

import com.qwikr.webapi.domain.ProductCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract interface ProductCategoryService
{
  public abstract void addCategory(ProductCategory paramProductCategory);
  
  public abstract List<ProductCategory> getAllCategory();
  
  public abstract List<ProductCategory> getCategory();
  
  public abstract List<ProductCategory> getSubCategoryById(long paramLong);
  
  public abstract ProductCategory getProductCategory(long paramLong);
  
  public abstract ProductCategory getParentCategory(ProductCategory paramProductCategory);
  
  public abstract ArrayList<ProductCategory> getChildCategory(ProductCategory paramProductCategory);
  
  public abstract HashMap<Long, ProductCategory> getCategoryMap(List<ProductCategory> paramList);
}