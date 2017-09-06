package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.Deliverydao;
import com.qwikr.webapi.domain.Delivery;
import java.io.PrintStream;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InMemoryDeliverydao
  implements Deliverydao
{
  @Autowired
  SessionFactory session;
  
  public void add(Delivery delivery)
  {
    this.session.getCurrentSession().save(delivery);
  }
  
  public Delivery get(long id)
  {
    return (Delivery)this.session.getCurrentSession().get(Delivery.class, Long.valueOf(id));
  }
  
  public void delete(long id)
  {
    this.session.getCurrentSession().delete(get(id));
  }
  
  public List<Delivery> viewAll()
  {
    return this.session.getCurrentSession().createQuery("FROM Delivery").list();
  }
  
  public List<Delivery> getAddressByOrderId(long oid)
  {
    return this.session.getCurrentSession().createQuery("From Delivery where orderid = " + oid).list();
  }
  
  public void update(Delivery login)
  {
    this.session.getCurrentSession().update(login);
  }
  
  @Transactional
  public List<Delivery> viewAddressById(long userId)
  {
    System.out.println("in inmemory delivery dao.....");
    String hql = "from Delivery WHERE userid = " + userId;
    System.out.println("after query in immemory delivery.............. ");
    return this.session.getCurrentSession().createQuery(hql).list();
  }
  
  @Transactional
  public void deleteAddressById(long userId, long orderId)
  {
    System.out.println("in inmemory delivery dao of delete address.....");
    String hql = "delete from Delivery WHERE userid = " + userId + " and  orderid =" + orderId;
    Query query = this.session.getCurrentSession().createQuery(hql);
    System.out.println("after query in delete address by id in imemmory del...");
    int result = query.executeUpdate();
    System.out.println("Deleted Records .. " + result);
  }
  
  @Transactional
  public void updateAddressByOrderId(String email, int zip, String city, String country, String landmark, String fname, String lname, String mobile, String street, long uid, long oid)
  {
    System.out.println("in inmemory delivery dao of update address.....");
    String queryString = "UPDATE Delivery set firstname = :firstname, lastname= :lastname, email = :email, mobilenumber = :mobile,city= :city , country = :coun, streetaddress = :street,landmark = :landmark , zipcode = :zip WHERE orderid = :orid  and userid = :urid ";
    
    Query query = this.session.getCurrentSession().createQuery(queryString);
    
    query.setParameter("email", email);
    query.setParameter("zip", Integer.valueOf(zip));
    query.setParameter("city", city);
    query.setParameter("coun", country);
    query.setParameter("firstname", fname);
    query.setParameter("lastname", lname);
    query.setParameter("mobile", mobile);
    query.setParameter("landmark", landmark);
    query.setParameter("street", street);
    query.setParameter("urid", Long.valueOf(uid));
    query.setParameter("orid", Long.valueOf(oid));
    int result = query.executeUpdate();
    
    System.out.println("updated  delivery address records : " + result);
  }
  
  @Transactional
  public List<Delivery> getbyUserId(long userId)
  {
    return this.session.getCurrentSession().createQuery("from Delivery where userid='" + userId + "'").list();
  }
  
  public List<Delivery> getAddress(long userId)
  {
    return this.session.getCurrentSession().createQuery("from Delivery where userid='" + userId + "'").list();
  }
}