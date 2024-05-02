package com.melissa.springboot.app.aop.sprintbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

  @Pointcut("execution(* com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService.*(..))")
  public void greetingLoggerPointCut(){ }

  @Pointcut("execution(* com.melissa.springboot.app.aop.sprintbootaop.services.GreetingService.*(..))")
  public void greetingFooLoggerPointCut(){ }

}
