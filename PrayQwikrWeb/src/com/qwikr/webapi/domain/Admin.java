package com.qwikr.webapi.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Admin")
public class Admin
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GenericGenerator(name="ref", strategy="increment")
  @GeneratedValue(generator="ref")
  @Column(name="Adminid", nullable=false, unique=true)
  private long adminid;
  @Column(name="Firstname")
  private String firstname;
  @Column(name="Lastname")
  private String lastname;
  @Column(name="Email")
  private String email;
  @Column(name="MobileNumber")
  private String mobilenumber;
  @Column(name="ComanyName")
  private String organization;
  @Column(name="Password")
  private String password;
  @Column(name="VerificationCode")
  private String verificationcode;
  @Column(name="VerificationStatus")
  private boolean verificationstatus;
  
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
  
  public String getOrganization()
  {
    return this.organization;
  }
  
  public void setOrganization(String organization)
  {
    this.organization = organization;
  }
  
  public long getAdminid()
  {
    return this.adminid;
  }
  
  public void setAdminid(long adminid)
  {
    this.adminid = adminid;
  }
  
  public String getMobilenumber()
  {
    return this.mobilenumber;
  }
  
  public void setMobilenumber(String mobilenumber)
  {
    this.mobilenumber = mobilenumber;
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
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
}
