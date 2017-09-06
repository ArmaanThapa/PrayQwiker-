package com.qwikr.webapi.validation;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;




public class doValidation
{
  public boolean validatemobileNumber(String mobilenumber)
  {
    boolean result = false;
    if (mobilenumber.matches("\\d{10}")) {
      result = true;
    }
    return result;
  }
  
  public boolean validateemailId(String email)
  {
    boolean result = false;
    String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    if (email.matches(EMAIL_REGEX)) {
      result = true;
    }
    return result;
  }
  
  public static String checkdigit()
  {
    String s = "";
    for (int i = 1; i <= 50; i++)
    {
      double d1 = Math.random() * 1212.0D;
      double d2 = Math.random() * 2323.0D;
      int r1 = (int)d1;
      int r2 = (int)d2;
      s = ""+r1 + r2;
      if (s.length() == 8) {
        return s;
      }
    }
    return s;
  }
  public static int addrandom()
  {
	  int max=999999999;
		int min=1;
		
		int rand=(int) (Math.random()*max+min);
	
	  return rand;
	  
  }
  public static String generateHash(String transId, String amnt)
  {
		String secret="FF08A997FCD8D8F118404BBB1507F2E9";
		
		
		System.out.println("amount::"+amnt);
	
		long id=1988;
	
		String str = secret.trim()+"|"+amnt.toString().trim()+"|"+id+"|"+transId.trim();
		//System.out.println(str);
		
		try {
			String hash = md5(str);
		
			System.err.println("HashCode"+hash);
			return hash;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String md5(String str) throws Exception {

		MessageDigest m = MessageDigest.getInstance("MD5");

		byte[] data = str.getBytes();

		m.update(data, 0, data.length);

		BigInteger i = new BigInteger(1, m.digest());

		String hash = String.format("%1$032X", i);

		return hash;
	}
	
	public static String checkDate()
	{
		Date date=new Date();
		
		String date1=date.toString();
		
		return date1;
	}
}