package com.qwikr.webapi.dao.impl;

import com.qwikr.webapi.dao.Branddao;
import com.qwikr.webapi.domain.Brand;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BranddaoImpl
  implements Branddao
{
  @Autowired
  SessionFactory session;
  
  @Transactional
  public void addbrand(Brand brand)
  {
    this.session.getCurrentSession().save(brand);
  }
  
  public List<Brand> getAllBrand()
  {
    return this.session.getCurrentSession().createQuery("From Brand").list();
  }
  
  
  public  double main(double d) 
	{
		int max=999999999;
		int min=1;
		
		double rand=Math.random()*max+min;
		return rand;
		

	}
}
