package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.orderDetail;
import com.qwikr.webapi.domain.Orderdetail;
import com.qwikr.webapi.domain.ProductCategory;
import com.qwikr.webapi.domain.Statuss;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InMemoryOrderDetaildao
  implements orderDetail
{
  
@Autowired
  SessionFactory session;
  
  @Transactional
  public void addorderDetail(Orderdetail orderdetail)
  {
    this.session.getCurrentSession().save(orderdetail);
  }
  
  @Transactional
  public List<Orderdetail> viewAll()
  {
    return this.session.getCurrentSession().createQuery("from Orderdetail").list();
  }
  
  @Transactional
  public List<Orderdetail> getByOrderId(String orderId)
  {
    return this.session.getCurrentSession().createQuery("from Orderdetail where orderId='" + orderId + "'").list();
  }
  
  @Transactional
  public void update(Orderdetail ordobj)
  {
    this.session.getCurrentSession().update(ordobj);
  }

  @Transactional
  public List<Orderdetail> getStatus(Statuss transactionStatus)
  {
    return this.session.getCurrentSession().createQuery("from order_del where transactionStatus=" + transactionStatus).list();
  }

 
  
  







	

}