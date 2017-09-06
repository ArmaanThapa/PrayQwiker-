package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.dao.SubcategoryDAO;
import com.qwikr.webapi.domain.ProductSubcategory;
import com.qwikr.webapi.service.SubcategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryServiceImpl
  implements SubcategoryService
{
  @Autowired
  SubcategoryDAO dao;
  
  public void addSubcategory(ProductSubcategory subcategory)
  {
    this.dao.addSubCategory(subcategory);
  }
  
  public List<ProductSubcategory> getSubcategory()
  {
    return this.dao.getAllSubcategory();
  }
  
  public List<ProductSubcategory> getSubcategoryByCategory(String category)
  {
    return this.dao.getSubcategoryByCategory(category);
  }
}
