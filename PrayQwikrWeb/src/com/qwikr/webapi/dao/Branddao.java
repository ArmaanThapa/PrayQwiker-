package com.qwikr.webapi.dao;

import com.qwikr.webapi.domain.Brand;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract interface Branddao
{
  public abstract void addbrand(Brand paramBrand);
  
  public abstract List<Brand> getAllBrand();
}
