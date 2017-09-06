package com.qwikr.webapi.interceptor;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceMonitorInterceptor
  implements HandlerInterceptor
{
  ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal();
  Logger logger = Logger.getLogger(getClass());
  
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
  {
    this.logger.info("I am from preHandle");
    StopWatch stopWatch = new StopWatch(handler.toString());
    stopWatch.start(handler.toString());
    this.stopWatchLocal.set(stopWatch);
    this.logger.info("Accessing URL path: " + getURLPath(request).toString());
    this.logger.info("Request processing started on: " + getCurrentTime());
    return true;
  }
  
  public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    throws Exception
  {
    this.logger.info("I am from postHandle");
    this.logger.info("Request processing ended on " + getCurrentTime());
  }
  
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
    throws Exception
  {
    this.logger.info("I am from after Completion");
    StopWatch stopWatch = (StopWatch)this.stopWatchLocal.get();
    stopWatch.stop();
    this.logger.info("Total time taken for processing: " + stopWatch.getTotalTimeMillis() + " ms");
    this.stopWatchLocal.set(null);
    this.logger.info("=======================================================");
  }
  
  private String getURLPath(HttpServletRequest request)
  {
    String currentPath = request.getRequestURI().toString();
    String queryString = request.getQueryString();
    queryString = "?" + queryString;
    return currentPath + queryString;
  }
  
  private String getCurrentTime()
  {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    return formatter.format(calendar.getTime());
  }
}
