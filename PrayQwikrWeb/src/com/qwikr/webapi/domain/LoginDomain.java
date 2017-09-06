package com.qwikr.webapi.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="session_log")
public class LoginDomain
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id", unique=true, nullable=false)
  private long id;
  @Column(name="session_id")
  private String sessionID;
  @Column(name="userId")
  private long userId;
  @Enumerated(EnumType.STRING)
  @Column(name="status")
  private Status status;
  @Column(name="emailId")
  private String emailId;
  
  public LoginDomain() {}
  
  public LoginDomain(Status status, String sessionID, long userId)
  {
    this.status = status;
    this.sessionID = sessionID;
    this.userId = userId;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public void setId(long id)
  {
    this.id = id;
  }
  
  public Status getStatus()
  {
    return this.status;
  }
  
  public void setStatus(Status status)
  {
    this.status = status;
  }
  
  public String getSessionID()
  {
    return this.sessionID;
  }
  
  public void setSessionID(String sessionID)
  {
    this.sessionID = sessionID;
  }
  
  public long getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(long userId)
  {
    this.userId = userId;
  }
  
  public String getEmailId()
  {
    return this.emailId;
  }
  
  public void setEmailId(String emailId)
  {
    this.emailId = emailId;
  }
}
