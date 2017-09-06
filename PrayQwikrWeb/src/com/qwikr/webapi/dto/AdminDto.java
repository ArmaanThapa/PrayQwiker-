package com.qwikr.webapi.dto;

public class AdminDto
{
  private String firstname;
  private String lastname;
  private String email;
  private String mobilenumber;
  private String organization;
  private String password;
  private String confirmpassword;
  
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
  
  public String getMobilenumber()
  {
    return this.mobilenumber;
  }
  
  public void setMobilenumber(String mobilenumber)
  {
    this.mobilenumber = mobilenumber;
  }
  
  public String getOrganization()
  {
    return this.organization;
  }
  
  public void setOrganization(String organization)
  {
    this.organization = organization;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
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
