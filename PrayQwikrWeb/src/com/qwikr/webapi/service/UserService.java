package com.qwikr.webapi.service;

import com.qwikr.webapi.domain.User;
import java.util.List;

public abstract interface UserService
{
  public abstract void add(User paramUser);
  
  public abstract void update(User paramUser);
  
  public abstract List<User> getuserByEmail(String paramString1, String paramString2);
  
  public abstract List<User> viewAll();
  
  public abstract List<User> getByPassword(String paramString);
  
  public abstract User getById(long paramLong);
  
  public abstract List<User> getbyVerificationcode(String paramString);
  
  public abstract void sendMail(User paramUser);
  
  public abstract void setPassword(long paramLong, String paramString);
  
  public abstract void verifyAccount(String paramString1, String paramString2);
  
  public abstract void updateUserProfile(long paramLong, String paramString1, String paramString2);
  
  public abstract List<User> getLoginVerification(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void verifyEmailByCode(String paramString);
  
  public abstract List<User> getOldPassword(String paramString);
  
  public abstract List<User> getMobilenumber(String paramString);
  
  public abstract List<User> getEmail(String paramString);
  
  public abstract List<User> getEmailAndPassword(String paramString1, String paramString2);
  
  public abstract List<User> getUserid(long paramLong);
  
  public abstract void resendVerificationCode(String paramString1, String paramString2);
  
  public abstract byte[] encrypt(String paramString);
  
  public abstract String decrypt(byte[] paramArrayOfByte);
  
  public abstract void forgotPasswordMail(String paramString, User paramUser);
  
  public abstract List<User> getEncodedPasswordByEmail(String paramString);
  
  public abstract List<String> getSearchItem(String paramString);
}