package com.conceptandcoding.demo.exception;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

@Component
public class DefaultAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, java.lang.reflect.Method method, Object... params) {
        System.out.println("Exception message - " + ex.getMessage());
        System.out.println("Method name - " + method.getName());
        for (Object param : params) {
            System.out.println("Parameter value - " + param);
        }

}
}
