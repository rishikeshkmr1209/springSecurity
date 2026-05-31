package com.conceptandcoding.demo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class MyCustomFilter2 implements Filter {

    @Override
    public void init(jakarta.servlet.FilterConfig filterConfig) throws ServletException {
        System.out.println("Initializing MyCustomFilter2");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Inside MyCustomFilter2 doFilter method");
        chain.doFilter(request, response);
        System.out.println("Exiting MyCustomFilter2 doFilter method");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying MyCustomFilter2");
    }

}
