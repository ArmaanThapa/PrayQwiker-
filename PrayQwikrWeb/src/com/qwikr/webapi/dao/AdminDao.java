package com.qwikr.webapi.dao;

import com.qwikr.webapi.domain.Admin;
import java.util.List;

public abstract interface AdminDao
{
  public abstract void addAdmin(Admin paramAdmin);
  
  public abstract List<Admin> getAdminList();
  
  public abstract List<Admin> getAdminMobilenumber(String paramString);
  
  public abstract List<Admin> checkAdminMobilenumber(String paramString);
  
  public abstract List<Admin> getAdminEmail(String paramString);
  
  public abstract List<Admin> checkAdminEmail(String paramString);
  
  public abstract List<Admin> getAdminOrganization(String paramString);
  
  public abstract List<Admin> checkAdminOrganization(String paramString);
  
  public abstract List<Admin> getbyVerificationcode(String paramString);
  
  public abstract void verifyAdminAccount(String paramString1, String paramString2);
  
  public abstract List<Admin> getEmailAndPassword(String paramString1, String paramString2);
}