package com.conceptandcoding.demo.model;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {

    public int value() default 0;
    public String name() default "Default Name";


}
