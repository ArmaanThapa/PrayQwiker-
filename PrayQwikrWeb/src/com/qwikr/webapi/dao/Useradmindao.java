package com.qwikr.webapi.dao;


import com.qwikr.webapi.domain.Admin;
import java.util.List;

public abstract interface Useradmindao
{
  public abstract void add(Admin paramAdmin);
  
  public abstract void update(Admin paramAdmin);
  
  public abstract List<Admin> getByEmail(String paramString1, String paramString2);
}
