package com.qwikr.webapi.interceptor;


import com.qwikr.webapi.domain.Admin;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditingInterceptor
  extends HandlerInterceptorAdapter
{
  Logger logger = Logger.getLogger("auditLogger");
  private String email;
  private String productDetailid;
  
  public boolean preHandle(Admin admin, HttpServletRequest request, HttpServletResponse arg1, Object handler)
    throws Exception
  {
    System.out.println("in preHandle of AudintingIntercepter..");
    if ((request.getRequestURI().endsWith("addProduct")) && (request.getMethod().equals("POST")))
    {
      this.email = admin.getEmail();
      
      System.err.println("Email in audit ---- > " + this.email);
      this.productDetailid = request.getParameterValues("productDetailid")[0];
      System.err.println("productDetailid  --- > " + this.productDetailid);
    }
    return true;
  }
  
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
    throws Exception
  {
    System.out.println("in afterCompletion of AudintingIntercepter..");
    if ((request.getRequestURI().endsWith("addProduct")) && (response.getStatus() == 302)) {
      this.logger.info(String.format("A New product[%s] Added by %s on %s", new Object[] { this.productDetailid, this.email, getCurrentTime() }));
    }
  }
  
  private String getCurrentTime()
  {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    return formatter.format(calendar.getTime());
  }
}
