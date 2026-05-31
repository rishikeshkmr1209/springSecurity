package com.conceptandcoding.demo.java8;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class corefunctionalinterfaces {
    public static void main(String[] args) {
        String s="hello world";
        Function<String,String> toUpperCase=(str)->str.toUpperCase();
        System.out.println(toUpperCase.apply(s));

        Predicate<String> isGreater=(str)->str.length()>5;
        System.out.println(isGreater.test(s));

        Supplier<String> stringSupplier=()->{ return "Hello from Supplier"; };
        System.out.println(stringSupplier.get());

        Consumer<String> stringConsumer=(str)->System.out.println("Consumed: "+str);
        stringConsumer.accept(s);

        BiFunction<String,String, Integer> stringLength=(str1,str2)->str1.length()+str2.length();
        System.out.println(stringLength.apply("Hello", "World"));

        
    }

}
