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
@Table(name="Product")
public class Product
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="productDetailid")
  private long productDetailid;
  @Column(name="productName")
  private String productName;
  @Column(name="UnitPrice")
  private long unitPrice;
  @Column(name="decription")
  @NotNull(message="Decription Field cannot be null")
  private String decription;
  @Column(name="status")
  private String status;
  @Column(name="weight")
  private double weight;
  @Column(name="fileName")
  private String fileName;
  @Column(name="categoryId")
  private long categoryId;
  @Column(name="subcategory")
  private String subcategory;
  @Column(name="brandid")
  private long brandid;
  
  public long getProductDetailid()
  {
    return this.productDetailid;
  }
  
  public void setProductDetailid(long productDetailid)
  {
    this.productDetailid = productDetailid;
  }
  
  public String getProductName()
  {
    return this.productName;
  }
  
  public void setProductName(String productName)
  {
    this.productName = productName;
  }
  
  public long getUnitPrice()
  {
    return this.unitPrice;
  }
  
  public void setUnitPrice(long unitPrice)
  {
    this.unitPrice = unitPrice;
  }
  
  public String getDecription()
  {
    return this.decription;
  }
  
  public void setDecription(String decription)
  {
    this.decription = decription;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public double getWeight()
  {
    return this.weight;
  }
  
  public void setWeight(double weight)
  {
    this.weight = weight;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
  
  public long getCategoryId()
  {
    return this.categoryId;
  }
  
  public long getBrandid()
  {
    return this.brandid;
  }
  
  public void setBrandid(long brandid)
  {
    this.brandid = brandid;
  }
  
  public String getSubcategory()
  {
    return this.subcategory;
  }
  
  public void setSubcategory(String subcategory)
  {
    this.subcategory = subcategory;
  }
  
  public void setCategoryId(long categoryId)
  {
    this.categoryId = categoryId;
  }
}
