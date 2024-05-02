package com.melissa.springboot.app.aop.sprintbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {
  private Logger logger = LoggerFactory.getLogger(getClass());

  @Before("execution(String com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService.*(..))")
  public void loggerBefore(JoinPoint joinPoint){
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("Antes:" + method + " con los argumentos " + args); 
  }

  @After("execution(String com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService.*(..))")
  public void loggerAfter(JoinPoint joinPoint){
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("Despues:" + method + " con los argumentos " + args); 
  }

  @AfterReturning("execution(String com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService.*(..))")
  public void loggerAfterReturning(JoinPoint joinPoint){
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("Despues de retornar:" + method + " con los argumentos " + args); 
  }

  @AfterThrowing("execution(String com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService.*(..))")
  public void loggerAfterThrowing(JoinPoint joinPoint){
    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());
    logger.info("Despues lanzar la excepcion:" + method + " con los argumentos " + args); 
  }
}
