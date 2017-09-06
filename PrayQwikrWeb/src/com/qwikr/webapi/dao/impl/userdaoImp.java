package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.Userdao;
import com.qwikr.webapi.domain.User;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class userdaoImp
  implements Userdao
{
  @Autowired
  SessionFactory session;
  
  @Transactional
  public void add(User user)
  {
    this.session.getCurrentSession().save(user);
  }
  
  @Transactional
  public void resendVerificationCode(String email, String vcode)
  {
    String hql = "UPDATE User set verificationcode = :vcode WHERE emailid = :email";
    Query query = this.session.getCurrentSession().createQuery(hql);
    query.setParameter("email", email);
    query.setParameter("vcode", vcode);
    int result = query.executeUpdate();
    System.out.println("updated records : " + result);
  }
  
  @Transactional
  public void setPassword(long uid, String password)
  {
    String hql = "UPDATE User set password = :password , confirmpassword = :cpassword WHERE userid = :uid";
    Query query = this.session.getCurrentSession().createQuery(hql);
    query.setParameter("password", password);
    query.setParameter("cpassword", password);
    query.setParameter("uid", Long.valueOf(uid));
    int result = query.executeUpdate();
    System.out.println("updated records : " + result);
  }
  
  @Transactional
  public void updateUserProfile(long uid, String fname, String lname)
  {
    String hql = "UPDATE User set firstname = :fn , lastname= :ln  WHERE userid = :uid";
    Query query = this.session.getCurrentSession().createQuery(hql);
    query.setParameter("fn", fname);
    query.setParameter("ln", lname);
    
    query.setParameter("uid", Long.valueOf(uid));
    int result = query.executeUpdate();
    System.out.println("updated UserProfile  records : " + result);
  }
  
  @Transactional
  public List<User> getEncodedPasswordByEmail(String email)
  {
    return this.session.getCurrentSession().createQuery("from User where emailid='" + email + "'").list();
  }
  
  @Transactional
  public void verifyAccount(String code, String email)
  {
    String hqlQuery = "Update User set verificationstatus = :status where verificationcode = :vcode and emailid = :email";
    Query query = this.session.getCurrentSession().createQuery(hqlQuery);
    boolean c = true;
    query.setParameter("status", Boolean.valueOf(c));
    query.setParameter("vcode", code);
    query.setParameter("email", email);
    int result = query.executeUpdate();
    System.out.println("updated records : " + result);
  }
  
  @Transactional
  public void update(User user)
  {
    this.session.getCurrentSession().update(user);
  }
  
  @Transactional
  public List<User> getuserByEmail(String email, String pass)
  {
    if (pass != null) {
      return 
        this.session.getCurrentSession().createQuery("from User where emailid='" + email + "' and password='" + pass + "'").list();
    }
    System.out.println(this.session.getCurrentSession().createQuery("from User where emailid='" + email + "'").list()
      .toString());
    return this.session.getCurrentSession().createQuery("from User where emailid='" + email + "'").list();
  }
  
  @Transactional
  public List<User> viewAll()
  {
    return this.session.getCurrentSession().createQuery("from User").list();
  }
  
  @Transactional
  public List<User> getByPassword(String password)
  {
    return this.session.getCurrentSession().createQuery("from User where password='" + password + "'").list();
  }
  
  @Transactional
  public User getById(long Id)
  {
    return (User)this.session.getCurrentSession().get(User.class, Long.valueOf(Id));
  }
  
  @Transactional
  public List<User> getbyVerificationcode(String verificationcode)
  {
    return 
      this.session.getCurrentSession().createQuery("from User where verificationcode='" + verificationcode + "'").list();
  }
  
  @Transactional
  public List<User> getLoginVerification(String email, String pass, boolean vstatus)
  {
    Query query = this.session.getCurrentSession().createQuery("from User where emailid='" + email + "' and password='" + 
      pass + "' and verificationstatus=" + vstatus);
    List<User> list = query.list();
    System.out.println("Login Size is ---" + list.size());
    return list;
  }
  
  @Transactional
  public void verifyEmailByCode(String code)
  {
    String hqlQuery = "Update User set verificationstatus = :status where verificationcode = :vcode ";
    Query query = this.session.getCurrentSession().createQuery(hqlQuery);
    boolean c = true;
    query.setParameter("status", Boolean.valueOf(c));
    query.setParameter("vcode", code);
    int result = query.executeUpdate();
    System.out.println("verifyEmailByCode updated records : " + result);
  }
  
  @Transactional
  public List<User> getOldPassword(String oldpassword)
  {
    return this.session.getCurrentSession().createQuery("from User where password='" + oldpassword + "'").list();
  }
  
  @Transactional
  public List<User> getMobilenumber(String mobile)
  {
    return this.session.getCurrentSession().createQuery("from User where mobilenumber='" + mobile + "'").list();
  }
  
  @Transactional
  public List<User> getEmail(String email)
  {
    return this.session.getCurrentSession().createQuery("from User where emailid='" + email + "'").list();
  }
  
  @Transactional
  public List<User> getEmailAndPassword(String email, String password)
  {
    Query query = this.session.getCurrentSession().createQuery("from User where password='" + password + "'");
    List<User> list = query.list();
    Iterator<User> itr = list.iterator();
    String pwd = null;
    while (itr.hasNext())
    {
      User usr = (User)itr.next();
      pwd = usr.getPassword();
    }
    return 
      this.session.getCurrentSession().createQuery("from User where emailid='" + email + "'and password='" + password + "'").list();
  }
  
  @Transactional
  public List<User> getUserid(long uid)
  {
    return this.session.getCurrentSession().createQuery("from User where userid=" + uid).list();
  }
  
  public byte[] encrypt(String password)
  {
    byte[] encryptedBytes = null;
    try
    {
      String KEY = "ABCD1234";
      String algo = "DES";
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algo);
      byte[] encBytes = KEY.getBytes("UTF8");
      DESKeySpec keySpecEncrypt = new DESKeySpec(encBytes);
      
      SecretKey keyEncrypt = keyFactory.generateSecret(keySpecEncrypt);
      
      Cipher cipherEncrypt = Cipher.getInstance(algo);
      cipherEncrypt.init(1, keyEncrypt);
      
      return cipherEncrypt.doFinal(password.getBytes());
    }
    catch (Exception e)
    {
      System.err.println("Excetion is : " + e.getMessage());
    }
    return encryptedBytes;
  }
  
  public String decrypt(byte[] encrypted)
  {
    byte[] decryptedBytes = null;
    try
    {
      String KEY = "ABCD1234";
      String algo = "DES";
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algo);
      byte[] encBytes = KEY.getBytes("UTF8");
      DESKeySpec keySpecEncrypt = new DESKeySpec(encBytes);
      
      SecretKey keyEncrypt = keyFactory.generateSecret(keySpecEncrypt);
      
      Cipher cipherEncrypt = Cipher.getInstance(algo);
      
      cipherEncrypt.init(2, keyEncrypt);
      decryptedBytes = cipherEncrypt.doFinal(encrypted);
      return new String(decryptedBytes);
    }
    catch (Exception e)
    {
      System.err.println("Exception is :" + e.getMessage());
    }
    return new String(decryptedBytes);
  }
  
  @Transactional
  public void forgotPasswordEmail(String password, String email)
  {
    String hqlQuery = "Update User set password = '" + password + "' , confirmpassword = '" + password + "' where emailid='" + email + "' ";
    Query query = this.session.getCurrentSession().createQuery(hqlQuery);
    query.executeUpdate();
  }
}