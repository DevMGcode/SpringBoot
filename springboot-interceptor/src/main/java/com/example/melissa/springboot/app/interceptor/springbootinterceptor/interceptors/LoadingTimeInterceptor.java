package com.example.melissa.springboot.app.interceptor.springbootinterceptor.interceptors;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

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

    Map<String, String> json = new HashMap<>();
    json.put("error","no tienes acceso a este recurso");
    json.put("Date",new Date().toString());

    ObjectMapper mapper = new ObjectMapper();
    String jsonString = mapper.writeValueAsString(json);
    response.setContentType("Application/json");
    response.setStatus(401);
    response.getWriter().write(jsonString);
    return false;
    //return true;
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
