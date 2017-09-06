package com.qwikr.webapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductBrand")
public class Brand
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="brandId")
  private long brandId;
  @Column(name="brandName")
  private String brandName;
  @Column(name="category")
  private String category;
  @Column(name="subcategory")
  private String subcategory;
  
  public long getBrandId()
  {
    return this.brandId;
  }
  
  public void setBrandId(long brandId)
  {
    this.brandId = brandId;
  }
  
  public String getBrandName()
  {
    return this.brandName;
  }
  
  public void setBrandName(String brandName)
  {
    this.brandName = brandName;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public void setCategory(String category)
  {
    this.category = category;
  }
  
  public String getSubcategory()
  {
    return this.subcategory;
  }
  
  public void setSubcategory(String subcategory)
  {
    this.subcategory = subcategory;
  }
}
