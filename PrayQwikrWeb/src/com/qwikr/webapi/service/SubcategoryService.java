package com.qwikr.webapi.service;

import com.qwikr.webapi.domain.ProductSubcategory;
import java.util.List;

public abstract interface SubcategoryService
{
  public abstract void addSubcategory(ProductSubcategory paramProductSubcategory);
  
  public abstract List<ProductSubcategory> getSubcategory();
  
  public abstract List<ProductSubcategory> getSubcategoryByCategory(String paramString);
}