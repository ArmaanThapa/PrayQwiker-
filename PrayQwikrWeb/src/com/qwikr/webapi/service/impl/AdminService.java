package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.domain.Admin;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface AdminService
{
	

  public abstract String addAdmin(Admin paramAdmin, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  public abstract List<Admin> getAdminList();
  
  public abstract List<Admin> getAdminMobilenumber(String paramString);
  
  public abstract List<Admin> checkAdminMobilenumber(String paramString);
  
  public abstract List<Admin> checkAdminEmail(String paramString);
  
  public abstract List<Admin> getAdminEmail(String paramString);
  
  public abstract List<Admin> getAdminOrganization(String paramString);
  
  public abstract List<Admin> checkAdminOrganization(String paramString);
  
  public abstract List<Admin> getbyVerificationcode(String paramString);
  
  public abstract void verifyAdminAccount(String paramString1, String paramString2);
  
  public abstract List<Admin> getEmailAndPassword(String paramString1, String paramString2);
}