package com.qwikr.webapi.dao;

import com.qwikr.webapi.domain.ProductCategory;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract interface ProductCategorydao
{
  public abstract void addCategory(ProductCategory paramProductCategory);
  
  public abstract List<ProductCategory> getAllCategory();
  
  public abstract List<ProductCategory> getCategory();
  
  public abstract ProductCategory getProductCategory(long paramLong);
  
  public abstract List<ProductCategory> getSubCategoryById(long paramLong);
}
