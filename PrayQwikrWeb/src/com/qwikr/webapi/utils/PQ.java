package com.qwikr.webapi.utils;

import java.net.URLEncoder;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PQ
{
  private static final String ALGO = "AES";
  private static final String WORKING_KEY = "PAYQWIKJMQWIKRPY";
  
  public static void main(String[] args)
  {
    String passwordEnc = "Could not enc";
    String passwordDec = "Counld not dec";
  }
  
  public static String encrypt(String Data)
    throws Exception
  {
    Key key = generateKey("PAYQWIKJMQWIKRPY");
    Cipher c = Cipher.getInstance("AES");
    c.init(1, key);
    byte[] encVal = c.doFinal(Data.getBytes());
    String encryptedValue = new BASE64Encoder().encode(encVal);
    String URL = URLEncoder.encode(encryptedValue, "UTF-8");
    return URL;
  }
  
  public static String decrypt(String encryptedData)
    throws Exception
  {
    Key key = generateKey("PAYQWIKJMQWIKRPY");
    Cipher c = Cipher.getInstance("AES");
    c.init(2, key);
    byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
    byte[] decValue = c.doFinal(decordedValue);
    String decryptedValue = new String(decValue);
    return decryptedValue;
  }
  
  private static Key generateKey(String workingKey)
    throws Exception
  {
    byte[] keyValue = workingKey.getBytes();
    Key key = new SecretKeySpec(keyValue, "AES");
    return key;
  }
}