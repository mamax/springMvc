package com.epam.spring.mvc.loggers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

  private static final Logger LOG = Logger.getLogger(LoggingAspect.class.getName());;

  @Before("allLogEventMethods()")
  public void logBefore(JoinPoint joinPoint){
    LOG.info("BEFORE : "+ joinPoint.getTarget().getClass().getSimpleName() + " " +
    joinPoint.getSignature().getName());
  }

  @Pointcut("execution(* *.logEvent(..))")
  private void allLogEventMethods(){}

}
