package com.qwikr.webapi.dao;


import com.qwikr.webapi.domain.Orderdetail;
import com.qwikr.webapi.domain.Statuss;

import java.util.List;

public abstract interface orderDetail
{
  public  void addorderDetail(Orderdetail paramOrderdetail);
  
  public  List<Orderdetail> getByOrderId(String paramString);
  
  public  List<Orderdetail> viewAll();
  
  public  void update(Orderdetail paramOrderdetail);
  
 
  List<Orderdetail> getStatus(Statuss transactionStatus);
  
  
  



}
