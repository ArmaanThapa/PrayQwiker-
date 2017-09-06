package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.dao.LoginDao;
import com.qwikr.webapi.domain.LoginDomain;
import com.qwikr.webapi.domain.Status;
import com.qwikr.webapi.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl
  implements LoginService
{
  @Autowired
  LoginDao logindao;
  
  public void add(LoginDomain login)
  {
    this.logindao.add(login);
  }
  
  public LoginDomain get(long id)
  {
    return this.logindao.get(id);
  }
  
  public void delete(long id)
  {
    this.logindao.delete(id);
  }
  
  public List<LoginDomain> viewAll()
  {
    return this.logindao.viewAll();
  }
  
  public void update(LoginDomain login)
  {
    this.logindao.update(login);
  }
  
  public List<LoginDomain> getActiveUser()
  {
    return this.logindao.getActiveUser();
  }
  
  public List<LoginDomain> getbyUserId(long userId)
  {
    return this.logindao.getbyUserId(userId);
  }
  
  public List<LoginDomain> getBySessionId(String sessionId)
  {
    return this.logindao.getBySessionId(sessionId);
  }
  
  public List<LoginDomain> getStatusByEmail(String email)
  {
    return this.logindao.getStatusByEmail(email);
  }
  
  public List<LoginDomain> getSessionStatusByEmailAndStatus(String email, Status status)
  {
    return this.logindao.getSessionStatusByEmailAndStatus(email, status);
  }
}