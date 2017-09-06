package com.qwikr.webapi.service.impl;

import com.qwikr.webapi.dao.Branddao;
import com.qwikr.webapi.domain.Brand;
import com.qwikr.webapi.service.BrandService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandServiceImpl
  implements BrandService
{
  @Autowired
  Branddao brandService;
  
  @Transactional
  public void addbrand(Brand brand)
  {
    this.brandService.addbrand(brand);
  }
  
  public List<Brand> getAllBrand()
  {
    return this.brandService.getAllBrand();
  }
}
