package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.Productdao;
import com.qwikr.webapi.domain.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InMemoryProductdao
  implements Productdao
{
  @Autowired
  SessionFactory session;
  
  @Transactional
  public void add(Product Product)
  {
    this.session.getCurrentSession().save(Product);
  }
  
  @Transactional
  public Product get(long id)
  {
    return (Product)this.session.getCurrentSession().get(Product.class, Long.valueOf(id));
  }
  
  @Transactional
  public void delete(long id)
  {
    this.session.getCurrentSession().delete(get(id));
  }
  
  @Transactional
  public void edit(Product product)
  {
    this.session.getCurrentSession().update(product);
  }
  
  @Transactional
  public List<Product> viewAll()
  {
    return this.session.getCurrentSession().createQuery("FROM Product").list();
  }
  
  public List<Product> getbyName(String name)
  {
    return this.session.getCurrentSession().createQuery("from Product where productName='" + name + "'").list();
  }
  
  @Transactional
  public List<Product> getProductById(long categoryId)
  {
    return this.session.getCurrentSession().createQuery("from Product where brandid=" + categoryId).list();
  }
}
