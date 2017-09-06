package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.dao.Deliverydao;
import com.qwikr.webapi.domain.Delivery;
import com.qwikr.webapi.service.DeliveryService;
import java.io.PrintStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliveryServiceImp
  implements DeliveryService
{
  @Autowired
  Deliverydao dao;
  
  @Transactional
  public void add(Delivery delivery)
  {
    this.dao.add(delivery);
  }
  
  @Transactional
  public Delivery get(long id)
  {
    return this.dao.get(id);
  }
  
  @Transactional
  public void delete(long id)
  {
    this.dao.delete(id);
  }
  
  @Transactional
  public List<Delivery> viewAll()
  {
    return this.dao.viewAll();
  }
  
  @Transactional
  public List<Delivery> getAddressByOrderId(long oid)
  {
    return this.dao.getAddressByOrderId(oid);
  }
  
  @Transactional
  public void update(Delivery delivery)
  {
    this.dao.update(delivery);
  }
  
  public List<Delivery> getbyUserId(long userId)
  {
    return this.dao.getbyUserId(userId);
  }
  
  public List<Delivery> getAddress(long userId)
  {
    return this.dao.getAddress(userId);
  }
  
  public List<Delivery> viewAddressById(long userId)
  {
    System.out.println("in viewaddress of delivery service....");
    return this.dao.viewAddressById(userId);
  }
  
  @Transactional
  public void deleteAddressById(long userId, long orderId)
  {
    System.out.println("delte address from delivery service impl...");
    this.dao.deleteAddressById(userId, orderId);
  }
  
  @Transactional
  public void updateAddressByOrderId(String email, int zip, String city, String country, String landmark, String fname, String lname, String mobile, String street, long uid, long oid)
  {
    System.out.println("update address from delivery service impl...");
    this.dao.updateAddressByOrderId(email, zip, city, country, landmark, fname, lname, mobile, street, uid, oid);
  }
}