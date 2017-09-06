package com.qwikr.webapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productcategory")
public class ProductCategory
{
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long Id;
  @Column(name="parentCategoryId")
  private long parentCategoryId;
  @Column(name="category")
  private String categoryName;
  
  public long getId()
  {
    return this.Id;
  }
  
  public void setId(long id)
  {
    this.Id = id;
  }
  
  public String getCategoryName()
  {
    return this.categoryName;
  }
  
  public void setCategoryName(String categoryName)
  {
    this.categoryName = categoryName;
  }
  
  public long getParentCategoryId()
  {
    return this.parentCategoryId;
  }
  
  public void setParentCategoryId(long parentCategoryId)
  {
    this.parentCategoryId = parentCategoryId;
  }
}
