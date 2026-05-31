package com.conceptandcoding.demo.java8.exceptionHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors; // ✅ required

public class ExceptionHandlingDemo {
    public static void main(String[] args) {

        List<Path> paths = List.of(Path.of("a.txt"), Path.of("b.txt"));

        List<String> contents = paths.stream()
                .map(p -> {
                    try {
                        return Files.readString(p);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList()); // ✅ fixed

        contents.forEach(System.out::println);
    }
}