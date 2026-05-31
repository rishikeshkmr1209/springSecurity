package com.conceptandcoding.demo.collection;

import java.util.*;

public class ImmutableCollectionsDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        var listunmodifiable = Collections.unmodifiableList(list);
        System.out.println("Unmodifiable List: " + listunmodifiable);
        list.add("B");
        
        // Using List.of() to create an immutable list
        var immutableList = List.of("A", "B", "C");
        System.out.println("Immutable List: " + immutableList);

        // Using Set.of() to create an immutable set
        var immutableSet = Set.of("X", "Y", "Z");
        System.out.println("Immutable Set: " + immutableSet);

        // Using Map.of() to create an immutable map
        var immutableMap = Map.of("key1", "value1", "key2", "value2");
        System.out.println("Immutable Map: " + immutableMap);
        
    }

}


