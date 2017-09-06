package com.qwikr.webapi.domain;

public enum CartStatus
{
  Processing("Processing"),  Completed("Completed");
  
  private String value;
  
  private CartStatus(String value)
  {
    this.value = value;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setValue(String value)
  {
    this.value = value;
  }
}
