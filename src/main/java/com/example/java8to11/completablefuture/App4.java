package com.example.java8to11.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() ->{
            System.out.println("Hello1 " + Thread.currentThread().getName());
        });
        future1.get();
        System.out.println("====================================================");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future2.get());
        System.out.println("====================================================");

        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello3 " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> {
            System.out.println("Hello3 " + Thread.currentThread().getName());
        });
        future3.get();
        System.out.println("====================================================");

        CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello4 " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println("Hello4 " + Thread.currentThread().getName());
        });
        future4.get();
        System.out.println("====================================================");

    }
}
