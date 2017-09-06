package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.SubcategoryDAO;
import com.qwikr.webapi.domain.ProductSubcategory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SubcategoryDAOImpl
  implements SubcategoryDAO
{
  @Autowired
  SessionFactory session;
  
  @Transactional
  public void addSubCategory(ProductSubcategory subcategory)
  {
    this.session.getCurrentSession().save(subcategory);
  }
  
  public List<ProductSubcategory> getAllSubcategory()
  {
    return this.session.getCurrentSession().createQuery("From ProductSubcategory").list();
  }
  
  public List<ProductSubcategory> getSubcategoryByCategory(String category)
  {
    Query query = this.session.getCurrentSession().createQuery("from ProductSubcategory where category=:cat");
    return query.setParameter("cat", category).list();
  }
}