package com.qwikr.webapi.dao;


import com.qwikr.webapi.domain.ProductSubcategory;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract interface SubcategoryDAO
{
  public abstract void addSubCategory(ProductSubcategory paramProductSubcategory);
  
  public abstract List<ProductSubcategory> getAllSubcategory();
  
  public abstract List<ProductSubcategory> getSubcategoryByCategory(String paramString);
}
