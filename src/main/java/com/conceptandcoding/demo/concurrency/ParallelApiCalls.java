package com.conceptandcoding.demo.concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class ParallelApiCalls {
    public static void main(String[] args) {
        List<CompletableFuture<String>> futures = List.of(
            callApi("API1"),
            callApi("API2"),
            callApi("API3"),
            callApi("API4"),
            callApi("API5")
        );

        List<String> results = futures.stream()
            .map(f -> f.completeOnTimeout("Timeout", 2, TimeUnit.SECONDS)
                       .exceptionally(ex -> "Error"))
            .map(CompletableFuture::join)
            .filter(res -> !res.equals("Error") && !res.equals("Timeout"))
            .toList();

        System.out.println(results);
    }

    static CompletableFuture<String> callApi(String name) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            if (name.equals("API3")) throw new RuntimeException("Fail");
            return name + " response";
        });
    }

    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }
}