package com.conceptandcoding.demo.java8.anonymous;

public class AnonymounsClassImpl {

    public static void main(String[] args) {
        new AnonymounsDemoInterface(){
            @Deprecated
            public void display() {
                System.out.println("This is an anonymous class implementation of AnonymounsDemoInterface");
            }
        }.display();
    }

}
