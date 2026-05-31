package com.conceptandcoding.demo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class MyCustomFilter1 implements Filter {

    @Override
    public void init(jakarta.servlet.FilterConfig filterConfig) throws ServletException {
        System.out.println("Initializing MyCustomFilter1");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Inside MyCustomFilter1 doFilter method");
        chain.doFilter(request, response);
        System.out.println("Exiting MyCustomFilter1 doFilter method");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying MyCustomFilter1");
    }

}
