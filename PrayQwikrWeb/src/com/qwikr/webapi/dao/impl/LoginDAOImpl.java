package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.LoginDao;
import com.qwikr.webapi.domain.LoginDomain;
import com.qwikr.webapi.domain.Status;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDAOImpl
  implements LoginDao
{
  @Autowired
  SessionFactory session;
  
  @Transactional
  public void add(LoginDomain login)
  {
    this.session.getCurrentSession().save(login);
  }
  
  @Transactional
  public LoginDomain get(long id)
  {
    return (LoginDomain)this.session.getCurrentSession().get(LoginDomain.class, Long.valueOf(id));
  }
  
  @Transactional
  public void delete(long id)
  {
    this.session.getCurrentSession().delete(get(id));
  }
  
  @Transactional
  public List<LoginDomain> viewAll()
  {
    return this.session.getCurrentSession().createQuery("FROM LoginDomain").list();
  }
  
  @Transactional
  public void update(LoginDomain login)
  {
    this.session.getCurrentSession().update(login);
  }
  
  @Transactional
  public List<LoginDomain> getActiveUser()
  {
    String active = "ACTIVE";
    return this.session.getCurrentSession().createQuery("from LoginDomain where status='" + active + "'").list();
  }
  
  @Transactional
  public List<LoginDomain> getbyUserId(long userId)
  {
    return this.session.getCurrentSession().createQuery("from LoginDomain where userId='" + userId + "'").list();
  }
  
  @Transactional
  public List<LoginDomain> getBySessionId(String sessionId)
  {
    return this.session.getCurrentSession().createQuery("from LoginDomain where sessionID='" + sessionId + "'").list();
  }
  
  @Transactional
  public List<LoginDomain> getStatusByEmail(String email)
  {
    return this.session.getCurrentSession().createQuery("from LoginDomain where emailId='" + email + "'").list();
  }
  
  @Transactional
  public List<LoginDomain> getSessionStatusByEmailAndStatus(String email, Status status)
  {
    return this.session.getCurrentSession().createQuery("from LoginDomain where emailId='" + email + "' and status='" + status + "'").list();
  }
}