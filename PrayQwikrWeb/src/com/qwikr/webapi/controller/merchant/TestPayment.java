package com.qwikr.webapi.controller.merchant;

import java.math.BigInteger;
import java.security.MessageDigest;

public class TestPayment 
{
	public static void main(String [] args)
	{
		String secret="FF08A997FCD8D8F118404BBB1507F2E9";
		String id="1988";
		String amount="10";
		String transactionID="1245637";
		String str=secret.trim()+"|"+id+"|"+amount.trim().toString()+"|"+transactionID.trim();
		
		
		try {
			String hash=md5(str);
			System.out.println(hash);
			
			
		} catch (Exception e) 
		{
		}
	}
	public static String md5(String str) throws Exception
	{
		MessageDigest digest=MessageDigest.getInstance("MD5");
		byte[] data=str.getBytes();
		digest.update(data, 0, data.length);
		BigInteger i=new BigInteger(1,digest.digest());
		String hash=String.format("%1$032X", i);
		return hash;
		
	}

}
