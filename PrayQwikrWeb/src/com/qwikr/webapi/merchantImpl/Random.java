package com.qwikr.webapi.merchantImpl;

import org.springframework.stereotype.Controller;

@Controller
public class Random {

	public  static double randomm()
	{
		int max=999999999;
		int min=1;
		
		double rand=Math.random()*max+min;
		return  rand;
		

	}

}
