package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.dao.orderDetail;
import com.qwikr.webapi.domain.Orderdetail;
import com.qwikr.webapi.domain.Statuss;
import com.qwikr.webapi.service.orderDetailService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class orderDetailServiceImp
  implements orderDetailService
{
  
@Autowired
  orderDetail orderdao;
  
  
  @Transactional
  public  void addorderDetail(Orderdetail orderdetail)
  {
    this.orderdao.addorderDetail(orderdetail);
  }
  
  @Transactional
  public List<Orderdetail> getByOrderId(String orderId)
  {
    return this.orderdao.getByOrderId(orderId);
  }
  
  @Transactional
  public List<Orderdetail> viewAll()
  {
    return this.orderdao.viewAll();
  }
  
  public void update(Orderdetail ordobj)
  {
    this.orderdao.update(ordobj);
  }
  
  @Transactional
  public List<Orderdetail> getByStatus(Statuss transactionStatus)
  {
	return  this.orderdao.getStatus(transactionStatus);
  }

 






 
 
}