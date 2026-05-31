package com.conceptandcoding.demo.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {
    public static void main(String[] args) {
        List<String> failFastList = new ArrayList<>();
        failFastList.add("A");
        failFastList.add("B");
        failFastList.add("C");  
        Iterator<String> iterator = failFastList.iterator();
        while(iterator.hasNext()){
            iterator.next();
            
            //failFastList.add("D"); // This will throw ConcurrentModificationException
        }
        System.out.println("Fail-Fast List: " + failFastList);

        CopyOnWriteArrayList<String> failSafeList = new CopyOnWriteArrayList<>();
        failSafeList.add("A");
        failSafeList.add("B");
        failSafeList.add("C");
        Iterator<String> failSafeIterator = failSafeList.iterator();
        while(failSafeIterator.hasNext()){
            failSafeIterator.next();
            failSafeList.add("D"); // This will NOT throw an exception
        }
        System.out.println("Fail-Safe List: " + failSafeList);
    }

}
