package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.dao.ProductCategorydao;
import com.qwikr.webapi.domain.ProductCategory;
import com.qwikr.webapi.service.ProductCategoryService;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl
  implements ProductCategoryService
{
  @Autowired
  ProductCategorydao categorydao;
  
  public void addCategory(ProductCategory category)
  {
    this.categorydao.addCategory(category);
  }
  
  public List<ProductCategory> getAllCategory()
  {
    return this.categorydao.getAllCategory();
  }
  
  public List<ProductCategory> getCategory()
  {
    return this.categorydao.getCategory();
  }
  
  public ProductCategory getProductCategory(long id)
  {
    return this.categorydao.getProductCategory(id);
  }
  
  public List<ProductCategory> getSubCategoryById(long parentCategoryId)
  {
    return this.categorydao.getSubCategoryById(parentCategoryId);
  }
  
  public ArrayList<ProductCategory> getChildCategory(ProductCategory category)
  {
    ArrayList<ProductCategory> cs = new ArrayList();
    ArrayList<ProductCategory> allCategory = (ArrayList)getAllCategory();
    for (ProductCategory cat : allCategory)
    {
      System.out.println("======cat===========" + cat.getCategoryName());
      if (cat.getParentCategoryId() == category.getId()) {
        cs.add(cat);
      }
    }
    return cs;
  }
  
  public ProductCategory getParentCategory(ProductCategory category)
  {
    HashMap<Long, ProductCategory> categoryMap = getCategoryMap(getAllCategory());
    return (ProductCategory)categoryMap.get(Long.valueOf(category.getParentCategoryId()));
  }
  
  public HashMap<Long, ProductCategory> getCategoryMap(List<ProductCategory> categories)
  {
    HashMap<Long, ProductCategory> map = new HashMap();
    for (ProductCategory category : getAllCategory()) {
      map.put(Long.valueOf(category.getId()), category);
    }
    return map;
  }
}