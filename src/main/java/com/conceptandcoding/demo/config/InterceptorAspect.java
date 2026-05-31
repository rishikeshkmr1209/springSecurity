package com.conceptandcoding.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InterceptorAspect {

    @Around("@annotation(com.conceptandcoding.demo.model.MyCustomAnnotation)")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before method execution: " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        System.out.println("After method execution: " + joinPoint.getSignature());
        return result;
    }

}
