package com.qwikr.webapi.service;

import com.qwikr.webapi.domain.Brand;
import java.util.List;

public abstract interface BrandService
{
  public abstract void addbrand(Brand paramBrand);
  
  public abstract List<Brand> getAllBrand();
}
