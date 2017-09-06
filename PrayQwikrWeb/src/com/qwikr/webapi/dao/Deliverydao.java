package com.qwikr.webapi.dao;

import com.qwikr.webapi.domain.Delivery;
import java.util.List;

public abstract interface Deliverydao
{
  public abstract void add(Delivery paramDelivery);
  
  public abstract Delivery get(long paramLong);
  
  public abstract void delete(long paramLong);
  
  public abstract List<Delivery> viewAll();
  
  public abstract void update(Delivery paramDelivery);
  
  public abstract List<Delivery> getbyUserId(long paramLong);
  
  public abstract List<Delivery> getAddress(long paramLong);
  
  public abstract List<Delivery> viewAddressById(long paramLong);
  
  public abstract void deleteAddressById(long paramLong1, long paramLong2);
  
  public abstract void updateAddressByOrderId(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, long paramLong1, long paramLong2);
  
  public abstract List<Delivery> getAddressByOrderId(long paramLong);
}