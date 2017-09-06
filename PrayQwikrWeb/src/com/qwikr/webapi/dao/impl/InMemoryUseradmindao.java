package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.Useradmindao;
import com.qwikr.webapi.domain.Admin;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InMemoryUseradmindao
  implements Useradmindao
{
  @Autowired
  SessionFactory session;
  
  @Transactional
  public void add(Admin uadmin)
  {
    this.session.getCurrentSession().save(uadmin);
  }
  
  @Transactional
  public void update(Admin uadmin)
  {
    this.session.getCurrentSession().update(uadmin);
  }
  
  @Transactional
  public List<Admin> getByEmail(String email, String pass)
  {
    return this.session.getCurrentSession().createQuery("from Adminuser where email='" + email + "' and password='" + pass + "'").list();
  }
}