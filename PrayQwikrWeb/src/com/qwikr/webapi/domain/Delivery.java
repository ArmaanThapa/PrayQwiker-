package com.qwikr.webapi.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="Delivery")
public class Delivery
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="orderid", nullable=false, unique=true)
  private long orderid;
  @Column(name="firstname")
  private String firstname;
@Column(name="lastname")
  private String lastname;
  @Column(name="streetaddress")
  @NotNull(message="Please enter valid address")
  private String streetaddress;
  @Column(name="email")
  @Email(message="please enter valid mail address")
  private String email;
  @Column(name="landmark")
  @Size(min=5, message="landmark is atleast 5 characters long!")
  private String landmark;
  @Column(name="city")
  @Size(min=3, message="city is atleast 3 characters long!")
  @NotNull(message="City cannot be null")
  private String city;
  @Column(name="country")
  @NotNull(message="country Field cannot be empty")
  private String country;
  @Column(name="mobilenumber", columnDefinition="TEXT")
  @NotNull(message="enter mobile number")
  @Size(min=10, message="mobile number is at least 10 chracters long")
  private String mobilenumber;
  @Column(name="zipcode", columnDefinition="TEXT")
  @NotNull(message="zipcode")
  @Size(min=6, message="mobile number is at least 6 chracters long")
  private int zipcode;
  @Column(name="userid")
  private long userid;
  
  public Delivery(String streetaddress, String email, String landmark, String city, String country)
  {
    this.streetaddress = streetaddress;
    this.email = email;
    this.landmark = landmark;
    this.city = city;
    this.country = country;
  }
  
  public Delivery(long userid)
  {
    this.userid = userid;
  }
  
  public Delivery() {}
  
  public long getOrderid()
  {
    return this.orderid;
  }
  
  public void setOrderid(long orderid)
  {
    this.orderid = orderid;
  }
  
  public String getStreetaddress()
  {
    return this.streetaddress;
  }
  
  public void setStreetaddress(String streetaddress)
  {
    this.streetaddress = streetaddress;
  }
  
  public String getLandmark()
  {
    return this.landmark;
  }
  
  public void setLandmark(String landmark)
  {
    this.landmark = landmark;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public void setCity(String city)
  {
    this.city = city;
  }
  
  public String getCountry()
  {
    return this.country;
  }
  
  public void setCountry(String country)
  {
    this.country = country;
  }
  
  public int getZipcode()
  {
    return this.zipcode;
  }
  
  public void setZipcode(int zipcode)
  {
    this.zipcode = zipcode;
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
  
  public String getMobilenumber()
  {
    return this.mobilenumber;
  }
  
  public void setMobilenumber(String mobilenumber)
  {
    this.mobilenumber = mobilenumber;
  }
  
  public long getUserid()
  {
    return this.userid;
  }
  
  public void setUserid(long userid)
  {
    this.userid = userid;
  }
}
