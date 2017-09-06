package com.qwikr.webapi.dao;

import com.qwikr.webapi.domain.Product;
import java.util.List;

public abstract interface Productdao
{
  public abstract void add(Product paramProduct);
  
  public abstract Product get(long paramLong);
  
  public abstract void delete(long paramLong);
  
  public abstract void edit(Product paramProduct);
  
  public abstract List<Product> viewAll();
  
  public abstract List<Product> getbyName(String paramString);
  
  public abstract List<Product> getProductById(long paramLong);
}
