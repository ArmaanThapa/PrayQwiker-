package com.qwikr.webapi.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Cart")
public class Cart
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="cartid", nullable=false, unique=true)
  private long cartid;
  @Column(name="userId", nullable=false)
  private long userId;
  @Column(name="productid", nullable=false)
  private long productid;
  @Column(name="quantity", nullable=false)
  @NotNull(message="please enter valid quantity")
  private long quantity;
  @Column(name="status")
  private String status;
  
  public long getCartid()
  {
    return this.cartid;
  }
  
  public void setCartid(long cartid)
  {
    this.cartid = cartid;
  }
  
  public long getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(long userId)
  {
    this.userId = userId;
  }
  
  public long getProductid()
  {
    return this.productid;
  }
  
  public void setProductid(long productid)
  {
    this.productid = productid;
  }
  
  public long getQuantity()
  {
    return this.quantity;
  }
  
  public void setQuantity(long quantity)
  {
    this.quantity = quantity;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
}
