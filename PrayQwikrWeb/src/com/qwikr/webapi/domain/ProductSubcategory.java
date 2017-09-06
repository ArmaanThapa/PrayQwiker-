package com.qwikr.webapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prod_subcat")
public class ProductSubcategory
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="subcat_id")
  private long subcategoryId;
  @Column(name="subcategory")
  private String subcategory;
  @Column(name="category")
  private String category;
  
  public long getSubcategoryId()
  {
    return this.subcategoryId;
  }
  
  public void setSubcategoryId(long subcategoryId)
  {
    this.subcategoryId = subcategoryId;
  }
  
  public String getSubcategory()
  {
    return this.subcategory;
  }
  
  public void setSubcategory(String subcategory)
  {
    this.subcategory = subcategory;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public void setCategory(String category)
  {
    this.category = category;
  }
}
