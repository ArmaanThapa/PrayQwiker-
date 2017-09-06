package com.qwikr.webapi.dao;

import com.qwikr.webapi.domain.LoginDomain;
import com.qwikr.webapi.domain.Status;
import java.util.List;

public abstract interface LoginDao
{
  public abstract void add(LoginDomain paramLoginDomain);
  
  public abstract LoginDomain get(long paramLong);
  
  public abstract void delete(long paramLong);
  
  public abstract List<LoginDomain> viewAll();
  
  public abstract void update(LoginDomain paramLoginDomain);
  
  public abstract List<LoginDomain> getActiveUser();
  
  public abstract List<LoginDomain> getbyUserId(long paramLong);
  
  public abstract List<LoginDomain> getBySessionId(String paramString);
  
  public abstract List<LoginDomain> getStatusByEmail(String paramString);
  
  public abstract List<LoginDomain> getSessionStatusByEmailAndStatus(String paramString, Status paramStatus);
}
