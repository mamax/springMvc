package com.epam.spring.mvc.loggers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Map;

@Aspect
public class StatisticsAspect {
  private Map<Class<?>, Integer> counter;

  @AfterReturning("allLogEventMethods()")
  public void count(JoinPoint jp){
    Class<?> claszz = jp.getTarget().getClass();
    if (!counter.containsKey(claszz)){
      counter.put(claszz, 0);
    }
    counter.put(claszz, counter.get(claszz)+1);
  }
}
