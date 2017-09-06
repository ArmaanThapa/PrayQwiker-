package com.qwikr.webapi.service;

import com.qwikr.webapi.domain.Orderdetail;
import com.qwikr.webapi.domain.Statuss;

import java.util.List;

public abstract interface orderDetailService
{
  public abstract void addorderDetail(Orderdetail paramOrderdetail);
  
  public abstract List<Orderdetail> getByOrderId(String paramString);
  
  public abstract List<Orderdetail> viewAll();
  
  public abstract void update(Orderdetail paramOrderdetail);
  
  public abstract List<Orderdetail> getByStatus(Statuss statsus);
  

 




 
  
}
