package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.dao.Useradmindao;
import com.qwikr.webapi.domain.Admin;
import com.qwikr.webapi.service.UseradminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseradminServiceImp
  implements UseradminService
{
  @Autowired
  Useradmindao dao;
  
  public void add(Admin useradmin)
  {
    this.dao.add(useradmin);
  }
  
  public void update(Admin useradmin)
  {
    this.dao.update(useradmin);
  }
  
  public List<Admin> getByEmail(String email, String pass)
  {
    return this.dao.getByEmail(email, pass);
  }
}