package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.ProductCategorydao;
import com.qwikr.webapi.domain.ProductCategory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductCategorydaoImpl
  implements ProductCategorydao
{
  @Autowired
  SessionFactory session;
  
  @Transactional
  public void addCategory(ProductCategory category)
  {
    this.session.getCurrentSession().save(category);
  }
  
  @Transactional
  public ProductCategory getProductCategory(long id)
  {
    return (ProductCategory)this.session.getCurrentSession().get(ProductCategory.class, Long.valueOf(id));
  }
  
  @Transactional
  public List<ProductCategory> getAllCategory()
  {
    return this.session.getCurrentSession().createQuery("from ProductCategory").list();
  }
  
  @Transactional
  public List<ProductCategory> getCategory()
  {
    return this.session.getCurrentSession().createQuery("from ProductCategory where parentCategoryId=0").list();
  }
  
  @Transactional
  public List<ProductCategory> getSubCategoryById(long parentCategoryId)
  {
    return this.session.getCurrentSession().createQuery("from ProductCategory where parentCategoryId=" + parentCategoryId).list();
  }
}