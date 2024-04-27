package com.example.melissa.springboot.app.interceptor.springbootinterceptor.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{

  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HandlerMethod controls = ((HandlerMethod)handler);
    logger.info("LoadingTimeInterceptor: preHandle() entrando...." + controls.getMethod().getName());

    long star = System.currentTimeMillis();
    request.setAttribute("start", star);

    Random random = new Random();
    int delay = random.nextInt(500);
    Thread.sleep(delay);
    return true;
  }
  
  private static final Logger logger= LoggerFactory.getLogger(LoadingTimeInterceptor.class);
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    
    long end = System.currentTimeMillis();
    long star = (long) request.getAttribute("start");
    long result = end -star;
    logger.info("Tiempo trascurrido: "+ result + " milisegundos!");
    logger.info("LoadingTimeInterceptor: posHandle() saliendo...." +((HandlerMethod)handler).getMethod().getName() );
    
  }

}
