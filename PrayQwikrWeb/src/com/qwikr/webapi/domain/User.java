package com.qwikr.webapi.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="userid", nullable=false, unique=true)
  private long userid;
  @Column(name="firstname")
  private String firstname;
  @Column(name="lastname")
  private String lastname;
  @Column(name="emailid")
  private String emailid;
  @Column(name="password")
  private String password;
  @Column(name="confirmpassword")
  private String confirmpassword;
  @Column(name="mobilenumber")
  private String mobilenumber;
  @Column(name="verificationcode")
  private String verificationcode;
  @Column(name="verificationstatus")
  boolean verificationstatus;
  
  public long getUserid()
  {
    return this.userid;
  }
  
  public void setUserid(long userid)
  {
    this.userid = userid;
  }
  
  public String getFirstname()
  {
    return this.firstname;
  }
  
  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }
  
  public String getLastname()
  {
    return this.lastname;
  }
  
  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }
  
  public String getEmailid()
  {
    return this.emailid;
  }
  
  public void setEmailid(String emailid)
  {
    this.emailid = emailid;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getMobilenumber()
  {
    return this.mobilenumber;
  }
  
  public void setMobilenumber(String mobilenumber)
  {
    this.mobilenumber = mobilenumber;
  }
  
  public String getVerificationcode()
  {
    return this.verificationcode;
  }
  
  public void setVerificationcode(String verificationcode)
  {
    this.verificationcode = verificationcode;
  }
  
  public boolean isVerificationstatus()
  {
    return this.verificationstatus;
  }
  
  public void setVerificationstatus(boolean verificationstatus)
  {
    this.verificationstatus = verificationstatus;
  }
  
  public String getConfirmpassword()
  {
    return this.confirmpassword;
  }
  
  public void setConfirmpassword(String confirmpassword)
  {
    this.confirmpassword = confirmpassword;
  }
}
