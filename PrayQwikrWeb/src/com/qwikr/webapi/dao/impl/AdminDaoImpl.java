package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.AdminDao;
import com.qwikr.webapi.domain.Admin;
import java.io.PrintStream;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDaoImpl
  implements AdminDao
{
  @Autowired
  SessionFactory session;
  
  @Transactional
  public void addAdmin(Admin admin)
  {
    this.session.getCurrentSession().save(admin);
  }
  
  @Transactional
  public List<Admin> getAdminList()
  {
    List<Admin> adminList = this.session.getCurrentSession().createQuery("from Admin").list();
    return adminList;
  }
  
  @Transactional
  public void verifyAdminAccount(String vcode, String email)
  {
    System.out.println("VCode : " + vcode);
    String hqlQuery = "Update Admin set VerificationStatus = :status where VerificationCode = :vcode and Email = :email";
    Query query = this.session.getCurrentSession().createQuery(hqlQuery);
    boolean c = true;
    query.setParameter("status", Boolean.valueOf(c));
    query.setParameter("vcode", vcode);
    query.setParameter("email", email);
    int result = query.executeUpdate();
    System.out.println("updated records : " + result);
  }
  
  @Transactional
  public List<Admin> getAdminMobilenumber(String mobilenumber)
  {
    System.out.println(this.session.getCurrentSession().createQuery("from Admin where MobileNumber='" + mobilenumber + "'"));
    return this.session.getCurrentSession().createQuery("from Admin where MobileNumber='" + mobilenumber + "'").list();
  }
  
  @Transactional
  public List<Admin> getAdminEmail(String email)
  {
    String hqlQuery = "from Admin where Email='" + email + "'";
    Query query = this.session.getCurrentSession().createQuery(hqlQuery);
    System.out.println(query);
    List<Admin> mlist = query.list();
    System.out.println("list size from getemail() : " + mlist.size());
    
    return mlist;
  }
  
  @Transactional
  public List<Admin> getEmailAndPassword(String email, String password)
  {
    return this.session.getCurrentSession().createQuery("from Admin where Email='" + email + "' and Password='" + password + "'").list();
  }
  
  @Transactional
  public List<Admin> getAdminOrganization(String organization)
  {
    return this.session.getCurrentSession().createQuery("from Admin where ComanyName='" + organization + "'").list();
  }
  
  @Transactional
  public List<Admin> checkAdminMobilenumber(String mobilenumber)
  {
    System.out.println("I am from check MObile number in ADMinDAO");
    System.out.println("Mobile Number fro AdminDAOIMpl : " + mobilenumber);
    Query query = this.session.getCurrentSession().createQuery("from Admin where MobileNumber=" + mobilenumber);
    List<Admin> list = query.list();
    System.out.println("Login Size is ---" + list.size());
    
    return list;
  }
  
  @Transactional
  public List<Admin> checkAdminEmail(String email)
  {
    String hqlQuery = "from Admin where Email='" + email + "'";
    Query query = this.session.getCurrentSession().createQuery(hqlQuery);
    System.out.println(query);
    List<Admin> mlist = query.list();
    System.out.println("list size from getemail() : " + mlist.size());
    
    return mlist;
  }
  
  @Transactional
  public List<Admin> checkAdminOrganization(String organization)
  {
    return this.session.getCurrentSession().createQuery("from Admin where ComanyName='" + organization + "'").list();
  }
  
  @Transactional
  public List<Admin> getbyVerificationcode(String vcode)
  {
    return this.session.getCurrentSession().createQuery("from Admin where VerificationCode='" + vcode + "'").list();
  }
}