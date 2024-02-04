package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Around("execution(* org.example.service.*.*(..))")
    @Order(1)
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        System.out.println("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute");
    }


    @Around("execution(* org.example.service.*.*(..))")
    @Order(2)
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        System.out.println("Метод: "+joinPoint.getSignature().getName() + " - "+elapsedTime+" милсек");
        return result;
    }

}
